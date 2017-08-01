/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6a;

/**
 *
 * @author warren
 */
abstract class Semaphore
{
	protected int value = 0; 

	protected Semaphore() 
	{value = 0;}
		 
	protected Semaphore(int initial) 
	{ 
		if (initial < 0) 
			throw new IllegalArgumentException("initial<0"); 
		value = initial;
	} 
		
	public synchronized void P()
	{ 
		value--; 
		if (value < 0)
		{ 
			while (true)
			{ 
				try {wait(); 
				break; 
				} 
				catch (InterruptedException e)
				{
					System.err.println("Semaphore.P(): InterruptedException, wait again");
					if (value >= 0) break; 
					else continue; 
				}
			}
		}
	} 
	public synchronized void V()
	{ 
		value++; 
		if(value <= 0)
			notify();
	} 
	public synchronized int value()
	{ return value;} 

	public synchronized String toString()
	{
		return String.valueOf(value); 
	}
}
