// 
public class Hor_Cars implements Runnable 
{
	 private final Road sharedRoad; // reference to shared object
	 public Hor_Cars(Road sharedRoad)
	 {
		 this.sharedRoad = sharedRoad;
	 }
	//let the horizontal cars ride 6 times
	 public void run()
	 {
		
		 for (int count = 1; count <= 6; count++)
		 {
			 try
			 {
				 Thread.sleep(1000);
				 sharedRoad.blocking_Hor_Cars();
			 }
			 catch (InterruptedException exception)
		{
				 Thread.currentThread().interrupt();
		}
	 }	
	 System.out.printf("HOrizontal cars go to sleep%n");	 
	 }
} 




