
package view.main;

import java.awt.event.*;

public class MainButtonActionListener implements ActionListener {
  private MainFrame mainFrame;

  public MainButtonActionListener(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

/**
 * Handles button click events for the main frame.
 * If the 'Jenis Member' button is clicked, it displays the JenisMemberFrame.
 * This method is triggered by ActionEvent.
 *
 * @param e the ActionEvent object representing the event
 */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == mainFrame.getButtonJenisMember()) {
      mainFrame.showJenisMemberFrame();
    } else {
      mainFrame.showJenisMemberFrame();
    }
  }
}
