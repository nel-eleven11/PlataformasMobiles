/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #1
 */

public class ItemDataJ{
    String respuesta;
    String respuesta2;

    Object originalValue;

    public ItemDataJ(Object objeto){
        this.originalValue = objeto;
    }

    public String getType() {

        if(originalValue instanceof String){
            respuesta = "cadena";
        }
        else if(originalValue instanceof Integer){
            respuesta = "entero";
        }
        else if(originalValue instanceof Boolean){
            respuesta = "booleano";
        }
        else{
            respuesta = null;
        }
        return respuesta;
    }

    public String getInfo() {
        if(respuesta != null){
            switch (respuesta) {
                case "cadena":
                    respuesta2 = "L" + originalValue.toString().length();
                    break;
                case "entero":
                    if((int)originalValue % 10 == 0){
                        respuesta2 = "M10";
                    }
                    else if((int)originalValue % 5 == 0){
                        respuesta2 = "M5";
                    }
                    else if((int)originalValue % 2 == 0){
                        respuesta2 = "M2";
                    }
                    else{
                        respuesta2 = null;
                    }
                    break;
                case "booleano":
                    if(originalValue.equals(true)){
                        respuesta2 = "Verdadero";
                    }else{
                        respuesta2 = "Falso";
                    }
                    break;
                default:
                    respuesta2 = null;
                    break;
            }
        }
        else{
            respuesta2 = null;
        }
        return respuesta2;
    }
}
