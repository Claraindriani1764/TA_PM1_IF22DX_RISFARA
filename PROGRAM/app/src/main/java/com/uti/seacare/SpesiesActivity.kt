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
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: Close current activity
                }
                R.id.spesies -> {
                    // Already in this activity
                }
                R.id.info -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("fragment", "info")
                    startActivity(intent)
                    finish() // Optional: Close current activity
                }
                else -> {
                }
            }
            true
        }
    }



    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
    }
        recyclerView.adapter = AdapterClass(dataList)
    }
    }
