(ns streats.routes
  (:require  [reitit.ring :refer [router ring-handler create-default-handler]]
             [streats.maps.handler :refer [map-handler]]
            ; [ring.middleware.cors :refer [wrap-cors]]
             #_[ring.util.http-response :refer [ok]]))


(def app-routes 
  (ring-handler
   (router
    [["/" 
      ["map" {:get {:handler map-handler}}]]])
   (create-default-handler)))