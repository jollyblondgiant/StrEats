(ns streats.db
  (:require [cljs-http.client :as http]
            [cljs.core.async :as async]
            [re-frame.core :refer [dispatch reg-event-db]]
            [goog.string :as gstring]
            [goog.string.format]))

(defonce appdb {:loaded true})



(defonce pages
  {:review "Leave a Review"
   :trucks "View Trucks"
   :truck "View a Truck"
   :truck-menu "Menu by Truck"
   :food-item "Dish"})

(defonce apollo {:username "apollo"
                 :id -1
                 :email "apollo@streats.com"
                 :avatar "img/apollo.jpg"})


(defn get-mapstring []
  (async/go
    (let [response (async/<! (http/get "http://localhost:3000/map"))]
      (dispatch [:map-response response]))))

(reg-event-db
 :map-response
 (fn [db [_ response]]
   (prn response)
   (-> db
       (assoc  :gmaps-api-key (:body response))
       (dissoc :loading))))