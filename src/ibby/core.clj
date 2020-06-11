(ns ibby.core
  (:gen-class)
  (:require [ibby.api :as api]
            [ibby.asyncapi :as aapi]))

(defn -main
  [& args]
  (api/login)
  (def edit-token (api/get-token))
  (def prom (aapi/replace-content "TestAsync" {:content "Async get!"
                                               :token edit-token}))
  (println (:body @prom)))