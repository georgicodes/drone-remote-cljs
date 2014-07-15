(ns drone-remote-cljs.core
  (:import (org.apache.log4j PatternLayout))
  (:use [compojure.core]
        [drone-remote-cljs.drone :as drone])
  (:require [clj-logging-config.log4j :as log-config]
            [clojure.stacktrace :refer :all]
            [clojure.tools.logging :as log]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]))

(defn init-logger []
  (log-config/set-logger! :level :debug
                          :layout (PatternLayout. "%d %p %m%n")
                          :out "logs/drone.log"))
(init-logger)

(defroutes app-routes
  (GET "/" []
       (resp/redirect "index.html"))

  (GET "/drone-take-off" []
       (drone/init-drone-and-take-off)
       (resp/redirect "index.html"))

  (GET "/drone-land" []
       (drone/land)
       (resp/redirect "index.html"))

  (GET "/drone-left" []
       (drone/spin-left)
       (resp/redirect "index.html"))

  (GET "/drone-right" []
       (drone/spin-right)
       (resp/redirect "index.html"))

  (route/resources "/")
  (route/not-found "Page not found"))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))
