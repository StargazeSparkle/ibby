(ns ibby.core
  (:gen-class)
  (:require [clojure.data.json :as json]))

(use 'ibby.config)
(use 'ibby.http)

(def test-query {:action "query"
                 :prop "revisions"
                 :titles "Creepypasta_Wiki"
                 :rvslots "*"
                 :rvprop "content"
                 :format "json"})

(defn -main
  [& args]
  (println (json/write-str (http-get test-query config-example))))