package org.blbulyandavbulyan.complexcalc

import kotlin.math.abs
import kotlin.math.pow

/**
 * Предоставляет класс для представления комплексного числа
 * @property real действительная часть комплексного числа
 * @property imaginary мнимая часть комплексного числа
 */
data class ComplexNumber(private val real: Double, private val imaginary: Double) {
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

    override fun toString(): String {
        //логика такая, если мнимая часть положительная то будет real+imaginary
        //если мнимая часть отрицательная, то будет real-imaginary
        //если она 0, то будет просто real
        return if (imaginary > 0) "$real+${imaginary}i" else if (imaginary < 0) "$real-${abs(imaginary)}i" else real.toString()
    }

}
