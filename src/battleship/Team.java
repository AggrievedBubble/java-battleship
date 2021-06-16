/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.BattleShipGUI.generateGrid;

/**
 *
 * @author j9neave
 */
public enum Team {
	FRIENDLY {
		
		@Override
		public void setTeamShipGrid(boolean[][] shipGrid) {
			this.shipGrid = shipGrid;
			this.getGrid().refresh();
		}
	},
	ENEMY;
	
	boolean[][] shipGrid;
	Grid grid;
	
	public void setTeamShipGrid(boolean[][] shipGrid) {
		this.shipGrid = shipGrid;
	}
	
	public boolean[][] getTeamShipGrid() {
		try {
			return this.shipGrid;
		} catch (Exception e) {
			return generateGrid();
		}
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	public Grid getGrid() {
		return this.grid;
	}
	
}
