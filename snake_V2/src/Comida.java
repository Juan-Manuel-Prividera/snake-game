import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Comida extends JComponent {
    Point coordenadas = new Point();
    public Comida(){
        coordenadas.x = ThreadLocalRandom.current().nextInt(10,490);
        coordenadas.y = ThreadLocalRandom.current().nextInt(10,490);
        setVisible(true);
    }



    public void reubicarComida(){
        coordenadas.x = ThreadLocalRandom.current().nextInt(10,490);
        coordenadas.y = ThreadLocalRandom.current().nextInt(10,490);
    }

}
