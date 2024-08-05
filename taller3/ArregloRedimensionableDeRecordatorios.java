package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] arreglo;
    private int largo;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
        this.largo = 0;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.largo = vector.largo;
        this.arreglo = new Recordatorio[vector.largo];
        for(int n=0; n < vector.largo; n++) {
            this.arreglo[n] = vector.obtener(n);
        }
        this.largo = vector.longitud();
    }

    public int longitud() {
        return largo;
    }

    public void agregarAtras(Recordatorio i) {
        this.largo = this.largo + 1;
        Recordatorio[] nuevoArreglo = new Recordatorio[this.largo];
        for(int n=0; n < this.largo - 1; n++) {
            nuevoArreglo[n] = this.arreglo[n];
        }
        nuevoArreglo[this.largo - 1] = i;
        this.arreglo = nuevoArreglo;

    }

    public Recordatorio obtener(int i) {
        return this.arreglo[i];
    }

    public void quitarAtras() {
        this.largo = this.largo - 1;
        Recordatorio[] nuevoArreglo = new Recordatorio[this.largo];
        for(int n=0; n < this.largo; n++) {
            nuevoArreglo[n] = this.arreglo[n];
        }
        this.arreglo = nuevoArreglo;

    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios arreglo2 = new ArregloRedimensionableDeRecordatorios();
        for(int n=0; n < this.largo; n++) {
            arreglo2.agregarAtras(this.arreglo[n]);;
        }
        return arreglo2;
    }

}
