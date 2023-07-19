package org.blbulyandavbulyan.complexcalc

import kotlin.math.pow

/**
 * Предоставляет класс для работы с комплексными числами
 * @property real действительная часть комплексного числа
 * @property imaginary мнимая часть комплексного числа
 */
class ComplexNumber(private val real: Double, private val imaginary: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)

    operator fun minus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)

    operator fun times(other: ComplexNumber): ComplexNumber =
        ComplexNumber(
            real * other.real - imaginary * other.imaginary,
            imaginary * other.real + real * other.imaginary
        )

    operator fun div(other: ComplexNumber): ComplexNumber {
        val a = this.real
        val b = this.imaginary
        val c = other.real
        val d = other.imaginary
        return ComplexNumber((a * c + b * d) / (c.pow(2) + d.pow(2)), (b * c - a * d) / (c.pow(2) + d.pow(2)))
    }
}
