package exercicis

import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue


fun main(args: Array<String>) {
    val ent = File.listRoots()[0]
    val f = ent

    llistaDirectori(f)
}

fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))

    var count = 1

    println("0" + ".- " + "Directori Pare")

    for (e in f.listFiles().sorted()) {

        if (e.isFile())
            println(count.toString() + ".- " + e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println(count.toString() + ".- " + e.getName() + "\t <Directori>")

        count = count + 1;

    }

    val v = 0

    do {
        println("\nIntrodueix un numero (-1 para acabar):")
        val ent = BufferedReader(InputStreamReader(System.`in`)).readLine()
        val valor  = File(ent).toString()

        if (valor is String) {

            val v = valor.toInt() -1

//            if (v.isnumeric){
//
//            }else
//                println("El valor no es numeric i no es valid")
            if (v == -1) {
                llistaDirectori(f)
            }else

            if (v<=25) {
                val peticion = File(f.listFiles().sorted()[v].name)

                println(peticion)

                val entrada = "/" + peticion.toString()
                val arch = File(entrada)
                if (arch.exists()) {
                    if (arch.isDirectory()) {
                        if (arch.canRead()) {
                            seleccionaDir(arch)
                        } else
                            println("\nEl usuari no te permisos de lectura sobre el directori")
                    } else

                        println("\nNo és un directori")
                } else
                    println("\nNo existeix el directori")
            }else
                println("\nIntrodueix un valor en el rang")
        }
    }while (v != -2)
//    if (v == -2){
//        println("Fin del programa")
//    }
}

    fun seleccionaDir(arch: File) {
        val s = "Llista de fitxers i directoris del directori " + arch.getCanonicalPath()
        println(s)
        println("-".repeat(s.length))

        var count = 1


        println("0" + ".- " + "Directori Pare")

        for (e in arch.listFiles().sorted()) {

            if (e.isFile())
                println(count.toString() + ".- " + e.getName() + "\t " + e.length())
            if (e.isDirectory())
                println(count.toString() + ".- " + e.getName() + "\t <Directori>")

            count = count + 1;

        }
    }
