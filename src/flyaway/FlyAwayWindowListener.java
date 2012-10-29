/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flyaway;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;



/**
 *
 * @author user
 */
public class FlyAwayWindowListener extends WindowAdapter {
    @Override
  public void windowClosing(WindowEvent e)
  {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?");
		if(option == JOptionPane.YES_OPTION){
			System.exit(0);
		}
  }
}
