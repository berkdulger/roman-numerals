/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class KataTest {
    
    /**
     * Utility method
     * @param roman
     * @param expectedDecimal 
     */
    private void testToDecimal(String roman, int expectedDecimal) {
        //When
        int result = romanToDecimal(roman);
        
        //Then
        assertEquals(expectedDecimal,result);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_I() {
        testToDecimal("I", 1);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_II() {
        testToDecimal("II", 2);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_III() {
        testToDecimal("III", 3);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_IV() {
        testToDecimal("IV", 4);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_V() {
        testToDecimal("V", 5);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_VI() {
        testToDecimal("VI", 6);
    }
    
    /**
     * Test of main method, of class Kata.
     */
    @Test
    public void test_VII() {
        testToDecimal("VII", 7);
    }
    
    
    /**
     * Convert
     * @param roman
     * @return 
     */
    private int romanToDecimal(String roman) {
        int result;

        if (hasOnlyI(roman)) {
            result = roman.length();
        } else if ("IV".equals(roman)){
            result = 4;
        } else if ("V".equals(roman)){
            result = 5;
        } else if ("VI".equals(roman)){
            result = 6;
        } else {
            result = 7;
        }

        return result;
    }
    
    private boolean hasOnlyI(String roman) {
        return roman.matches("I+");
    }
}