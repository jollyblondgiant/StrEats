(ns streats.maps.handler
  (:require [cheshire.core :refer [generate-string]]
            [ring.util.response :refer [bad-request]]
            [environ.core :refer [env]]))

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