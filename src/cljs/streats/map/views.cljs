(ns streats.map.views
  (:require [streats.map.events :as events]
            [streats.map.subs :as subs]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.card-media :refer [card-media]]))


(defn map-did-mount
  []
  (let [map-canvas (.getElementById js/document "map")
        map-options #js{"center" (js/google.maps.LatLng. 37 115)
                        "zoom" 12}]
    (js/google.maps.Map. map-canvas map-options)))

(defn map-canvas
  []
  [:div#map.map])

(defn map-page
  []
  (let [map-key (subscribe [::subs/map-key])]
    (r/create-class
     {:reagent-render map-canvas
      :component-did-mount map-did-mount})))

