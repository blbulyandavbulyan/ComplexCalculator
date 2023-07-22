package org.blbulyandavbulyan.complexcalc.calc.exceptions

/**
 * Исключение выбрасывается в случае если выражение для разбора калькулятором записано в неверном формате
 */
class WrongExpressionException: CalculatorException{
    constructor(msg: String, throwable: Throwable): super(msg, throwable)
    constructor(msg: String) : super(msg)
}