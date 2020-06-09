(ns ibby.http
  (:require [clj-http.client :as client]
            [clj-http.cookies :as cookies]
            [clojure.data.json :as json]))

(def cookie-store (cookies/cookie-store))

(defn http-get
  "takes a query hashmap and a config struct and performs a GET to the API"
  [query config]
  (json/read-str (:body
                   (client/get (str (:protocol config)
                                    (:host config)
                                    (:api-path config))
                               {:accept :json
                                :cookie-store cookie-store
                                :query-params query}))))