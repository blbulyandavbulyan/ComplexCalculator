package org.blbulyandavbulyan.complexcalc.complex

import kotlin.math.abs
import kotlin.math.pow

/**
 * Предоставляет класс для представления комплексного числа
 * @property real действительная часть комплексного числа
 * @property imaginary мнимая часть комплексного числа
 */
data class ComplexNumber(private val real: Double, private val imaginary: Double) {
    /**
     * @param other второе слагаемое
     * @return сумму комплексных чисел
     */
    operator fun plus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real + other.real, this.imaginary + other.imaginary)

    /**
     * @param other вычитаемое
     * @return разность текущего комплексного числа и заданного
     */
    operator fun minus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(this.real - other.real, this.imaginary - other.imaginary)

    /**
     * Умножает данное комплексное число на заданное значение
     * @param other другой множитель
     * @return произведение текущего и заданного
     */
    operator fun times(other: ComplexNumber): ComplexNumber =
        ComplexNumber(
            real * other.real - imaginary * other.imaginary,
            imaginary * other.real + real * other.imaginary
        )

    /**
     * Делит данное число на заданное
     * @param other делитель
     * @return частное данного числа и заданного
     */
    operator fun div(other: ComplexNumber): ComplexNumber {
        val a = this.real
        val b = this.imaginary
        val c = other.real
        val d = other.imaginary
        return ComplexNumber((a * c + b * d) / (c.pow(2) + d.pow(2)), (b * c - a * d) / (c.pow(2) + d.pow(2)))
    }

    /**
     * Представляет данное комплексное число в виде строки
     *
     * Если мнимая часть 0, то будет представлена только вещественная часть
     *
     * Если мнимая часть > 0, то будет вещественное + мнимое
     *
     * Если мнимая часть < 0, то будет вещественное - мнимое
     * @return строковое представление данного вещественного числа
     */
    override fun toString(): String {
        //логика такая, если мнимая часть положительная то будет real+imaginary
        //если мнимая часть отрицательная, то будет real-imaginary
        //если она 0, то будет просто real
        return if (imaginary > 0) "$real+${imaginary}i" else if (imaginary < 0) "$real-${abs(imaginary)}i" else real.toString()
    }

}
