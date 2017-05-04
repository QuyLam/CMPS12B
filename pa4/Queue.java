//---------------------------------------------------------------------------
// Quy Lam
// qlam
// 12b
// pa4
// 05/15/16    
//-----------------------------------------------------------------------------
// Queue.java
// Queue ADT implements the QueueInterface
//-----------------------------------------------------------------------------

public class Queue implements QueueInterface{
    
    //private inner node class
    private class Node{
	Object item;
	Node next;
	
	Node(Object x){
	    this.item = x;
	    this.next = null;
	}
    }
    
    private Node head;     //reference to the very first Node in the queue
    private Node tail;     //reference to the very last Node in the queue
    private int numItems;  //number of items in the Queue
    
    //Queue
    //default constructor for the Queue class
    public Queue(){
	head = null;
	tail = null;
	numItems = 0;
    }

    //ADT Operations
    //-----------------------------------------------------------------------------------
 
    // isEmpty()
    // pre: none
    // post: returns true if this Queue is empty, false otherwise
    public boolean isEmpty(){
	return(numItems == 0);
    }

    // length()
    // pre: none
    // post: returns the length of this Queue.
    public int length(){
	return numItems;
    }

    // enqueue()
    // adds newItem to back of this Queue
    // pre: none
    // post: !isEmpty()
    public void enqueue(Object newItem){
	Node E = new Node(newItem);
	if(numItems == 0){
	    head = E;
	}
	else if(numItems == 1){
	    Node N = head;
	    N.next = E;
	    tail = N.next;
	}
	else{
	    Node N = tail;
	    N.next = E;
	    tail = N.next;
	}
	numItems++;
    }

    // dequeue()
    // deletes and returns item from front of this Queue
    // pre: !isEmpty()
    // post: this Queue will have one fewer element
    public Object dequeue() throws QueueEmptyException{
	Node N = null;
	if(numItems == 0)
	    throw new QueueEmptyException(
					  "cannot dequeue() empty queue");
	if(!isEmpty()) {
	    N = head; 
	    head = head.next;
	    numItems--; 
	}
	return N.item;
    }

    // peek()
    // pre: !isEmpty()
    // post: returns item at front of Queue
    public Object peek() throws QueueEmptyException{
	if(numItems == 0)
	    throw new QueueEmptyException(
					  "cannot peek() empty queue");
	return head.item;
    }

    // dequeueAll()
    // sets this Queue to the empty state
    // pre: !isEmpty()
    // post: isEmpty()
    public void dequeueAll() throws QueueEmptyException{
	if(numItems == 0)
	    throw new QueueEmptyException(
					  "cannot dequeueAll() empty queue");
	numItems = 0;
	head = null;
	tail = null;
    }

    // toString()
    // overrides Object's toString() method
    public String toString(){

	    String s ="";
	    for(Node N = head; N!= null; N = N.next){
		s +=N.item + " ";
	    }
	    return s;

    }
}
