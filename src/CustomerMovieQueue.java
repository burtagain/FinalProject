
public class CustomerMovieQueue {

	  private final int MAX_SIZE = 10;
	   private String[] queArray;
	   private int front;
	   private int rear;
	   private int nItems;
	  
	//--------------------------------------------------------------
	   public CustomerMovieQueue()          // constructor
	      {
	      
	      queArray = new String[MAX_SIZE];
	      front = 0;
	      rear = -1;
	      nItems = 0;
	      }
	//--------------------------------------------------------------
	   public void insert(String j)   // put item at rear of queue
	      {
	      if(rear == MAX_SIZE-1)         // deal with wraparound
	         rear = -1;
	      queArray[++rear] = j;         // increment rear and insert
	      nItems++;                     // one more item
	      }
	//--------------------------------------------------------------
	   public String remove()         // take item from front of queue
	      {
	      String temp = queArray[front++]; // get value and incr front
	      if(front == MAX_SIZE)           // deal with wraparound
	         front = 0;
	      nItems--;                      // one less item
	      return temp;
	      }
	//--------------------------------------------------------------
	   public String peekFront()      // peek at front of queue
	      {
	      return queArray[front];
	      }
	//--------------------------------------------------------------
	   public boolean isEmpty()    // true if queue is empty
	      {
	      return (nItems==0);
	      }
	//--------------------------------------------------------------
	   public boolean isFull()     // true if queue is full
	      {
	      return (nItems==MAX_SIZE);
	      }
	//--------------------------------------------------------------
	   public int size()           // number of items in queue
	      {
	      return nItems;
	      }
	//--------------------------------------------------------------
	   }  // end class Queue
	
	
	

