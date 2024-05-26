package Ac2;

public class Jugador {
    private static int idCounter = 0;
    private int id;
    private String nombre;
    private String posicion;
    private int edad;

    public Jugador(String nombre, String posicion, int edad) {
        this.id = ++idCounter;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                '}';
    }
}