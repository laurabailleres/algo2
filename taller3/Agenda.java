package aed;

public class Agenda {
    private ArregloRedimensionableDeRecordatorios recordatorios;
    private Fecha fecha;
    

    public Agenda(Fecha fechaActual) {
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
        this.fecha = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    public String toString() {
        String str = new String(fechaActual() + "\n=====\n" );
        for(int n=0; n < this.recordatorios.longitud(); n++) {
            if(fechaActual().equals(this.recordatorios.obtener(n).fecha())){
                str += this.recordatorios.obtener(n).toString() + "\n";
            }
        }
        return str;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha fechaDevolver = new Fecha(this.fecha);
        return fechaDevolver;
    }

}
