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
 */
public class SortedArrayPriorityQueueTest extends PriorityQueueTest{
    PriorityItem item1;
    PriorityItem item2;
    PriorityItem item3;

    public SortedArrayPriorityQueueTest() {
    }

    /*
     * Sets up a new instance. 
     */

    @Before
    @Override
    public void setUp(){
        instance = new SortedArrayPriorityQueue<>(8);
    };
    
    @After
    @Override
    public void tearDown(){
        
    };

    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks that adding a new item to middle of the array inserts it correctly.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        Object item = ("Jeff Morrison");
        int priority = 20;
        instance.add(item, priority);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Outputs current array string and head, then adds a new head and checks that the head function updates correctly.
     */
    @Test
    public void testAddHead() throws Exception {
        System.out.println("add");
        instance.add("John Doe", 10);
        instance.add("Jeff Morrison", 20);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        Object item = ("Jane Woods");
        int priority = 30;
        instance.add(item, priority);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
    }
    
    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     * Checks that adding an item with the lowest priority to the array places it at the end correctly.
     */
    @Test
    public void testAddEnd() throws Exception {
        System.out.println("add");
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        Object item = "John Doe";
        int priority = 10;
        instance.add(item, priority);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
    }
     
    /**
     * Test of toString method, of class PriorityQueue.
     * Checks that the toString method prints the array in the correct format and order.
     */
    @Test
    public void testToString() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        System.out.println("toString");
        String expResult = "[(Jane Woods, 30), (John Doe, 10)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
