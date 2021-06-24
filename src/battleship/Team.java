/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.BattleShipGUI.generateGrid;
import battleship.ship.Segment;
import battleship.ship.segment.State;
import java.awt.Component;

/**
 *
 * @author j9neave
 */
public enum Team {
	FRIENDLY{
		@Override
		public void CPUHit() {
			int x = (int)Math.floor(Math.random()*8);
			int y = (int)Math.floor(Math.random()*8);
			for (Component comp: this.getDisplayGrid().getComponents()) {
				Segment seg = (Segment) comp;
				if (seg.getPos().getX() == x && seg.getPos().getY() == y) {
					if (seg.getState().equals(State.UNKNOWN)) {
						seg.setState(State.MISS);
					} else if (seg.getState().equals(State.ALIVE)) {
						seg.setState(State.DEAD);
					} else {
						this.CPUHit();
					}
					
				}
			}
			
		}
	},
	ENEMY;
	
	boolean[][] shipGrid;
	Grid DisplayGrid;
	
	public void setTeamShipGrid(boolean[][] shipGrid) {
		this.shipGrid = shipGrid;
		this.getDisplayGrid().refresh();
	}
	
	public boolean[][] getTeamShipGrid() {
		try {
			return this.shipGrid;
		} catch (Exception e) {
			return generateGrid();
		}
	}
	
	public void setDisplayGrid(Grid grid) {
		this.DisplayGrid = grid;
	}
	
	public Grid getDisplayGrid() {
		return this.DisplayGrid;
	}

	public void CPUHit() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
