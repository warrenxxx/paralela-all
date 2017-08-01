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
public class graparHojas extends MyObject
{ 
	protected static final CountingSemaphore CH = new CountingSemaphore(4);
	protected static final BinarySemaphore G = new BinarySemaphore(0); 
	
	public static void main(String args[])
	{
		mesa m = new mesa(CH,G); 
		Thread Amontonar = new Thread(new amontonar(m)); 
		Thread Grapar = new Thread(new grapar(m)); 
		Amontonar.start(); 
		Grapar.start();
	}
} 

