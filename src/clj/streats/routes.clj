(ns streats.routes
  (:require  [reitit.ring :refer [router ring-handler create-default-handler]]
             [streats.maps.handler :refer [map-handler]]
             [streats.index.handler :refer [index-handler]]))



(def app-routes
  (ring-handler
   (router
    [["/" {:get {:handler index-handler}}]
     
     ["/api"
      ["/map" {:get {:handler map-handler}}]]])
   (create-default-handler)))