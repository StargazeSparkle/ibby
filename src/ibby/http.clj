(ns ibby.http
  (:require [clj-http.client :as client]
            [clj-http.cookies :as cookies]
            [clojure.data.json :as json]))

(def cookie-store (cookies/cookie-store))

;;; FIXME: Currently there is a bug with how clj-http calls the async api and
;;;        as a result this is not going to work for the time being.
; (defn async-post [query config pass fail]
; (client/post (str (:protocol config)
;                   (:host config)
;                   (:api-path config))
;              {:accept :json
;               :async? true
;               :cookie-policy :standard
;               :cookie-store cookie-store
;               :form-params query}
;              pass
;              fail))

(defn http-get
  "Performs an HTTP GET.
  This function serves as a network interface. It takes a hashmap for the
  querystring `query` and a struct for the uri fragments `config`. For
  HTTP POST see: [[http-post]].
  This hashmap `query` contains keys and values to build a querystring from.
  This struct `config` contains at least `protocol`, `host`, and `api-path`."
  [query config]
  (json/read-str (:body
                   (client/get (str (:protocol config)
                                    (:host config)
                                    (:api-path config))
                               {:accept :json
                                :cookie-policy :standard
                                :cookie-store cookie-store
                                :query-params query}))))

(defn http-post
  "Performs an HTTP POST.
  This function serves as a network interface. It takes a hashmap for the
  body of the form `query` and a struct for the uri fragments `config`. For
  HTTP GET see: [[http-get]].
  This hashmap `query` contains keys and values to build a form body from.
  This struct `config` contains at least `protocol`, `host`, and `api-path`."
  [query config]
  (json/read-str (:body
                   (client/post (str (:protocol config)
                                     (:host config)
                                     (:api-path config))
                                {:accept :json
                                 :cookie-policy :standard
                                 :cookie-store cookie-store
                                 :form-params query}))))