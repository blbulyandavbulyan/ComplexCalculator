package org.blbulyandavbulyan.complexcalc.expressions

import org.blbulyandavbulyan.complexcalc.calc.Operation
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber

/**
 * Данный класс предоставляет обработанное выражение, которое в дальнейшем будет вычисляться нашим калькулятором
 */
data class Expression(val operand1: ComplexNumber, val operand2: ComplexNumber, val operation: Operation)
