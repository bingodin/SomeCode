;1.4  过程作为运算返回值
 (define (a_plus_abs_b a b) ((if (> b 0) + -) a b))
(a_plus_abs_b 1 2)
(a_plus_abs_b 1 -2)

;1.5
(test  0 (p))


;C:\Program Files\Racket>Racket
;Welcome to Racket v6.2.
;> (define (p) (p))
;> (define (test x y) (if (= x 0) 0 y)  )
;> (test 0 (p))
;loop 进入死循环


