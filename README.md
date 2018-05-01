# anagram
Anagram service on heroku

## Prepare the App
Clone the application code from github using following commands:
```script
git clone https://github.com/sudheshrajan/anagram.git
cd anagram
```

## Create an App
Create an app on Heroku.
```script
heroku create ${app_name}
```

## Deploy the App code
```script
git push heroku master
```
To ensure that atleast one instance of the app is running.
```script
heroku ps:scale web=1
```
To visit the app
```script
heroku open
```
## Run App Locally
To run the application locally, run the following commands:
```script
heroku local web
```

## To get the anagrams
Application will return the anagrams for all the words sent as path token. e.g. herokuapp.com/crepitus
Response will contain the words known to the application in json format: 
```json
{"crepitus":["cuprites","pictures","piecrust"]}
```

Multiple words should be separated by comma ','. e.g. herokuapp.com/crepitus,paste,kinship,enlist,boaster,fresher,sinks,knits,sort
Response will contain the result for all the words (refer to issue 1).
```json
{"knits":["skint","stink","tinks"],"fresher":["refresh"],"sinks":["skins"],"kinship":["pinkish"],"sort":["orts","rots","stor","tors"],"paste":["pates","peats","septa","spate","tapes","tepas"],"boaster":["boaters","borates","rebatos","sorbate"],"crepitus":["cuprites","pictures","piecrust"],"enlist":["elints","inlets","listen","silent","tinsel"]}
```
