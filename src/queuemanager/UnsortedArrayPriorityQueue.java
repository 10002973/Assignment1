/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/*
 * @author Heather Taylor-Stanley 10002973
 *
 * This class implements an unsorted array priority queue.

 * @param <T>
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
        
    /**
     * Array used to store the data.
     */
    private final Object[] storage;

    /**
     * Capacity of the array.
     */
    private final int capacity;

    /**
     * Position of the last item in the array.
     *
     */
    private int tailIndex;

    /**
     * Creates an empty queue with a length of 'size'.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    /**
     * Loops through every item in the array, and returns the one with the highest priority.
     *
     */
    @Override
    public T head() throws QueueUnderflowException {
        //Throws exception if the array is empty.
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            //Set the priority to the priority of the first item in the array.
            int priority = ((PriorityItem<T>) storage[0]).getPriority();
            int pos = 0;
            //Loop through every item in the array          
            for (int i = 0; i < tailIndex + 1; i++) {
                //If the current items priority is higher than the stored priority in the priority variable,
                //then set priority variable equal to the new priority and set pos equal to the current position in the array.
                if (((PriorityItem<T>) storage[i]).getPriority() > priority) {
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    pos = i;
                } 
            }
            //Return the name of the person with the highest priority
            return ((PriorityItem<T>) storage[pos]).getItem();
        }
    }

    /**
     * Adds a new item to the array.
     *
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        //If there is not enough room to add another item to the array, then an exception is thrown.
        if (tailIndex >= capacity) {
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            //Item is added to the end of the array
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }

    /**
     * Loops through every item in the array, and removes the one with the highest priority.
     *
     */
    @Override
    public void remove() throws QueueUnderflowException {
        //Throws an exception if the array is empty.
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            //Sets the priority variable to the priority of the first item in the array.
            int priority = ((PriorityItem<T>) storage[0]).getPriority();
            int pos = 0;
            //Loop through every item in the array
            for (int i = 0; i < tailIndex + 1; i++) {
                //If the current items priority is higher than the stored priority in the priority variable,
                //then set priority variable equal to the new priority and set pos equal to the current position in the array.
                if (((PriorityItem<T>) storage[i]).getPriority() > priority) {
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    pos = i;
                } 
            }
            //If the highest priority item is not at the end of the array, then it moves the items in the array down one
            if (pos != tailIndex){
                for (int i = pos; i < tailIndex; i++) {
                    storage[i] = storage[i + 1];
                }  
            }          
            //Removes the item at the end of the array.
            tailIndex = tailIndex - 1;
        }
    }

    /**
     * Checks if the array is empty.
     *
     */
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    /**
     * Adds each item in the array to a string and returns it.
     * @return
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }

}
