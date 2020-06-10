(ns ibby.core
  (:gen-class)
  (:require [ibby.api :as api]))

(defn -main
  [& args]
  (api/login)
  (def edit-token (api/get-token))
  (println (api/edit-replace "Rhapsody" "Mama mia!" edit-token))
  (println (api/edit-prepend "Rhapsody" "Mama mia!\n" edit-token))
  (println (api/edit-append "Rhapsody" "\nMama mia let me go!" edit-token)))