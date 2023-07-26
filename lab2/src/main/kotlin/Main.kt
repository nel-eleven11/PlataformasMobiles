/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #2
 */

fun main(args: Array<String>) {

    var Usuarios: MutableList<PerfilUsuario> = mutableListOf()

    println("Bienvenido a la aplicación de administración de perfiles de usuario")
    var Opcion: Int = 1

    while(Opcion > 0 && Opcion <= 5){
        println("Seleccione una opción:")
        println("1. Crear prefil \n 2. Buscar perfil \n 3. Eliminar perfil \n 4. Agregar hobby \n 5. Salir")
        Opcion = readln().toInt()
        when(Opcion){
            1 -> {
                println("Ingrese el nombre del usuario")
                var Nombre: String = readln()
                println("Ingrese el apellido del usuario")
                var Apellido: String = readln()
                println("Ingrese la edad del usuario")
                var Edad: Int = readln().toInt()
                println("Ingrese el correo del usuario")
                var Correo: String = readln()
                println("Ingrese la biografía del usuario")
                var Biografia: String = readln()
                println("Ingrese el estado del usuario \n 1. Activo\n 2. Pendiente \n 3. Inactivo")
                var Estado: String = ""
                while(true){
                    when(readln()){
                        "1" -> {
                            Estado = "Activo"
                            break
                        }
                        "2" -> {
                            Estado = "Pendiente"
                            break
                        }
                        "3" -> {
                            Estado = "Inactivo"
                            break
                        }
                        else -> {
                            println("Opción no válida")
                        }
                    }
                }
                println("Ingrese el ID del usuario")
                var ID: Int = readln().toInt()
                println("Ingrese la URL de la foto del usuario")
                var UrlPhoto: String = readln()
                var NuevoUsuario: PerfilUsuario = PerfilUsuario(ID, Nombre, Apellido, UrlPhoto, Edad, Correo, Biografia, Estado)
                Usuarios.add(NuevoUsuario)
            }
            2 -> {
                println("Ingrese el ID del usuario")
                var ID: Int = readln().toInt()
                var UsuarioEncontrado: PerfilUsuario? = null
                for (usuario in Usuarios){
                    if (usuario.ID == ID){
                        UsuarioEncontrado = usuario
                    }
                }
                if (UsuarioEncontrado != null){
                    println("Usuario encontrado")
                    println("Nombre: ${UsuarioEncontrado.Nombres}")
                    println("Apellido: ${UsuarioEncontrado.Apellidos}")
                    println("Edad: ${UsuarioEncontrado.Edad}")
                    println("Correo: ${UsuarioEncontrado.Correo}")
                    println("Biografía: ${UsuarioEncontrado.Biografia}")
                    println("Estado: ${UsuarioEncontrado.Estado}")
                    println("Hobbies: ")
                    for (hobby in UsuarioEncontrado.Hobbies!!){
                        println("Titulo: ${hobby.titulo}")
                        println("Descripción: ${hobby.descripcion}")
                        println("URL de la foto: ${hobby.UrlPhoto}")
                    }
                }else{
                    println("Usuario no encontrado")
                }
            }
            3 -> {
                println("Ingrese el ID del usuario")
                var ID: Int = readln().toInt()
                var UsuarioEncontrado: PerfilUsuario? = null
                for (usuario in Usuarios){
                    if (usuario.ID == ID){
                        UsuarioEncontrado = usuario
                    }
                }
                if (UsuarioEncontrado != null){
                    Usuarios.remove(UsuarioEncontrado)
                    println("Usuario eliminado")
                }else{
                    println("Usuario no encontrado")
                }
            }
            4 -> {
                println("Ingrese el ID del usuario")
                var ID: Int = readln().toInt()
                var UsuarioEncontrado: PerfilUsuario? = null
                for (usuario in Usuarios){
                    if (usuario.ID == ID){
                        UsuarioEncontrado = usuario
                    }
                }
                if (UsuarioEncontrado != null){
                    println("Ingrese el titulo del hobby")
                    var Titulo: String = readln()
                    println("Ingrese la descripción del hobby")
                    var Descripcion: String = readln()
                    println("Ingrese la URL de la foto del hobby")
                    var UrlPhoto: String = readln()
                    var NuevoHobby: Hobby = Hobby(Titulo, Descripcion, UrlPhoto)
                    UsuarioEncontrado.AgregarHobby(NuevoHobby)
                }else{
                    println("Usuario no encontrado")
                }
            }
            5 -> {
                println("Gracias por usar la aplicación")
                Opcion = 0
            }
            else -> {
                println("Opción no válida")
            }
        }
    }
}