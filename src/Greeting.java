import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Greeting extends JFrame implements ActionListener {
	
	
	public Greeting() {
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(this);
    	display paint = new display();
    	JPanel content = new JPanel();
    	content.setLayout(new BorderLayout());
    	content.add(paint, BorderLayout.CENTER);
    	content.add(yesButton, BorderLayout.SOUTH);
     	setSize(200, 100);
    	setLocation(100, 100);
    	setContentPane(content);
    	setVisible(true);
  this.setResizable(false);

	}
	public static class display extends JPanel {
	       public void paintComponent(Graphics g) {
	    	   super.paintComponents(g);
		g.drawString("Start Game?", 20, 30);
			}
	}
	/**
	 * 
	 * @author horacezhang
	 * method of the button.
	 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stu
			
			new Board();
			this.setVisible(false);
			this.dispose();
		
			
			
		}   	
    
    public static void main (String[] args) {
    new Greeting();
    }
	
}
