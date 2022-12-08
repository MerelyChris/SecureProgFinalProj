package binaryconverter.tests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


import org.junit.Test;

import binaryconverter.BinaryConverter;
public class BinConTest{
    @Test
    public void testValidAns(){
        //Bounds 
        assertTrue(BinaryConverter.validAns("0")); //lower
        assertTrue(BinaryConverter.validAns("2")); //uppper
        assertFalse(BinaryConverter.validAns("-1")); //negative
        assertTrue(BinaryConverter.validAns("")); //empty, defaults to end
        assertFalse(BinaryConverter.validAns("3")); //overbounds
        //Invalid input
        assertFalse(BinaryConverter.validAns("\\n"));
        assertFalse(BinaryConverter.validAns("not integer"));
    }

    @Test
    public void testValidBin(){
        //Bounds 
        assertTrue(BinaryConverter.validBin("0")); //lower
        assertTrue(BinaryConverter.validBin("1111111111111111111111111111111")); //uppper
        assertFalse(BinaryConverter.validBin("-1")); //negative
        assertFalse(BinaryConverter.validBin("")); //empty
        assertFalse(BinaryConverter.validBin("11111111111111111111111111111111")); //overbounds
        //Invalid input
        assertFalse(BinaryConverter.validBin("\\n"));
        assertFalse(BinaryConverter.validBin("not binary"));
    }

    @Test
    public void testValidInt(){
        //Bounds 
        assertTrue(BinaryConverter.validInt("0")); //lower
        assertTrue(BinaryConverter.validInt("2147483646")); //uppper
        assertFalse(BinaryConverter.validInt("-1")); //negative
        assertFalse(BinaryConverter.validInt("")); //empty
        assertFalse(BinaryConverter.validInt("2147483648")); //overbounds
        //Invalid input
        assertFalse(BinaryConverter.validInt("\\n"));
        assertFalse(BinaryConverter.validInt("not integer"));
    }

    @Test
    public void testConvBin(){
        assertEquals("10", BinaryConverter.convBin("1010")); //valid
        assertNotEquals("1010", BinaryConverter.convBin("10")); //invalid
    }

    @Test
    public void testConvInt(){
        assertEquals("1010", BinaryConverter.convInt("10")); //valid
        assertNotEquals("10", BinaryConverter.convInt("1010")); //invalid
    }

    @Test
    public void testHandleFork(){
        ByteArrayInputStream inp = new ByteArrayInputStream("1".getBytes());
        System.setIn(inp);
        Scanner scan = new Scanner(inp);
        assertEquals("1", BinaryConverter.handleFork(scan));
        scan.close();
    }
}

