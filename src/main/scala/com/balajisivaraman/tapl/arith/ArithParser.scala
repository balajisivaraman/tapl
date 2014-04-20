package com.balajisivaraman.tapl.arith

import org.parboiled2._
import terms.Term, terms.Terms._

class ArithParser(override val input: ParserInput) extends Parser {

  def ArithInput = rule { BooleanTerm | ArithTerm }

  def tmTrue = rule { Map("true" -> True) }
  def tmFalse = rule { Map("false" -> False) }
  def tmIf = rule {
    "if" ~ BooleanTerm ~ "then" ~ BooleanTerm ~ "else" ~ BooleanTerm ~> ((t1: Term, t2: Term, t3: Term) => If(t1, t2, t3))
  }
  def BooleanTerm: Rule1[Term] = rule { WhiteSpace ~ (tmTrue | tmFalse | tmIf) ~ WhiteSpace }

  def tmZero = rule { Map("0" -> Zero) }
  def tmIsZero = rule {
    "iszero" ~ '(' ~ ArithTerm ~ ')' ~> ((t: Term) => IsZero(t))
  }
  def tmSucc = rule {
    "succ" ~ '(' ~ ArithTerm ~ ')' ~> ((t: Term) => Succ(t))
  }
  def tmPred = rule {
    "pred" ~ '(' ~ ArithTerm ~ ')' ~> ((t: Term) => Pred(t))
  }
  def ArithTerm: Rule1[Term] = rule { WhiteSpace ~ (tmZero | tmIsZero | tmSucc | tmPred) ~ WhiteSpace }

  def WhiteSpace = rule { zeroOrMore(WhiteSpaceChar) }
  val WhiteSpaceChar = CharPredicate(" \n\r\t\f")

}
