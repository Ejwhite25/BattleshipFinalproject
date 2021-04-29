import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    JPanel jPanel = new JPanel();;
    JFrame frame = new JFrame();
    JTextArea board1Area = new JTextArea();
    JTextArea board2Area = new JTextArea();
    JButton enterButton = new JButton("Enter");
    JButton leaveButton = new JButton("Leave");
    JTextField playerInput = new JTextField();
    JTextField serverOutput = new JTextField();
    public GUI() {
        this.frame.setLayout(new BorderLayout());
        this.frame.getContentPane().add(BorderLayout.NORTH,this.serverOutput);
        this.frame.getContentPane().add(BorderLayout.WEST,this.board1Area);
        this.frame.getContentPane().add(BorderLayout.EAST,this.board2Area);
        this.jPanel.add(playerInput);
        this.jPanel.add(enterButton);
        this.jPanel.add(leaveButton);
        this.frame.getContentPane().add(BorderLayout.SOUTH,this.jPanel);
        this.frame.setSize(300,300);
        this.frame.setVisible(true);
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
