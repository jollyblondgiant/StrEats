(ns streats.profile.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 ::user
 (fn [db _]
   (:user db)))