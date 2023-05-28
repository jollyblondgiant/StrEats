(ns streats.core
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [streats.routes :refer [app-routes]]))


(defonce port 3000)

(defn -main
  "I don't do a whole lot ... yet."
  [& _]
  (run-jetty #'app-routes {:port (Integer. (or port 3000)) 
                           :join? false})
  )
