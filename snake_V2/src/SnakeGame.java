import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class SnakeGame extends JComponent {
    ArrayList<Point> cola = new ArrayList<>();
    Movimientos eventoMovimiento = new Movimientos();
    Comida comida = new Comida();
    Direccion direccionActual;
    boolean colisionConCola = false;
    int puntaje;
    final int ANCHO_SNAKE = 15;
    final int ALTO_SNAKE = 15;
    final int ANCHO_PANEL = 500;
    final int ALTO_PANEL = 500;

    public SnakeGame(){
        puntaje = 0;

        cola.addFirst(new Point(ANCHO_PANEL/2,ALTO_PANEL/2));

        addKeyListener(eventoMovimiento);
        setFocusable(true);
        requestFocus();

    }


    public void desplazamiento(){

        direccionActual = eventoMovimiento.direccion;
        Point posicionCabeza = new Point(cola.getFirst());


        // Guarda la nueva posicion de la cabeza
        switch (direccionActual) {
            case LEFT:
                posicionCabeza.x -= ANCHO_SNAKE;
                break;
            case RIGHT:
                posicionCabeza.x += ANCHO_SNAKE;
                break;
            case UP:
                posicionCabeza.y -= ALTO_SNAKE;
                break;
            case DOWN:
                posicionCabeza.y += ALTO_SNAKE;
                break;
            case STOP:
                return;


        }

        if(cola.contains(posicionCabeza)){
            System.out.println("colision");
            mostrarCola();
            colisionConCola = true;
            perder();
        }



        // Desplaza cada elemento de la cola uno para atras
        // Lo que hace que la posicion que este mas atras se borre
        // y quede como que todos avanzaron 1
        // Tambien guarda las nuevas posiciones en el Set
        for (int i = cola.size() - 1; i > 0; i--) {
            cola.set(i, cola.get(i - 1));
        }
        cola.set(0, posicionCabeza);


    }

    public boolean perder(){
        // Chequea que la cabeza no toque los bordes de la ventana
        return cola.getFirst().x >= ANCHO_PANEL || cola.getFirst().y >= ALTO_PANEL || cola.getFirst().x <= 0 || cola.getFirst().y <= 0 || colisionConCola;
    }

    public void comer(){
        // Ve si la cabeza pasa sobre la comida, le puse tolerancia porque sino hay veces que pasa justo por encima y no lo toma
        if(aproximadamenteIgual(comida.coordenadas.x, cola.getFirst().x,10) && aproximadamenteIgual(comida.coordenadas.y, cola.getFirst().y,10)){
            System.out.println("toque comida");
            puntaje+=10;
            agrandarCola();
            comida.reubicarComida();
        }
    }
    public boolean aproximadamenteIgual(double valor1, double valor2, double tolerancia) {
        return Math.abs(valor1 - valor2) < tolerancia;
    }
    public void agrandarCola(){
        Point ultimaPosicion = cola.getLast();
        direccionActual = eventoMovimiento.direccion;

        switch (direccionActual){
            case UP:
                cola.add(new Point(ultimaPosicion.x, ultimaPosicion.y + ALTO_SNAKE));
                System.out.println("Agrando cola");
                break;
            case DOWN:
                System.out.println("Agrando cola");
                cola.add(new Point(ultimaPosicion.x, ultimaPosicion.y - ALTO_SNAKE));
                break;
            case RIGHT:
                System.out.println("Agrando cola");
                cola.add(new Point(ultimaPosicion.x + ANCHO_SNAKE, ultimaPosicion.y));
                break;
            case LEFT:
                System.out.println("Agrando cola");
                cola.add(new Point(ultimaPosicion.x - ANCHO_SNAKE, ultimaPosicion.y));
                break;
        }


    }

    public void mostrarCola(){
        for(int i = 0; i < cola.size(); i++){
            System.out.println("X: " +  cola.get(i).x + " Y: " + cola.get(i).y);
        }
    }
}
