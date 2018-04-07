package ExpresionesMatematicas;

import proyecto.TDA.ArrayQueue;
import proyecto.TDA.ArrayStack;

public class Calculadora {
    
    private ArrayStack pila;
    
    public Calculadora(){
        
    }
    
    public String Solucion(String problema){
        return Expresion(problema);
    }
    
    private String Expresion(String problema){
        problema = Operacion(problema, '*');
        problema = Operacion(problema, '/');
        problema = Operacion(problema, '+');
        problema = Operacion(problema, '-');
        return problema;
    }
    
    private String Operacion(String problema, char operador){
        ArrayQueue queueMult = QueueOperacion(problema, operador);
        String salida = "";
        while (!queueMult.isEmpty()) {
            String temp = (String)queueMult.deQueue();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == operador) {
                    String[] mult = temp.split("\\*");
                    while(mult.length != 1) {
                        double factorA = Double.parseDouble(mult[0]);
                        double factorB = Double.parseDouble(mult[1]);
                        double producto = 0;
                        switch (operador) {
                            case '*':
                                {
                                    producto = factorA * factorB;
                                    break;
                                }
                            case '/':
                                {
                                    producto = factorA / factorB;
                                    break;
                                }
                            case '+':
                                {
                                    producto = factorA + factorB;
                                    break;
                                }
                            case '-':
                                {
                                    producto = factorA - factorB;
                                    break;
                                }
                            default:
                                break;
                        }
                        String[] tempMult = new String[mult.length-1];
                        tempMult[0] = Double.toString(producto);
                        for (int j = 1; j < tempMult.length; j++) {
                            tempMult[j] = mult[j+1];
                        }
                        mult = tempMult;
                    }
                    temp = mult[0];
                    break;
                }
            }
            salida += temp;
        }
        return salida;
    }
    
    private ArrayQueue QueueOperacion(String problema, char operador){
        ArrayQueue queueMult = new ArrayQueue();
        int floor = -1;
        String tempStr = "";
        for (int i = 0; i < problema.length(); i++) {
            if ((problema.charAt(i) <= 57 && problema.charAt(i) >= 48) || problema.charAt(i) == '.') {
                tempStr+=problema.charAt(i);
                if (i == problema.length()-1) {
                    queueMult.queue(tempStr);
                }
            }else if(problema.charAt(i) == operador){
                int j;
                for (j = i; j < problema.length(); j++) {
                    if ((problema.charAt(j) <= 57 && problema.charAt(j) >= 48) || problema.charAt(j) == '.' || problema.charAt(j) == operador) {
                        tempStr+=problema.charAt(j);
                    }else if(problema.charAt(j) == '/' || problema.charAt(j) == '+' || problema.charAt(j) == '-' || problema.charAt(j) == '*' ){
                        break;
                    }
                }
                queueMult.queue(tempStr);
                tempStr="";
                i=j-1;
            }else if(problema.charAt(i) == '/' || problema.charAt(i) == '+' || problema.charAt(i) == '-' || problema.charAt(i) == '*'){
                tempStr+=problema.charAt(i);
                queueMult.queue(tempStr);
                tempStr="";
            }
        }
        return queueMult;
    }
    
}