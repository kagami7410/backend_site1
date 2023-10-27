package com.mysite.site1.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

    @Test
    void twoNumberShouldAdd() {
        var calculator = new TestClass();
        assertEquals(5, calculator.doMath(2,3));

    }
}