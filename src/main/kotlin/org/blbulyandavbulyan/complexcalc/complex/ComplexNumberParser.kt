package org.blbulyandavbulyan.complexcalc.complex

import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import kotlin.math.sign
import kotlin.math.withSign

/**
 * Данная функция парсит комплексное число записанное в виде строки
 * @param value строка, содержащая комплексное число
 * @return полученное из строки комплексное число
 * @throws WrongComplexNumber если комплексное число записано в неверном формате
 */
fun parseComplexNumber(value: String): ComplexNumber {
    //считаем что у нас число записано в виде A + Bi или A - Bi
    //запись вида A + Bi при отрицательном B будет означать то же самое, что и A - abs(B)i
    //запись вида A - Bi при отрицательном B будет означать то же самое, что и A + abs(B)i
    //где A - вещественная часть, а B - мнимая часть
    val regexForParsing = """(-?\d+\.?\d*) *([+-]) *(-?\d+\.?\d*)i"""
    val patternForParsing = Regex(regexForParsing)
    val mathResult = patternForParsing.find(value, 0) ?: throw WrongComplexNumber()//если мы ничего не нашли, то выбрасываем исключение о том что комплексное число имеет не верный формат
    //строка верного формата
    val groupValues = mathResult.groupValues
    val real = groupValues[1].toDouble()//действительная часть у нас написана первой
    var imaginary = groupValues[3].toDouble()//мнимая часть самая последняя
    if (groupValues[2] == "-") imaginary = -imaginary//если у нас стоит - между комплексной и вещественной частью, инвертируем знак вещественного числа
    return ComplexNumber(real, imaginary)
}

/**
 * Преобразует строку в комплексное число
 * @return полученное в результате преобразования комплексное число
 * @throws WrongComplexNumber если комплексное число записанное в неверном формате
 * @receiver строка, содержащая комплексное число
 */
fun String.toComplex() = parseComplexNumber(this)