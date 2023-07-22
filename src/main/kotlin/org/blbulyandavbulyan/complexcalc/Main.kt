package org.blbulyandavbulyan.complexcalc

import org.blbulyandavbulyan.complexcalc.calc.Calculator
import org.blbulyandavbulyan.complexcalc.calc.CalculatorWithLogging
import org.blbulyandavbulyan.complexcalc.expressions.ExpressionParser
import org.blbulyandavbulyan.complexcalc.calc.exceptions.WrongExpressionException
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import org.blbulyandavbulyan.complexcalc.expressions.Expression
import java.util.Scanner
import java.util.logging.FileHandler

/**
 * @param expression выражение, которое нужно вычислить
 * @receiver калькулятор, который будет производить вычисление
 * @return комплексное число, которое получилось в результате вычисления выражения
 * @see Calculator.calculate(ComplexNumber, ComplexNumber, Operation)
 */
private fun Calculator.calculate(expression: Expression): ComplexNumber = this.calculate(expression.operand1, expression.operand2, expression.operation)
fun main() {
    val sc = Scanner(System.`in`)
    val calculator = CalculatorWithLogging()
    val fileHandler = FileHandler("log.txt")
    calculator.logger.addHandler(fileHandler)
    calculator.logger.useParentHandlers = false
    val expressionParser = ExpressionParser()
    while (true){
        try {
            val expressionString = sc.nextLine()
            if(expressionString == "EXIT" || expressionString == "exit") return
            val expression = expressionParser.parse(expressionString)
            println(calculator.calculate(expression))
        }
        catch (e: RuntimeException){
            if(e is WrongComplexNumber || e is WrongExpressionException) println(e.message)
            else throw e
        }
    }
}
