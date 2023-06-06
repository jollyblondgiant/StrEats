(ns streats.profile.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [streats.profile.subs :as subs]
            [streats.profile.events :as events]
            [reagent-mui.material.box :refer [box]]
            [reagent-mui.material.typography :refer [typography]]
            [reagent-mui.material.button :refer [button]]
            [reagent-mui.material.icon-button :refer [icon-button]]
            [reagent-mui.material.container :refer [container]]
            [reagent-mui.material.card :refer [card]]
            [reagent-mui.material.card-media :refer [card-media]]
            [reagent-mui.material.card-content :refer [card-content]]
            [reagent-mui.icons.account-circle :refer [account-circle]]))

(defn profile
  []
 (let [user (subscribe [::subs/user])] 
  (fn []
    [container
     (if @user
       [card
        [card-media 
         {:component :img
          :image (:avatar @user)
          :alt (:username @user)}]
        [card-content
         [typography
          (:username @user)]
         [typography 
          {:on-click #(dispatch [::events/logout])}
          "Sign Out"]]]
       [card
        [card-media
         [account-circle]]
        [card-content
         {:on-click #(dispatch [::events/login])}
         "Sign In"]
        [card-content 
         "Sign Up"]])])))