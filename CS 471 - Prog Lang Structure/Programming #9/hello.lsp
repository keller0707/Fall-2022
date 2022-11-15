;;   Shaun Cooper
;;   November 2014
;;
;;   Example code for LISP/mzscheme which does tail recursion
;;   while adding one to each element of a list

(require trace)  ;; we turn on tracing to see how things work
                 ;; tracing must be on before defining a function

(define (addone L)
    (if (null? L)
          L
          (cons (+ (car L) 1) (addone (cdr L)))))

 

;;;  Shaun Cooper
;;;
;;;  Demonstration of recursion
;;;  left recursion  append two lists together

(require trace ) ;; so we can see what is going on

(define (myappend L1 L2)
  (if (null? L1)
      L2
      (cons (car L1) (myappend (cdr L1) L2))))

 

 

;; Shaun Cooper
;; November 2014
;;
;; A simple uniqueness function to make a list into a "set"

(define (myuniq L)
     (if (null? L)
         L
        (if (list? (member (car L) (cdr L)))
            (myuniq (cdr L))
            (cons (car L) (myuniq (cdr L))))))

 

 

;;  Shaun Cooper
;; November 2014
;;
;;  Example showing how to use eval with with known functions and lambda functio
n

;;

;; show how to evaluate a string

(eval '(+ 1 2))

(eval '((lambda (X) (+ 1 X)) 5))
