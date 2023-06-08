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
   (:show-menu? db false)))

(reg-sub
 ::show-profile?
 (fn [db _]
   (:show-profile? db false)))

(reg-sub
 ::show-search?
 (fn [db _]
   (:show-search? db false)))

(reg-sub
 ::show-trucks?
 (fn [db _]
   (:show-trucks? db false)))

(reg-sub
 ::data-loading?
 (fn [db _]
   (contains? db :loading)))