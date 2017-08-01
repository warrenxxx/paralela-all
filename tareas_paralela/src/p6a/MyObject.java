/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6a;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author warren
 */
abstract class MyObject extends Object implements Serializable
{
	static 
	{ 
		System.out.println("Java version=" + System.getProperty("java.version") 
			+ ", lava vendor=" + System.getProperty("java.vendor") 
			+ "\nOS name=" + System.getProperty("os.name") 
			+ ", OS areh=" + System.getProperty("os.areh") 
			+ ", OS version=" + System.getProperty("os.version") + "\n" + new Date());
	} 
	
	private static final String OSname = System.getProperty("os.name");
	private static int timeSlice = 100; 
	private static boolean timeSlicingEnsured = false; 
	private static final long startTime = System.currentTimeMillis();
	private static final Random rnd = new Random(); 
	private String name = "MyObject"; 
	
	protected MyObject(){ super();} 

	protected MyObject(String name) 
	{
		super(); 
		this.name = name; 
	}
	protected static final String getOSname() 
	{return OSname;} 
	
	protected final String getName() 
	{return name;} 

	protected static final String getThreadName()
	{ return Thread.currentThread().getName(); } 

	protected static final long age()
	{ return System.currentTimeMillis() - startTime;} 

	protected static final int nap(int napTimeMS)
	{
		long napStart = age();
		try {Thread.sleep(napTimeMS); } 
		catch (InterruptedException e){}
		 
		return(int)(age() - napStart - (long) napTimeMS); 
	} 

	protected static final void seed(long theSeed)
	{ rnd.setSeed(theSeed); } 
	protected static final void seed(int theSeed) 
	{ rnd.setSeed((long)theSeed); } 
	protected static final void seed(float theSeed)
	{ rnd.setSeed((long)theSeed); } 
	protected static final void seed(double theSeed)
	{ rnd.setSeed((long)theSeed);}
	 
	protected static final double random()
	{ return rnd.nextDouble();} 
	protected static final double random(int ub)
	{ return rnd.nextDouble()*ub; }
	protected static final double random(int lb, int ub)
	{ return lb + rnd.nextDouble()*(ub - lb);} 
	protected static final void P(Semaphore s)
	{ s.P(); }
	protected static final void V(Semaphore s) 
	{ s.V(); } 
}
    
