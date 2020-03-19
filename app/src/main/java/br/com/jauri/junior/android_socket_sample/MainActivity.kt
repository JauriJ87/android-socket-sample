package br.com.jauri.junior.android_socket_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.PrintWriter
import java.net.Socket


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            var socket = Socket("190.1.2.14", 8080)

            var out: OutputStream = socket.getOutputStream()

            val output = PrintWriter(out)

            output.println("Hello Android!")

            val input = BufferedReader(InputStreamReader(socket.getInputStream()))

            //read line(s)
            val st = input.readLine()

            println("$st")

            //Close connection
            socket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
