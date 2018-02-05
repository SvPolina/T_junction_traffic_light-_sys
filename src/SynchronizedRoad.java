
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;


public class SynchronizedRoad implements Road{
	
	// Lock to control synchronization with this Road
	private final Lock accessLock = new ReentrantLock();
	// conditions to control Vertical and HOrizontal cars
	private final Condition Hor_go = accessLock.newCondition();
	private final Condition Ver_go = accessLock.newCondition();
	public JFrame app;
	private int hor_t;
	private int ver_t;
	
    //whether Horizontal cars ride
	private boolean horizontal_go = false; 
	// shared by horizontal and vertical cars threads
	private T_L_Try1 panel;
	
	public SynchronizedRoad(JFrame app,Integer[] times){
	
		this.app=app;		
		panel=new T_L_Try1(400,150,50,horizontal_go);
		app.add(panel);	
	
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		app.setSize(600,600);
		this.hor_t=times[0];
		this.ver_t=times[1];
	}
	
	public void blocking_Hor_Cars() throws InterruptedException
	 {
		accessLock.lock();		
		try
		 {		
		// while horizontal cars ride, place thread in waiting state
		 while (horizontal_go)
		 {
		 System.out.println("Horizontal cars try to go");
		 displayState("Horizontal cars already going. Vertical pedestrians waits.");
		 Hor_go.await();
		 }	
		 
		 //Horizontal cars go, make the necessary operations with the traffic lights
		 horizontal_go = true;	 		 
		 Timer timer = new Timer(500, new ActionListener() 			
		 {
			    private int i=4;
			    @Override
			  public void actionPerformed(ActionEvent e) 
			  { 
			   	 
			    panel.SetL1(horizontal_go);
		    	panel.SetL2(!horizontal_go);			    	 
		    	panel.SetL3(horizontal_go);
		    	 		    	
		    	 
			   	  if (i%2 == 0)		   		     
			       	{
			   		 panel.SetL4(true);//flashing horizontal green	
			         app.repaint();
			        }
			       else 
			        {			    	
			    	 panel.SetL4(false);//flashing horizontal green		
		             app.repaint();	        	
		            }
			        i++;	           
			  }
			});
			timer.start();			
			TimeUnit.SECONDS.sleep(hor_t);			
			timer.stop();		 	  	  
		 		  
		 displayState("Horizontal cars ride " );	
		 Ver_go.signalAll();
		 }
		 finally
		 {
		 accessLock.unlock();			 
		 }
		 }
	
	public void blocking_Ver_Cars() throws InterruptedException
	 {
	 int readValue = 0; 
	 accessLock.lock();	
	 try
	 {
		// while vertical cars ride, place thread in waiting state
	 while (!horizontal_go)
	 {
	 System.out.println("Vertical cars try to go");
	 displayState("Vertical cars already going.  Horizontal pedestrians waits.");
	 Ver_go.await();
	 }
	
	 horizontal_go = false;	 
	 Timer timer = new Timer(500, new ActionListener() 
		{
		    private int i=4;
		    @Override
		  public void actionPerformed(ActionEvent e) 
		  {  
		     
		     panel.SetL3(horizontal_go);
		     panel.SetL4(horizontal_go);		    	   
	    	 panel.SetL1(horizontal_go);
		    	
		  	  if (i%2 == 0)		   		     
		       	{ 	     
		   	      panel.SetL2(true);//flashing vertical green	
		          app.repaint();
		        }
		       else 
		       { 
		    	
		    	  panel.SetL2(false);//flashing vertical green	
	              app.repaint();	        	
	           }
		        i++;	           
		  }
		});
		timer.start();			
		TimeUnit.SECONDS.sleep(ver_t);			
		timer.stop();	
	 
	
     displayState("Vertical cars ride " );
	 Hor_go.signalAll();
	 }
	 finally
	 { accessLock.unlock();}	 
	 }
	
	
	 private void displayState(String operation)
	 {
	 try
	 {
	 accessLock.lock();
	 System.out.printf("%s\n", operation);
	 }
	 finally
	 {
	 accessLock.unlock();
	 }
	 }
}
