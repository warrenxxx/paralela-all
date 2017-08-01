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
class amontonar extends graparHojas implements Runnable
{
	private mesa m1; 
	public amontonar(mesa m)
	{ this.m1 = m; } 
	
	public void run()
	{ 
		for(int i=1;i<=10;i++)
		{ 
			int j=1; 
			while(j != 5) 
			{ 
					m1.amontona(j);
					j++;
			}
		}
	}
}

