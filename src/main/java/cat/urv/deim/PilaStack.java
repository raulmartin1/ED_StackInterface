package cat.urv.deim;

import java.util.Stack;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.PilaBuida;
import cat.urv.deim.exceptions.PilaPlena;

public class PilaStack implements TADPila {
private Stack<Persona> pila;
private int maxElem;

public PilaStack(int dim) {
    pila=new Stack<>();
    maxElem=dim;
}

   public void apilar(Persona p) throws PilaPlena {
    if(esPlena()) throw new PilaPlena();
    pila.push(p);
   }

   public void desapilar() throws PilaBuida {
    if(esBuida()) throw new PilaBuida();
    pila.pop();
   }

   public Persona cim() throws PilaBuida {
    if (esBuida()) throw new PilaBuida();
    return pila.peek();
   }

   public int numElem() {
    return pila.size();
   }

   public boolean esBuida() {
    return pila.isEmpty();
   }

   public boolean esPlena() {
    return (pila.size()>=maxElem);
   }

   public Persona anterior(Persona p) throws ElementNoTrobat {
    int i= pila.search(p);
       if(i==-1) throw new ElementNoTrobat();
        else if(i==1) return null;
        else
        {
            int pos= pila.size() - i;
            return pila.elementAt(pos-1);
        }

    }

    public Persona seguent(Persona p) throws ElementNoTrobat {
    int i= pila.search(p);
       if(i==-1) throw new ElementNoTrobat();
        else if(i==pila.size()) return null;
        else
        {
            int pos= pila.size() - i;
            return pila.elementAt(pos+1);
        }

    }
}

