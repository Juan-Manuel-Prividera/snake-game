import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    Image gameOverImage = new ImageIcon("C:\\Users\\jmpri\\IdeaProjects\\snake_V2\\Game-Over-Graphics-30114494-1-1-580x386.png").getImage();
    public GameOver(){
        setPreferredSize(new Dimension(500,500));
        setVisible(true);
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(gameOverImage,25,50,this);
    }
}
