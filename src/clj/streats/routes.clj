(ns streats.routes
  (:require  [reitit.ring :refer [router ring-handler create-default-handler]]
             [streats.maps.handler :refer [map-handler]]
             [ring.middleware.cors :refer [wrap-cors]]))

(def app-routes 
  (ring-handler
   (router
    [["/" 
      ["map" {:get {:handler map-handler}}]]]
    {:data {:middleware [wrap-cors]}})
   (create-default-handler)))