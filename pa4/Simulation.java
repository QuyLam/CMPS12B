//---------------------------------------------------------------------------
// Quy Lam
// qlam
// 12b
// pa4
// 05/15/16    
//-----------------------------------------------------------------------------
// Simulation.java
// 
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

public class Simulation{
  
    public static Job getJob(Scanner in) {
	String[] s = in.nextLine().split(" ");
	int a = Integer.parseInt(s[0]);
	int d = Integer.parseInt(s[1]);
	return new Job(a, d);
    }
//-------------------------------------------------------------------------------  
    public static void main(String[] args) throws IOException{
	if (args[0] != null) {
	    Scanner in = null;
	    in = new Scanner(new File(args[0]));
	    PrintWriter rpt = new PrintWriter(new FileWriter(args[0]+".rpt"));
	    PrintWriter trc = new PrintWriter(new PrintWriter(args[0]+".trc"));
    
	    int m = Integer.parseInt(in.nextLine().trim());
            
	    Queue storage = new Queue();
	    for(int i = 0; i < m; ++i) 
		storage.enqueue((Job)getJob(in));
	    Queue backup = backup(storage, m);
      
	    in.close();
      
	    Queue[] processor = new Queue[m+1];
	    for (int j = 1; j <= m; ++j) 
		processor[j] = new Queue();
      
      
	    rpt.println("Report file: "+args[0]+".rpt");
	    rpt.println(m+" Jobs:");
	    rpt.println(storage);
	    rpt.println();
            rpt.println("********************************************************");
      
      
	    trc.println("Trace file: "+args[0]+".trc");
	    trc.println(m+" Jobs:");
	    trc.println(storage);
      
	    for(int i = 1; i < m; i++) {
		if(i == 1) 
		    rpt.print(i+" processor: ");
		else 
		    rpt.print(i+" processors: ");
        
		
		trc.println();
		trc.println("*****************************");
		if(i == 1) trc.println(i+" processor:");
		else trc.println(i+" processors:");
		trc.println("*****************************");
        
        
		trc.println("time=0");
		trc.println("0: "+storage);
		for(int j = 1; j <= i; j++){
		    trc.println(j+": "+processor[j]);
		}
		int clock = 0;
		int remaining = m;
        
		while(remaining > 0) {
		    boolean print_now = false;
		    while(newProcess(storage,processor,clock,i)) 
			print_now = true;
		    while(finished(storage,processor,clock,i)){
			print_now = true; 
			remaining--;
		    }
          
          
		    if (print_now) {
			trc.println("time="+clock);
			trc.println("0: "+storage);
			for(int j = 1; j <= i; ++j){
			    trc.println(j+": "+processor[j]);
			}
			trc.println();
		    }
          
		    clock++;
		}
        
		int totalWait = gettotalWait(storage, m);
		int maxWait = getMaxWait(storage, m);
		reset(backup, storage, m);
        
		rpt.printf("totalWait=%d, maxWait=%d, averageWait=%.2f %n",
			   totalWait, maxWait ,(float)totalWait/m);
        
	    }
      
	    rpt.close();
	    trc.close();
	}
    }
  
    static boolean finished(Queue storage, Queue[] process, int time, int num) {
	for (int i = 1; i <= num; i++) {
	    if (process[i].isEmpty()){
		continue;
	    }else{
		if (((Job)process[i].peek()).getFinish() == time) {
		    storage.enqueue(process[i].dequeue());
		    if(!process[i].isEmpty()) ((Job)process[i].peek()).computeFinishTime(time);
		    return true;
		}
	    }
	}
	return false;
    }
  
    static boolean newProcess(Queue storage, Queue[] process, int time, int num) {
	if (!storage.isEmpty()) {
	    if (((Job)storage.peek()).getArrival() == time) {
		Job tmp = ((Job)storage.dequeue());
		int value = nextProcessor(process, num);
		process[value].enqueue(tmp);
		if (((Job)process[value].peek()).getFinish() == Job.UNDEF) ((Job)process[value].peek()).computeFinishTime(time);
		return true;
	    }
	}
	return false;
    }
  
    static int nextProcessor(Queue[] processor, int num) {
	int next = 1;
	for(int i = 1; i <= num; i++) {
	    if(processor[i].length() < processor[next].length()) next = i;
	}
	return next;
    }
  
    static int gettotalWait(Queue storage, int m) {
	int WaitTime = 0;
	for (int i = 0; i < m; i++) {
	    Job A = (Job)storage.dequeue();
	    WaitTime += A.getWaitTime();
	    storage.enqueue(A);
	}
	return WaitTime;
    }
  
    static int getMaxWait(Queue storage, int m) {
	int WaitTime = 0;
	for (int i = 0; i < m; i++) {
	    Job B = (Job)storage.dequeue();
	    if (B.getWaitTime() > WaitTime) WaitTime = B.getWaitTime();
	    storage.enqueue(B);
	}
	return WaitTime;
    }
  
    static void reset(Queue backup, Queue storage, int m) {
	if (!storage.isEmpty()) storage.dequeueAll();
	for (int i = 0; i < m; i++) {
	    Job C = (Job)backup.dequeue();
	    C.resetFinishTime();
	    storage.enqueue(C);
	    backup.enqueue(C);
	}
    }
  
    static Queue backup(Queue storage, int m) {
	Queue input = new Queue();
	for (int i = 0; i < m; i++) {
	    Job D = (Job)storage.dequeue();
	    input.enqueue(D);
	    storage.enqueue(D);
	}
	return input;
    }
}
