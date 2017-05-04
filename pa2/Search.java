// Quy Lam
// qlam
// 12B
// 04/13/16
// Search.java
// This program will search the target in input file and print out the result plus report where the target is found.

import java.io.*;
import java.util.Scanner;

public class Search{
    public static void main(String[] args) throws IOException{
	
	// check input
	if(args.length < 2){
	    System.out.println("Usage: Search file target1 [target2 ..]");
	    System.exit(1);
	}
	
	// count the number of line in file
	Scanner in = new Scanner(new File(args[0]));
	in.useDelimiter("\\Z"); 
	String s = in.next();
	in.close();
	String[] lines = s.split("\n");
	int lineCount = lines.length;
	int[] lineNumber = new int[lines.length];

	// take the target
	int j=1, t=1;
	String [] target = new String[args.length];
	while(t<args.length){
	    target[t] = args[t];
	    t++;
	}
	
	for(int i=0;i<lines.length;i++){
	    lineNumber[i] = j;
	    j++;
	}
	
	mergeSort(lines,lineNumber, 0, lines.length-1);
	
	// search for target in input file and print out the resut
	for(t=1;t<target.length;t++){
	    int l;
	    l=Search(lines,lineNumber,0,lines.length-1,target[t]);
	    if(l!=-1){
		System.out.println(target[t]+" found on line "+lineNumber[l]);
	    }else{
		System.out.println(target[t]+" not found");
	    }
	}
    }
    
    // sort subarry word[p...r]
    static void mergeSort( String [] word, int[] lineNumber, int p, int r){
	int q;
	
	if(p<r){
	    q = (p+r)/2;
		
	    mergeSort(word,lineNumber,p,q);
	    mergeSort(word,lineNumber,q+1,r);
	    merge(word,lineNumber,p,q,r);
	}
    }

    // merges sorted subarrays word[p..q] and word[q+1..r]
    static void merge(String[] word, int [] lineNumber, int p, int q, int r){
	
	int n1 = q-p+1;
	int n2 = r-q;
	int[] Left = new int[n1];
	int[] Right = new int[n2];
	String[] L = new String[n1];
	String[] R = new String[n2];
	int i, j, k;
	
	for(i=0;i<n1;i++){
	    L[i] = word[p+i];
	    Left[i] = lineNumber[p+i];
	}

	for(j=0;j<n2;j++){
	    R[j] = word[q+j+1];
	    Right[j] = lineNumber[q+j+1];
	}
    	
	i = 0; j = 0;
	for(k=p;k<=r;k++){
	    if( i<n1 && j<n2 ){
		if( L[i].compareTo(R[j])<0 ){
		    word[k] = L[i];
		    lineNumber[k] = Left[i];  
		    i++;
		}else if( L[i].compareTo(R[j])>0 ){
		    word[k] = R[j];
		    lineNumber[k] = Right[j];
		    j++;
		}
	    }else if( i<n1 ){
		word[k] = L[i];
		lineNumber[k] = Left[i];
		i++;
	    }else{  //j<n2
		word[k] = R[j];
		lineNumber[k] = Right[j];
		j++;
	    }
	}
    }

    //
    public static int Search(String[] word,int[] lineNumber, int p,int r, String target){
	int q;
	if(p>r){
	    return -1;
	}else{
	    q= (p+r)/2;
	    if(target.compareTo(word[q])==0){
		return q;
	    }else if(target.compareTo(word[q])<0){
		return Search(word,lineNumber,p,q-1,target);
	    }else{
		return Search(word,lineNumber,q+1,r,target);
	    }
	}
    }
}
