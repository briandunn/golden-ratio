(ns golden-ratio.core)

(defn fibonacci
  ([a b]
    (cons a (lazy-seq (fibonacci b (+' b a)))))
  ([]
    (fibonacci 1 1)))

(defn ratios [coll]
  (map #(apply / (reverse %)) (partition 2 1 coll)))

(defn point-of-convergence [coll]
  (count (take-while #(apply not= %) (partition 2 1 coll))))

(take 9000 (fibonacci))

; (ratios (take 90 (fibonacci)))

; (point-of-convergence (ratios (take 90 (fibonacci))))
