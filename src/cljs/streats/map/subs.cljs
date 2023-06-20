(ns streats.map.subs
  (:require [re-frame.core :refer [reg-sub]]))


(reg-sub
 ::current-position
 (fn [db _]
   (:current-position db)))

(reg-sub 
 ::trucks
 (fn [db _]
   (:trucks db)))

(reg-sub
 ::filters
 (fn [db _]
   (:filters db #{})))