(ns drone-remote-cljs.main
  ;;   (:use [drone-remote-cljs.remote :as remote])
  (:require [domina :as dom]
            [domina.events :as ev]
            [ajax.core :refer [GET POST]]))

(defn handler [response]
  (.log js/console (str response)))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

;; (defn action-take-off []
;;   (.log js/console "asking drone to take-off")
;;   (POST "/drone-fly" {:params {:left-right-tilt "Hello World"
;;                                :front-back-tilt    "Bob"
;;                                :vertical-speed 0
;;                                :angular-speed 0}
;;                       :format :json
;;                       :response-format :json
;;                       :keywords? true
;;                       :handler handler
;;                       :error-handler error-handler}))

(defn action-take-off []
  (dom/remove-class! (dom/by-id "take-off-button") "animated bounce")
;;   element.offsetWidth = element.offsetWidth;
  (dom/add-class! (dom/by-id "take-off-button") "animated bounce")
  (.log js/console "asking drone to take-off")
  (GET "/drone-take-off"))

(defn action-land []
  (.log js/console "asking drone to land")
  (GET "/drone-land"))

(defn action-left []
  (.log js/console "asking drone to go left")
  (GET "/drone-left"))

(defn action-right []
  (.log js/console "asking drone to go right")
  (GET "/drone-right"))

(defn action-up []
  (.log js/console "asking drone to go up")
  (GET "/drone-up"))

(defn action-down []
  (.log js/console "asking drone to go down")
  (GET "/drone-down"))

(defn action-forward []
  (.log js/console "asking drone to go forward")
  (GET "/drone-forward"))

(defn action-backward []
  (.log js/console "asking drone to go backward")
  (GET "/drone-backward"))

(defn action-yaw-left []
  (.log js/console "asking drone to yaw left")
  (GET "/drone-yaw-left"))

(defn action-yaw-right []
  (.log js/console "asking drone to yaw right")
  (GET "/drone-yaw-right"))

(defn symbol-from-int [number]
  (keyword (str number)))



(def keys-to-actions {:87 [action-forward]
                      :65 [action-left]})



(defn init []
  (if (and js/document
           (.-getElementById js/document))
    (do
      (ev/listen! :keydown (fn [evt]
                             (let [keycode (:keyCode evt)]
                             (.log js/console (str "keypressed" keycode))
                             (cond
                              (= 87 keycode) (action-forward)
                              (= 65 keycode) (action-left)
                              (= 68 keycode) (action-right)
                              (= 83 keycode) (action-backward)
                              (= 38 keycode) (action-up)
                              (= 37 keycode) (action-yaw-left)
                              (= 40 keycode) (action-down)
                              (= 39 keycode) (action-yaw-right)
                              (= 13 keycode) (action-take-off)
                              (= 32 keycode) (action-land)))))
      (ev/listen! (dom/by-id "take-off-button") :click action-take-off)
      (ev/listen! (dom/by-id "land-button") :click action-land)
      (ev/listen! (dom/by-id "left-button") :click action-left)
      (ev/listen! (dom/by-id "right-button") :click action-right)
      (ev/listen! (dom/by-id "yaw-left-button") :click action-yaw-left)
      (ev/listen! (dom/by-id "yaw-right-button") :click action-yaw-right)
      (ev/listen! (dom/by-id "up-button") :click action-up)
      (ev/listen! (dom/by-id "forward-button") :click action-forward)
      (ev/listen! (dom/by-id "backward-button") :click action-backward)
      (ev/listen! (dom/by-id "down-button") :click action-down))))

(set! (.-onload js/window) init)
