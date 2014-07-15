(ns drone-remote-cljs.core
  (:import (org.apache.log4j PatternLayout))
  (:use [compojure.core]
        [cheshire.core]
        [ring.util.response])
  (:require [clj-logging-config.log4j :as log-config]
            [clojure.stacktrace :refer :all]
            [clojure.tools.logging :as log]
            [drone-remote-cljs.drone :as drone]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]))

(defn init-logger []
  (log-config/set-logger! :level :debug
                          :layout (PatternLayout. "%d %p %m%n")
                          :out "logs/drone.log"))
(init-logger)

(defroutes app-routes
  (GET "/" []
       (redirect "index.html"))

;;   (POST "/drone-fly" {params :body}
;;         (println params)
;;         (println (get params :front-back-tilt))
;;         (drone/init-drone-and-take-off)
;;         (drone/fly [params])
;;         {:body params})

;;   W - pitch forward
;; S - pitch backward
;; A - roll left
;; D - roll right
;; Left Arrow - yaw left
;; right arrow - yaw right
;; Up arrow - increase alt.
;; down arrow - decrease alt

  (GET "/drone-take-off" []
       (drone/init-drone-and-take-off)
       (redirect "index.html"))

  (GET "/drone-land" []
       (drone/land)
       (redirect "index.html"))

  (GET "/drone-left" []
       (drone/left)
       (redirect "index.html"))

  (GET "/drone-right" []
       (drone/right)
       (redirect "index.html"))

  (GET "/drone-up" []
       (drone/up)
       (redirect "index.html"))

  (GET "/drone-down" []
       (drone/down)
       (redirect "index.html"))

  (GET "/drone-forward" []
       (drone/forward)
       (redirect "index.html"))

  (GET "/drone-backward" []
       (drone/backward)
       (redirect "index.html"))

  (route/resources "/")
  (route/not-found "Page not found"))

(def handler
  (-> (handler/api app-routes)
      (middleware/wrap-json-body {:keywords? true})
      (middleware/wrap-json-response)))
