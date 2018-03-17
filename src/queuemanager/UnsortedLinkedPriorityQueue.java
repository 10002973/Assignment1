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
 *  Code in this class adapted from Adamchik, V.S (2009) Linked Lists [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html> [06 March 2018]
 * 
 * This class implements an unsorted linked priority queue.
 * 
 * @param <T>
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {  
    //This will track the head node
    private itemNode<T> head;

    private static class itemNode<T>
    {   
        private T item;
        private int priority;
        private itemNode next;

        public itemNode(T item, int priority, itemNode next)
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
            head = new itemNode<>(item, priority, head);
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
            for (itemNode<T> node = head; node != null; node = node.next) {
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
            itemNode<T> sel  = head;
            itemNode<T> last = null;
            T pos = null;
            //Loops through the list to get the item with the highest priority. It updates the priority, pos and sel variables each time a higher priority is encountered.
            for (itemNode<T> node = head; node != null; node = node.next) {
                if (node.priority > priority) {
                    priority = node.priority;
                    pos = node.item;
                    sel = node;
                } 
            }

            //If the highest priority node is the head, then remove the head node.
            if (sel == head){
                head = head.next;
            }
            else{
                sel = head;
                //Gets the node before the highest priority item.
                while(sel != null && sel.item != pos) {
                   last = sel;
                   sel = sel.next;
                }
                //Deletes the sel node (highest priority item).
                last.next = sel.next;
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
     * @return result.
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

