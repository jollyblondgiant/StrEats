(ns streats.map.views
  (:require [streats.map.events :as events]
            [streats.map.subs :as subs]
            [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch]]))


(defn update-fn
  [comp gmap] 
  (let [trucks [{:title "Gato Peligroso"
                 :coords {:latitude  35.9447
                          :longitude -83.89041 }}];;@(subscribe [::subs/trucks])
        markers (into [{:title "you" :coords (r/props comp)}] trucks)]
    (doseq [{title :title {:keys [latitude longitude]} :coords} markers]
      (js/google.maps.Marker. #js{:map @gmap :title title :position (js/google.maps.LatLng. latitude longitude)})
      ;;set map bound to include marker
      )
    
    (.panTo @gmap (js/google.maps.LatLng. (:latitude (r/props comp)) (:longitude (r/props comp))))))


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
  (let [pos (subscribe [::subs/current-position])
        trucks (subscribe [::subs/trucks])]
    [gmap-component @pos @trucks]))

