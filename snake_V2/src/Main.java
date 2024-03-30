import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Snake");
        ventana.setLocation(600,200);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SnakePanel snakePanel = new SnakePanel();
        ventana.add(snakePanel);

        ventana.pack();
        ventana.setVisible(true);

        GameOver panelGameOver = new GameOver();


        Timer timer = new Timer(70, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.snakeGame.desplazamiento();
                snakePanel.repaint();
                snakePanel.snakeGame.comer();

                if (snakePanel.snakeGame.perder()) {
                    System.out.println("Game Over");
                    snakePanel.setVisible(false);
                    ventana.add(panelGameOver);
                    panelGameOver.setVisible(true);
                    panelGameOver.repaint();
                    ((Timer) e.getSource()).stop(); // Detener el temporizador si el juego ha terminado
                }
            }
        });
        timer.start();
    }



}
