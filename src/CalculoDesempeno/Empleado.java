package CalculoDesempeno;

public class Empleado {
    
    private double calificacion = 0;
    private String nombre;
    
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public Empleado(int calificacion, String nombre) {
        this.calificacion = calificacion;
        this.nombre = nombre;
    }
    
    public double calculoDesempeno(Empleado... inferiores){
        double suma = 0;
        for (Empleado empleado : inferiores) {
            suma += empleado.getCalificacion();
        }
        return (suma / inferiores.length);
    }
    
    public double getCalificacion(){
        return calificacion;
    }
    
    public void setCalificacion(double newCalificacion){
        calificacion = newCalificacion;
    }
    
}
