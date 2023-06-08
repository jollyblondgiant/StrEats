(ns streats.db
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [environ.core :refer [env]]
            [goog.string :as gstring]
            [goog.string.format]))

(defonce appdb {:loaded true})

(defonce pages
  {:review "Leave a Review"
   :trucks "View Trucks"
   :truck "View a Truck"
   :truck-menu "Menu by Truck"
   :food-item "Dish"
   })

(defonce apollo {:username "apollo"
                 :id -1
                 :email "apollo@streats.com"
                 :avatar "img/apollo.jpg"})

(defn map-string
  []
  (let [{:keys [server-port server-url]} env]
    (http/get (str server-url ":" server-port "/map"))))