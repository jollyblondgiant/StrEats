(ns streats.db)

(defonce appdb {})

(defonce pages
  {:review "Leave a Review"
   :trucks "View Trucks"
   :truck "View a Truck"
   :truck-menu "Menu by Truck"
   :food-item "Dish"
   })

(defonce apollo {:username "apollo"
                 :id -1
                 :email "apollo@streats.com"
                 :avatar "img/apollo.jpg"})