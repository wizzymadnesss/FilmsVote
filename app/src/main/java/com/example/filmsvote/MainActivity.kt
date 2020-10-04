package com.example.filmsvote

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple.*
import com.example.filmsvote.SimpleFragment.Companion.cont1
import com.example.filmsvote.SimpleFragment.Companion.cont2

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded1=false
    var isFragmentLoaded2=false
    val manager = supportFragmentManager

    var peli1Like=0
    var peli1Dislike=0
    var peli2Like=0
    var peli2Dislike=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnVote1)
        btn1.setOnClickListener({
            if(!isFragmentLoaded1)
                showFragment1()
            else
                hideFragment1()
        })

        val btn2 = findViewById<Button>(R.id.btnVote2)
        btn2.setOnClickListener({
            if(!isFragmentLoaded2)
                showFragment2()
            else
                hideFragment2()
        })

        val btn3 = findViewById<Button>(R.id.CountVote)
        btn3.setOnClickListener({
            countVotes()
        })



    }

    fun showFragment1(){
        val transaction = manager.beginTransaction()
        val fragment=SimpleFragment()
        transaction.replace(R.id.fragment_container1,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded1=true
        val btn=findViewById<Button>(R.id.btnVote1)
        btn.setText("Cerrar votacion")
        cont1=peli1Like
        cont2=peli1Dislike

    }
    fun hideFragment1(){
        peli1Like=cont1
        peli1Dislike=cont2
        cont1=0
        cont2=0
        val transaction = manager.beginTransaction()
        val fragment=manager.findFragmentById(R.id.fragment_container1)
        transaction.remove(fragment!!)
        transaction.commit()
        isFragmentLoaded1=false
        val btn=findViewById<Button>(R.id.btnVote1)
        btn.setText(R.string.open_txt)

    }
    fun showFragment2(){
        val transaction = manager.beginTransaction()
        val fragment=SimpleFragment()
        transaction.replace(R.id.fragment_container2,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded2=true
        val btn=findViewById<Button>(R.id.btnVote2)
        btn.setText("Cerrar votacion")
        cont1=peli2Like
        cont2=peli2Dislike

    }
    fun hideFragment2(){
        peli2Like=cont1
        peli2Dislike=cont2
        cont1=0
        cont2=0
        val transaction = manager.beginTransaction()
        val fragment=manager.findFragmentById(R.id.fragment_container2)
        transaction.remove(fragment!!)
        transaction.commit()
        isFragmentLoaded2=false
        val btn=findViewById<Button>(R.id.btnVote2)
        btn.setText(R.string.open_txt)

    }
    fun countVotes(){
        val asd =findViewById<TextView>(R.id.tvre)
            if(peli1Like<peli2Like){
                asd.setText("Gana Rio con $peli2Like votaciones")
                Toast.makeText(this,"Gana Rio con $cont2 votaciones",Toast.LENGTH_SHORT)
            }
            if(peli2Like<peli1Like){
                asd.setText("Gana Nemo con $peli1Like votaciones")
                Toast.makeText(this,"Gana Nemo con $cont1 votaciones",Toast.LENGTH_SHORT)
            }
            if(peli1Like==peli2Like){
                asd.setText("Empatan")
                Toast.makeText(this,"Empatan",Toast.LENGTH_SHORT)
            }
    }

}