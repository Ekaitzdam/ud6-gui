package TresEnRaya;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero {
    private JPanel Tablero;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JLabel jugador;
    private JLabel turnoo;
    private JLabel turnoTexto;
    private JPanel jugadorTexto;

    private int fila=0;
    private int columna=0;

    // Tablero
    private int[][] tablero = new int[3][3];

    // ¿A quien le toca?
    private int turno = 0;

    private int tiradas;


    public Tablero() {

        limpiarTablero();

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            boton(boton1, 0, 0);

            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            boton(boton2, 0, 1);

            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton3, 0, 2);

            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton4, 1, 0);

            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton5, 1, 1);

            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton6, 1, 2);

            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton7, 2, 0);

            }
        });
        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton8, 2, 1);

            }
        });
        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton(boton9, 2, 2);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablero");
        frame.setContentPane(new Tablero().Tablero);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);





    }

    private void limpiarTablero(){
        //limpiar texto
        boton1.setText("");
        boton2.setText("");
        boton3.setText("");
        boton4.setText("");
        boton5.setText("");
        boton6.setText("");
        boton7.setText("");
        boton8.setText("");
        boton9.setText("");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 3;
            }
        }
    }

    private void boton(JButton boton, int fila, int columna){

        // Comprobar si el hueco está libre
        if (tablero[fila][columna] == 3) {
            // Libre

            tablero[fila][columna] = turno;

            if(turno == 0){
                boton.setText("O");
            } else {
                boton.setText("X");
            }


            if (hayGanador(tablero, turno)) {
                JOptionPane.showMessageDialog(Tablero, "Enhorabuena");
            } else {
                if (turno == 1)
                    turno = 0;
                else
                    turno = 1;
            }

            tiradas += 1;

            if(tiradas == 9){
                JOptionPane.showMessageDialog(Tablero,"Empate!!");
                limpiarTablero();
            }
        } else {
            // Ocupado
            JOptionPane.showMessageDialog(Tablero,"Casilla ocupada, prueba otra vez...");
        }



    }







    private boolean hayGanador(int[][] t, int turno) {

        boolean hayGanador = false;

        // Filas
        if (t[0][0] == turno && t[0][1] == turno && t[0][2] == turno) {
            hayGanador = true;
        }
        if (t[1][0] == turno && t[1][1] == turno && t[1][2] == turno) {
            hayGanador = true;
        }
        if (t[2][0] == turno && t[2][1] == turno && t[2][2] == turno) {
            hayGanador = true;
        }

        // Columnas
        if (t[0][0] == turno && t[1][0] == turno && t[2][0] == turno) {
            hayGanador = true;
        }
        if (t[0][1] == turno && t[1][1] == turno && t[2][1] == turno) {
            hayGanador = true;
        }
        if (t[0][2] == turno && t[1][2] == turno && t[2][2] == turno) {
            hayGanador = true;
        }

        // Diagonales
        if (t[0][0] == turno && t[1][1] == turno && t[2][2] == turno) {
            hayGanador = true;
        }
        if (t[0][2] == turno && t[1][1] == turno && t[2][0] == turno) {
            hayGanador = true;
        }

        return hayGanador;
    }
}


