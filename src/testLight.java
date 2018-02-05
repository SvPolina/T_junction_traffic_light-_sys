import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.concurrent.ExecutorService;
//main function

public class testLight 
{
	static JFrame app=new JFrame();
	public static void main (String[] args) throws InterruptedException	
	{	
// Array for the Input parameters from the command line for the times the Horizontal and Vertical 
// traffic lights should operate.	
	Integer[] times=new Integer[2];	
	
//The input parameters will be accepted only if there are two of them(for vertical and horizontal lights)
//and only if they are integers, otherwise, default parameters will be given.	
	if(args.length>=2)
	 {	
		for(int i=0;i<2;i++)  
		{  
			try 
			{times[i] = Integer.parseInt(args[i]);
			System.out.printf("Horizontal t.light time %s\n",args[0]);
			System.out.printf("Vertical t.light time %s\n",args[1]);
			}	
			
			catch(NumberFormatException e) 
			{System.out.println("Input is not a valid integer");}
	    }	
	  }
	else{
		times[0]=5;
		times[1]=5;
	}
		
		//create new thread pool with two threads	
		ExecutorService executorService = Executors.newCachedThreadPool();	
		Road sharedRoad = new SynchronizedRoad(app,times);
		
		//execute the horizontal_cars and vertical_cars tasks
		executorService.execute(new Hor_Cars(sharedRoad));
		executorService.execute(new Ver_Cars(sharedRoad));		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

}

