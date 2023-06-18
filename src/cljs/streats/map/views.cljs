(ns streats.map.views
  (:require [streats.map.events :as events]
            [streats.map.subs :as subs]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]))


(defn update-fn
  [comp gmap] 
  (let [{:keys [latitude longitude]} (r/props comp)
        latlng (js/google.maps.LatLng. latitude longitude)
        you {:title "you" :coords {:lat latitude :lng longitude}}
        trucks [{:title "Gato Peligroso"
                 :coords {:lat  35.9447
                          :lng -83.89041 }}];;@(subscribe [::subs/trucks])
        markers (into [you] trucks)]
    (doseq [{title :title {:keys [lat lng]} :coords} markers]
      (js/google.maps.Marker. #js{:map @gmap :title title :position (js/google.maps.LatLng. lat lng)}))
    (.panTo @gmap latlng)))


(defn position-fn 
  [geo]
(dispatch [::events/current-position {:latitude geo.coords.latitude
                                      :longitude geo.coords.longitude}]))


(defn mount-fn
  [comp gmap]
  (let [map-canvas (.getElementById js/document "map")
        options #js{"zoom" 15}
        gm (js/google.maps.Map. map-canvas options)]
    (dispatch [::events/get-trucks])
    (js/navigator.geolocation.getCurrentPosition position-fn)
    (reset! gmap gm))
  (update-fn comp gmap))


(defn gmap-component
  []
  (let [gmap (r/atom nil)]
    (r/create-class
     {:display-name "gmap-component"
      :reagent-render (fn [] [:div#map.map])
      :component-did-mount (fn [comp] (mount-fn comp gmap))
      :component-did-update (fn [comp] (update-fn comp gmap))})))


(defn map-page
  []
  (let [pos (subscribe [::subs/current-position])]
    [gmap-component @pos]))

