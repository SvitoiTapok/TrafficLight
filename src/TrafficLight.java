import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;

public class TrafficLight extends Canvas {
    @Override
    public void paint(Graphics g) {
        try {
            Graphics2D gg = (Graphics2D) g;
            gg.setPaint(new TexturePaint(ImageIO.read(new File("C:\\Users\\Lenovo\\IdeaProjects\\Study Project 2\\img\\Traffic Light.jpg")), new Rectangle2D.Double(0, 0, 1024, 1024)));
            gg.fill(new Rectangle(0, 0, 1024, 1024));
        } catch (Exception a) {
            System.out.println(a.getMessage());
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        JFrame a = Window.Windowa();
        TrafficLight x = new TrafficLight();
        a.add(x);
        a.setVisible(true);
    }

}
class Window extends JFrame{
    public static JFrame Windowa(){
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return fr;
    }

}
