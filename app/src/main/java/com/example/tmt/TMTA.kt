package com.example.tmt


import android.content.Intent
import android.graphics.PointF
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.AbsoluteLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_t_m_t_a.*
import java.lang.Math.pow
import java.util.*
import kotlin.math.sqrt


class TMTA : AppCompatActivity(), ViewTreeObserver.OnGlobalLayoutListener {


    private lateinit var mLineView: LineView


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_m_t_a)

        var stopTime:Long = 0
        chronometer.base = SystemClock.elapsedRealtime()+stopTime
        chronometer.start()

        val animDrawable = Rlayout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()



        /**
         * Adding random numbers to the screen on the Relative layout.
         */

        var relativeLayout = findViewById<RelativeLayout>(R.id.Rlayout)
        //  mLineView = findViewById(R.id.lineView);
        //val tv = findViewById<TextView>(R.id.tv)


        /**
         * We need to pre-draw the layout before getting it's height and width.
         * Otherwise it will always return 0.
         */

        val messages = arrayOf("1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25")
        var TVlist: ArrayList<TextView> = arrayListOf()
        TVlist = arrayListOf(
            findViewById(R.id.tv),
            findViewById(R.id.tv2),
            findViewById(R.id.tv3),
            findViewById(R.id.tv4),
            findViewById(R.id.tv5),
            findViewById(R.id.tv6),
            findViewById(R.id.tv7),
            findViewById(R.id.tv8),
            findViewById(R.id.tv9),
            findViewById(R.id.tv10),
            findViewById(R.id.tv11),
            findViewById(R.id.tv12),
            findViewById(R.id.tv13),
            findViewById(R.id.tv14),
            findViewById(R.id.tv15),
            findViewById(R.id.tv16),
            findViewById(R.id.tv17),
            findViewById(R.id.tv18),
            findViewById(R.id.tv19),
            findViewById(R.id.tv20),
            findViewById(R.id.tv21),
            findViewById(R.id.tv22),
            findViewById(R.id.tv23),
            findViewById(R.id.tv24),
            findViewById(R.id.tv25)


        )
        // Log.d("Message","This is tvlist of 0"+TVlist[2]);

        for (i in 0..24) {
            TVlist!![i]!!.setText(messages!![i])

        }


        val boundW = relativeLayout.measuredWidth + 1080
        val boundH = relativeLayout.measuredHeight + 1920

        relativeLayout.viewTreeObserver.addOnGlobalLayoutListener() {
            relativeLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)


            for (i in 0..24) {


                TVlist[i].setX(Random().nextInt(boundW).toFloat())
                TVlist[i].setY(Random().nextInt(boundH).toFloat())



                while(TVlist[i].x <= 0F || TVlist[i].x >= 900F || TVlist[i].y <= 0F || TVlist[i].y >= 1400F)
                {
                    TVlist[i].setX(Random().nextInt(boundW).toFloat())
                    TVlist[i].setY(Random().nextInt(boundH).toFloat())
                }



                for(j in 1 .. 24)
                {
                    if(i != j) {

                        while (sqrt(pow(((TVlist[i].x - TVlist[j].x).toDouble()), 2.0) + pow(((TVlist[i].y - TVlist[j].y).toDouble()), 2.0)) < 50F) {
                            Log.d(
                                "THIS IS TAGGED MESSAGE",
                                "THOSE TEXT VIEWS ARE TOO CLOSE" + TVlist[i] + "," + TVlist[j]
                            )

                            TVlist[j].setX(
                                Random().nextInt(boundW).toFloat()
                            )
                            TVlist[j].setY(
                                Random().nextInt(boundH).toFloat()
                            )



                            while (TVlist[j].x <= 0F || TVlist[j].x >= 880F || TVlist[j].y <= 0F || TVlist[j].y >= 1650) {
                                TVlist[j].setX(
                                    Random().nextInt(boundW).toFloat()
                                )
                                TVlist[j].setY(
                                    Random().nextInt(boundH).toFloat()
                                )
                            }
                        }


                    }
                }


            }

        }










        var isPressed  = arrayListOf<Boolean>(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false)

        for (i in 0 .. 24)
        {
            TVlist[0].setOnClickListener {
                isPressed[0] = true;

                if(isPressed[0]) {
                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                    TVlist[0].setVisibility(View.INVISIBLE)

                    TVlist[1].setOnClickListener {

                        isPressed[1] = true;

                        if(isPressed[1]) {
                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                            TVlist[1].setVisibility(View.INVISIBLE)

                            TVlist[2].setOnClickListener {

                                isPressed[2] = true;

                                if(isPressed[2]) {
                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                    TVlist[2].setVisibility(View.INVISIBLE)

                                    TVlist[3].setOnClickListener {

                                        isPressed[3] = true;

                                        if(isPressed[3]) {
                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                            TVlist[3].setVisibility(View.INVISIBLE)

                                            TVlist[4].setOnClickListener {

                                                isPressed[4] = true;

                                                if(isPressed[4]) {
                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                    TVlist[4].setVisibility(View.INVISIBLE)

                                                    TVlist[5].setOnClickListener {

                                                        isPressed[5] = true;

                                                        if(isPressed[5]) {
                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                            TVlist[5].setVisibility(View.INVISIBLE)

                                                            TVlist[6].setOnClickListener {

                                                                isPressed[6] = true;

                                                                if(isPressed[6]) {
                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                    TVlist[6].setVisibility(View.INVISIBLE)

                                                                    TVlist[7].setOnClickListener {

                                                                        isPressed[7] = true;

                                                                        if(isPressed[7]) {
                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                            TVlist[7].setVisibility(View.INVISIBLE)

                                                                            TVlist[8].setOnClickListener {

                                                                                isPressed[8] = true;

                                                                                if(isPressed[8]) {
                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                    TVlist[8].setVisibility(View.INVISIBLE)

                                                                                    TVlist[9].setOnClickListener {

                                                                                        isPressed[9] = true;

                                                                                        if(isPressed[9]) {
                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                            TVlist[9].setVisibility(View.INVISIBLE)

                                                                                            TVlist[10].setOnClickListener {

                                                                                                isPressed[10] = true;

                                                                                                if(isPressed[10]) {
                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                    TVlist[10].setVisibility(View.INVISIBLE)

                                                                                                    TVlist[11].setOnClickListener {

                                                                                                        isPressed[11] = true;

                                                                                                        if(isPressed[11]) {
                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                            TVlist[11].setVisibility(View.INVISIBLE)

                                                                                                            TVlist[12].setOnClickListener {

                                                                                                                isPressed[12] = true;

                                                                                                                if(isPressed[12]) {
                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                    TVlist[12].setVisibility(View.INVISIBLE)

                                                                                                                    TVlist[13].setOnClickListener {

                                                                                                                        isPressed[13] = true;

                                                                                                                        if(isPressed[13]) {
                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                            TVlist[13].setVisibility(View.INVISIBLE)

                                                                                                                            TVlist[14].setOnClickListener {

                                                                                                                                isPressed[14] = true;

                                                                                                                                if(isPressed[14]) {
                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                    TVlist[14].setVisibility(View.INVISIBLE)

                                                                                                                                    TVlist[15].setOnClickListener {

                                                                                                                                        isPressed[15] = true;

                                                                                                                                        if(isPressed[15]) {
                                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                            TVlist[15].setVisibility(View.INVISIBLE)

                                                                                                                                            TVlist[16].setOnClickListener {

                                                                                                                                                isPressed[16] = true;

                                                                                                                                                if(isPressed[16]) {
                                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                    TVlist[16].setVisibility(View.INVISIBLE)

                                                                                                                                                    TVlist[17].setOnClickListener {

                                                                                                                                                        isPressed[17] = true;

                                                                                                                                                        if(isPressed[17]) {
                                                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                            TVlist[17].setVisibility(View.INVISIBLE)

                                                                                                                                                            TVlist[18].setOnClickListener {

                                                                                                                                                                isPressed[18] = true;

                                                                                                                                                                if(isPressed[18]) {
                                                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                    TVlist[18].setVisibility(View.INVISIBLE)

                                                                                                                                                                    TVlist[19].setOnClickListener {

                                                                                                                                                                        isPressed[19] = true;

                                                                                                                                                                        if(isPressed[19]) {
                                                                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                            TVlist[19].setVisibility(View.INVISIBLE)

                                                                                                                                                                            TVlist[20].setOnClickListener {

                                                                                                                                                                                isPressed[20] = true;

                                                                                                                                                                                if(isPressed[20]) {
                                                                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                                    TVlist[20].setVisibility(View.INVISIBLE)

                                                                                                                                                                                    TVlist[21].setOnClickListener {

                                                                                                                                                                                        isPressed[21] = true;

                                                                                                                                                                                        if(isPressed[21]) {
                                                                                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                                            TVlist[21].setVisibility(View.INVISIBLE)

                                                                                                                                                                                            TVlist[22].setOnClickListener {

                                                                                                                                                                                                isPressed[22] = true;

                                                                                                                                                                                                if(isPressed[22]) {
                                                                                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                                                    TVlist[22].setVisibility(View.INVISIBLE)

                                                                                                                                                                                                    TVlist[23].setOnClickListener {

                                                                                                                                                                                                        isPressed[23] = true;

                                                                                                                                                                                                        if(isPressed[23]) {
                                                                                                                                                                                                            Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                                                            TVlist[23].setVisibility(View.INVISIBLE)

                                                                                                                                                                                                            TVlist[24].setOnClickListener {

                                                                                                                                                                                                                isPressed[24] = true;

                                                                                                                                                                                                                if(isPressed[24]) {
                                                                                                                                                                                                                    Toast.makeText(applicationContext, "✔", Toast.LENGTH_SHORT).show()
                                                                                                                                                                                                                    TVlist[24].setVisibility(View.INVISIBLE)
                                                                                                                                                                                                                    stopTime= chronometer.base-SystemClock.elapsedRealtime()
                                                                                                                                                                                                                    chronometer.stop()
                                                                                                                                                                                                                    saveData()
                                                                                                                                                                                                                    val intent = Intent(this, MainActivity::class.java)
                                                                                                                                                                                                                    startActivity(intent)


                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }

                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }

                }

            }
        }



        /**
         * Making a line between 2 points
         */

        mLineView = findViewById(R.id.lineView)
        var PointA = PointF(TVlist[0].x, TVlist[0].y)
        var PointB = PointF(TVlist[1].x, TVlist[1].y)
        mLineView.setPointA(PointA)
        mLineView.setPointB(PointB)
        mLineView.draw()
        Log.d(
            "TAG FOR COORDINATES",
            "This are the coordinates for first TV" + TVlist[0].x + "    " + TVlist[0].y
        )










    }



    override fun onGlobalLayout() {
        TODO("Not yet implemented")

    }

    fun saveData()
    {
        val savedTime = chronometer.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs", 0)
        val editor = sharedPreferences.edit()

        editor.apply{
            putString("STRING_KEYA", savedTime)
        }.apply()

    }


}
























