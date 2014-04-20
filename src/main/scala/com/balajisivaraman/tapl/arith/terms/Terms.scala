package com.balajisivaraman.tapl.arith.terms

sealed trait Term

object Terms {
  case object True extends Term
  case object False extends Term
  case class If(t1: Term, t2: Term, t3: Term) extends Term
  case object Zero extends Term
  case class Succ(t: Term) extends Term
  case class Pred(t: Term) extends Term
  case class IsZero(t: Term) extends Term
}

sealed trait Value
sealed trait Nat extends Value

object Values {
  case object Zero extends Nat
  case object True extends Value
  case object False extends Value
  case class Succ(nv: Nat) extends Nat
}
