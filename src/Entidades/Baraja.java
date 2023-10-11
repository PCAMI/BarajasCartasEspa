/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene
 * un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas,
 * bastos, oros y copas). Esta clase debe contener un método toString() que
 * retorne el número de carta y el palo. La baraja estará compuesta por un
 * conjunto de cartas, 40 exactamente. Las operaciones que podrá realizar la
 * baraja son: • barajar(): cambia de posición todas las cartas aleatoriamente.
 * • siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando
 * no haya más o se haya llegado al final, se indica al usuario que no hay más
 * cartas. • cartasDisponibles(): indica el número de cartas que aún se puede
 * repartir. • darCartas(): dado un número de cartas que nos pidan, le
 * devolveremos ese número de cartas. En caso de que haya menos cartas que las
 * pedidas, no devolveremos nada, pero debemos indicárselo al usuario. •
 * cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido
 * ninguna indicárselo al usuario • mostrarBaraja(): muestra todas las cartas
 * hasta el final. Es decir, si se saca una carta y luego se llama al método,
 * este no mostrara esa primera carta.
 *
 *
 * @author kamil
 */
public class Baraja {
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> monton;
    private Random random;

    public Baraja() {
        cartas = new ArrayList<Carta>();
        monton = new ArrayList<Carta>();
        random = new Random();

        String[] palos = {"espadas", "bastos", "oros", "copas"};
        for (String palo : palos) {
            for (int i = 1; i <= 12; i++) {
                if (i != 8 && i != 9) {
                    cartas.add(new Carta(i, palo));
                }
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas, random);
    }

    public Carta siguienteCarta() {
        if (cartas.isEmpty()) {
            System.out.println("No hay más cartas en la baraja");
            return null;
        }
        Carta carta = cartas.remove(0);
        monton.add(carta);
        return carta;
    }

    public int cartasDisponibles() {
        return cartas.size();
    }

    public ArrayList<Carta> darCartas(int numero) {
        if (numero > cartas.size()) {
            System.out.println("No hay suficientes cartas en la baraja");
            return null;
        }
        ArrayList<Carta> mano = new ArrayList<Carta>();
        for (int i = 0; i < numero; i++) {
            mano.add(siguienteCarta());
        }
        return mano;
    }

    public void cartasMonton() {
        if (monton.isEmpty()) {
            System.out.println("No ha salido ninguna carta aún");
        } else {
            System.out.println("Cartas en el montón:");
            for (Carta carta : monton) {
                System.out.println(carta);
            }
        }
    }

    public void mostrarBaraja() {
        System.out.println("Cartas en la baraja:");
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
}
