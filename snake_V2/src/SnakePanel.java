import javax.swing.*;
import java.awt.*;


public class SnakePanel extends JPanel {
    SnakeGame snakeGame = new SnakeGame();

    final int ANCHO_PANEL = 500;
    final int ALTO_PANEL = 500;
    final int ANCHO_COMIDA = snakeGame.ANCHO_SNAKE;
    final int ALTO_COMIDA = snakeGame.ALTO_SNAKE;

    public SnakePanel(){
        setPreferredSize(new Dimension(ANCHO_PANEL,ALTO_PANEL));

        add(snakeGame);
        add(snakeGame.comida);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // Dibujo cabeza
        g.fillRect(snakeGame.cola.getFirst().x,snakeGame.cola.getFirst().y,snakeGame.ANCHO_SNAKE,snakeGame.ALTO_SNAKE);

        // Dibujo cola
        for(int i = 1; i < snakeGame.cola.size(); i++){
            if (snakeGame.cola.get(i) != null) {
                g.fillRect(snakeGame.cola.get(i).x,snakeGame.cola.get(i).y,snakeGame.ANCHO_SNAKE,snakeGame.ALTO_SNAKE);
            }
        }

        g.drawString("PUNTAJE: ",50,450);
        g.drawString(String.valueOf(snakeGame.puntaje),120,450);

        g.setColor(Color.RED);
        g.fillRect(snakeGame.comida.coordenadas.x,snakeGame.comida.coordenadas.y,ANCHO_COMIDA,ALTO_COMIDA);

    }

}
