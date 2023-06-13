(ns streats.map.views
  (:require [streats.map.events :as events]
            [streats.map.subs :as subs]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.card-media :refer [card-media]]))




(defn map-page
  []
  (let [map-key (subscribe [::subs/map-key])]
    (fn []
      [container
       {:id "map-page"}
       (when @map-key
         [:<>
          ]
         )])))

