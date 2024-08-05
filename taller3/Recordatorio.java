package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha fecha2 = new Fecha(this.fecha);
        return fecha2;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (this.getClass() != otro.getClass()) {
            return false;
        } else {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            return (otroRecordatorio.mensaje == this.mensaje && 
            otroRecordatorio.horario.equals(this.horario) && 
            otroRecordatorio.fecha.equals(this.fecha));
        }
    
    }

}
