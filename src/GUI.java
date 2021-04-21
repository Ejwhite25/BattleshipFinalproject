import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    JPanel jPanel = new JPanel();
    JFrame f = new JFrame();
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton enterButton = new JButton("Enter");
    JButton leaveButton = new JButton("Leave");
    JTextField playerInput = new JTextField();
    JTextField serverOutput = new JTextField();
    public void GUI() {
        this.frame.getContentPane().add(BorderLayout.NORTH,this.serverOutput);
        this.jPanel.add(playerInput);
        this.jPanel.add(enterButton);
        this.jPanel.add(leaveButton);
        this.frame.getContentPane().add(BorderLayout.SOUTH,this.jPanel);


    }

    void setEnterButtonActionListener(ActionListener al){
        enterButton.addActionListener(al);
    }

    void setLeaveButtonActionListener(ActionListener al){
        leaveButton.addActionListener(al);
    }

    void setOutputText(String val){
        this.serverOutput.setText(val);
    }

    String getInputText(){
        return this.playerInput.getText();
    }

}
