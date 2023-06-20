(ns streats.db.core
  (:require [datascript.core :as d]
            [streats.db.truck :refer [truck]]
            [streats.db.menu :refer [menu]]
            [streats.db.photo :refer [photo]]
            [streats.db.user :refer [user]]
            [streats.db.favorite :refer [favorite]]
            [streats.db.review :refer [review]]
            [streats.db.order :refer [order]]
            [streats.db.venue :refer [venue]]
            [streats.db.dish :refer [dish]]
            [streats.db.event :refer [event]]))


(def schema 
  {:truck truck
   :menu menu
   :photo photo
   :user user
   :favorite favorite
   :review review
   :order order
   :venue venue
   :dish dish
   :event event})


(def streats 
  (d/create-conn schema))
