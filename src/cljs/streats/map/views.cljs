(ns streats.map.views
  (:require [cljsjs.openlayers]))

(defn map-component 
  []
  (fn []
    (let [mapp (js/ol.Map. "map")
          layer (js/ol.Layer.OSM "A simple map app")
          mapp (.addLayer mapp layer)
          projection (js/ol.Projection "EPSG:4326")
          center (.transform (js/ol.LonLat -71.147 42.472)
                             projection (.getProjectionObject mapp))
          mapp (.setcenter mapp center 12)]
      mapp)))