import javax.swing.*;

public class Human {

    public static void main(String [] args){
        JFrame frame = new JFrame();
        frame.setTitle("BackGammon");
        frame.setSize(860, 654);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI(new Game()));
        frame.setVisible(true);
    }
}
