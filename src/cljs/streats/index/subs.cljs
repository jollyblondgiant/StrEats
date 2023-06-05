(ns streats.index.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 ::user
 (fn [db _]
   (:user db)))

(reg-sub
 ::page
 (fn [db _]
   (:page db)))

(reg-sub
 ::show-menu?
 (fn [db _]
   (:show-menu? db)))

(reg-sub
 ::show-profile?
 (fn [db _]
   (:show-profile? db)))