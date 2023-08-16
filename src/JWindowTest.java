import java.awt.*;
import java.util.Random;
//  w  w  w.  jav  a 2s  .  c  om
import javax.swing.JFrame;
import javax.swing.JPanel;

class Gradient extends Canvas{
    public static int count = 0;
    short color1[]; short color2[];
    Gradient(short color1[], short color2[]){
        super();
        this.color1 = color1;
        this.color2 = color2;
        count = (count+1)%2;
    }
    public void paint(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;
        Color colorFirst = Color.getHSBColor(color1[0]/255.0f, color1[1]/255.0f, color1[2]/255.0f);
        Color colorSecond = Color.getHSBColor(color2[0]/255.0f, color2[1]/255.0f, color2[2]/255.0f);
        g.setPaint(new GradientPaint(new Point(0,0), colorFirst, new Point(1500,1000), colorSecond));
        g.fill(new Rectangle(0,0,1500,1000));

    }
}


class Main extends JPanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        short color1 []= randomColor();
        short color2 []= randomColor();
        Gradient g = new Gradient(color1, color2);
        Gradient gg = new Gradient(color1, color2);
        frame.add(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0, 1500,1000);
        frame.setVisible(true);
        Random r = new Random();
        while (true){
            try {
                //Thread.sleep(500);
                int bias1 = r.nextInt(-10,11);
                int number1 = r.nextInt(3);
                color1[number1]+=bias1;
                if(!isColor(color1))
                    color1[number1]-=2*bias1;
                int bias2 = r.nextInt(-10,11);
                int number2 = r.nextInt(3);
                color2[number2]+=bias2;
                if(!isColor(color2))
                    color2[number2]-=2*bias2;
                //frame.add(new Gradient(color1, color2));
                if (Gradient.count%2==0){
                    gg = new Gradient(color1, color2);
                    frame.add(gg);
                    frame.setVisible(true);
                    Thread.sleep(200);
                    frame.remove(g);
                    frame.repaint();
                }else {
                    g = new Gradient(color1, color2);
                    frame.add(g);
                    frame.setVisible(true);
                    Thread.sleep(200);
                    frame.remove(gg);
                    frame.repaint();
                }
            }catch (InterruptedException a){
                System.exit(0);
            }


        }
    }
    public static short[] randomColor(){
        Random r = new Random();
        short []l = {(short) r.nextInt(255), (short) r.nextInt(255), (short)r.nextInt(255)};
        return l;
    }
    public static boolean isColor(short []color){
        if(color[0]>255||color[0]<0||color[1]>255||color[1]<0||color[2]>255||color[2]<0)
            return false;
        return true;
    }
}