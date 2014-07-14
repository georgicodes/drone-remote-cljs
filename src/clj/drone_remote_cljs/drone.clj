(ns drone-remote-cljs.drone
  (:use [clj-drone.core]))

(defn fly-drone []
  (drone-initialize)
  (drone :take-off)
  (Thread/sleep 10000)
  (drone :land))

(defn take-off []
  (drone-initialize)
  (drone :take-off))

;; (def land []
;;   (drone :land))

;; (defn left []
;;   (drone :spin-left 0.5))

;; (defn right []
;;   (drone :spin-right 0.5))
