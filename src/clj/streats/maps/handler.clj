(ns streats.maps.handler
  (:require [ring.util.response :refer [bad-request]]
            [streats.environ :refer [env]]))

(defn gmap-string
  [_]
  {:status 200
   :body (:gmaps-api-key env)})

(defn map-handler
  [{params :path-params
    method :request-method}]
  (condp = method
    :get (gmap-string params)
    bad-request))