import ratpack.jackson.Jackson;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class TestAnagram {

    public static String dictionaryName = "wordlist.txt";
    public static File dictionary = new File(TestAnagram.class.getClassLoader().getResource(dictionaryName).getFile());

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s.
                serverConfig(c -> c.baseDir(BaseDir.find())
                .env())
            .handlers(chain -> chain
                .get(":words", ctx -> {
                    final String[] words = ctx.getPathTokens().get("words").split(",");
                    Map<String, List> anagramMap = new ConcurrentHashMap<>();
                    Stream.of(words).parallel().forEach(word -> {
                        anagramMap.put(word, findAnagrams(word));
                    });
                    ctx.render(Jackson.json(anagramMap));
                })
            )
        );
    }

    public static List findAnagrams(final String word) {
        ArrayList<String> anagrams = new ArrayList<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String candidate = s.next();
                if(candidate.length() == word.length() &&
                        checkMatch(word, candidate)) {
                    anagrams.add(candidate);
                }
            }
         } catch (FileNotFoundException ex) {
            // do nothing
        }
        return anagrams;
    }

    public static boolean checkMatch(final String word, final String candidate) {
        char[] wordChars = word.toCharArray();
        char[] candiChars = candidate.toCharArray();
        if (Arrays.equals(wordChars, candiChars)) {
            return false;
        }
        Arrays.sort(wordChars);
        Arrays.sort(candiChars);
        if (Arrays.equals(wordChars, candiChars)) {
            return true;
        }
        return false;
    }
}
