/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * Code adapted from Adamchik, V.S (2009) Heap [online]. Available from <https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/code/Heap.java> [09 March 2018].
 * @author Heather Taylor-Stanley 10002973
 */


public class HeapPriorityQueue<T> implements PriorityQueue<T>{  
   //Stores the size of the array
   private int arraySize;            
   //Stores the array
   private Object[] heapArray; 

   public HeapPriorityQueue()
   {
        arraySize = 0;
        heapArray = (T[]) new Object[2];
   }
   
   public HeapPriorityQueue(T[] array)
   {
        arraySize = array.length;
        heapArray = (T[]) new Object [arraySize+1];
        //Make a copy of the heapArray, and initialise the new array to start from position 1.
        System.arraycopy(array, 0, heapArray, 1, arraySize);
        //Create the heap.
        createHeap();
   }
   
    private void createHeap()
   {
      for (int i = arraySize/2; i > 0; i--)
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
       //Temp used to store heapArray[i] temporarily
        Object temp = heapArray[i];
        int child;
        
        //For each item in the array
        for(; 2*i <= arraySize; i = child){
            child = 2*i;
            //If the item is not the last in the array, and it's priority is smaller than the one to the right of it then move it to that position.
            if(child != arraySize && ((PriorityItem<T>)heapArray[child]).getPriority() < ((PriorityItem<T>)heapArray[child + 1]).getPriority()){
                child++;
            }
            //If the priority of the parent is smaller than the smallest child then switch them.
            if(((PriorityItem<T>)temp).getPriority() < ((PriorityItem<T>)heapArray[child]).getPriority()){
                heapArray[i] = heapArray[child];
            }
            //End the loop if none of the above apply.
            else {
                break;
            }
        }
        
        //Set heapArray[i] back to temp.
        heapArray[i] = temp;
    } 
     
    /*
     * Insert a new item into the array.
     */  
    @Override
    public void add(T item, int priority){
        //If the array is full then double the size.
          if(arraySize == heapArray.length - 1) {
            doubleArray();
          }
          //Add item to the end of the array
          int pos = ++arraySize;
          //Sift up, swapping the item for its parent where necessary so the parent has a higher priority than the child.
          for(;pos > 1 && priority > ((PriorityItem<T>)heapArray[pos/2]).getPriority(); pos = pos/2 )
          {
             heapArray[pos] = heapArray[pos/2];
          }
          //Set the item position to the new item
          heapArray[pos] = new PriorityItem<>(item, priority);
   }
   
    /*
     * Double the size of the array
     */
    private void doubleArray()
   {
      Object[] old = heapArray;
      //Double the length of heapArray
      heapArray = (T[]) new Object[heapArray.length * 2];
      //Make a copy of heapArray and initialise array to start from position 1
      System.arraycopy(old, 1, heapArray, 1, arraySize);
   }
         
         
    /*
     * Remove the highest priority item in the array which is at the roor of the tree.
     */  
   @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            heapArray[1] = heapArray[arraySize--];
            //Sort the tree
            siftDown(1);
	} 
    }
   
    /*
     * Check if the array is empty.
     */  
    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    /*
     * Output the array into a string.
     */  
    @Override
    public String toString() {
        String result = "[";
        for(int i = 1; i <= arraySize; i++){
            //If there is another item in the array, insert a comma into the string.
            if (heapArray[arraySize]!= null && i !=1) {
                result = result + ", ";
            }
            result += heapArray[i];
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
            return ((PriorityItem<T>) heapArray[1]).getItem();
        } 
    }
}