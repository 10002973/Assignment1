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
 * This class tests the sorted linked priority queue implementation.
 */
public class SortedLinkedPriorityQueueTest extends PriorityQueueTest{

    public SortedLinkedPriorityQueueTest() {
    }

    /*
     * Sets up a new instance. 
     */
    @Before
    @Override
    public void setUp(){
        instance = new SortedLinkedPriorityQueue<>();
    };
    
    @After
    @Override
    public void tearDown(){
        
    };

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     * Checks that adding a new item to middle of the array inserts it correctly.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("Add new item to middle of array");
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        System.out.println("Array: " + instance.toString());
        Object item = ("Jeff Morrison");
        int priority = 20;
        instance.add(item, priority);
        String expResult = "[(Jane Woods, 30),(Jeff Morrison, 20),(John Doe, 10)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     * Outputs current array head, then adds a new head and checks that the head function updates correctly.
     */
    @Test
    public void testAddHead() throws Exception {
        System.out.println("Add new head item to array");
        instance.add("John Doe", 10);
        instance.add("Jeff Morrison", 20);
        System.out.println("Head: " + instance.head());
        Object item = ("Jane Woods");
        int priority = 30;
        instance.add(item, priority);
        String expResult = "Jane Woods";
        String result = instance.head().toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     * Checks that adding an item with the lowest priority to the array places it at the end correctly.
     */
    @Test
    public void testAddEnd() throws Exception {
        System.out.println("Add new lowest priority item");
        instance.add("Jane Woods", 30);  
        instance.add("Jeff Morrison", 20);
        System.out.println("Array: " + instance.toString());
        Object item = ("John Doe");
        int priority = 10;
        instance.add(item, priority);
        String expResult = "[(Jane Woods, 30),(Jeff Morrison, 20),(John Doe, 10)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
     
    /**
     * Test of toString method, of class PriorityQueue.
     * Checks that the toString method prints the array in the correct format and order.
     */
    @Test
    public void testToString() throws Exception {
        instance.add("John Doe", 10);
        instance.add("Jane Woods", 30);
        instance.add("Jeff Morrison", 20);
        System.out.println("Test toString method");
        String expResult = "[(Jane Woods, 30),(Jeff Morrison, 20),(John Doe, 10)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
