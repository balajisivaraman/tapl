package com.balajisivaraman.tapl.arith

import scala.util.{Failure, Success}
import com.balajisivaraman.tapl.arith.terms.{Value, Term}
import org.parboiled2.ParseError
import scala.io.StdIn

object App extends App {

  import Evaluator.eval
  val input = StdIn.readLine()
  val parsedInput = new ArithParser(input).ArithInput.run()
  val result: Option[Value] = parsedInput match {
    case Success(t: Term) => eval(t)
    case Failure(error: ParseError) => println(s"Incorrect Input: \n ${error.getMessage}"); None
    case _ => println("Incorrect Input"); None
  }
  result.map(println(_))

}
