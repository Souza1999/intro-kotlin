package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 7) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 9
        when (opcao) {
            1 -> {
                val cachorro = Cachorro(10, Color.preto)
                cachorro.nome = "Rex"
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                val gato = Gato(5, Color.vermelho)
                gato.nome = "Felix"
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                val passaro = Passaro(2, Color.amarelo)
                passaro.nome = "Piu"
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                repositorioAnimal.listar()
            }
            5 -> {
                //repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            6 -> {
                //repositorioAnimal.animais.forEach(Animal::exibirCor)
                repositorioAnimal.animais.forEach { it.exibirCor()}
            }
        }

    }
}

abstract class Animal(var idade: Int, var cor: Color) {
    open var nome: String = ""
        get() = "Animal: $field"
        set(valor) {
            field = valor
        }

    open fun emitirSom() {

    }

    open fun exibirCor() {

    }

    open fun idadeHumanos() {

    }
}

enum class Color() {
    amarelo, preto, vermelho
}


class Cachorro(idade: Int, cor: Color) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }

    override fun exibirCor() {
        println("Cor do cachorro: $cor")
    }

}


class Gato(idade: Int, cor: Color) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Miau")
    }

    override fun exibirCor() {
        println("Cor do gato: $cor")
    }

}


class Passaro(idade: Int, cor: Color) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Piu piu")
    }

    override fun exibirCor() {
        println("Cor do passarinho: $cor")
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Listar Animais")
    println("5 - Emitir som")
    println("6 - Exibir cor")
    println("7 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }
}