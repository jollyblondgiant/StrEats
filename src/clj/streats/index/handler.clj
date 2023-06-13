(ns streats.index.handler
   (:require [ring.util.response :refer [bad-request]]
             [streats.environ :refer [env]]
             [cheshire.core :as json]
             [hiccup.page :refer [html5 include-css include-js]]))

(defn index-page
  [] 
  {:status 200
   :body (html5
          [:head 
           (include-css "/css/style.css")
           [:title "StrEats"]]
          [:body
           [:div#app]
           (include-js "/js/app/main.js")])})

(defn index-handler
  [{params :path-params
    method :request-method}]
  (condp = method
    :get (index-page)
    bad-request))