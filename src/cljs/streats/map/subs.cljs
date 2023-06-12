(ns streats.map.subs
  (:require [re-frame.core :refer [reg-sub]]))


(reg-sub
 ::map-key
 (fn [db _]
   (:gmaps-api-key db)))