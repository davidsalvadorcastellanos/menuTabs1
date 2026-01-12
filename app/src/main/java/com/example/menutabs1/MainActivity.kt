package com.example.menutabs1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "My Application"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            lateinit var fragment : Fragment

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> fragment = Fragmento1()
                    1 -> fragment = Fragmento2()
                    2 -> fragment = Fragmento3()
                    3 -> fragment = FragmentoCompose()
                }
                supportFragmentManager.beginTransaction().replace(R.id.content_fragment, fragment).commit()
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {}
            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })
        }
    }