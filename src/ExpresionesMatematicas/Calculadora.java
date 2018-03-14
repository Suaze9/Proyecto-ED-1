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
        problema = Multiplicacion(problema);
        problema = Division(problema);
        problema = Suma(problema);
        problema = Resta(problema);
        return problema;
    }
    
    private String Multiplicacion(String problema){
        ArrayQueue queueMult = QueueMultiplicacion(problema);
        String salida = "";
        while (!queueMult.isEmpty()) {
            String temp = (String)queueMult.deQueue();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '*') {
                    String[] mult = temp.split("\\*");
                    while(mult.length != 1) {
                        double factorA = Double.parseDouble(mult[0]);
                        double factorB = Double.parseDouble(mult[1]);
                        double producto = factorA * factorB;
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
    
    private ArrayQueue QueueMultiplicacion(String problema){
        ArrayQueue queueMult = new ArrayQueue();
        int floor = -1;
        String tempStr = "";
        for (int i = 0; i < problema.length(); i++) {
            if ((problema.charAt(i) <= 57 && problema.charAt(i) >= 48) || problema.charAt(i) == '.') {
                tempStr+=problema.charAt(i);
                if (i == problema.length()-1) {
                    queueMult.queue(tempStr);
                }
            }else if(problema.charAt(i) == '/' || problema.charAt(i) == '+' || problema.charAt(i) == '-' || problema.charAt(i) == '(' || problema.charAt(i) == ')' ){
                tempStr+=problema.charAt(i);
                queueMult.queue(tempStr);
                tempStr="";
            }else{
                int j;
                for (j = i; j < problema.length(); j++) {
                    if ((problema.charAt(j) <= 57 && problema.charAt(j) >= 48) || problema.charAt(j) == '.' || problema.charAt(j) == '*') {
                        tempStr+=problema.charAt(j);
                    }else if(problema.charAt(j) == '/' || problema.charAt(j) == '+' || problema.charAt(j) == '-' || problema.charAt(j) == '(' || problema.charAt(j) == ')' ){
                        break;
                    }
                }
                queueMult.queue(tempStr);
                tempStr="";
                i=j-1;
            }
        }
        return queueMult;
    }
    
    private String Division (String problema){
        ArrayQueue queueDiv = QueueDivision(problema);
        String salida = "";
        while (!queueDiv.isEmpty()) {
            String temp = (String)queueDiv.deQueue();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '/') {
                    String[] div = temp.split("\\/");
                    while(div.length != 1) {
                        double divisor = Double.parseDouble(div[0]);
                        double dividendo = Double.parseDouble(div[1]);
                        double cociente = divisor / dividendo;
                        String[] tempMult = new String[div.length-1];
                        tempMult[0] = Double.toString(cociente);
                        for (int j = 1; j < tempMult.length; j++) {
                            tempMult[j] = div[j+1];
                        }
                        div = tempMult;
                    }
                    temp = div[0];
                    break;
                }
            }
            salida += temp;
        }
        return salida;
    }
    
    private ArrayQueue QueueDivision(String problema){
        ArrayQueue queueDiv = new ArrayQueue();
        int floor = -1;
        String tempStr = "";
        for (int i = 0; i < problema.length(); i++) {
            if ((problema.charAt(i) <= 57 && problema.charAt(i) >= 48) || problema.charAt(i) == '.') {
                tempStr+=problema.charAt(i);
                if (i == problema.length()-1) {
                    queueDiv.queue(tempStr);
                }
            }else if(problema.charAt(i) == '*' || problema.charAt(i) == '+' || problema.charAt(i) == '-' || problema.charAt(i) == '(' || problema.charAt(i) == ')' ){
                tempStr+=problema.charAt(i);
                queueDiv.queue(tempStr);
                tempStr="";
            }else{
                int j;
                for (j = i; j < problema.length(); j++) {
                    if ((problema.charAt(j) <= 57 && problema.charAt(j) >= 48) || problema.charAt(j) == '.' || problema.charAt(j) == '/') {
                        tempStr+=problema.charAt(j);
                    }else if(problema.charAt(j) == '*' || problema.charAt(j) == '+' || problema.charAt(j) == '-' || problema.charAt(j) == '(' || problema.charAt(j) == ')' ){
                        break;
                    }
                }
                queueDiv.queue(tempStr);
                tempStr="";
                i=j-1;
            }
        }
        return queueDiv;
    }
    
    private String Resta(String problema){
        ArrayQueue queueResta = QueueResta(problema);
        String salida = "";
        while (!queueResta.isEmpty()) {
            String temp = (String)queueResta.deQueue();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '-') {
                    String[] resta = temp.split("\\-");
                    while(resta.length != 1) {
                        double numeroA = Double.parseDouble(resta[0]);
                        double numeroB = Double.parseDouble(resta[1]);
                        double resultado = numeroA - numeroB;
                        String[] tempResta = new String[resta.length-1];
                        tempResta[0] = Double.toString(resultado);
                        for (int j = 1; j < tempResta.length; j++) {
                            tempResta[j] = resta[j+1];
                        }
                        resta = tempResta;
                    }
                    temp = resta[0];
                    break;
                }
            }
            salida += temp;
        }
        return salida;
    }
    
    private ArrayQueue QueueResta(String problema){
        ArrayQueue queueResta = new ArrayQueue();
        int floor = -1;
        String tempStr = "";
        for (int i = 0; i < problema.length(); i++) {
            if ((problema.charAt(i) <= 57 && problema.charAt(i) >= 48) || problema.charAt(i) == '.') {
                tempStr+=problema.charAt(i);
                if (i == problema.length()-1) {
                    queueResta.queue(tempStr);
                }
            }else if(problema.charAt(i) == '/' || problema.charAt(i) == '+' || problema.charAt(i) == '*' || problema.charAt(i) == '(' || problema.charAt(i) == ')' ){
                tempStr+=problema.charAt(i);
                queueResta.queue(tempStr);
                tempStr="";
            }else{
                int j;
                for (j = i; j < problema.length(); j++) {
                    if ((problema.charAt(j) <= 57 && problema.charAt(j) >= 48) || problema.charAt(j) == '.' || problema.charAt(j) == '-') {
                        tempStr+=problema.charAt(j);
                    }else if(problema.charAt(j) == '/' || problema.charAt(j) == '+' || problema.charAt(j) == '*' || problema.charAt(j) == '(' || problema.charAt(j) == ')' ){
                        break;
                    }
                }
                queueResta.queue(tempStr);
                tempStr="";
                i=j-1;
            }
        }
        return queueResta;
    }
    
    private String Suma(String problema){
        ArrayQueue queueSuma = QueueSuma(problema);
        String salida = "";
        while (!queueSuma.isEmpty()) {
            String temp = (String)queueSuma.deQueue();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '+') {
                    String[] sum = temp.split("\\+");
                    while(sum.length != 1) {
                        double numeroA = Double.parseDouble(sum[0]);
                        double numeroB = Double.parseDouble(sum[1]);
                        double resultado = numeroA + numeroB;
                        String[] tempResta = new String[sum.length-1];
                        tempResta[0] = Double.toString(resultado);
                        for (int j = 1; j < tempResta.length; j++) {
                            tempResta[j] = sum[j+1];
                        }
                        sum = tempResta;
                    }
                    temp = sum[0];
                    break;
                }
            }
            salida += temp;
        }
        return salida;
    }
    
    private ArrayQueue QueueSuma(String problema){
        ArrayQueue queueSuma = new ArrayQueue();
        int floor = -1;
        String tempStr = "";
        for (int i = 0; i < problema.length(); i++) {
            if ((problema.charAt(i) <= 57 && problema.charAt(i) >= 48) || problema.charAt(i) == '.') {
                tempStr+=problema.charAt(i);
                if (i == problema.length()-1) {
                    queueSuma.queue(tempStr);
                }
            }else if(problema.charAt(i) == '/' || problema.charAt(i) == '*' || problema.charAt(i) == '-' || problema.charAt(i) == '(' || problema.charAt(i) == ')' ){
                tempStr+=problema.charAt(i);
                queueSuma.queue(tempStr);
                tempStr="";
            }else{
                int j;
                for (j = i; j < problema.length(); j++) {
                    if ((problema.charAt(j) <= 57 && problema.charAt(j) >= 48) || problema.charAt(j) == '.' || problema.charAt(j) == '+') {
                        tempStr+=problema.charAt(j);
                    }else if(problema.charAt(j) == '/' || problema.charAt(j) == '*' || problema.charAt(j) == '-' || problema.charAt(j) == '(' || problema.charAt(j) == ')' ){
                        break;
                    }
                }
                queueSuma.queue(tempStr);
                tempStr="";
                i=j-1;
            }
        }
        return queueSuma;
    }
    
}