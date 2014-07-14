(ns drone-remote-cljs.drone
  (:use [clj-drone.core]))

(defn fly-drone []
  (drone-initialize)
  (drone :take-off)
  (Thread/sleep 10000)
  (drone :land))
