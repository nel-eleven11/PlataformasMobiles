/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #2
 */

class Hobbie {

    var titulo: String = ""
    var descripcion: String = ""
    var UrlPhoto: String? = ""

    fun Hobbie(titulo: String, descripcion: String, UrlPhoto: String?) {
        this.titulo = titulo
        this.descripcion = descripcion
        this.UrlPhoto = UrlPhoto
    }

}