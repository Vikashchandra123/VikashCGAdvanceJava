package com.lpu.JUnitEmployeeSalaryCalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeSalaryCalculatorTest {

    @Test
    void testValidSalaryCalculation() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(27900, calc.calculateNetSalary());
    }

    @Test
    void testHRA() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(4000, calc.calculateHRA());
    }

    @Test
    void testDA() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(2000, calc.calculateDA());
    }

    @Test
    void testGrossSalary() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(31000, calc.calculateGrossSalary());
    }

    @Test
    void testNetSalary() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(27900, calc.calculateNetSalary());
    }

    //Negative test cases
    @Test
    void testBasicSalaryZero() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(0, 5000, 10);

        assertThrows(IllegalArgumentException.class,
                () -> calc.calculateGrossSalary());
    }

    @Test
    void testNegativeSalary() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(-20000, 5000, 10);

        assertThrows(IllegalArgumentException.class,
                () -> calc.calculateGrossSalary());
    }

    @Test
    void testTaxGreaterThan100() {
        EmployeeSalaryCalculator calc = new EmployeeSalaryCalculator(20000, 5000, 150);

        assertThrows(IllegalArgumentException.class,
                () -> calc.calculateGrossSalary());
    }
}
