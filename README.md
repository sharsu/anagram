# anagram
Anagram service on heroku

## Known Issues
1. Word order is not maintained in the response.
Request: http://localhost:5000/crepitus,paste,kinship,enlist,boaster,fresher,sinks,knits,sort
Actual Response: {"fresher":["refresh"],"knits":["skint","stink","tinks"],"sinks":["skins"],"kinship":["pinkish"],"paste":["pates","peats","septa","spate","tapes","tepas"],"boaster":["boaters","borates","rebatos","sorbate"],"sort":["orts","rots","stor","tors"],"crepitus":["cuprites","pictures","piecrust"],"enlist":["elints","inlets","listen","silent","tinsel"]}

Expected Response: {"crepitus":["cuprites","pictures","piecrust"],"paste":["pates","peats","septa","spate","tapes","tepas"],"kinship":["pinkish"],"enlist":["elints","inlets","listen","silent","tinsel"],"boaster":["boaters","borates","rebatos","sorbate"],"fresher":["refresh"],"sinks":["skins"],"knits":["skint","stink","tinks"],"sort":["orts","rots","stor","tors"]}
