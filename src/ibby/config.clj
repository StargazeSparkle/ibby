(ns ibby.config)

;;; configuration
; this is the configuration struct and everything that you need to configure
; application can be found and modified here.
;
;; username [string]
;; password [string]
;; host     [string]
;; api-path [string]
;; ssl      [boolean]
(def configuration (create-struct
              :username
              :password
              :host
              :api-path
              :ssl))

;;; config-example
; this is an example of a proper configuration.
; this is not a valid configuration as a valid configuration is named config
; and not config-example.
;
; NOTE: do not commit your actual config to git and do not share it with other
; people. I do not provide any means of loading configurations from disk nor do
; I make any effort to load them from an environment variable. You are free to
; do this yourself just as long as the result in a valid config structure
(def config-example
        (struct configuration "Username"
                "Password"
                "creepypasta.fandom.com"
                "/api.php"
                true))

;;; config
; DO NOT FILL THIS OUT AND THEN COMMIT
;(def config
;       (struct configuration ""
;               ""
;               ""
;               ""
;               true))