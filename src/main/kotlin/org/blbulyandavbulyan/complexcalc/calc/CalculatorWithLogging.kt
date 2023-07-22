package org.blbulyandavbulyan.complexcalc.calc

import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import java.lang.Exception
import java.util.logging.Logger
import java.util.logging.Level

/**
 * Данный класс добавляет логирование к калькулятору, он очень похож на паттерн "декоратор", а возможно это он и есть
 */
class CalculatorWithLogging : Calculator() {
    val logger: Logger = Logger.getLogger(this.javaClass.name)
    override fun calculate(a: ComplexNumber, b: ComplexNumber, operation: Operation): ComplexNumber {
        try {
            val result = super.calculate(a, b, operation)
            logger.info("calculate was called with operands: $a and $b and operation: $operation and result: $result")
            return result
        } catch (exception: Exception) {
            logger.log(Level.SEVERE, exception) {
                "There was exception in calculator: "
            }
            throw exception
        }
    }
}