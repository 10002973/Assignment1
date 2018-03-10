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
 * Tests:
 *  
 */
public class HeapPriorityQueueTest extends PriorityQueueTest{
    
    public HeapPriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
        instance = new HeapPriorityQueue<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class HeapPriorityQueue.
     * Checks that adding a new item to middle of the array inserts it correctly without disrupting the heap structure.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        instance.add("John Doe", 10);
        instance.add("Jeff Morrison", 20);
        instance.add("Poppy Taylor", 40);
        instance.add("Jane Woods", 30);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        Object item = ("Robert Wells");
        int priority = 35;
        instance.add(item, priority);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        String expResult = "[(Poppy Taylor, 40), (Robert Wells, 35), (Jeff Morrison, 20), (John Doe, 10), (Jane Woods, 30)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class HeapPriorityQueue.
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
        String expResult = "Jane Woods";
        String result = instance.head().toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class HeapPriorityQueue.
     * Checks that adding an item with the lowest priority to the array places it in the heap correctly.
     */
    @Test
    public void testAddEnd() throws Exception {
        System.out.println("add");
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        instance.add("Dean Thomas", 12);
        instance.add("John Doe", 10);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        Object item = "Katie Bell";
        int priority = 4;
        instance.add(item, priority);
        System.out.println("Array: " + instance.toString());
        System.out.println("Head: " + instance.head());
        String expResult = "[(Jane Woods, 30), (Jeff Morrison, 20), (Dean Thomas, 12), (John Doe, 10), (Katie Bell, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
     
    /**
     * Test of toString method, of class HeapPriorityQueue.
     * Checks that the toString method prints the array in the correct format and order.
     */
    @Test
    public void testToString() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        instance.add("Poppy Taylor", 40);
        instance.add("Robert Wells", 35);
        instance.add("Dean Thomas", 12);
        instance.add("Katie Bell", 4);
        System.out.println("toString");
        String expResult = "[(Poppy Taylor, 40), (Robert Wells, 35), (Jeff Morrison, 20), (John Doe, 10), (Jane Woods, 30), (Dean Thomas, 12), (Katie Bell, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }   
}
