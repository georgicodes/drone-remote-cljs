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


;; define the function to attach validate-form to onsubmit event of
;; the form
(defn init []
  ;; verify that js/document exists and that it has a getElementById
  ;; property
  (if (and js/document
           (.-getElementById js/document))
    (do
      (ev/listen! (dom/by-id "take-off-button") :click action-take-off)
      (ev/listen! (dom/by-id "land-button") :click action-land)
      (ev/listen! (dom/by-id "left-button") :click action-left)
      (ev/listen! (dom/by-id "right-button") :click action-right)
      (ev/listen! (dom/by-id "up-button") :click action-up)
      (ev/listen! (dom/by-id "forward-button") :click action-forward)
      (ev/listen! (dom/by-id "backward-button") :click action-backward)
      (ev/listen! (dom/by-id "down-button") :click action-down))))

;; initialize the HTML page in unobtrusive way
(set! (.-onload js/window) init)
