// Ben Fristad
public class DLinkedList
{
    protected DNode head;
    protected DNode tail;
    protected int size;

    public DLinkedList()
    {
        head = new DNode(null, null, null);
        tail = new DNode(null, null, null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;

    }// end EVC

    public DNode getFirst()
    {
        if(size == 0)
            throw new IllegalArgumentException("Linked List is empty");
        
        return this.head.getNext();

    }// end getFirst

    public DNode getLast()
    {
        if(size == 0)
            throw new IllegalArgumentException("Linked List is empty");
        
        return this.tail.getPrev();

    }// end getLast

    public int size()
    {
        return this.size;

    }// end size

    public void addLast(DNode insertNode)
    {
        insertNode.setPrev(tail.getPrev());
        insertNode.setNext(tail);
        tail.getPrev().setNext(insertNode);
        tail.setPrev(insertNode);  
        size++;

    }// end addLast
    
    public void addBefore(DNode insertNode, DNode refNode)
    {
       if(refNode == null || refNode == head)
          throw new IllegalArgumentException("CANNOT ENTER NODE");
       
       insertNode.setPrev(refNode.getPrev());
       insertNode.setNext(refNode);
       refNode.getPrev().setNext(insertNode);
       refNode.setPrev(insertNode);
       size++;

    }// end addBefore
    
    public void addAfter(DNode insertNode, DNode refNode)
    {
      if(refNode == null || refNode == tail)
         throw new IllegalArgumentException("CANNOT ENTER NODE");
      
      insertNode.setPrev(refNode);
      insertNode.setNext(refNode.getNext());
      refNode.getNext().setPrev(insertNode);
      refNode.setNext(insertNode);
      size++;    

    }// end addAfter

    public void remove(DNode deleteNode)
    {
        if(deleteNode == null || deleteNode == head || deleteNode == tail)
            throw new IllegalArgumentException("Invalid Parameter: deleteNode");

        deleteNode.getPrev().setNext(deleteNode.getNext());
        deleteNode.getNext().setPrev(deleteNode.getPrev());
        deleteNode.setPrev(null);
        deleteNode.setNext(null);
        size--;
        
    }// end remove
    
    /*
      quickSort is a recursive function that sorts the linked list using the partition helper method
      All pointers used in the function are offset by one Node to keep the pointers from moving when a swap occurs  
    */
    public void quickSort(DNode left, DNode right)
    {
        if(left.getPrev() == right || left == right) // base case for when the method is recursing to the left (checks if the size of the working area is 1)
            return;
        
        left = left.getPrev(); // offset the pointers so it wont move on a swap
        right = right.getNext();
        
        DNode pivotNode = partition(left.getNext(), right.getPrev()); // call the partition method to set the pivotNode to its sorted postion in the linked list
        
        if(left.getNext() == right || left == right) // base case for when the method is recursing to the right (checks if the size of the working area is 1)  
            return;
        
        quickSort(left.getNext(), pivotNode.getPrev()); // recursively call quick sort to partition the left side of the linked list
        quickSort(pivotNode.getNext(), right.getPrev()); // recursively call quick sort partition the right side of the linked list
        
    }// end quickSort
    
    // the references in partiton point to the node beside the one that is being swapped
    // the reason for this is so the pointers wont move on a swap
    
    public DNode partition(DNode left, DNode right)
    {
        DNode pivotNode = right; // set the pivot node to the last Node in the working area
        DNode index = left.getPrev(); // set index to left previous to prevent the pointer from moving when a swap occurs
        DNode cursor; // declare cursor
        
        // this for loop will check if the data cursor's next is equal to the data of the pivot node.
        // if cursor's next is less than or equal to the pivot node, then the node referenced by cursor's next will swap with index's next
        // once this loop and the following if statement is complete, the pivot node will be one swap from its sorted postion
        
        for(cursor = left.getNext(); cursor.getNext() != right.getNext(); cursor = cursor.getNext())
        {
           if(Integer.parseInt(cursor.getPrev().getData()) <= Integer.parseInt(pivotNode.getData()))
           {
              swap(index.getNext(), cursor.getPrev());
              index = index.getNext();
           }
           
        }// end for loop
        
        if(Integer.parseInt(cursor.getPrev().getData()) <= Integer.parseInt(pivotNode.getData()))
           {
              swap(index.getNext(), cursor.getPrev());
              index = index.getNext();
           }
  
        swap(index.getNext(), right); // move the pivot node to it's sorted postion        
        return index.getNext();

    }// end partition
    
    public void swap(DNode node1, DNode node2)
    {  
        if(node1 == node2) // return out of the method if the references are pointing to the same Node
           return;
           
        DNode temp1 = node1.getPrev(); // create two pointers to hold the positon of where the Nodes need to be returned
        DNode temp2 = node2.getNext();
        remove(node1); // remove the nodes from the linked list and reset links (node1 and node2 are still pointing to the Nodes deleted)
        remove(node2);
        addAfter(node2, temp1); // add node2 in node1's previous position
        addBefore(node1, temp2); // andd node1 into node2's previous position

    }// end swap
    
   public void printResults()
   {
      DNode cursor;
      
      for(cursor = head.getNext(); cursor != tail; cursor = cursor.getNext())
      {
         System.out.println(cursor.getData());
         
      }// end for loop
      
   }// end toString
    
}// end class