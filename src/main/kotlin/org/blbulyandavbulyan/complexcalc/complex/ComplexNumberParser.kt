package org.blbulyandavbulyan.complexcalc.complex

import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber

/**
 * Данная функция парсит комплексное число записанное в виде строки
 * @param value строка, содержащая комплексное число
 * @return полученное из строки комплексное число
 * @throws WrongComplexNumber если комплексное число записано в неверном формате
 */
fun parseComplexNumber(value: String): ComplexNumber {
    //считаем что у нас число записано в виде A + Bi или A - Bi
    //где A - вещественная часть, а B - мнимая часть
    val regexForParsing = """(-?\d+\.?\d*) *([+-]) *(-?\d+\.?\d*)i"""
    val patternForParsing = Regex(regexForParsing)
    val mathResult = patternForParsing.find(value, 0) ?: throw WrongComplexNumber()
    //строка верного формата
    val groupValues = mathResult.groupValues
    val real = groupValues[1].toDouble()//действительная часть у нас написана первой
    var imaginary = groupValues[3].toDouble()//мнимая часть самая последняя
    if (groupValues[2] == "-") imaginary *= -1
    return ComplexNumber(real, imaginary)
}

/**
 * Преобразует строку в комплексное число
 * @return полученное в результате преобразования комплексное число
 * @throws WrongComplexNumber если комплексное число записанное в неверном формате
 * @receiver строка, содержащая комплексное число
 */
fun String.toComplex() = parseComplexNumber(this)