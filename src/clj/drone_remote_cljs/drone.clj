(ns drone-remote-cljs.drone
  (:require [clj-drone.core :refer :all]
            [clj-drone.navdata :refer :all]))

(defrecord Fly [left-right-tilt front-back-tilt vertical-speed angular-speed])

;; (defn mini-drone-sequence []
;;   (println "flying drone on server")
;;   (init-drone-and-take-off)
;;   (drone :anim-wave)
;;   (drone :hover)
;;   (drone :land))

;; (defn init-video []
;;   (init-video (drone-ip :default))
;;   (start-video (drone-ip :default)))

;; (defn stop-video []
;;   (end-video))

(defn init-drone-and-take-off []
  (println "sending take off command to drone")
  (set-log-data [:seq-num :flying :battery-percent :control-state :roll :pitch :yaw
                :velocity-x :velocity-y :velocity-z])
  (drone-initialize)
  (drone-init-navdata)
  (drone-do-for 2 :take-off))

(defn land []
  (drone :land)
  (end-navstream))

(defn left []
  (drone :tilt-left 0.2))

(defn right []
  (drone :tilt-right 0.2))

(defn spin-left []
  (drone :spin-left 0.2))

(defn spin-right []
  (drone :spin-right 0.2))

(defn up []
  (drone :up 0.2))

(defn down []
  (drone :down 0.2))

(defn forward []
  (drone :tilt-front 0.2))

(defn backward []
  (drone :tilt-back 0.2))

(defn fly [data]
  (println "sending fly command to drone")
;;   (drone-do-for 3.75 :fly 0.2 0 0 0.5))
  (drone :anim-wave) ;; doesn't seem to do anything?
  (drone-do-for 2 :spin-right 0.8) ;=> spin right at 80% for 2 seconds
(drone-do-for 2 :spin-left 0.3) ;=> spin left at 30% for 2 seconds
  (drone :fly 0 0 0.7 -0.2)
  )

