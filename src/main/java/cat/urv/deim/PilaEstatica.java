package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.PilaBuida;
import cat.urv.deim.exceptions.PilaPlena;

public class PilaEstatica implements TADPila {
private Persona[] pila;
private int numElem, maxElem;

public PilaEstatica(int dim){
    pila = new Persona[dim];
    numElem=0;
    maxElem= dim;
}

public void apilar(Persona p) throws PilaPlena{
    if(esPlena()) throw new PilaPlena();
    pila[numElem]=p;
    numElem++;
}

public void desapilar() throws PilaBuida{
    if(esBuida()) throw new PilaBuida();
    numElem--;
}

public Persona cim() throws PilaBuida{
    if(esBuida()) throw new PilaBuida();
    return pila[numElem-1];
}

public int numElem() {
    return numElem;
}

public boolean esBuida() {
    if(numElem==0) return true;
    else return false;
}

public boolean esPlena() {
    if(numElem==maxElem) return true;
    else return false;
}

public Persona anterior(Persona p) throws ElementNoTrobat {
    int i=0;
    while (i<numElem && !pila[i].equals(p)){
        i++;
    }
    if(i==numElem) throw new ElementNoTrobat();
    else if(i==0) return null;
    else return pila[i-1];
}

public Persona seguent(Persona p) throws ElementNoTrobat{
    int i=0;
    while (i<numElem && !pila[i].equals(p)) {
        i++;
    }
    if(i==numElem) throw new ElementNoTrobat();
    else if(i==maxElem) return null;
    else return pila[i+1];
 }

}
