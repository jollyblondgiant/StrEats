(ns streats.routes
  (:require  [reitit.ring :refer [router ring-handler create-default-handler]]))

(def app-routes 
  (ring-handler
   (router
    [["/" {:get {:handler (fn [_] {:status 200 :body "Hello World!"})}}]])
   ))