package aed;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

    private class Nodo {
        public Nodo padre;
        public Nodo izq;
        public Nodo der;
        public T valor;

        public Nodo (T data) {
            this.valor = data;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }

    public Nodo raiz;
    private int cardinal;

    public ABB() {
        this.raiz = null;
        this.cardinal = 0;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimoRecursivo(Nodo actual) {
        if (actual.izq == null){
            return actual.valor;
        }
        return minimoRecursivo(actual.izq);
    }

    public T minimo() {
        if (this.raiz == null) {
            return null;
        }
        Nodo aux = this.raiz;
        return minimoRecursivo(aux);
    }

    public T maximoRecursivo(Nodo actual) {
        if (actual.der == null){
            return actual.valor;
        }
        return maximoRecursivo(actual.der);
    }

    public T maximo(){
        if (this.raiz == null) {
            return null;
        }
        Nodo aux = this.raiz;
        return maximoRecursivo(aux);
    }

    public void insertar(T elem){
        Nodo actual = this.raiz;
        if (raiz == null) {
            this.raiz = new Nodo(elem);
            this.cardinal++;
        } else {
            while (true) {
                if (actual.valor.compareTo(elem) == 0) {
                    break;
                } else if (actual.valor.compareTo(elem) > 0) {
                    if (actual.izq == null) {
                        actual.izq = new Nodo(elem);
                        actual.izq.padre = actual;
                        this.cardinal++;
                        break;
                    } else {
                        actual = actual.izq;
                    }
                } else if (actual.valor.compareTo(elem) < 0) {
                    if (actual.der == null) {
                        actual.der = new Nodo(elem);
                        actual.der.padre = actual;
                        this.cardinal++;
                        break;
                    } else {
                        actual = actual.der;
                    }
                }
            }
        }
    }

    public Nodo dondeEsta(T elem){
        Nodo actual = this.raiz; 
        if (this.raiz == null){
            return null;
        } else {
            while (actual != null) {
                if (actual.valor.compareTo(elem) == 0) {
                    return actual;
                } else if (actual.valor.compareTo(elem) > 0) {
                        actual = actual.izq;
                } else if (actual.valor.compareTo(elem) < 0) {
                        actual = actual.der;
                }
            }
            return null;
        }
    }

    public boolean pertenece(T elem){
        return dondeEsta(elem) != null;
    }


    private void intercambiar(Nodo n1, Nodo n2) {
        if (n1.padre == null) {
            this.raiz = n2;
        } else if (n1 == n1.padre.izq) {
            n1.padre.izq = n2;
        } else {
            n1.padre.der = n2;
        }
    
        if (n2 != null) {
            n2.padre = n1.padre;
        }
    }


    public void eliminar(T elem){
        Nodo actual = dondeEsta(elem);
        if (this.pertenece(elem)){
            if (actual.der == null){
                intercambiar(actual, actual.izq);;
            } else if (actual.izq == null) {
                intercambiar(actual, actual.der);;
            } else {
                Nodo sucesor = dondeEsta(minimoRecursivo(actual.der));
                if (sucesor.padre != actual) {
                    intercambiar(sucesor, sucesor.der);
                    sucesor.der = actual.der;
                    sucesor.der.padre = sucesor;
                }
                intercambiar(actual, sucesor);
                sucesor.izq = actual.izq;
                sucesor.izq.padre = sucesor;
            }
        }
            cardinal--;
    }

    

    public String toString(){
        Iterador iterador = iterador();
        String res = "{";
        while (iterador.haySiguiente()) {
            res = res + iterador.siguiente() + ",";
        }
        res = res + iterador.siguiente() + "}";
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        public T actual = minimo();
        public int indice = 0;

        public boolean haySiguiente() {            
            List<T> lista = armarLista(raiz);
            if (indice == lista.size() - 1) {
                return false;
            } else {
                return true;
            }
        }
    
        public T siguiente() {
            List<T> lista = armarLista(raiz);
            T res = null;
            if (haySiguiente()) {
                res = actual;
                actual = lista.get(indice + 1);
                indice++;
            } else {
                res = actual;
            }
            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

    void inorder(Nodo raiz, List<T> lista){
        if (raiz != null){
            inorder(raiz.izq, lista);
            lista.add(raiz.valor);
            inorder(raiz.der, lista);
        }
    }

    public List<T> armarLista(Nodo raiz) {
        List<T> res = new ArrayList<T>();
        this.inorder(raiz, res);
        return res;
    }
}
