;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname screener) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))


; screensaver-3:
; The screensaver is a universe program that displays circles
; that move around a canvas an allow interaction by the user.

(require rackunit)
(require "extras.rkt")
(require 2htdp/universe)
(require 2htdp/image)

(check-location "04" "screensaver-3.rkt")

(provide
  screensaver
  initial-world
  world-after-tick
  world-after-key-event
  world-after-mouse-event
  world-paused?
  new-circle
  circ-after-mouse-event
  circ-selected?
  circ-x
  circ-y
  circ-vx
  circ-vy
  world-circles
  circle-pen-down?
  circle-after-key-event
)


; ==============================================================================


; DATA DEFINITIONS:

(define-struct world (circles paused? button-down? mouse-x mouse-y))   
; A WorldState is a
;     (make-world ListOfCircle Boolean Boolean NonNegInt NonNegInt)
; INTERPRETATION:
; -- circles : ListOfCircle
; -- paused? : true iff the world state is paused, otherwise false
; -- button-down? : true iff the mouse button is down (button-down or drag)
; -- mouse-x : the x-coordinate of the mouse
; -- mouse-y : the y-coordinate of the mouse
;
; (define (world-fn w)
;   (...
;     (world-circles w)
;     (world-paused? w)
;     (world-button-down? w)
;     (world-mouse-x w)
;     (world-mouse-y w)


(define-struct circ (x y vx vy selected? ox oy pen-down? marks))    
; A Circle is a
;     (make-circ NonNegInt NonNegInt Int Int Bolean Int Intx)
; INTERPRETATION:
; -- x : x-coordinate of the center of the circle
; -- y : y-coordinate of the center of the circle
; -- vx : x-direction velocity of the circle
; -- vy : y-direction velocity of the circle
; -- selected? : true iff the given circle is selected
; -- ox : when a circle is selected, this is the x-offset between the
;         center of the circle and the location of the button-down event
; -- oy : when a circle is selected, this is the y-offset between the
;         center of the circle and the location of the button-down event
; -- pen-down? : true if the circle's pen is down, otherwise false
; -- marks : a ListOfPosn representing the visible marks that were made
;            by the circle
;
; (define (circle-fn c)
;   (...
;     (circ-x c)
;     (circ-y c)
;     (circ-vx c)
;     (circ-vy c) 
;     (circ-selected? c)
;     (circ-ox c)
;     (circ-oy c)
;     (circ-pen-down? c)
;     (circ-marks c)))


; A ListOfCircle (LOC) is a:
; -- empty
; -- (cons Circle LOC)
;
; loc-fn : LOC -> ??
; (define (loc-fn loc)
;   (cond
;     [(empty? loc) ...]
;     [else (...
;             (circle-fn (first loc))
;             (loc-fn (rest loc)))]))


; A ListOfPosn (LOP) is a:
; -- empty
; -- (cons Posn LOP)
;
; loc-fn : LOP -> ??
; (define (lop-fn lop)
;   (cond
;     [(empty? lop) ...]
;     [else (...
;             (posn-fn (first lop))
;             (lop-fn (rest lop)))]))


; ==============================================================================



; CONSTANTS
(define RADIUS 40)
(define WIDTH 400)
(define HEIGHT 300)
(define MIN-X RADIUS)
(define MIN-Y RADIUS)
(define MAX-X (- WIDTH RADIUS))
(define MAX-Y (- HEIGHT RADIUS))
(define MID-X (/ WIDTH 2))
(define MID-Y (/ HEIGHT 2))
(define EMPTY-CANVAS (empty-scene WIDTH HEIGHT))
(define CIRCLE-COLOR "blue")
(define CIRCLE-COLOR-SELECTED "red")
(define FONT-COLOR "blue")
(define FONT-SIZE 12)
(define EMPTY-CIRCLE (circle RADIUS "outline" CIRCLE-COLOR))
(define EMPTY-CIRCLE-SELECTED (circle RADIUS "outline" CIRCLE-COLOR-SELECTED))
(define CIRCLE-NEW (make-circ MID-X MID-Y 0 0 #f 0 0 #f empty))
(define MARK (circle 1 "solid" "black"))
(define pause-key-event " ")
(define non-pause-key-event "q")



; Used for testing & examples
(define circ1 (make-circ 200 100 -12 20 #f 0 0 #f empty))
(define circ2 (make-circ 200 200 23 -14 #f 0 0 #f empty))
(define circ-selected (make-circ 200 100 -12 20 #t 0 0 #f empty))
(define circ1-text (text "(-12, 20)" FONT-SIZE FONT-COLOR))
(define circ2-text (text "(23, -14)" FONT-SIZE FONT-COLOR))
(define circ1-image (overlay circ1-text EMPTY-CIRCLE))
(define circ2-image (overlay circ2-text EMPTY-CIRCLE))
(define circ-selected-image (overlay circ1-text EMPTY-CIRCLE-SELECTED))
(define mouse-image (circle 5 "solid" "red"))
(define world0 (make-world empty #t #f 0 0))
(define world0-after-n (make-world (list (make-circ MID-X MID-Y 0 0 #f 0 0 #f empty)) #t #f 0 0))
(define world-with-marks (make-world (list (make-circ MID-X MID-Y 0 0 #t 0 0 #f (list (make-posn 190 200) (make-posn 200 200)))) #t #f 0 0))
(define world-with-marks-after-e (make-world (list (make-circ MID-X MID-Y 0 0 #t 0 0 #f empty)) #t #f 0 0))
(define paused-world (make-world (list circ1 circ2) #t #f 0 0))
(define unpaused-world (make-world (list circ1 circ2) #f #f 0 0))  
(define unpaused-world2 (make-world (list (make-circ 188 120 -12 20 #f 0 0 #f empty)
                                          (make-circ 223 186 23 -14 #f 0 0 #f empty)) #f #f 0 0))  
(define world-with-pen-down (make-world (list (make-circ MID-X MID-Y 0 0 #f 0 0 #t empty)) #f #f 0 0))
(define world-with-pen-down2 (make-world (list (make-circ MID-X MID-Y 0 0 #f 0 0 #t (list (make-posn MID-X MID-Y)))) #f #f 0 0))


; ==============================================================================


; screensaver : PosReal -> WorldState
; GIVEN: the speed of the simulation, in seconds/tick
; EFFECT: runs the simulation, starting with the initial state as
; specified in the problem set.
; RETURNS: the final state of the world 
(define (screensaver speed)
  (big-bang (initial-world 1)
            [on-tick world-after-tick speed]
            [on-key world-after-key-event]
            [on-mouse world-after-mouse-event]
            [to-draw render]))


; ==============================================================================


; initial-world : Any -> WorldState
; GIVEN: any value (ignored)
; RETURNS: the initial world specified in the problem set
; EXAMPLES:
; (initial-world 1) = (make-world empty #t #f 0 0)
; STRATEGY: used template for WorldState
(define (initial-world v)
  (make-world empty #t #f 0 0))

(begin-for-test
  (check-equal? 
   (initial-world 1)
   (make-world empty #t #f 0 0)
   "initial world should return (make-world empty #t #f 0 0)"))


; world-after-tick : WorldState -> WorldState
; RETURNS: the world state that should follow the given world state
; after a tick event.
; EXAMPLES:
; (world-after-tick paused-world) = paused-world
; (world-after-tick unpaused-world) = unpaused-world2
; STRATEGY: used template for WorldState
(define (world-after-tick w)
  (if (world-paused? w)
      w
      (make-world
        (loc-after-tick (world-circles w))
        #f
        (world-button-down? w)
        (world-mouse-x w)
        (world-mouse-y w))))

(begin-for-test
  (check-equal? 
   (world-after-tick paused-world)
   paused-world
   "A paused world should remain a paused world after a tick-event")
  
  (check-equal? 
   (world-after-tick unpaused-world)
   unpaused-world2
   "An unpaused world should remain an unpaused after a tick-event")

  (check-equal? 
   (world-after-tick world-with-pen-down)
   world-with-pen-down2
   "A world that contains a circle with a pen-down should add marks after each tick"))



; world-after-key-event : WorldState KeyEvent -> WorldState
; RETURNS: the world that should follow the given world
; after the given keyevent
; On " " (space bar), toggle paused?. Ignore all other key events. 
; EXAMPLES:
; (world-after-key-event unpaused-world pause-key-event) = paused-world
; (world-after-key-event paused-world pause-key-event) = unpaused-world
; (world-after-key-event unpaused-world non-pause-key-event) = unpaused-world
; (world-after-key-event paused-world non-pause-key-event) = paused-world
; STRATEGY: cases on KeyEvent ke
(define (world-after-key-event w ke)
  (cond
    [(key=? ke pause-key-event) (world-with-paused-toggled w)]
    [(key=? ke "n") (world-after-new-circle-key-event w)]
    [else (world-after-existing-circle-key-event w ke)]))

(begin-for-test
  (check-equal? 
   (world-after-key-event unpaused-world pause-key-event)
   paused-world
   "an unpaused world should transition to a paused world following
     a (space bar) key event")
  
  (check-equal? 
   (world-after-key-event paused-world pause-key-event)
   unpaused-world
   "a paused world should transition to an unpaused world following
     a (space bar) key event")
  
  (check-equal? 
   (world-after-key-event unpaused-world non-pause-key-event)
   unpaused-world
   "an unpaused world should remain an unpaused world following
     a non-(space bar) key event")
  
  (check-equal? 
   (world-after-key-event paused-world non-pause-key-event)
   paused-world
   "a paused world should remain a paused world following
     a non-(space bar) key event")
  
  (check-equal? 
   (world-after-key-event world0 "n")
   world0-after-n
   "world0-after-n should follow world0 given a 'n' key event")

  (check-equal? 
   (world-after-key-event world-with-marks "e")
   world-with-marks-after-e
   "The 'e' key should erase all marks for the selected circle"))


; ==============================================================================


; loc-after-tick : ListOfCircle : ListOfCircle
; RETURNS: the given loc that should follow a tick event
; EXAMPLES:
; (loc-after-tick (list circ1)) = (list (make-circ 188 120 -12 20 #f 0 0 #f empty))
; STRATEGY: use template for ListOfCircle
(define (loc-after-tick loc)
  (cond
     [(empty? loc) empty]
     [else (cons
             (circ-after-tick (first loc))
             (loc-after-tick (rest loc)))])) 


; circ-after-tick : Circle -> Circle
; RETURNS: the circ that will follow the given circ following it's next move
; EXAMPLES:
; (circ-after-tick (new-circle 100 200 10 20)) = (make-circ 110 220 10 20 #f 0 0)
; (circ-after-tick (new-circle 50 200 -10 20)) = (make-circ 40 220 10 20 #f 0 0)
; (circ-after-tick (new-circle 350 200 20 20)) = (make-circ 360 220 -20 20 #f 0 0)
; (circ-after-tick (make-circ 350 200 20 20 #t 0 0)) = (make-circ 350 200 20 20 #t 0 0))
; STRATEGY: use template for Circle
(define (circ-after-tick c)
  (if (circ-selected? c)
      c
      (make-circ (circ-x-after-move c)
                 (circ-y-after-move c)
                 (circ-vx-after-move c)
                 (circ-vy-after-move c)
                 #f
                 0
                 0
                 (circ-pen-down? c)
                 (circ-marks-after-move c))))


(begin-for-test
  (check-equal?
   (circ-after-tick (make-circ 350 200 20 20 #t 0 0 #f empty))
   (make-circ 350 200 20 20 #t 0 0 #f empty)
   "A selected circle should not move due to a tick event"))


; circ-vx-after-move : Circle -> Int
; RETURNS: the x-velocity of the given circ following it's next move
; EXAMPLES:
; (circ-vx-after-move (make-circ 100 200 10 20)) = 10
; (circ-vx-after-move (make-circ 50 200 -10 20)) = 10
; (circ-vx-after-move (make-circ 350 200 20 20)) = -20
; STRATEGY: use template for Circle
(define (circ-vx-after-move c)
  (if (x-bounce? c)
      (* -1 (circ-vx c))
      (circ-vx c)))


(begin-for-test
  
  (check-equal? 
   (circ-vx-after-move (make-circ 100 200 10 20 #f 0 0 #f empty))
   10
   "The circle's x-velocity should remain the same unless the circle bounces
     off the left or right sides of the canvas")
  
  (check-equal? 
   (circ-vx-after-move (make-circ 45 200 -10 20 #f 0 0 #f empty))
   10
   "The circle's x-velocity should flip signs when the circle bounces
     off the left or right sides of the canvas")
  
  (check-equal? 
   (circ-vx-after-move (make-circ 390 200 20 20 #f 0 0 #f empty))
   -20
   "The circle's x-velocity should flip signs when the circle bounces
     off the left or right sides of the canvas"))


; circ-vy-after-move : Circle -> Int
; RETURNS: the y-velocity of the given circle following it's next move
; EXAMPLES:
; (circ-vy-after-move (make-circ 100 200 10 20)) = 20
; (circ-vy-after-move (make-circ 50 50 -10 -20)) = 20
; (circ-vy-after-move (make-circ 350 290 20 20)) = -20
; STRATEGY: use template for Circle
(define (circ-vy-after-move c)
  (if (y-bounce? c)
      (* -1 (circ-vy c))
      (circ-vy c)))

(begin-for-test
  
  (check-equal? 
   (circ-vy-after-move (make-circ 100 200 10 20 #f 0 0 #f empty))
   20
   "The circle's y-velocity should remain the same unless the circle bounces
     off the top or bottom of the canvas")
  
  (check-equal? 
   (circ-vy-after-move (make-circ 10 20 -10 -20 #f 0 0 #f empty))
   20
   "The circle's y-velocity should flip signs when the circle bounces
     off the top or bottom of the canvas")
  
  (check-equal? 
   (circ-vy-after-move (make-circ 390 290 20 20 #f 0 0 #f empty))
   -20
   "The circle's y-velocity should flip signs when the circle bounces
     off the top or bottom of the canvas"))


; x-bounce? : Circle -> Boolean
; RETURNS: true iff the given circle will bounce off the left or
;   right edges of the canvas on its next move.
; EXAMPLES:
; (x-bounce? circ1) = #f
; (x-bounce? (make-circ 50 200 -20 30)) = #t
; STRATEGY: combine simpler functions
(define (x-bounce? c)
  (not (< MIN-X (circ-x-after-move c) MAX-X)))


; y-bounce? : Circle -> Boolean
; RETURNS: true iff the given circ will bounce off the top or
;   bottom edges of the canvas on its next move.
; EXAMPLES:
; (y-bounce? circ1) = #f
; (y-bounce? (make-circ 200 250 20 30)) = #t
; STRATEGY: combine simpler functions
(define (y-bounce? c)
  (not (< MIN-Y (circ-y-after-move c) MAX-Y)))


; circ-x-after-move : Circle -> NonNegInt
; RETURNS: the given circle's x-coordinate following it's next move
; EXAMPLES:
; (circ-x-after-move (make-circ 100 200 10 20)) = 110
; (circ-x-after-move (make-circ 350 250 50 20)) = 360
; (circ-x-after-move (make-circ 50 50 -30 -20)) = 40
; STRATEGY: use template for Circle
(define (circ-x-after-move c)
  (min MAX-X
       (max MIN-X
            (+ (circ-x c) (circ-vx c)))))


; circ-y-after-move : Circle -> NonNegInt
; RETURNS: the given circle's y-coordinate following it's next move
; EXAMPLES:
; (circ-y-after-move (make-circ 100 200 10 20)) = 220
; (circ-y-after-move (make-circ 100 250 10 20)) = 260
; (circ-y-after-move (make-circ 100 50 10 -20)) = 40
; STRATEGY: use template for Circle
(define (circ-y-after-move c)
  (min MAX-Y
       (max MIN-Y
            (+ (circ-y c) (circ-vy c)))))


; circ-marks-after-move : Circle -> ListOfPosn
; RETURNS: the given circle's marks following it's next move
; EXAMPLES:
; (circ-marks-after-move (make-circ 200 200 10 10 #f 0 0 #t empty))
;   = (make-posn 200 200)
; STRATEGY: Use template for Circle
(define (circ-marks-after-move c)
  (if (circ-pen-down? c)
      (cons (make-posn (circ-x c) (circ-y c)) (circ-marks c))
      (circ-marks c)))


; ==============================================================================


; world-after-new-circle-key-event : WorldState : WorldState
; RETURNS: the given world with a new circle added in the center of the
;          image with x- and y-velocities initially set to zero
; EXAMPLES:
; (world-after-new-circle-key-event world0) =
;     (make-world (list (make-circ MID-X MID-Y 0 0 #f 0 0 #f empty)) #t #f 0 0)
; STRATEGY: use template for WorldState
(define (world-after-new-circle-key-event w)
  (make-world
    (cons CIRCLE-NEW (world-circles w))
    (world-paused? w)
    (world-button-down? w)
    (world-mouse-x w)
    (world-mouse-y w)))


; world-after-existing-circle-key-event : WorldState ke : WorldState
; RETURNS: the world that should follow the given world and the given
;          key event
; EXAMPLES:
; (world-after-new-circle-key-event world0) = world0
; STRATEGY: use template for WorldState
(define (world-after-existing-circle-key-event w ke)
  (make-world
    (loc-after-key-event (world-circles w) ke)
    (world-paused? w)
    (world-button-down? w)
    (world-mouse-x w)
    (world-mouse-y w)))


; loc-after-key-event : ListOfCircle ke : ListOfCircle
; RETURNS: the given loc that should follow the given key event
; EXAMPLES:
; (loc-after-key-event (list circ1) " ") = (list circ1)
; (loc-after-key-event (list (make-circ MID-X MID-Y 0 0 #f 0 0 #t empty)) "u")
;    = (list (make-circ MID-X MID-Y 0 0 #f 0 0 #f empty))
; STRATEGY: use template for ListOfCircle
(define (loc-after-key-event loc ke)
  (cond
    [(empty? loc) empty]
    [else (cons
             (circle-after-key-event (first loc) ke)
             (loc-after-key-event (rest loc) ke))]))


; circle-after-key-event : Circle KeyEvent -> Circle
; RETURNS: the state of the circle that should follow the given
; circle after the given key event
; EXAMPLES:
; (circle-after-key-event (make-circ MID-X MID-Y 0 0 #f 0 0 #t empty)) "u")
;     = (make-circ MID-X MID-Y 0 0 #f 0 0 #f empty)
; STRATEGY: cases on KeyEvent ke
(define (circle-after-key-event c ke)
  (if (circ-selected? c)
      (cond
        [(key=? ke "up") (circ-adjust-velocities c 0 -2)]
        [(key=? ke "down") (circ-adjust-velocities c 0 2)]
        [(key=? ke "left") (circ-adjust-velocities c -2 0)]
        [(key=? ke "right") (circ-adjust-velocities c 2 0)]
        [(key=? ke "d") (circ-set-pen-down c #t)]
        [(key=? ke "u") (circ-set-pen-down c #f)]
        [(key=? ke "e") (circ-erase-marks c)]
        [else c])
      c))

(begin-for-test
  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "up")
   (make-circ 100 100 0 -2 #t 0 0 #f empty)
   "an up arrow ke should change the y-velocity by -2")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "down")
   (make-circ 100 100 0 2 #t 0 0 #f empty)
   "a down arrow ke should change the y-velocity by +2")
  
  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "left")
   (make-circ 100 100 -2 0 #t 0 0 #f empty)
   "a left arrow ke should change the x-velocity by -2")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "right")
   (make-circ 100 100 2 0 #t 0 0 #f empty)
   "a right arrow ke should change the x-velocity by +2")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "d")
   (make-circ 100 100 0 0 #t 0 0 #t empty)
   "a 'd' ke should drop the circle's pen")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #t empty) "u")
   (make-circ 100 100 0 0 #t 0 0 #f empty)
   "a 'u' ke should lift the circle's pen")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f (list (make-posn 10 10))) "e")
   (make-circ 100 100 0 0 #t 0 0 #f empty)
   "a 'e' ke should erase the circle's marks")

  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #t 0 0 #f empty) "z")
   (make-circ 100 100 0 0 #t 0 0 #f empty)
   "an unrecognized ke should not impact the circle")
  
  (check-equal?
   (circle-after-key-event (make-circ 100 100 0 0 #f 0 0 #f empty) "d")
   (make-circ 100 100 0 0 #f 0 0 #f empty)
   "an unselected circle should not be impacted by a ke"))

  
; circ-adjust-velocities : Circle Int Int : Circle
; RETURNS: the given circle with it's x- and y-velocities adjusted by
;   the given change in velocities (dx, dy)
; EXAMPLES:
; (circ-adjust-velocities (make-circ 0 0 0 0 #f 0 0 #f empty) 0 -2)
;     = (make-circ 0 0 0 -2 #f 0 0 #f empty)
; Strategy: use template for Circle
(define (circ-adjust-velocities c dx dy)
  (make-circ
     (circ-x c)
     (circ-y c)
     (+ (circ-vx c) dx)
     (+ (circ-vy c) dy)
     (circ-selected? c)
     (circ-ox c)
     (circ-oy c)
     (circ-pen-down? c)
     (circ-marks c)))



; circ-set-pen-down : Circle Boolean : Circle
; RETURNS: the given circle with it's pen-down? set to the given boolean
; EXAMPLES:
; (circ-set-pen-down (make-circ 0 0 0 0 #f 0 0 #f empty) #t)
;     = (make-circ 0 0 0 0 #f 0 0 #t empty)
; Strategy: use template for Circle
(define (circ-set-pen-down c b)
  (make-circ
     (circ-x c)
     (circ-y c)
     (circ-vx c)
     (circ-vy c)
     (circ-selected? c)
     (circ-ox c)
     (circ-oy c)
     b
     (circ-marks c)))


; circ-erase-marks : Circle : Circle
; RETURNS: the given circle with all existing marks removed
; EXAMPLES:
; (circ-erase-marks (make-circ 0 0 0 0 #f 0 0 #f (list (make-posn 1 1))))
;     = (make-circ 0 0 0 0 #f 0 0 #f empty)
; Strategy: use template for Circle
(define (circ-erase-marks c)
  (make-circ
     (circ-x c)
     (circ-y c)
     (circ-vx c)
     (circ-vy c)
     (circ-selected? c)
     (circ-ox c)
     (circ-oy c)
     (circ-pen-down? c)
     empty))


; ==============================================================================



; world-after-mouse-event : WorldState Int Int MouseEvent -> WorldState
; GIVEN: A World, the x- and y-coordinates of a mouse event, and the
; mouse event
; RETURNS: the world that should follow the given world after the given mouse
; event.
; EXAMPLES:
; (world-after-mouse-event (initial-world 1) 10 15 "button-down")
;   =   (make-world empty #t #t 10 15)
; STRATEGY: use template for WorldState on w
(define (world-after-mouse-event w mx my mev)
  (make-world
   (loc-after-mouse-event (world-circles w) mx my mev)
   (world-paused? w)
   (or (mouse=? mev "button-down") (mouse=? mev "drag"))
   mx
   my))


(begin-for-test
  (check-equal?
   (world-after-mouse-event (initial-world 1) 10 15 "button-down")
   (make-world
        empty
        #t
        #t
        10
        15)
   "World should change to button-down state with mouse coordinates of (10, 15)")
  
  (check-equal?
   (world-after-mouse-event (initial-world 1) 10 15 "drag")
   (make-world
        empty
        #t
        #t
        10
        15)
   "World should change to button-down state with mouse coordinates of (10, 15)")

  (check-equal?
   (world-after-mouse-event (make-world (list circ1) #t #t 10 15) 10 15 "drag")
   (make-world (list circ1) #t #t 10 15)
   "World should change to button-down state with mouse coordinates of (10, 15)"))


; loc-after-mouse-event : ListOfCircle Int Int MouseEvent : ListOfCircle
; RETURNS: the loc that should follow the given loc and the given mouse event
; EXAMPLES:
; (loc-after-mouse-event (list circ1) " ") = (list circ1)
; STRATEGY: use template for ListOfCircle
(define (loc-after-mouse-event loc mx my mev)
  (cond
    [(empty? loc) empty]
    [else (cons
             (circ-after-mouse-event (first loc) mx my mev)
             (loc-after-mouse-event (rest loc) mx my mev))]))


; circ-after-mouse-event :  Circle Int Int MouseEvent -> Circle
; GIVEN: A circle, the x- and y-coordinates of a mouse event, and the
; mouse event
; RETURNS: the circle that should follow the given circle after
; the given mouse event
; EXAMPLES:
; (circ-after-mouse-event circ1 210 120 "button-down")
;     = (make-circ 200 100 -12 20 #t 10 20)
; (circ-after-mouse-event circ1 0 0 "leave")
;     = circ1
; (circ-after-mouse-event (make-circ 200 200 10 -10 #t 15 -5) 210 120 "drag")
;     = (make-circ 225 115 10 -10 #t 15 -5)
; (circ-after-mouse-event (make-circ 200 200 10 -10 #t 15 -5) 210 120 "button-up")
;     = (make-circ 200 200 10 -10 #f 15 -5)
; STRATEGY: cases on mouse event mev
(define (circ-after-mouse-event c mx my mev)
  (cond
    [(mouse=? mev "button-down") (circ-after-button-down c mx my)]
    [(mouse=? mev "drag") (circ-after-drag c mx my)]
    [(mouse=? mev "button-up") (circ-after-button-up c mx my)]
    [else c]))


(begin-for-test
  (check-equal?
   (circ-after-mouse-event circ1 210 120 "button-down")
   (make-circ 200 100 -12 20 #t -10 -20 #f empty)
   "The output should be a selected circle with offsets (10, 20)")

  (check-equal?
   (circ-after-mouse-event circ1 0 0 "leave")
   circ1
   "A leave event has undefined behavior")
  
  (check-equal?
   (circ-after-mouse-event (make-circ 200 200 10 -10 #t 15 -5 #f empty) 210 120 "drag")
   (make-circ 225 115 10 -10 #t 15 -5 #f empty)
   "The output should be a selected circle with offsets (15, -5)")

  (check-equal?
   (circ-after-mouse-event (make-circ 200 200 10 -10 #t 15 -5 #f empty) 210 120 "button-up")
   (make-circ 200 200 10 -10 #f 15 -5 #f empty)
   "The output should be a selected circle with offsets (15, -5)"))


; circ-after-button-down : Circle Int Int -> Circle
; GIVEN: A circle and the x- and y-coordinates of a button-down mouse event
; RETURNS: the circle that should follow the given circle after
; the mouse event
; EXAMPLES:
; (circ-after-button-down circ1 10 10) = circ1
; STRATEGY: use template for Circle
(define (circ-after-button-down c mx my)
  (if (button-down-within-circle? c mx my)
      (make-circ (circ-x c)
                 (circ-y c)
                 (circ-vx c)
                 (circ-vy c)
                 #t
                 (- (circ-x c) mx)
                 (- (circ-y c) my)
                 (circ-pen-down? c)
                 (circ-marks c))
      c))

(begin-for-test
  (check-equal?
   (circ-after-button-down (make-circ 100 100 0 0 #t 0 0 #f empty) 0 0)
   (make-circ 100 100 0 0 #t 0 0 #f empty)
   "a button down outside of the circle should not impact the circle"))


; button-down-within-circle? : Circle Int Int -> Boolean
; GIVEN: A circle and the x- and y-coordinates of a button-down mouse event
; RETURNS: true iff the button-down mouse event coordinates fall within the
; area of the circle
; EXAMPLES:
; (button-down-within-circle? 200 100) = #t
; STRATEGY: combine simpler functions
(define (button-down-within-circle? c mx my)
  (< (sqrt (+ (sqr (- mx (circ-x c)))
              (sqr (- my (circ-y c)))))
     RADIUS))


; circ-after-drag : Circle Int Int -> Circle
; GIVEN: A circle and the x- and y-coordinates of a drag mouse event
; RETURNS: the circle that should follow the given circle after
; the mouse event
; EXAMPLES:
; (circ-after-drag circ1) = circ1
; STRATEGY: use template for Circle
(define (circ-after-drag c mx my)
  (if (circ-selected? c)
      (make-circ (+ mx (circ-ox c))
                 (+ my (circ-oy c))
                 (circ-vx c)
                 (circ-vy c)
                 #t
                 (circ-ox c)
                 (circ-oy c)
                 (circ-pen-down? c)
                 (circ-marks c))
      c))

(begin-for-test
  (check-equal?
   (circ-after-drag circ1 200 200)
   circ1
   "An unselected circle should not be change due to a mouse-drag event"))


; circ-after-button-up : Circle Int Int -> Circle
; GIVEN: A circle and the x- and y-coordinates of a button-up mouse event
; RETURNS: the circle that should follow the given circle after
; the mouse event
; EXAMPLES:
; (circ-after-button-up (new-circle 50 60 10 -10 #f) 200 200)
;     = (new-circle 50 60 10 -10 #t))
; STRATEGY: use template for Circle
(define (circ-after-button-up c mx my)
  (if (circ-selected? c)
      (make-circ (circ-x c)
                 (circ-y c)
                 (circ-vx c)
                 (circ-vy c)
                 (not (circ-selected? c))
                 (circ-ox c)
                 (circ-oy c)
                 (circ-pen-down? c)
                 (circ-marks c))
      c))


(begin-for-test
  (check-equal?
   (circ-after-button-up circ1 200 200)
   circ1
   "An unselected circle should not be change due to a button-up mouse event"))


; ==============================================================================




  
; world-with-paused-toggled : WorldState -> WorldState
; RETURNS: a world just like the given one, but with 
;  paused? toggled
; EXAMPLES:
; (world-with-paused-toggled unpaused-world) = paused-world
; (world-with-paused-toggled paused-world) = unpaused-world
; STRATEGY: use template for WorldState on w
(define (world-with-paused-toggled w)
  (make-world
   (world-circles w)
   (not (world-paused? w))
   (world-button-down? w)
   (world-mouse-x w)
   (world-mouse-y w)))

(begin-for-test

  (check-equal? 
   (world-with-paused-toggled unpaused-world)
   paused-world
   "an unpaused world should transition to a paused world")
  
  (check-equal? 
   (world-with-paused-toggled paused-world)
   unpaused-world
   "a paused world should transition to an unpaused world"))


; circle-pen-down? : Circle -> Boolean
; RETURNS: true if the pen in the given circle is down, otherwise false
; Examples:
; (circle-pen-down? (make-circ 200 200 0 0 #f 0 0 #f)) = #f
; (circle-pen-down? (make-circ 200 200 0 0 #f 0 0 #t)) = #t
; STRATEGY: use template for Circle on c
(define (circle-pen-down? c)
  (circ-pen-down? c))

(begin-for-test
  (check-false
   (circle-pen-down? (make-circ 200 200 0 0 #f 0 0 #f empty))
   "A circle with a pen-down of false should return false")
  (check-true
   (circle-pen-down? (make-circ 200 200 0 0 #f 0 0 #t empty))
   "A circle with a pen-down of true should return true"))



; new-circle : NonNegInt NonNegInt Int Int -> Circle
; GIVEN: 2 non-negative integers x and y, and 2 integers vx and vy
; RETURNS: an unselected circle centered at (x,y), which will travel with
; velocity (vx, vy). The circle also starts with its pen up.
; EXAMPLES:
; (new-circle 1 2 3 4) = (make-circ 1 2 3 4 #f 0 0 #f empty)
; STRATEGY: use template for Circ
(define (new-circle x y vx vy)
  (make-circ x y vx vy #f 0 0 #f empty))

(begin-for-test
  (check-equal? 
   (new-circle 1 2 3 4) 
   (make-circ 1 2 3 4 #f 0 0 #f empty)))


; ==============================================================================


; render : WorldState -> Scene
; RETURNS: a scene that portrays the given world.
; EXAMPLE: 
; (render (initial-world 1))
;   = (place-image circ1-image 200 100
;        (place-image circ2-image 200 200 EMPTY-CANVAS)))
; (render (make-world circ1 circ2 #t #t 10 10)
;   = (place-image mouse-image 10 10
;       (place-image circ1-image 200 100
;        (place-image circ2-image 200 200 EMPTY-CANVAS)))
; STRATEGY: combine simpler functions
(define (render w)
  (if (world-button-down? w)
      (place-image mouse-image (world-mouse-x w) (world-mouse-y w)
               (render-loc-on-image (world-circles w) EMPTY-CANVAS))
      (render-loc-on-image (world-circles w) EMPTY-CANVAS)))

(begin-for-test
  
  (check-equal? 
     (render (initial-world 1))
     EMPTY-CANVAS
     "(render (initial-world 1)) did not yield the expected scene")
  
  (check-equal? 
     (render (make-world (list circ1 circ2) #t #t 10 10))
     (place-image mouse-image 10 10
                  (place-image circ1-image 200 100
                               (place-image circ2-image 200 200 EMPTY-CANVAS)))
     "Did not yeild the expected scene"))


; render-loc-on-image : ListOfCircle Image : Image
; RETURNS: the given loc rendered on top of the given Image
; EXAMPLES:
; (render-loc-on-image empty EMPTY-CANVAS) = EMPTY-CANVAS
; STRATEGY:
(define (render-loc-on-image loc img)
  (cond
    [(empty? loc) img]
    [else (render-loc-on-image
              (rest loc)
              (place-circ (first loc) img))]))


; place-circ : Circle Image -> Image
; GIVEN: a circle and a scene
; RETURNS: the scene with the circle's center placed at the
;          circle's x- and y-coordinates
; EXAMPLES:
; (place-circ circ1 EMPTY-CANVAS)
;   = (place-image circ1-image 200 100 EMPTY-CANVAS))
; STRATEGY: use template for Circle
(define (place-circ c img)
  (place-image (draw-circ c) (circ-x c) (circ-y c)
               (draw-marks (circ-marks c) img)))

(begin-for-test
  (check-equal? 
   (place-circ circ1 EMPTY-CANVAS)
   (place-image circ1-image 200 100 EMPTY-CANVAS)
   "place-circ should draw the circle on the scene at the x- and y- coordinates specified"))


; draw-circ : Circle -> Image
; GIVEN: a circle
; RETURNS: an image with the circle's x- and y-velocities overlayed in the center of
;  the circle as: (vx, vy)
; EXAMPLES:
; (draw-circ circ1) = circ1-image
; (draw-circ circ-selected) = circ-selected-image
; STRATEGY: combine simpler functions
(define (draw-circ c)
  (if (circ-selected? c)
      (overlay (draw-circ-velocities c) EMPTY-CIRCLE-SELECTED)
      (overlay (draw-circ-velocities c) EMPTY-CIRCLE)))


(begin-for-test

  (check-equal?
   (draw-circ circ1)
   circ1-image
   "circ1-image was the expected scene")
  
  (check-equal?
   (draw-circ circ-selected)
   circ-selected-image
   "circ-selected-image was the expected scene"))


; draw-marks : ListOfPosn Image -> Image
; GIVEN: a list of coordinates representing pen markings and a background image
; RETURNS: the given background image pen markings drawn at each coordinate set
; EXAMPLES:
; (draw-marks (list (make-posn 10 15)) EMPTY-CANVAS)
;    = (place-image MARK 10 15 EMPTY-CANVAS)
; STRATEGY:
(define (draw-marks lop img)
  (cond
    [(empty? lop) img]
    [else (draw-marks
              (rest lop)
              (place-image MARK (posn-x (first lop)) (posn-y (first lop)) img))]))

(begin-for-test
  check-equal?
  (draw-marks (list (make-posn 10 15)) EMPTY-CANVAS)
  (place-image MARK 10 15 EMPTY-CANVAS))


; draw-circ-velocities : Circle -> Image
; GIVEN: a circle
; RETURNS: a text image of the circle's x- and y-velocities in th form of: (vx, vy)
; EXAMPLES:
; (draw-circ-velocities circ1) = circ1-text
; STRATEGY: combine simpler functions
(define (draw-circ-velocities c)
  (text (string-append
         "("
         (number->string (circ-vx c))
         ", "
         (number->string (circ-vy c))
         ")")
        FONT-SIZE
        FONT-COLOR))

(begin-for-test
  (check-equal? 
   (draw-circ-velocities circ1)
   circ1-text
   "draw-circ-velocities should produce a text image in the form of: (vx, vy)"))