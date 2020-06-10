(ns ibby.core
  (:gen-class)
  (:require [clojure.data.json :as json]))

(use 'ibby.api)

(defn -main
  [& args]
  (println (login)))