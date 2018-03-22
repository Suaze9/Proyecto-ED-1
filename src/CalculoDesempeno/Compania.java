package CalculoDesempeno;

import proyecto.TDA.ArrayList;
import proyecto.TDA.NodeTree;

public class Compania {
    
    private ArrayList empleados;
    
    Compania(){
        empleados = new ArrayList();
    }
    
    public void nuevoEmpleado(Empleado nuevo){
        empleados.add(new NodeTree(nuevo));
    }
    
    public boolean nuevoSubEmpleado(Empleado jefe, Empleado nuevo){
        NodeTree arbolJefe = null;
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            arbolJefe = encontrarEmpleado(jefe, (NodeTree)empleados.get(i));
            if (arbolJefe != null) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            arbolJefe.agregar(new NodeTree(nuevo));
            return true;
        }else{
            return false;
        }
    }
    
    private NodeTree encontrarEmpleado(Empleado buscar, NodeTree nodo){
        if (buscar == nodo.getData()) {
            return nodo;
        }
        if (nodo.numHijosAdjacentes() != 0) {
            NodeTree hijo = nodo.hijoMasIzq();
            for (int i = 0; i < nodo.numHijosAdjacentes(); i++) {
                NodeTree tempRes = encontrarEmpleado(buscar, hijo);
                if (tempRes != null) {
                    return tempRes;
                }else{
                    hijo = hijo.hermanoDer();
                }
            }
        }
        return null;
    }
    
    //Retorna false si la calificacion dada es menor que 0 o mayor que 100.
    //Tambien si no encontro el empleado especificado o el empleado especificado no es una hoja
    public boolean calificar(Empleado empleado, double calificacion){
        if (calificacion < 0 || calificacion > 100) {
            return false;
        }else{
            NodeTree arbolEmpleado = null;
            boolean encontrado = false;
            for (int i = 0; i < empleados.size(); i++) {
                arbolEmpleado = encontrarEmpleado(empleado, (NodeTree)empleados.get(i));
                if (arbolEmpleado != null) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                if (arbolEmpleado.numHijosAdjacentes() == 0) {
                    ((Empleado)arbolEmpleado.getData()).setCalificacion(calificacion);
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }
    
    public void calificarFinal(){
        NodeTree arbolJefe;
        for (int i = 0; i < empleados.size(); i++) {
            calificarArbol((NodeTree)empleados.get(i));
        }
    }
        
    private double calificarArbol(NodeTree nodo){
        if (nodo.numHijosAdjacentes() == 0) {
            return ((Empleado)nodo.getData()).getCalificacion();
        }else{
            double calificacion = 0;
            NodeTree hijo = nodo.hijoMasIzq();
            for (int i = 0; i < nodo.numHijosAdjacentes(); i++) {
                calificacion += calificarArbol(hijo);
                hijo = hijo.hermanoDer();
            }
            calificacion = calificacion / nodo.numHijosAdjacentes();
            ((Empleado)nodo.getData()).setCalificacion(calificacion);
            return calificacion;
        }
    }
    
}
