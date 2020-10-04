package com.example.filmsvote

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_simple.*

class SimpleFragment : Fragment(){

    val TAG="FragmentOne"

    companion object{
        var cont1=0
        var cont2=0
    }

    override fun onAttach(context: Context) {
        Log.d(TAG,"onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(       inflater: LayoutInflater,        container: ViewGroup?,        savedInstanceState: Bundle?    ): View? {
        Log.d(TAG,"onCreateView")
        val root= inflater.inflate(R.layout.fragment_simple,container,false)

        val btnLike = root.findViewById<Button>(R.id.btnLike)
        btnLike.setOnClickListener({
            like()
            btnLike.setText(cont1.toString())
        })
        btnLike.setText(cont1.toString())
        val btnDislike = root.findViewById<Button>(R.id.btnDislike)
        btnDislike.setOnClickListener({
            dislike()
            btnDislike.setText(cont2.toString())
        })
        btnDislike.setText(cont2.toString())
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG,"onPause")
        super.onPause()
    }

    override fun onDestroyView() {
        Log.d(TAG,"onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG,"onDetach")
        super.onDetach()
    }


    fun like(){
        cont1++

    }
    fun dislike(){
        cont2++
    }

}

