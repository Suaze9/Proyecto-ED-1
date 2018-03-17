package CalculoDesempeno;

public class Empleado {
    
    private int calificacion = 0;
    private String nombre;
    
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public Empleado(int calificacion, String nombre) {
        this.calificacion = calificacion;
        this.nombre = nombre;
    }
    
    public int calculoDesempeno(Empleado... inferiores){
        int suma = 0;
        for (Empleado empleado : inferiores) {
            suma += empleado.getCalificacion();
        }
        return (suma / inferiores.length);
    }
    
    public int getCalificacion(){
        return calificacion;
    }
    
}
