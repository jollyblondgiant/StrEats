(ns streats.core
  (:gen-class)
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [streats.routes :refer [app-routes]]
             [ring.middleware.cors :refer [wrap-cors]]
             [streats.environ :refer [env]]))


(defn wrap-debug
  [handler]
  (println handler)
  handler)


(defn wrap-cors* [handler ]
  (wrap-cors handler
             :access-control-allow-origin [#"http://localhost:9500"]
             :access-control-allow-methods [:get :post :put :delete]
             :access-control-allow-headers #{"accept"
                                             "accept-encoding"
                                             "accept-language"
                                             "authorization"
                                             "content-type"
                                             "origin"}
             :access-control-allow-credentials "true"))

(defn -main
  "I don't do a whole lot ... yet."
  [& _]
  (let [port (Integer. (:server-port env 3000))]
    (-> app-routes
        wrap-cors*
        (run-jetty {:port port :join? false}))
    (println "starting server on port:" port)))


(comment
  (run-jetty (wrap-cors* app-routes) {:port 3000 :join? false})
  )