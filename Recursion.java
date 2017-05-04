//-----------------------------------------------------------------------------
// Quy Lam                                                                    
// qlam                                                                       
// 12B                                                                        
// 04/06/16                                                                   
//-----------------------------------------------------------------------------
// Recursion.java
// The program includes five recursive methods. Functions reverseArray will copy the elements of the input array into the output array in reverse order. Function maxArrayIndex and minArrayIndex return index of the maximum and minimum element repectively.
//-----------------------------------------------------------------------------

class Recursion {
   
    // reverseArray1()
    // Places the leftmost n elements of X[] into the rightmost n positions in
    // Y[] in reverse order
    static void reverseArray1(int[] X, int n, int[] Y){
	if(n>0){
	    Y[X.length-n] = X[n-1];
	    reverseArray1(X,n-1,Y);
	}    
    }

    // reverseArray2()
    // Places the rightmost n elements of X[] into the leftmost n positions in
    // Y[] in reverse order.
    static void reverseArray2(int[] X, int n, int[] Y){
	if(n>0){
	    reverseArray2(X,n-1,Y);
	    Y[n-1] = X[X.length-n];
	}
    }
    // reverseArray3()
    // Reverses the subarray X[i...j].
    static void reverseArray3(int[] X, int i, int j){
	if(i<=j){
	    int temp;
	    temp = X[i];
	    X[i] = X[j];
	    X[j] = temp;
	    reverseArray3(X,i+1,j-1);
	}
    }
   
    // maxArrayIndex()
    // returns the index of the largest value in int array X
    static int maxArrayIndex(int[] X, int p, int r){
	int q=0, i=0, m1=0, m2=0;
	if(p==r){
	 return  p;
	}
	if(p<r){
	    q = (p+r)/2;
	    
	    m1 = maxArrayIndex(X,p,q);
	    	       
	    m2 = maxArrayIndex(X,q+1,r);
	    
	    if(X[m1]<X[m2]){
		return i = m2;
	    }else{
		return i = m1;
	    }
	}
	return i;
    }
   
    // minArrayIndex()
    // returns the index of the smallest value in int array X
    static int minArrayIndex(int[] X, int p, int r){
	int q, m1=0, m2=0, i=0;
	if(p==r){
	    return p;
	}
	if(p<r){
	    q = (p+r)/2;
	    
	    m1= minArrayIndex(X,p,q);
	    
	    m2 = minArrayIndex(X,q+1,r);
	    
	    if(X[m1]<X[m2]){
		return i =m1;
	    }else{
		return i = m2;
	    }
	}
	return i;
    }

    // main()
    public static void main(String[] args){
      
	int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
	int[] B = new int[A.length];
	int[] C = new int[A.length];
	int minIndex = minArrayIndex(A, 0, A.length-1);
	int maxIndex = maxArrayIndex(A, 0, A.length-1);
      
	for(int x: A) System.out.print(x+" ");
	System.out.println(); 
      
	System.out.println( "minIndex = " + minIndex );  
	System.out.println( "maxIndex = " + maxIndex );  

	reverseArray1(A, A.length, B);
	for(int x: B) System.out.print(x+" ");
	System.out.println();
      
	reverseArray2(A, A.length, C);
	for(int x: C) System.out.print(x+" ");
	System.out.println();
      
	reverseArray3(A, 0, A.length-1);
	for(int x: A) System.out.print(x+" ");
	System.out.println();  
      
    }
   
}
/* Output:
-1 2 6 12 9 2 -5 -2 8 5 7
minIndex = 6
maxIndex = 3
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
7 5 8 -2 -5 2 9 12 6 2 -1
*/
