package cat.urv.deim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import cat.urv.deim.exceptions.PilaPlena;

public class Main {
    TADPila persones;

    public Main() {}

    private void carregarDades(String filename) {
    try {
        BufferedReader f = new BufferedReader(new FileReader("persones.csv"));
            String linea;
            linea = f.readLine();
            while(linea != null)
            {
                StringTokenizer coma = new StringTokenizer(linea,",");
                int id_persona = Integer.parseInt(coma.nextToken());
                int edat = Integer.parseInt(coma.nextToken());
                String nom = coma.nextToken();
                String cognom = coma.nextToken();
                int pes = Integer.parseInt(coma.nextToken());
                int alsada = Integer.parseInt(coma.nextToken());
                Persona p = new Persona(id_persona, edat, nom, cognom, alsada, pes);

                persones.apilar(p);

                linea = f.readLine();
            }
            f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch (IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
        catch (PilaPlena e) {
            System.out.println("La pila està plena, no s'ha pogut apilar");
        }

    }

    // Metode per carregar les dades en una pila estatica
    public TADPila carregarFitxerEstatica(String filename, int maxElem) {
        persones = new PilaEstatica(maxElem);
        carregarDades(filename);
        return persones;
    }

    // Metode per carregar les dades en una pila dinamica
    public TADPila carregarFitxerDinamica(String filename, int maxElem) {
        persones = new PilaDinamica(maxElem);
        carregarDades(filename);
        return persones;
    }

    // Metode per carregar les dades en una pila java.util.stack
    public TADPila carregarFitxerStack(String filename, int maxElem) {
        persones = new PilaStack(maxElem);
        carregarDades(filename);
        return persones;
    }

    public static void main(String[] args) {
        System.out.println("No cal que executis aixo, mira els tests!");
    }
}
