package com.example.practical7

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate (savedInstancestate: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstancestate)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwitch.setOnClickListener{
            Intent(this,WebViewActivity::class.java).also{ startActivity(it) }
        }
    }
    private fun initVideoPlayer(){
        val mediaController = MediaController(this)
        val video_path = "android.resource://" + packageName + "/" + R.raw.thestoryoflight
        val video_uri = Uri.parse(video_path)
        binding.videoView.setMediaController(mediaController)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setVideoURI(video_uri)
        binding.videoView.requestFocus()
        binding.videoView.start()
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }
}