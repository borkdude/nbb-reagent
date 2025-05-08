(ns reagent.react.dom.server)

(defn react-dom-server []
  (.-nbb$internal$react-dom-server goog/global))
