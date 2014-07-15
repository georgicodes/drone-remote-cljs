(ns drone-remote-cljs.drone
  (:require [clj-drone.core :refer :all]
            [clj-drone.navdata :refer :all]
            [clj-drone.video :refer :all]))

;; (defn mini-drone-sequence []
;;   (println "flying drone on server")
;;   (init-drone-and-take-off)
;;   (drone :anim-wave)
;;   (drone :hover)
;;   (drone :land))

(defn init-video []
  (init-video (drone-ip :default))
  (start-video (drone-ip :default)))

(defn stop-video []
  (end-video))

(defn init-drone-and-take-off []
  (set-log-data [:seq-num :flying :battery-percent :control-state :roll :pitch :yaw
                :velocity-x :velocity-y :velocity-z])
  (drone-initialize)
  (drone-init-navdata)
  (drone-do-for 2 :take-off))

(defn land []
  (drone :land)
  (end-navstream))

(defn left []
  (drone :spin-left 0.5))

(defn right []
  (drone :spin-left 0.5))

(defn spin-left []
  (drone :spin-left 0.5))

(defn spin-right []
  (drone :spin-right 0.5))
