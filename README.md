Clojure Drone Remote
====================

<em>Technologies: Clojure, ClojureScript, Compojure, Domina, Leiningen</em>

What's more fun that controlling a Parrot AR Drone 2.0 using the keyboard like you would in a video game? Not much I wager.

Drone Remote is a simple web app written in Clojure / ClojureScript using libraries such as Compojure and Domina.

![](https://dl-web.dropbox.com/get/Screenshots/Screenshot%202014-08-28%2012.31.01.png?_subject_uid=290579252&w=AACG1WNsAaPIyz9hejduZlkPvACB5pHIPM6f5ZU6Eh0qYg)

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
