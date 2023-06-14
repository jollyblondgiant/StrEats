(ns streats.core
  (:gen-class)
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [streats.routes :refer [app-routes]]
             [ring.middleware.cors :refer [wrap-cors]]
             [ring.middleware.reload :refer [wrap-reload]]
             [ring.middleware.resource :refer [wrap-resource]]
             [streats.environ :refer [env]]))


(defn wrap-cors* [handler]
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
  [& _]
  (let [port (Integer. (:server-port env 3000))]
    (-> app-routes
        wrap-cors*
        (wrap-resource "public")
        (run-jetty {:port port :join? false}))
    (println "starting server on port:" port)))

(defn -main:dev
  [& _]
  (let [port (Integer. (:server-port env 3000))]
    (-> app-routes
        wrap-cors*
        (wrap-resource "public")
        wrap-reload
        (run-jetty {:port port :join? false}))
    (println "starting development server on port:" port)))



(comment
  (run-jetty (wrap-cors* app-routes) {:port 3000 :join? false}))