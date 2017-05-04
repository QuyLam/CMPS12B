//---------------------------------------------------------------------------
// Quy Lam
// qlam
// 12b
// 04/22/16    
//-----------------------------------------------------------------------------
// Dictionary.java
// this program implements a Dictionary ADT based on the linked list.
//-----------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface {
    
    // private inner Node class
    private class Node {
	String key;
	String value;
	Node next;
	

	Node(String key, String value){
	    this.value = value;
	    this.key = key;
	    next = null;
	}
    }

    // Fields for the IntegerList class
    private Node head;     // reference to first Node in List
    private int numKeys;  // number of keys in this Dictionary
    private Node tail; //reference to last Node in list

    // IntegerList()
    // constructor for the IntegerList class
    public Dictionary(){
	head = null;
	tail =null;
	numKeys = 0;
    }


    // private helper function -------------------------------------------------

    // findkey()
    // returns a reference to the Node at position index in this IntegerList
    private Node findkey(String key){
	Node N = head;

	while(N !=null){
	    if(key.equals(N.key)){
		break;
	    }else{
		N = N.next;
	    }
	}
	if(N==null){
	    return null;
	}else{
	    return N;
	}
    }
    

	     
        
    // ADT operations ----------------------------------------------------------

    // isEmpty()
    // pre: none
    // post: returns true if this Dictionary is empty, false otherwise
    public boolean isEmpty(){
	return(numKeys == 0);
    }

    // size()
    // pre: none
    // post: returns the number of (key,value) pairs in this Dictionary
    public int size() {
	return numKeys;
    }

    // lookup()
    //pre: none
    // post: returns value at position key in the Dictionary,return null otherwise
    public String lookup(String key){
   
	Node N = findkey(key);
	if(N==null){
	    return null;
	}else{
	return N.value;
	}
    }

    // insert()
    // inserts the pair(key,value) to the Dictionary
    // pre: the Dictionary does not currently contain the argument key
    // post: !isEmpty(), keys to the right of newItem are renumbered
    public void insert(String key, String value) 
	throws DuplicateKeyException{
      
	if(lookup(key)!=null ){
	    throw new DuplicateKeyException(
						    "cannot insert duplicate keys");
	}
	if(numKeys==0){
	    head = tail = new Node(key,value);
	}else{
	    Node N = new Node(key,value);
	    tail.next = N;
	    tail = N;
	}
	numKeys++;
    }

    // delete()
    // deletes the pair whose key field matches the argument key
    // pre:  the Dictionary currently contains the argument key
    // post: keys to the right of deleted item are renumbered
    public void delete(String key)
	throws KeyNotFoundException{
	if( lookup(key)==null){
	    throw new KeyNotFoundException(
						    "cannot delete non-existent key");
	}
	Node N = findkey(key);
	if(numKeys==1){
	    Node A = head;
	    head = head.next;
	    A.next = null;
	}else if(N==head){
	    N = head;
	    head = N.next;
	    N.next = null;
	}else{
	    Node A = head;
	    while(A.next!=N){
		A = A.next;
	    }
	    A.next = N.next;
	    N.next = null;
	}    
	numKeys--;
    }

    // makeEmpty()
    // pre: none
    // post: isEmpty()
    public void makeEmpty(){
	head = null;
	numKeys = 0;
    }

    // toString()
    // pre: none
    // post:  prints current state to stdout
    // Overrides Object's toString() method
    public String toString(){
	StringBuffer sb = new StringBuffer();
	Node N = head;

	for( ; N!=null; N=N.next) sb.append(N.key).append(" "+N.value+"\n");
	return new String(sb);
    }

}
