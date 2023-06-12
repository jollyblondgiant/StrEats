Installation:
prerequisites:
  - leiningen
  - node, npm & npx

on first startup:
  - npm install

to start:
lein run -- starts the server on port 3000 (or whatever you configure in local config.edn)

in a new terminal:

shadow-cljs watch app -- starts the client on port 9500

DEVELOPMENT:
first terminal: lein repl
new terminal: lein figwheel

TODO:
serve index.html via hiccup delivered by server
pages layouts:
  - login screen        -|
  - forgot login screen  |- does auth0 plugin cover these 3?
  - sign up page        -|
  - home/map screen
  - search page
  - profile/settings page
  - review truck/dish/event-space page
  - trucks list view
  - truck focus view
  - truck menu page
  - truck menu-item/dish page
auth0
spoof maps
client: spoof API calls
server: get trucks
server: get truck by id
server: add truck to favorites
client: setup styles