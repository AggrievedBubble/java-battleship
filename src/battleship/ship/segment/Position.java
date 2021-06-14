/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.ship.segment;

/**
 *
 * @author j9neave
 */
public class Position {
	private final int xpos;
	private final int ypos;
	
	public Position(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
		
	}
	
	public int getX() {
		return this.xpos;
	}
	
	public  int getY() {
		return this.ypos;
	}
}
