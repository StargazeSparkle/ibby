(ns ibby.core
  (:gen-class)
  (:require [clojure.data.json :as json]))

(use 'ibby.config)
(use 'ibby.http)

(def login-query {:action "login"
                 :lgname (:username config)
                 :lgpassword (:password config)
                 :format "json"})

(defn -main
  [& args]
  (def lgtoken (get-in
               (http-post login-query config)
               ["login" "token"]))
  (def login-with-token (into (hash-map) [login-query {:lgtoken lgtoken}]))
  (println (http-post login-with-token config)))