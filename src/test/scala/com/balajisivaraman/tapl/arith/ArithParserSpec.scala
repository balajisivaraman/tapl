package com.balajisivaraman.tapl.arith

import org.specs2.mutable.Specification
import com.balajisivaraman.tapl.arith.terms.Terms._
import scala.util.{Failure, Try, Success}
import org.parboiled2.ParseError

class ArithParserSpec extends Specification {

  "The Arith Parser" should {

    "parse the constant true" in {
      val result = new ArithParser("true").ArithInput.run()
      result must equalTo(Success(True))
    }

    "parse the constant false" in {
      val result = new ArithParser("false").ArithInput.run()
      result must equalTo(Success(False))
    }

    "parse the constant zero" in {
      val result = new ArithParser("0").ArithInput.run()
      result must equalTo(Success(Zero))
    }

    "parse an if containing only boolean terms" in {
      val result = new ArithParser("if true then true else false").ArithInput.run()
      result must equalTo(Success(If(True,True,False)))
    }

    "parse an if containing only boolean and arithmetic terms" in {
      val result = new ArithParser("if true then 0 else succ(0)").ArithInput.run()
      result must equalTo(Success(If(True,Zero,Succ(Zero))))
    }

  }

}
