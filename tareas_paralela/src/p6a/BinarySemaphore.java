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
import java.util.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

final class BinarySemaphore extends Semaphore  
{
	public BinarySemaphore()
	{super();}
	public BinarySemaphore(int initial)
	{
		super(initial);
		if (initial > 1)
			throw new IllegalArgumentException("initial > 1"); 
	}
	
	public BinarySemaphore(boolean initial)
	{super(initial ? 1:0);} 
	
	public final synchronized void V()
	{
		super.V(); 
		if (value > 1) 
			value = 1;
	}
} 

