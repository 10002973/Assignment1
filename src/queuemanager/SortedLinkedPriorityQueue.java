/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Heather Taylor-Stanley 10002973
 * 
 * Code in this class is adapted from Adamchik, V.S (2009) Linked Lists [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html> [06 March 2018]
 * 
 * This class implements a sorted linked priority queue.
 * @param <T>
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {  
    //This will track the head node
    private itemNode<T> head;

    private static class itemNode<T> {   
        private T item;
        private int priority;
        private itemNode next;

        public itemNode(T item, int priority, itemNode next) {
            this.item = item;
            this.priority = priority;
            this.next = next;
        }
    }

    /**
     *
     * This will add a node according to its priority
     */
    @Override
    public void add(T item, int priority){
        itemNode<T> sel = head;
        //If the array is empty, or the item is higher than the highest priority item in the queue, then the item will be inserted in the head position.
        if (isEmpty() || head.priority < priority) {
            head = new itemNode<>(item, priority, head);
        }
        //This iterates through the code until the priority of the next item is either lower in priority than the item to be added, or the array ends.
        //It sets the selected variable to the next node each time, so when the loop runs false, the sel variable will be set to the node before the 
        //position the new item is to be inserted into.
        else {
            while((sel.next != null) && (sel.next.priority > priority)) {
                sel = sel.next;
            }
            //Inserts the new item in the next node
            sel.next = new itemNode<>(item, priority, sel.next);
        }
    }
    
    /**
     *
     * Returns the item with the highest priority, providing the queue isn't empty.
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return head.item;
        } 
    }
    
    /**
     *
     * Removes the item with the highest priority, providing the queue isn't empty.
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            head = head.next;
        }
    }
    
    /**
     *
     * Checks if the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds each item to a string and returns the string.
     * @return the result.
     */
    @Override
    public String toString() {
        String result = "[";
        for (itemNode<T> node = head; node != null; node = node.next){
            if (node != head) {
                result = result + ",";
            }
            result += "(" + node.item + ", " + node.priority + ")";
        }
        result = result + "]";
        return result;
    }
}
    
