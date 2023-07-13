/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #1
 */


var result: String? = ""
var result1: String = ""

class ItemData (val originalValue: Any?){

    fun getType (): String? {
        if(originalValue is String) {
            result = "cadena"
        }
        else if(originalValue is Int) {
            result = "entero"
        }
        else if(originalValue is Boolean) {
            result = "booleano"
        }
        else{  result = null
        }
        return result
    }

    fun getInfo (): String? {
        return when(result){
            "cadena" ->  "L${originalValue.toString().length}"
            "entero" ->{
                if (originalValue.toString().toInt().mod(10) == 0) {
                    "M10"
                }else if(originalValue.toString().toInt().mod(5) == 0) {
                    "M5"
                }else if(originalValue.toString().toInt().mod(2) == 0) {
                    "M2"
                }else{null}
            }
            "booleano" ->{
                if (originalValue.toString().equals("true")){
                    "Verdadero" }else {"Falso"}
            }
            else -> null
        }
    }
}

