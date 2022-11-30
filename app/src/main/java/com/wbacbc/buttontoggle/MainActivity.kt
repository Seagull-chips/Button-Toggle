package com.wbacbc.buttontoggle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wbacbc.buttontoggle.databinding.ActivityMainBinding


/**
 * https://its301.com/article/cunchi4221/107477589
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked -> }
    }
}