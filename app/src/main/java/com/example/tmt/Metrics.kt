package com.example.tmt

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.collection.LLRBNode
import kotlinx.android.synthetic.main.activity_metrics.*

class Metrics : AppCompatActivity() {

    lateinit var barList:ArrayList<BarEntry>
    lateinit var barDataSet: BarDataSet
    lateinit var barData : BarData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrics)

        barList = ArrayList()
        barList.add(BarEntry(13f,50f))
        barList.add(BarEntry(20f,40f))
        barList.add(BarEntry(30f,46f))
        barList.add(BarEntry(35f,60f))
        barList.add(BarEntry(40f,70f))
        barList.add(BarEntry(45f,75f))
        barList.add(BarEntry(50f,79f))
        barList.add(BarEntry(80f,90f))

        barDataSet = BarDataSet(barList, "Average time completion for part A")
        barData = BarData(barDataSet)
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS, 250)
        barChart.data = barData
        barDataSet.valueTextColor= Color.BLACK
        barDataSet.valueTextSize = 15f


    }
}