package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return String.valueOf(hora) + ":" + String.valueOf(minutos);
    }

    @Override
    public boolean equals(Object otro) {
        if (this.getClass() != otro.getClass() || otro == null) {
            return false;
        } else {
            Horario otroHorario = (Horario) otro;
            return otroHorario.hora == this.hora && otroHorario.minutos == this.minutos;
        }
    }

}
