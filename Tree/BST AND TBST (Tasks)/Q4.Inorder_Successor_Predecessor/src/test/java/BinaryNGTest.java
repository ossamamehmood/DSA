/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ossam
 */
public class BinaryNGTest {
    
    public BinaryNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of findPredAndSuc method, of class Binary.
     */
    @Test
    public void testFindPredAndSuc() {
        System.out.println("findPredAndSuc");
        int item = 0;
        Binary instance = new Binary();
        instance.findPredAndSuc(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuc method, of class Binary.
     */
    @Test
    public void testGetSuc() {
        System.out.println("getSuc");
        node par = null;
        node loc = null;
        Binary instance = new Binary();
        node expResult = null;
        node result = instance.getSuc(par, loc);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPred method, of class Binary.
     */
    @Test
    public void testGetPred() {
        System.out.println("getPred");
        node par = null;
        node loc = null;
        Binary instance = new Binary();
        node expResult = null;
        node result = instance.getPred(par, loc);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Binary.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int item = 0;
        Binary instance = new Binary();
        instance.find(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Binary.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int item = 0;
        Binary instance = new Binary();
        instance.insert(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
