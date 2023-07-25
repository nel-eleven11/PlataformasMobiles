/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #2
 */


class PerfilUsuario {

    var ID: Int = 0
    var Nombres: String = ""
    var Apellidos: String = ""
    var UrlPhoto: String? = ""
    var Edad: Int = 0
    var Correo: String = ""
    var Biografia: String? = ""
    var Estado: String = ""
    var Hobbies: MutableList<Hobbie>? = mutableListOf()


    fun PerfilUsuario(ID: Int, Nombres: String, Apellidos: String, UrlPhoto: String?, Edad: Int, Correo: String, Biografia: String, Estado: String, Hobbies: MutableList<Hobbie>?) {
        this.ID = ID
        this.Nombres = Nombres
        this.Apellidos = Apellidos
        this.UrlPhoto = UrlPhoto
        this.Edad = Edad
        this.Correo = Correo
        this.Biografia = Biografia
        this.Estado = Estado
        this.Hobbies = Hobbies
    }

    fun  AgregarHobby(hobbie: Hobbie) {
        this.Hobbies?.add(hobbie)
    }

}