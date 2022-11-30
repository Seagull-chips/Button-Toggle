package com.wbacbc.buttontoggle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.addisonelliott.segmentedbutton.SegmentedButtonGroup.OnPositionChangedListener
import com.wbacbc.buttontoggle.databinding.ActivityMainBinding


/**
 * https://github.com/addisonElliott/SegmentedButton
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonGroupLordOfTheRings.onPositionChangedListener = OnPositionChangedListener {

            // Get current position
            val position = binding.buttonGroupLordOfTheRings.position
            // Handle stuff here
            Log.d("MainActivity", "$position")
        }


    }
}