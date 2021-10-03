(ns reagent.dom.server
  (:require [reagent.impl.protocols :as p]
            [reagent.impl.template :as tmpl]
            [reagent.impl.util :as util]
            [reagent.ratom :as ratom]
            [reagent.react.dom.server :refer [react-dom-server]]))

(defn render-to-string
  "Turns a component into an HTML string."
  ([component]
   (render-to-string component tmpl/default-compiler))
  ([component compiler]
   (ratom/flush!)
   (binding [util/*non-reactive* true]
     ((.-renderToString react-dom-server) (p/as-element compiler component)))))

(defn render-to-static-markup
  "Turns a component into an HTML string, without data-react-id attributes, etc."
  ([component]
   (render-to-static-markup component tmpl/default-compiler))
  ([component compiler]
   (ratom/flush!)
   (binding [util/*non-reactive* true]
     ((.-renderToStaticMarkup react-dom-server) (p/as-element compiler component)))))
