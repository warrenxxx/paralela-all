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
class grapar extends graparHojas implements Runnable 
{ 
	private mesa m2; 
	public grapar(mesa m)
	{this.m2 = m; } 

	public void run()
	{ 
		for(int i=1;i<=12;i++) 
		{ 
			m2.grapa();
		}
	} 
}

