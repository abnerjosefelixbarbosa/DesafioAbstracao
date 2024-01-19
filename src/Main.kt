
enum class Nivel(val nivel: Int) {
    BASICO(1),
    INTERMEDIARIO(2),
    DIFICIL(3)
}

data class Usuario(var id: Int, var nome: String, var email: String, var dataNascimento: String)

data class ConteudoEducacional(var nome: String, var duracao: Int)

data class Formacao(var nome: String,var nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    var inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {

        if (inscritos.isEmpty()) {
            inscritos.add(usuario)
        } else {
            inscritos.forEach({
                if (it.id != usuario.id && it.email != usuario.email) {
                    inscritos.add(usuario)
                } else {
                    throw Exception("Id e email existe")
                }
            })
        }

        println(inscritos.toString())
    }
}

fun main() {
    var usuario1 = Usuario(1,"name1", "email1@gmail.com", "12/01/2003")
    var usuario2 = Usuario(2,"name2", "email2@gmail.com", "10/08/2005")
    var usuario3 = Usuario(3,"name3", "email3@gmail.com", "05/11/2007")

    var conteudoEducacional1 = ConteudoEducacional("nome1", 40)
    var conteudoEducacional2 = ConteudoEducacional("nome2", 50)
    var conteudoEducacional3 = ConteudoEducacional("nome3", 60)

    var formacao1 = Formacao("name1", Nivel.BASICO, listOf(conteudoEducacional1))
    var formacao2 = Formacao("name2", Nivel.INTERMEDIARIO, listOf(conteudoEducacional1, conteudoEducacional2))
    var formacao3 = Formacao("name3", Nivel.DIFICIL, listOf(conteudoEducacional1, conteudoEducacional2, conteudoEducacional3))

    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)
}