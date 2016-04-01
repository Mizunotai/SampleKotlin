package com.lifeistech.android.samplekotln

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var number: Int = 0
    var number2: Int = 0
    var pref: SharedPreferences? = null
    var edit: SharedPreferences.Editor? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = getSharedPreferences("KEY", MODE_PRIVATE)
        edit = pref?.edit()


        var button1 = findViewById(R.id.button) as Button
        var button2 = findViewById(R.id.button2) as Button
        var button3 = findViewById(R.id.button3) as Button
        var button4 = findViewById(R.id.button4) as Button
        var button5 = findViewById(R.id.button5) as Button
        var button6 = findViewById(R.id.button6) as Button
        var button7 = findViewById(R.id.button7) as Button

        var textView1 = findViewById(R.id.textView) as TextView
        var textView2 = findViewById(R.id.textView2) as TextView
        var textView3 = findViewById(R.id.textView3) as TextView

        var imageView1 = findViewById(R.id.imageView) as ImageView

        button1.setBackgroundResource(R.drawable.icon)



        button1.setOnClickListener {


            number = randomNumber(100)
            textView1.text = number.toString()


        }

        button2.setOnClickListener {


            edit?.putInt("SAVE", number)
            edit?.commit()


        }

        button3.setOnClickListener {

            textView2.text = pref?.getInt("SAVE", 0).toString()

        }

        button4.setOnClickListener {
            imageView1.setImageResource(R.drawable.icon)
        }

        button5.setOnClickListener {
            Log.e("hoge", number.toString())


        }

        button6.setOnClickListener {
            Toast.makeText(this, number.toString(), Toast.LENGTH_LONG).show()
        }

        button7.setOnClickListener {

            val handler = Handler()

            Timer().schedule(1000, 1000) {

                handler.post {
                    number2++
                    textView3.text = number2.toString()
                }
            }




        }
    }



    fun randomNumber(max :Int ) : Int{

        var random: Random = Random()

        return random.nextInt(max)
    }
}
