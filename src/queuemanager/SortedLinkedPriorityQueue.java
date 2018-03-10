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
 * Code adapted from Adamchik, V.S (2009) Linked Lists [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html> [06 March 2018]
 * @param <T>
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {  
    //This will track the head node
    private Node<T> head;

    private static class Node<T>
    {   
        private T item;
        private int priority;
        private Node next;

        public Node(T item, int priority, Node next)
        {
            this.item = item;
            this.priority = priority;
            this.next = next;
        }
    }

    /**
     *
     * This will add a node according to its priority
     */
    public void add(T item, int priority){
        Node<T> cur = head;
        T pos = null;
        //If the array is empty, or the item is higher than the highest priority item in the queue, then the item will be inserted in the head position.
        if (isEmpty() || head.priority < priority) {
            head = new Node<T>(item, priority, head);
        }
        //This iterates through the code until the priority of the next item is either lower in priority than the item to be added, or the array ends.
        //It then sets the node to pos.
        else {
            for (Node<T> node = head; node != null; node = node.next) {
                if (node.priority < priority || node.next == null) {
                    pos = node.item;
                }
            }
            //Inserts the new item in the next node
            if(cur != null && cur.item != pos){
                cur.next = new Node<T>(item, priority, cur.next);
            }
        }
    }
    
    /**
     *
     * Returns the item with the highest priority, providing the queue isn't empty.
     */
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
     * @return
     */
    @Override
    public String toString() {
        String result = "[";
        for (Node<T> node = head; node != null; node = node.next){
            if (node != head) {
                result = result + ",";
            }
            result += "(" + node.item + ", " + node.priority + ")";
        }
        result = result + "]";
        return result;
    }
}
    
