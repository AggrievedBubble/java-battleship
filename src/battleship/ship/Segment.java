package battleship.ship;

import battleship.ship.segment.Position;
import battleship.ship.segment.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j9neave
 */
public class Segment extends javax.swing.JPanel {

	private State state;
	private final Position pos;
	
	/**
	 * Creates new form Segment
	 */
		
	
	public Segment(int xpos, int ypos, State defaultState) {
		
		initComponents();
		
		this.state = defaultState;
		this.updateColor();
		this.pos = new Position(xpos, ypos);
	
	}
	
	public State getState() {
		return this.state;
	}
	
	public void setState(State state) {
		this.state = state;
		this.updateColor();
	}

	public Position getPos() {
		return this.pos;
	}
	
	public void updateColor() {
		java.awt.Color color;
		switch(this.state) {
			case UNKNOWN: {
				color = new java.awt.Color(195, 195, 195);
				break;
			}
			case ALIVE: {
				color = new java.awt.Color(0, 162, 232);
				break;
			}
			case DEAD: {
				color = new java.awt.Color(237, 28, 36);
				break;
			}
			case MISS: {
				color = new java.awt.Color(127, 127, 127);
				break;
			}
			case HIT: {
				color = new java.awt.Color(255, 127, 39);
				break;
			}
			default: {
				color = new java.awt.Color(240, 240, 240);
				break;
			}
		}
		this.setBackground(color);
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
		switch(this.state) {
			case UNKNOWN: {
				this.setState(State.ALIVE);
				break;
			}
			case ALIVE: {
				this.setState(State.DEAD);
				break;
			}
			case DEAD: {
				this.setState(State.MISS);
				break;
			}
			case MISS: {
				this.setState(State.HIT);
				break;
			}
			case HIT: {
				this.setState(State.UNKNOWN);
				break;
			}
			default: {
				this.setState(State.UNKNOWN);
				break;
			}
		}
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}