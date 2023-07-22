package org.blbulyandavbulyan.complexcalc.expressions

import org.blbulyandavbulyan.complexcalc.calc.Operation
import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber

data class Expression(val operand1: ComplexNumber, val operand2: ComplexNumber, val operation: Operation)
