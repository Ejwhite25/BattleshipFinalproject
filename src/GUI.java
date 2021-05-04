import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    JPanel jPanel;
    JPanel boardPanel;
    JFrame frame;
    JButton enterButton;
    JButton leaveButton;
    JTextField playerInput;
    JTextField serverOutput;
    JTextArea board1Area;
    JTextArea board2Area;

    public GUI() {
        jPanel = new JPanel();
        boardPanel = new JPanel();
        frame = new JFrame();
        enterButton = new JButton("Enter");
        leaveButton = new JButton("Leave");
        playerInput = new JTextField();
        serverOutput = new JTextField();
        playerInput.setPreferredSize(new Dimension(200,20));
        board1Area = new JTextArea(20,20);
        board2Area = new JTextArea(20,20);
        this.boardPanel.add(board1Area);
        this.boardPanel.add(board2Area);
        this.frame.getContentPane().add(BorderLayout.CENTER,this.boardPanel);
        this.frame.getContentPane().add(BorderLayout.NORTH,this.serverOutput);
        this.frame.getContentPane().add(BorderLayout.WEST,this.board1Area);
        this.frame.getContentPane().add(BorderLayout.EAST,this.board2Area);
        this.jPanel.add(playerInput);
        this.jPanel.add(enterButton);
        this.jPanel.add(leaveButton);
        this.frame.getContentPane().add(BorderLayout.SOUTH,this.jPanel);
        this.frame.setSize(1000,1000);
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
