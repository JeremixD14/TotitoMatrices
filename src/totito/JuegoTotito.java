package totito;

import java.awt.Color;
import javax.swing.JOptionPane;

public class JuegoTotito {

    int turno;

    public JuegoTotito(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void intercambiar() {
        if (getTurno() == 0) {
            setTurno(1);
        } else {
            setTurno(0);
        }
    }

    // las posibilidades de ganar
    public int juego(int matriz[][]) {
        // posibilidades en horizontal
        if (matriz[0][0] == matriz[0][1]
                && matriz[0][0] == matriz[0][2]) {
            return 1;
        }
        if (matriz[1][0] == matriz[1][1]
                && matriz[1][0] == matriz[1][2]) {
            return 2;
        }
        if (matriz[2][0] == matriz[2][1]
                && matriz[2][0] == matriz[2][2]) {
            return 3;
        }

        // posibilidades en vertical
        if (matriz[0][0] == matriz[1][0]
                && matriz[0][0] == matriz[2][0]) {
            return 4;
        }
        if (matriz[0][1] == matriz[1][1]
                && matriz[0][1] == matriz[2][1]) {
            return 5;
        }
        if (matriz[0][2] == matriz[1][2]
                && matriz[0][2] == matriz[2][2]) {
            return 6;
        }

        // posibilidades en diagonal
        if (matriz[0][0] == matriz[1][1]
                && matriz[0][0] == matriz[2][2]) {
            return 7;
        }
        if (matriz[2][0] == matriz[1][1]
                && matriz[2][0] == matriz[0][2]) {
            return 8;
        }
        return 0;
    }

    public int ejecutar(javax.swing.JButton btnMatriz, int i, int j, int matriz[][]) {
        matriz[i][j] = getTurno();
        String jugador = new String();

        if (getTurno() == 0) {
            jugador = "X";
            btnMatriz.setForeground(Color.red);
        } else {
            jugador = "O";
            btnMatriz.setForeground(Color.blue);
        }

        intercambiar();
        btnMatriz.setText(jugador);
        btnMatriz.setEnabled(false);

        if (juego(matriz) != 0) {
            JOptionPane.showMessageDialog(null, "Gano el jugador: " + jugador);
            if (getTurno() == 1) {
            }
            if (getTurno() == 0) {
            }
            return 1;
        }

        return 0;
    }

}
