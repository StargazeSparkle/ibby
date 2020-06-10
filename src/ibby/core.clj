(ns ibby.core
  (:gen-class)
  (:require [clojure.data.json :as json]))

(use 'ibby.api)


(defn -main
  [& args]
  (login)
  (def edit-token (get-token))
  (println (edit "Test" "Test test bot bot" edit-token)))