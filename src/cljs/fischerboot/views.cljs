(ns fischerboot.views
  (:require [re-frame.core :as rf]
            [fischerboot.ws :as ws]))


(defn connection-state []
  (let [server @(rf/subscribe [:fischer-ws])
        bg-color (if (:open? server) "green" "red")]
    [:div
     [:p (str @ws/chsk-state)]
     [:div {:id "connectionIndicator" :style {:width "20px" :height "20px" :background bg-color :borderRadius "10px"}}]
     [:p (str "Hello! You can find fischer under " server)]]))

(defn profile->predictions []
  (let [profile->predictions @(rf/subscribe [:profile->predictions])]
    [:div
     (for [[profile predictions] profile->predictions]
       [:p
        [:p (name profile)] [:p (str predictions)]])]))

(defn ui []
  [:div.main
   [connection-state]
   [profile->predictions]])