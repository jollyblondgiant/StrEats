(ns streats.maps.handler
  (:require [ring.util.response :refer [bad-request]]
            [streats.environ :refer [env]]))

(defn gmap-string
  [_]
  (let [gmap-key (:gmaps-api-key env)]
    {:status 200
     :body (format "https://maps.googleapis.com/maps/api/js?key=%s&libraries=maps" gmap-key)}))

(defn map-handler
  [{params :path-params
    method :request-method}]
  (condp = method
    :get (gmap-string params)
    bad-request))