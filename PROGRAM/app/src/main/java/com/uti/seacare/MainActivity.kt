package com.uti.seacare

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.uti.seacare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


        val fragmentName = intent.getStringExtra("fragment")
        if (fragmentName != null) {
            when (fragmentName) {
                "home" -> replaceFragment(HomeFragment())
                "info" -> replaceFragment(InfoFragment())
                else -> replaceFragment(HomeFragment())
            }
        } else {
            replaceFragment(HomeFragment())
        }

        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.spesies -> {
                    // Intent untuk membuka SpesiesActivity
                    val intent = Intent(this, SpesiesActivity::class.java)
                    startActivity(intent)
                }
                R.id.info -> replaceFragment(InfoFragment())
                else -> {
                    // Kode untuk item menu lainnya
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction().addToBackStack(null)
        fragmentTransaction.replace(R.id.frm_layout, fragment)
        fragmentTransaction.commit()
    }
}