package org.blbulyandavbulyan.complexcalc.complex

import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
fun parseComplexNumber(value: String): ComplexNumber {
    //считаем что у нас число записано в виде A + Bi или A - Bi
    //где A - вещественная часть, а B - мнимая часть
    val regexForParsing = """(-?\d+\.?\d*) *([+-]) *(-?\d+\.?\d*)i"""
    val patternForParsing = Regex(regexForParsing)
    if (patternForParsing.matches(value)) {
        //строка верного формата
        val mathResult = patternForParsing.find(value, 0) ?: throw WrongComplexNumber()
        val groupValues = mathResult.groupValues
        val real = groupValues[1].toDouble()//действительная часть у нас написана первой
        var imaginary = groupValues[3].toDouble()//мнимая часть самая последняя
        if(groupValues[2] == "-") imaginary*=-1
        return ComplexNumber(real, imaginary)
    }
    else throw WrongComplexNumber()
}
fun String.toComplex() = parseComplexNumber(this)