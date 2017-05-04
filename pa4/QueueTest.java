//---------------------------------------------------------------------------
// Quy Lam
// qlam
// 12b
// pa4
// 05/15/16    
//-----------------------------------------------------------------------------
// QueueTest.java                                                               
// Test Client for the Queue class                                              
//-----------------------------------------------------------------------------

public class QueueTest {

    public static void main(String[] args){
        Queue A = new Queue();
        A.enqueue(5); A.enqueue(3); A.enqueue(9); A.enqueue(7); A.enqueue(8);
        System.out.println(A);
        System.out.println(A.peek());
        A.dequeue(); A.dequeue(); A.dequeue();
        System.out.println(A.peek());
        System.out.println(A);
        Queue B = new Queue();
        System.out.println(A.isEmpty());
        System.out.println(B.isEmpty());
        B.enqueue(7); B.enqueue(8);
        System.out.println(A.equals(B));
        A.enqueue(12);
        B.enqueue(13);
        System.out.println(A);
        System.out.println(B);
        System.out.println(A.equals(B));
        A.dequeueAll();
        System.out.println(A);
        System.out.println(A.isEmpty());
	A.enqueue("AN");
	A.enqueue("ANTI");
	A.enqueue("ANT");
	System.out.println(A);
        A.dequeue(); A.dequeue();
	System.out.println(A);

    }
}
