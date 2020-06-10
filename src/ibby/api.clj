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

(defn get-token
  "makes a request to the API for the current session's tokens"
  []
  (def token-query {:action "query"
                    :meta "tokens"
                    :format "json"})
  (def response (http-get token-query config))
  (get-in response ["query" "tokens" "csrftoken"]))

(defn edit
  "edits a page and replaces it with the content string passed"
  [page content token]
  (def edit-query {:action "edit"
                   :title page
                   :text content
                   :token token
                   :format "json"})
  (http-post edit-query config))