package org.blbulyandavbulyan.complexcalc

import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.toComplex
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConversionStringToComplexNumberTest {
    @BeforeEach
    @Test
    fun `test parse with correct data`(){
        assertEquals(ComplexNumber(2.0,2.0),"2 + 2i".toComplex())
        assertEquals(ComplexNumber(2.323, 2.23), "2.323 + 2.23i".toComplex())
        assertEquals(ComplexNumber(-2.2, -2.2), "-2.2 - 2.2i".toComplex())
        assertEquals(ComplexNumber(2.2, -2.2324), "2.2 - 2.2324i".toComplex())
    }
    @Test
    fun `should throw if no i letter added`(){
        assertThrows(WrongComplexNumber::class.java) {
            "2 + 2".toComplex()
        }
    }
    @Test
    fun `should throw if i letter in wrong place`(){
        assertThrows(WrongComplexNumber::class.java){
            "2i + 2".toComplex()
        }
        assertThrows(WrongComplexNumber::class.java){
            "2i.2 + 2".toComplex()
        }
        assertThrows(WrongComplexNumber::class.java){
            "2i + 2i".toComplex()
        }
    }
}