;;sicp习题2.1的答案
;;name:yuyongjiang
;;Email:yuyongjianghit@163.com


;;这种定义代码行数太多，代码不优美
;(define (make-rat n d) 
;  (let ([g (gcd n d)])
;    (if (or (and
;           (> n 0) (> d 0))
;          (and
;           (< n 0) (< d 0)))
;        (cons (abs (/ n g)) (abs (/ d g)))
;        (cons (/ n g) (abs (/ d g))))
;    ))

  
(define (make-rat n d) 
  (let ([g ((if (> d 0)
                +
                -)
                (gcd n d))])
    (cons (/ n g)  (/ d g))))
    

(define (number x) (car x))

(define (denom x) (cdr x))

(define (print-rat x)
  (newline)
  (display (number x))
  (display "/")
  (display (denom x)))
