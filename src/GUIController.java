import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    GUI gui = new GUI();
    String inputLine;

    public GUIController(){
        this.gui.setEnterButtonActionListener(new GUIController.enterButtonActionListener());
        this.gui.setLeaveButtonActionListener(new GUIController.leaveButtonActionListener());
    }
    public class enterButtonActionListener implements ActionListener {
        public enterButtonActionListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            inputLine = gui.getInputText();

        }
    }

    public class leaveButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }



}
