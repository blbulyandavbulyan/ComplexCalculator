package org.blbulyandavbulyan.complexcalc.calc.exceptions

open class CalculatorException: RuntimeException{
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
}