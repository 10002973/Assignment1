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
 *  Code adapted from Adamchik, V.S (2009) Linked Lists [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html> [06 March 2018]
 * @param <T>
 */

public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {  
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
     * This will add a node to the head position.
     */
    @Override
    public void add(T item, int priority){
            head = new Node<T>(item, priority, head);
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
            int priority = head.priority;
            T pos = head.item;
            //Loops through the list and each time it encounters a higher priority, it sets the priority to the priority variable, and the item to the pos variable.
            for (Node<T> node = head; node != null; node = node.next) {
                if (node.priority > priority) {
                    priority = node.priority;
                    pos = node.item;
                } 
            }
            //Returns the item with the highest priority.
            return pos;
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
            int priority = head.priority;        
            Node<T> cur  = head;
            Node<T> prev = null;
            T pos = null;
            //Loops through the list to get the item with the highest priority. It updates the priority, pos and cur variables each time a higher priority is encountered.
            for (Node<T> node = head; node != null; node = node.next) {
                if (node.priority > priority) {
                    priority = node.priority;
                    pos = node.item;
                    cur = node;
                } 
            }

            //If the highest priority node is the head, then remove the head node.
            if (cur == head){
                head = head.next;
            }
            else{
                //Gets the node before the highest priority item.
                while(cur != null && cur.item != pos)
                {
                   prev = cur;
                   cur = cur.next;
                }
                //Deletes the cur node (highest priority item).
                prev.next = cur.next;
            }
        }
    }
    
    /**
     *
     * Checks if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     *
     * Returns all the items in the list in a string format.
     * @return 
     */
    @Override
    public String toString() {
        String result = "[";
        for (Node<T> node = head; node != null; node = node.next){
            if (node != head) {
                result = result + ", ";
            }
            result = result + node.item + node.priority;
        }
        result = result + "]";
        return result;
    }
    
}

