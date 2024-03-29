import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

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
            gui.playerInput = null;

        }
    }

    public class leaveButtonActionListener implements ActionListener{
        public leaveButtonActionListener(){}
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }



}
