(ns streats.trucks.handler
  (:require [ring.util.response :refer [bad-request]]))


(defn get-trucks
  [params]
  [])


(defn trucks-handler
  [{params :path-params
    method :request-method}]
  (condp = method
    :get (get-trucks params)
    bad-request))