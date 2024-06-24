package com.uti.seacare

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SpesiesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spesies)

        imageList = arrayOf(
            R.drawable.dugong,
            R.drawable.lumba,
            R.drawable.paus,
            R.drawable.penyu,
            R.drawable.pauss,
            R.drawable.parimanta,
            R.drawable.penguin,
            R.drawable.gurita,
            R.drawable.ikankarang,
            R.drawable.hiu
        )

        titleList = arrayOf(
            "Tentang Dugong",
            "Tentang Lumba-Lumba",
            "Tentang Paus",
            "Tentang Penyu",
            "Tentang Hiu Paus",
            "Tentang Pari manta",
            "Tentang Penguin",
            "Tentang Gurita",
            "Tentang Ikan Karang",
            "Tentang Hiu"
        )


    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
    }
        recyclerView.adapter = AdapterClass(dataList)
    }
    }
