package org.blbulyandavbulyan.complexcalc

import org.blbulyandavbulyan.complexcalc.calc.Calculator
import org.blbulyandavbulyan.complexcalc.calc.ExpressionParser
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val calculator = Calculator()
    val expressionParser = ExpressionParser(calculator)
    while (true){
        try {
            val expression = sc.nextLine()
            if(expression == "EXIT" || expression == "exit") return
            val result = expressionParser.parse(expression)
            println(result)
        }
        catch (e: RuntimeException){
            println(e.message)
        }
    }
}