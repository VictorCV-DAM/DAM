package exercicis

import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val ent = "/"
    val f = File(ent)
    if (f.exists()) {
        if (f.isDirectory()) {
            llistaDirectori(f)
        } else
            println("No és un directori")
    } else
        println("No existeix el directori")
}

fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))

    var count = 1

    println("0" + ".- "+"Directori Pare")

    for (e in f.listFiles().sorted()) {


        if (e.isFile())
            println(count.toString() + ".- "+ e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println(count.toString() + ".- "+ e.getName() + "\t <Directori>")

        count = count +1;


    }


}
