import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Test {
    public static int counter = 0;
    public static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Test frame");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton northButton = new JButton("North");
        panel.add(northButton, BorderLayout.NORTH);

        JButton southButton = new JButton("South");
        panel.add(southButton, BorderLayout.SOUTH);

        JButton eastButton = new JButton("East");
        panel.add(eastButton, BorderLayout.EAST);

        JButton westButton = new JButton("West");
        panel.add(westButton, BorderLayout.WEST);

        JButton centerButton = new JButton("Center");
        panel.add(centerButton, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                counter++;
                System.out.println(counter);
                if(counter<100){
                    Test.createGUI();
                }
            }
            @Override
            public void windowClosing(WindowEvent e) {
                if (counter < 200){
                    Test.createGUI();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        Random x = new Random();


        frame.pack();
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Test.createGUI();
    }
}