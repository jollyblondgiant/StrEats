(ns streats.map.views
  (:require [streats.map.events :as events]
            [streats.map.subs :as subs]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.card-media :refer [card-media]]))



(defn map-did-mount
  [comp]
  (let [map-canvas (.getElementById js/document "map")
        map-options #js{"zoom" 12}
        gmap (js/google.maps.Map. map-canvas map-options)]))

(defn update-component
  [comp gmap]
  (let [{:keys [latitude longitude]} (r/props comp)
        latlng (js/google.maps.LatLng. latitude longitude)]
    (.setPosition (:marker @gmap) latlng)
    (.panTo (:map @gmap) latlng)))


(defn gmap-component
  []
  (let [gmap (r/atom nil)
        options #js{"zoom" 15}
        position (fn [geo]
                   (dispatch [::events/current-position {:latitude geo.coords.latitude
                                                         :longitude geo.coords.longitude}]))
        update (fn [comp]
                 (let [{:keys [latitude longitude]} (r/props comp)
                       
                       latlng (js/google.maps.LatLng. latitude longitude)]
                  
                   (.setPosition (:marker @gmap) latlng)
                   (.panTo (:map @gmap) latlng)))]
    (r/create-class
     {:display-name "gmap-component"
      :reagent-render (fn [] [:div#map.map])
      :component-did-mount (fn [comp] (let [map-canvas (.getElementById js/document "map")
                                            gm (js/google.maps.Map. map-canvas options)
                                            marker (js/google.maps.Marker. #js{:map gm :title "You"})]
                                        (js/navigator.geolocation.getCurrentPosition position)
                                        (reset! gmap {:map gm :marker marker}))
                             (update comp))
      :component-did-update update})))


(defn map-page
  []
  (let [pos (subscribe [::subs/current-position])]
    [gmap-component @pos]))

