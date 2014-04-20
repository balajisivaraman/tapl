package com.balajisivaraman.tapl.arith

object Evaluator {

  import terms._,Terms._

  def eval(t: Term): Option[Value] = t match {
    case If(t1, t2, t3) => eval(t1).flatMap {
      case Values.True => eval(t2)
      case Values.False => eval(t3)
    }
    case Succ(t1) => eval(t1).flatMap {
      case n: Nat => Some(Values.Succ(n))
      case _ => None
    }
    case Pred(t1) => eval(t1).flatMap {
      case Values.Zero => Some(Values.Zero)
      case Values.Succ(n) => Some(n)
      case _ => None
    }
    case IsZero(t1) => eval(t1).flatMap {
      case Values.Zero => Some(Values.True)
      case _ => Some(Values.False)
    }
    case Zero => Some(Values.Zero)
    case True => Some(Values.True)
    case False => Some(Values.False)
    case _ => None
  }

}
