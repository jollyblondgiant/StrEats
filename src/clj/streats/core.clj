(ns streats.core
  (:gen-class)
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [streats.routes :refer [app-routes]]
             [environ.core :refer [env]]))



(defn -main
  "I don't do a whole lot ... yet."
  [& _]
  (let [port (Integer. (:server-port env 3000))]
    (run-jetty #'app-routes {:port port :join? false})
    (println "starting server on port:" port)))
