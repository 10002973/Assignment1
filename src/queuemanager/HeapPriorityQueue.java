/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * Code in this class adapted from Adamchik, V.S (2009) Heap [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/code/Heap.java> [09 March 2018].
 * 
 * @author Heather Taylor-Stanley 10002973
 * 
 * This class implements a heap priority queue.
 */


public class HeapPriorityQueue<T> implements PriorityQueue<T>{  
   //Stores the size of the array
   private int capacity;            
   //Stores the array
   private Object[] storage; 

   public HeapPriorityQueue()
   {
        capacity = 0;
        storage = (T[]) new Object[2];
   }
   
   public HeapPriorityQueue(T[] array)
   {
        capacity = array.length;
        storage = (T[]) new Object [capacity+1];
        //Make a copy of the storage, and initialise the new array to start from position 1.
        System.arraycopy(array, 0, storage, 1, capacity);
        //Create the heap.
        createHeap();
   }
   
    private void createHeap()
   {
      for (int i = capacity/2; i > 0; i--)
      {
          //Use siftDown to sort the order of each item in the tree
         siftDown(i);
      }
   }
    
    /*
     * Sort the heap so the parent is larger than the child.
     */  
    private void siftDown(int i)
   {
       //Temp used to store storage[i] temporarily
        Object temp = storage[i];
        int index;
        
        //For each item in the array
        for(; 2*i <= capacity; i = index){
            index = 2*i;
            //If the item is not the last in the array, and it's priority is smaller than the one to the right of it then move it to that position.
            if(index != capacity && ((PriorityItem<T>)storage[index]).getPriority() < ((PriorityItem<T>)storage[index + 1]).getPriority()){
                index++;
            }
            //If the priority of the parent is smaller than the smallest child then switch them.
            if(((PriorityItem<T>)temp).getPriority() < ((PriorityItem<T>)storage[index]).getPriority()){
                storage[i] = storage[index];
            }
            //End the loop if none of the above apply.
            else {
                break;
            }
        }
        
        //Set storage[i] back to temp.
        storage[i] = temp;
    } 
     
    /*
     * Insert a new item into the array.
     */  
    @Override
    public void add(T item, int priority){
        //If the array is full then double the size.
          if(capacity == storage.length - 1) {
            doubleArray();
          }
          //Add item to the end of the array
          int sel = ++capacity;
          //Sift up, swapping the item for its parent where necessary so the parent has a higher priority than the child.
          for(;sel > 1 && priority > ((PriorityItem<T>)storage[sel/2]).getPriority(); sel = sel/2 )
          {
             storage[sel] = storage[sel/2];
          }
          //Set the item position to the new item
          storage[sel] = new PriorityItem<>(item, priority);
   }
   
    /*
     * Double the size of the array
     */
    private void doubleArray()
   {
      Object[] old = storage;
      //Double the length of storage
      storage = (T[]) new Object[storage.length * 2];
      //Make a copy of storage and initialise array to start from position 1
      System.arraycopy(old, 1, storage, 1, capacity);
   }
         
         
    /*
     * Remove the highest priority item in the array which is at the roor of the tree.
     */  
   @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            storage[1] = storage[capacity--];
            //Sort the tree
            siftDown(1);
	} 
    }
   
    /*
     * Check if the array is empty.
     */  
    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    /*
     * Output the array into a string.
     */  
    @Override
    public String toString() {
        String result = "[";
        for(int i = 1; i <= capacity; i++){
            //If there is another item in the array, insert a comma into the string.
            if (storage[capacity]!= null && i !=1) {
                result = result + ", ";
            }
            result += storage[i];
        }
        result = result + "]";
        return result;
    }
    
    /*
     * Return the highest priority item.
     */  
   @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[1]).getItem();
        } 
    }
}