// Controla el movimiento del snake eventos

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movimientos implements KeyListener {

    Direccion direccion = Direccion.STOP;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                if(direccion != Direccion.DOWN)
                    direccion = Direccion.UP;

                break;
            case KeyEvent.VK_A:
                if(direccion != Direccion.RIGHT)
                    direccion = Direccion.LEFT;
                break;
            case KeyEvent.VK_S:
                if(direccion != Direccion.UP)
                    direccion = Direccion.DOWN;
                break;
            case KeyEvent.VK_D:
                if(direccion != Direccion.LEFT)
                    direccion = Direccion.RIGHT;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_P:
                direccion = Direccion.STOP;



        }
    }


    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
