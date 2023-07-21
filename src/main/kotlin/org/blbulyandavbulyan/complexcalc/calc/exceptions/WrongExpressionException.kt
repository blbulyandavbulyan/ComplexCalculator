package org.blbulyandavbulyan.complexcalc.calc.exceptions

class WrongExpressionException: CalculatorException{
    constructor(msg: String, throwable: Throwable): super(msg, throwable)
    constructor(msg: String) : super(msg)
}