(ns streats.map.views
 (:require [streats.map.events :as events]
           [streats.map.subs :as subs]
  [reagent-mui.material.container :refer [container]]
           [reagent-mui.material.card :refer [card]]
           [reagent-mui.material.card-media :refer [card-media]]))

(defn map-page
  []
  (fn []
    [container 
     {:id "map-page"}
     [card
     {:id "map"}]]))