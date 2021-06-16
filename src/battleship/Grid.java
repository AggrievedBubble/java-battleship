/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import battleship.ship.Segment;
import battleship.ship.segment.State;

/**
 *
 * @author j9neave
 */
public class Grid extends javax.swing.JPanel {

	private final Team team;
	
	/**
	 * Creates new form Grid
	 * @param team
	 */
	public Grid(Team team) {
		initComponents();
		
		this.team = team;

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				this.add(new Segment(x, y, State.UNKNOWN, this.team));
			}
		}
		
		this.revalidate();
		this.repaint();
	}

	public void refresh() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				
			}
		}
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(8, 8, 5, 5));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
