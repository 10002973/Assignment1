/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heather Taylor-Stanley 10002973
 * 
 * This class tests the unsorted array priority queue implementation.
 */
public class UnsortedArrayPriorityQueueTest extends PriorityQueueTest{
    
    /**
     *
     */
    public UnsortedArrayPriorityQueueTest() {
    }
    
    /*
     * Sets up a new instance. 
     */
    @Before
    public void setUp() {
        instance = new UnsortedArrayPriorityQueue<>(8);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue. Checks that adding an item correctly adds it to the end of the queue.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddEnd() throws Exception {
        System.out.println("Add item to end of array.");
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        Object item = "Jeff Morrison";
        int priority = 20;
        instance.add(item, priority);
        String expResult = "[(John Doe, 10), (Jane Woods, 30), (Jeff Morrison, 20)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue. Checks that removing an item from the middle of the array functions correctly.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveMiddle() throws Exception {
        System.out.println("Remove item from middle of array");
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        System.out.println("Array before removal: " + instance.toString());
        instance.remove();
        String expResult = "[(John Doe, 10), (Jeff Morrison, 20)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue. Checks that removing an item from the start of the array functions correctly.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveStart() throws Exception {
        System.out.println("Remove item from start of array");
        instance.add("Jane Woods", 30);
        instance.add("John Doe", 10);
        instance.add("Jeff Morrison", 20);
        System.out.println("Array before removal: " + instance.toString());
        instance.remove();
        String expResult = "[(John Doe, 10), (Jeff Morrison, 20)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }  
      
    /**
     * Test of toString method, of class PriorityQueue. Checks that the toString method prints out the array, and that the array itself is stored in an unordered manner.
     * @throws java.lang.Exception
     */
    @Test
    public void testToString() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        System.out.println("Test toString method");
        String expResult = "[(John Doe, 10), (Jane Woods, 30), (Jeff Morrison, 20)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
