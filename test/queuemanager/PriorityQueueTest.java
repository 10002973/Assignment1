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
public abstract class PriorityQueueTest {
    public PriorityQueue instance;
    
    public PriorityQueueTest() {
    }
        
    @Before
    public abstract void setUp();
    
    @After
    public abstract void tearDown();

    /**
     * Test of add method, of class PriorityQueue. Tests adding an item to the array, to check the method inserts correctly.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = "Jeff Morrison";
        int priority = 20;
        instance.add(item, priority);
    }

    /**
     * Test of head method, of class PriorityQueue. Checks that the highest priority item is returned.
     */
    @Test
    public void testHead() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        System.out.println("head");
        Object expResult = "Jane Woods";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of head method, of class PriorityQueue. Checks that calling the head method on an empty array returns a QueueUnderflow exception.
     */
    @Test (expected =  QueueUnderflowException.class) 
    public void testHeadArrayEmpty() throws Exception {
        System.out.println("head");
        instance.head();
    }

    /**
     * Test of remove method, of class PriorityQueue. Checks that the remove method removes the highest priority item.
     */
    @Test
    public void testRemove() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        System.out.println("remove");
        instance.remove();
    }
    
    /**
     * Test of remove method, of class PriorityQueue. Checks that using the remove method on an empty array returns a QueueUnderflow exception.
     */
    @Test (expected =  QueueUnderflowException.class) 
    public void testRemoveArrayEmpty() throws Exception {
        System.out.println("remove");
        instance.remove();
    }
    
    /**
     * Test of remove method, of class PriorityQueue. Checks that using remove method on the last item in the array does not cause an error.
     */
    @Test
    public void testRemoveOnlyItemInArray() throws Exception {
        System.out.println("remove");
        instance.add("John Doe", 10);
        System.out.println("Array before removal: " + instance.toString());
        instance.remove();
        System.out.println("Array after removal: " + instance.toString());
    }

    /**
     * Test of isEmpty method, of class PriorityQueue. Tests that the isEmpty method returns false if the array is not empty.
     */
    @Test
    public void testIsEmpty() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        System.out.println("isEmpty");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method, of class PriorityQueue. Tests that the isEmpty method returns true if the array is empty.
     */
    @Test
    public void testIsEmptyArrayEmpty() throws Exception {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class PriorityQueue. Tests that using toString on an empty array does not throw an error.
     */
    @Test
    public void testToStringArrayEmpty() throws Exception {
        System.out.println("toString");
        String expResult = "[]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
  
}
