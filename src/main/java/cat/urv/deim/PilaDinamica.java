package cat.urv.deim;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.PilaBuida;
import cat.urv.deim.exceptions.PilaPlena;

public class PilaDinamica implements TADPila {
    private Node recent;
    private int numElem, maxElem;

    public PilaDinamica(int dim) {
        maxElem=dim;
        this.recent=null;
        this.numElem=0;
    }

    public class Node {
        Persona persona;
        Node seguent;

    public Node(Persona persona) {
        this.persona = persona;
        this.seguent=null;
    }
    }

    public void apilar(Persona p) throws PilaPlena {
        Node nouNode = new Node(p);
        if(esPlena()) throw new PilaPlena();
        nouNode.seguent = recent;
        recent= nouNode;
        numElem++;
    }

	public void desapilar() throws PilaBuida {
        if(esBuida()) throw new PilaBuida();
        recent =recent.seguent;
        numElem--;
    }

	public Persona cim() throws PilaBuida {
        if(esBuida()) throw new PilaBuida();
        return recent.persona;
    }

	public int numElem() {
        return numElem;
    }

    public boolean esBuida() {
        return numElem==0;
    }

	public boolean esPlena() {
        return numElem==maxElem;
    }

     public Persona anterior(Persona p) throws ElementNoTrobat {
        Node actual= recent;
        Node seguent = null;
        boolean trobat= false;
        if(actual==null) throw new ElementNoTrobat();
        seguent=actual.seguent;
        if(seguent==null) return null;
        while(seguent!= null && !trobat) {
            if((actual.persona).equals(p)) {
                trobat=true;
            }
            else {
                seguent = seguent.seguent;
                actual = actual.seguent;
            }
        }
        if(!trobat) throw new ElementNoTrobat();
        return seguent.persona;
     }

     public Persona seguent(Persona p) throws ElementNoTrobat {
        Node actual = recent;
        Node anterior= null;
        boolean trobat=false;

        if(actual.seguent==null) return null;

        while (actual !=null && !trobat) {
            if(actual.persona.equals(p)) {
                trobat=true;
            }
            else{
                anterior=actual;
                actual =actual.seguent;
            }
        }

        if(!trobat) throw new ElementNoTrobat();
        return anterior.persona;
    }


}
