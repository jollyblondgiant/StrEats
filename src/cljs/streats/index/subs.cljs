(ns streats.index.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 ::page
 (fn [db _]
   (:page db)))
