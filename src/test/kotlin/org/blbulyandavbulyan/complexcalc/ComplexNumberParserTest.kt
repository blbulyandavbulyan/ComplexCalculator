package org.blbulyandavbulyan.complexcalc

import org.blbulyandavbulyan.complexcalc.complex.ComplexNumber
import org.blbulyandavbulyan.complexcalc.complex.exceptions.WrongComplexNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ComplexNumberParserTest {
    private lateinit var parser: ComplexNumberParser

    @BeforeEach
    fun setUp() {
        parser = ComplexNumberParser()
    }
    @Test
    fun `test parse with correct data`(){
        assertEquals(ComplexNumber(2.0,2.0), parser.parse("2 + 2i"))
        assertEquals(ComplexNumber(2.323, 2.23), parser.parse("2.323 + 2.23i"))
        assertEquals(ComplexNumber(-2.2, -2.2), parser.parse("-2.2 - 2.2i"))
        assertEquals(ComplexNumber(2.2, -2.2324), parser.parse("2.2 - 2.2324i"))
    }
    @Test
    fun `should throw if no i letter added`(){
        assertThrows(WrongComplexNumber::class.java) {
            parser.parse("2 + 2");
        }
    }
    @Test
    fun `should throw if i letter in wrong place`(){
        assertThrows(WrongComplexNumber::class.java){
            parser.parse("2i + 2")
        }
        assertThrows(WrongComplexNumber::class.java){
            parser.parse("2i.2 + 2")
        }
        assertThrows(WrongComplexNumber::class.java){
            parser.parse("2i + 2i")
        }
    }
}