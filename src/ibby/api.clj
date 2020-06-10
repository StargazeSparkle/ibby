(ns ibby.api
  (:require [clojure.data.json :as json]))

(use 'ibby.http)
(use 'ibby.config)

(defn login
  "sends a login request to the mediawiki api endpoint"
  []
  (def login-query {:action "login"
                    :lgname (:username config)
                    :lgpassword (:password config)
                    :format "json"})
  (def lgtoken (get-in
                 (http-post login-query config)
                 ["login" "token"]))
  (def login-with-token (assoc-in login-query [:lgtoken] lgtoken))
  (http-post login-with-token config))