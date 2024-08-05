package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int largo;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v) { this.valor = v; }
    }

    public ListaEnlazada() {
        this.primero = new Nodo(null);
        this.ultimo = new Nodo(null);
        this.largo = 0;
    }

    public int longitud() {
        return this.largo;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (this.largo == 0){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.primero.anterior = nuevoNodo;
            nuevoNodo.siguiente = this.primero;
            this.primero = nuevoNodo;
        }
        this.largo = this.largo + 1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if (this.largo == 0){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = this.ultimo;
            nuevoNodo.siguiente = new Nodo(null);
            this.ultimo = nuevoNodo;
        }
        this.largo = this.largo + 1;
    }

    public T obtener(int i) {
        Nodo actual = primero;
        for(int n = 0; n < i; n++){
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        int indice = 0;
        Nodo actual = primero;
        if (i == 0){
            this.primero = actual.siguiente;
        } else if (i == this.largo){
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.anterior.siguiente = null;
        } else {
            while (indice != i){
                actual = actual.siguiente;
                indice = indice + 1;
            }
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        largo = largo - 1;
    }


    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        Nodo nuevoNodo = new Nodo(elem);
        for (int n=0; n<indice; n++){
            actual = actual.siguiente;
        }
        actual.valor = nuevoNodo.valor;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<T>();
        if (this.largo == 0) {
            return copia;
        } else {
            for (int n = 0; n < this.largo ; n++){
                copia.agregarAtras(this.obtener(n));
            }
            return copia;
        }
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        for (int n = 0; n < lista.largo ; n++){
            this.agregarAtras(lista.obtener(n));
        }
    }
    
    
    @Override
    public String toString() {
        String lista = "[";
        for (int n = 0; n < this.largo - 1; n++){
            lista = lista + this.obtener(n) + ", ";
        };
        return lista + this.ultimo.valor + "]";
    }

    private class ListaIterador implements Iterador<T> {
        int dedito;
        ListaEnlazada<T> nuevo;
        public ListaIterador(ListaEnlazada<T> lista){
            dedito = 0;
            nuevo = lista;
        }

        public boolean haySiguiente() {
            return dedito != nuevo.largo;
        }
        
        public boolean hayAnterior() {
            return dedito != 0; 
        }

        public T siguiente() {
            dedito ++;
            return nuevo.obtener(dedito - 1);
        }
        
        public T anterior() {
            dedito --;
            return nuevo.obtener(dedito);
        }
    }
    public Iterador<T> iterador() {
        return new ListaIterador(this);
    }
}
