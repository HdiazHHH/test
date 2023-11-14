package Reglas;

public class Pelicula {

    private int idpel;
    private String titulo;
    private int votos;
    private double calificacion;

    public Pelicula(int idpel, String titulo, int votos, double calificacion) {
        this.idpel = idpel;
        this.titulo = titulo;
        this.votos = votos;
        this.calificacion = calificacion;
    }

    public int getIdpel() {
        return idpel;
    }

    public void setIdpel(int idpel) {
        this.idpel = idpel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idpel=" + idpel +
                ", titulo='" + titulo + '\'' +
                ", votos=" + votos +
                ", calificacion=" + calificacion +
                '}';
    }

    public String gettitulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
