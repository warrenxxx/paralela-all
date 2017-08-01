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
final class CountingSemaphore extends Semaphore
{ 
	public CountingSemaphore()
	{ super();} 
	
	public CountingSemaphore( int initial) 
	{super( initial);} 
}

