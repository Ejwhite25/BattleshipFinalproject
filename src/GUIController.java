import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    String inputLine;
    GUI gui;

    public GUIController(){
        gui = new GUI();
        this.gui.setEnterButtonActionListener(new GUIController.enterButtonActionListener());
        this.gui.setLeaveButtonActionListener(new GUIController.leaveButtonActionListener());
    }
    public class enterButtonActionListener implements ActionListener {
        public enterButtonActionListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            inputLine = gui.getInputText();
            gui.playerInput.setText(null);

        }
    }

    public class leaveButtonActionListener implements ActionListener{
        public leaveButtonActionListener(){}
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }



}
