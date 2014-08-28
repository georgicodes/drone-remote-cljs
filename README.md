Clojure Drone Remote
====================

<em>Technologies: Clojure, ClojureScript, Compojure, Domina, Leiningen</em>

What's more fun that controlling a Parrot AR Drone 2.0 using the keyboard like you would in a video game? Not much I wager.

Drone Remote is a simple web app written in Clojure / ClojureScript using libraries such as Compojure and Domina.

![](https://photos-6.dropbox.com/t/0/AAAL5-wp_p6jZGyoj9RHJ0WihIv02-YxyNakLatdjznt-w/12/290579252/png/1024x768/3/1409248800/0/2/Screenshot%202014-08-28%2012.31.01.png/QiB_Txb9IB98Gk-pXCa-YGgIEOat97oFgq8lTbE6I4k)

## To Run

Build
```
lein cljsbuild once
```
Run
```
lein ring server
```
Now navigate too `localhost:3000` to view.

You will need to also have the Drone switched on and connected correctly to wifi. Then you can use the keyobard to control it!

## TODO
* emergency status
* batter indicator
