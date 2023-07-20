package org.blbulyandavbulyan.complexcalc

/**
 * Данный класс предоставляет калькулятор комплексных чисел
 * @property getOperand функция, возвращающая операнд.
 * @property getOperation функция возвращающая операцию
 */
open class Calculator(val getOperand: () -> ComplexNumber, val getOperation: () -> Operation) {
    fun calculate(): ComplexNumber = when (getOperation()) {
        Operation.ADD -> getOperand() + getOperand()
        Operation.SUB -> getOperand() - getOperand()
        Operation.DIV -> getOperand() / getOperand()
        Operation.MUL -> getOperand() * getOperand()
    }
}