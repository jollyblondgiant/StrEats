(ns streats.routes
  (:require  [reitit.ring :refer [router ring-handler create-default-handler create-resource-handler]]
             [streats.index.handler :refer [index-handler]]
             [streats.trucks.handler :refer [trucks-handler]]))


(def app-routes
  (ring-handler
   (router
    [["/" index-handler] 
     ["/api"
      ["/trucks" trucks-handler]]]
    ["/resources/public/*" (create-resource-handler)])
   (create-default-handler)))