package org.blbulyandavbulyan.complexcalc

import org.blbulyandavbulyan.complexcalc.calc.Calculator
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val calculator = Calculator()
    while (true){
        try {
            val expression = sc.nextLine()
            if(expression == "EXIT" || expression == "exit") return
            val result = calculator.processExpression(expression)
            println(result)
        }
        catch (e: RuntimeException){
            println(e.message)
        }
    }
}