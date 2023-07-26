/*
Nelson García Bravatti 22434
Programación en plataformas móbiles
Laboratorio #2
 */

class PerfilUsuario (

    var ID: Int,
    var Nombres: String,
    var Apellidos: String,
    var UrlPhoto: String?,
    var Edad: Int,
    var Correo: String,
    var Biografia: String?,
    var Estado: String ,  //Activo Pendiente o Inactivo
    var Hobbies: MutableList<Hobby>? = mutableListOf()){
    fun  AgregarHobby(hobby: Hobby) {
        Hobbies?.add(hobby)
    }
}