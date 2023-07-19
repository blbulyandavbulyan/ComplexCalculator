package org.blbulyandavbulyan.complexcalc

class ComplexNumberParser {
    fun parse(value: String): ComplexNumber {
        //считаем что у нас число записано в виде A + Bi или A - Bi
        //где A - вещественная часть, а B - мнимая часть
        val regexForParsing = """(-?\d+\.?\d*) *([+-]) *(-?\d+\.?\d*)i"""
        val patternForParsing = Regex(regexForParsing)
        if (patternForParsing.matches(value)) {
            //строка верного формата
            val mathResult = patternForParsing.find(value, 0) ?: throw RuntimeException("OOOps")
            val groupValues = mathResult.groupValues
            val real = groupValues[1].toDouble()//действительная часть у нас написана первой
            var imaginary = groupValues[3].toDouble()//мнимая часть самая последняя
            if(groupValues[2] == "-") imaginary*=-1
            return ComplexNumber(real, imaginary)
        }
        else throw RuntimeException("you entered wrong complex number")
    }
}