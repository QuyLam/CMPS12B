//-----------------------------------------------------------------
// Quy Lam
// qlam
// 12b
// 04/21/16
//---------------------------------------------------------------
// DictionaryTest.java
// This program use as a test client for the Dictionary ADT while it is underconstruction.
//----------------------------------------------------------------    

public class DictionaryTest{
    public static void main(String[] args){
	String v;
	Dictionary A = new Dictionary();
	
	//Test isEmpty
	System.out.println("isEmpty is: "+A.isEmpty());
	
	// Test size()
	System.out.println("Size: "+A.size());
	System.out.println();

	// Test insert
	A.insert("1","a");
	System.out.println(A);
	/*
	System.out.println("isEmpty is: "+A.isEmpty());
	System.out.println("size: "+A.size());
	*/
	
	A.insert("2","b");
	System.out.println(A);
	A.insert("3","e");
	System.out.println(A);
	A.insert("4","f");
	System.out.println(A);
	A.insert("five","value");
	System.out.println(A);
	A.insert("six","value");
	System.out.println(A);
	A.insert("seven","-100");
	System.out.println(A);
	A.insert("8","-100");
	System.out.println(A);

	System.out.println("size: "+A.size());
	System.out.println();	
	/*	
	//A.insert("six","2"); // thrown out error message
	//A.insert("8","-100"); // throw out error message
	A.insert("eigth","-100");
	A.insert("nine","f");
	System.out.println(A);
	System.out.println();
	
	System.out.println("size: "+A.size());
	System.out.println("isEmpty is: "+A.isEmpty());
	System.out.println();
	*/
	//Test lookup
	v = A.lookup("1");
	System.out.println("key=1 "+(v==null?"not found":("value="+v)));
	v = A.lookup("3");
	System.out.println("key=3 "+(v==null?"not found":("value="+v)));
	v = A.lookup("five");
	System.out.println("key=five "+(v==null?"not found":("value="+v)));
	v = A.lookup("ten");
	System.out.println("key=nine "+(v==null?"not found":("value="+v)));
	v = A.lookup("11");
	System.out.println("key=11 "+(v==null?"not found":("value="+v)));
	/*
	System.out.println();
	System.out.println("isEmpty is: "+A.isEmpty());
	System.out.println("size: "+A.size());
	System.out.println();
	*/
	A.delete("1");
        System.out.println(A);
	A.delete("2");
	System.out.println(A);
	A.delete("seven");
	System.out.println(A);
	A.delete("8");
	System.out.println(A);
	/*
	v = A.lookup("1");
        System.out.println("key=1 "+(v==null?"not found":("value="+v)));
        v = A.lookup("2");
        System.out.println("key=2 "+(v==null?"not found":("value="+v)));
        v = A.lookup("nine");
        System.out.println("key=eigth "+(v==null?"not found":("value="+v)));
	v = A.lookup("10");
        System.out.println("key=10 "+(v==null?"not found":("value="+v)));
	System.out.println();
	//	A.delete("ten"); print out usage message
	*/
	System.out.println(A);
	System.out.println("isEmpty is: "+A.isEmpty());
        System.out.println("size: "+A.size());
        System.out.println();

	A.makeEmpty();
        System.out.println("isEmpty is: "+A.isEmpty());
        System.out.println("size: "+A.size());
	System.out.println();
	

   }
}	
