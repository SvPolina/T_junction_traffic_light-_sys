
public class Ver_Cars implements Runnable
{
	 private final Road sharedRoad; // reference to shared object	
	 public Ver_Cars (Road sharedRoad)
	{this.sharedRoad  = sharedRoad;}	 
	//let the vertical cars ride 6 times
	 public void run()
	 {		
	    for (int count = 1; count <= 6; count++)
	 	{
	    	try
	    	{	Thread.sleep(1000);
	    	sharedRoad.blocking_Ver_Cars(); 
	    	}	 
	    	catch (InterruptedException exception)
	    	{
			 Thread.currentThread().interrupt();
			}
	    }	
	 System.out.printf("Vertical cars go to sleep%n");	 
	 }	
}

