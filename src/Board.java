import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Board extends JFrame implements MouseListener{
	// the size of the game.
     int width = 500;
     int height = 500;
     int positionx = 0;
     int positiony = 0;
     int[][] chess = new int[19][19];
     boolean canPlay = true;
     boolean colorB = true;
     int totalCount = 0;
     
     /**
      * the constructor method of the design of board.
      */
     public Board () {
    	 this.setTitle("Connect5");
    	 this.setSize(width, height);
    	 this.setResizable(false);
    	 this.setVisible(true);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setLocation(100, 100);
    	 addMouseListener(this);
     }
    	  /**
    	   * draw components of the game.
    	   */
     public void paint(Graphics g) {
    	 int vertical = 0;
    	 for (int i = 0; i < 19; i++) {
    		 g.drawLine(100, 100 + vertical, 460, 100 + vertical);
    		 vertical += 20;
    	 }
    	 int horizontal = 0;
    	 for (int i = 0; i < 19; i++) {
    		 g.drawLine(100 + horizontal, 100, 100 + horizontal,460 );
    		 horizontal += 20;
    	 }
    	 for(int i = 0; i < 19; i++) {
    	 for(int j = 0; j < 19; j ++) {
    		 if(this.chess[i][j] == 1) {
    			 /**
    			  * Black Chess.
    			  */
    			 int comX = i * 20 + 100;
    			 int comY = j * 20 + 100;
    			 g.fillOval(comX - 7, comY - 7, 14, 14);
    		 }
    		 if(this.chess[i][j] == 2) {
    			 /**
    			  * white chess.
    			  */
    			 int comX = i * 20 + 100;
    			 int comY = j * 20 + 100;
    			 g.setColor(Color.white);	
    			 g.fillOval(comX - 7, comY - 7, 14, 14);
    			 g.setColor(Color.BLACK);
             g.drawOval(comX - 7, comY - 7, 14, 14);
    		 }
    		 
    	 } 
    	 }
     }
     

     // the main method;
     public static void main (String[] args) {
    	 new Board();
     }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (canPlay == false) {
			return;
		} 
		System.out.println(e.getX() + "---" + e.getY());
		positionx = e.getX();
		positiony = e.getY();
		if(positionx >= 100 && positionx 
		<= 460 && positiony >= 100 && positiony < 460) {
			positionx = (positionx - 100) / 19;
			positiony = (positiony - 100) / 19;
			
			if(chess[positionx][positiony] == 0) {
				
				if(this.colorB == true) {
					chess[positionx][positiony] = 1;
					colorB = false;
				} else {
					
				chess[positionx][positiony] = 2;
				colorB = true;
				}
				
				boolean win = this.win();
				if (win) {
					
					canPlay = false;
					JOptionPane.showMessageDialog(null, "Game over!");
				}
				totalCount++;
				if (totalCount % 10 == 0) {
					reverse();
				}
		
			}
			this.repaint();
			
		}
		
	}
	
	private boolean win() {
		boolean winFlag = false;
		
		int count = 1;
		
		int color = this.chess[positionx][positiony];
		
		count = checkCount(1, 0, color);
		if (count >= 5) {
			winFlag = true;
		} else {
			count = checkCount(0, 1, color);
			if (count >= 5) {
				winFlag = true;
			} else {
				count = checkCount(1, -1, color);
				if (count >= 5) {
					winFlag = true;
				} else {
					count = checkCount(1, 1, color);
					if (count >= 5) {
						winFlag = true;
					}
				}
			}
		}
		return winFlag;
	}
	
	private int checkCount(int Xchange, int Ychange, int color) {
		int count = 1;
		int tempX = Xchange;
		int tempY = Ychange;
		
		while (color == this.chess[positionx + Xchange][positiony + Ychange]) {
			count++;
			if (Xchange != 0) {
				Xchange++;
			} 
			if (Ychange != 0) {
				if (Ychange > 0) {
					Ychange++;
				} 
				if (Ychange < 0) {
					Ychange--;
				}
			}
		}
		
		Xchange = tempX;
		Ychange = tempY;
		
		while (color == this.chess[positionx - Xchange][positiony - Ychange]) {
			count++;
			if (Xchange != 0) {
				Xchange++;
			} 
			if (Ychange != 0) {
				if (Ychange > 0) {
					Ychange++;
				} 
				if (Ychange < 0) {
					Ychange--;
				}
			}
		}
		
		return count;
	}
	
	public void reverse() {
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				
				if (this.chess[i][j] == 1) {
					this.chess[i][j] = 2;
				} else if (this.chess[i][j] == 2) {
					this.chess[i][j] = 1;
				}
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}