(ns ibby.core
  (:gen-class)
  (:require [ibby.api :as api]))

(defn -main
  [& args]
  (api/login)
  (def edit-token (api/get-token))
  (println (api/edit-replace "Test2" "New text." edit-token))
  (println (api/edit-prepend "Test2" "Prepended text." edit-token))
  (println (api/edit-append "Test2" "Appended text." edit-token)))