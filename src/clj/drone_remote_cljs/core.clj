(ns drone-remote-cljs.core
  (:use [compojure.core]
        [drone-remote-cljs.drone :as drone])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]))

;; defroutes macro defines a function that chains individual route
;; functions together. The request map is passed to each function in
;; turn, until a non-nil response is returned.
;;     (drone/fly-drone)

(defroutes app-routes
  (GET "/" [] (resp/redirect "index.html"))
  (route/resources "/")
  (route/not-found "Page not found"))

;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))
