package com.example.myyoutubemusic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var botaoPlay      : ImageView
    private lateinit var botaoNext      : ImageView
    private lateinit var botaoBack      : ImageView
    private lateinit var imagemMusic    : ImageView
    private lateinit var TextMusic      : TextView
    private lateinit var TextName       : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagemMusic = findViewById(R.id.image1)
        botaoPlay = findViewById(R.id.play)
        botaoNext = findViewById(R.id.next)
        botaoBack = findViewById(R.id.back)
        TextMusic = findViewById(R.id.nameMusic)
        TextName = findViewById(R.id.nameSinger)

        var media = MediaPlayer.create(applicationContext, R.raw.alone)

        botaoPlay.setOnClickListener{
            media.start()
        }
        botaoNext.setOnClickListener{
            media.pause()
            imagemMusic.setImageResource(R.drawable.image2)


            media = MediaPlayer.create(applicationContext, R.raw.`in`)
        }
        botaoBack.setOnClickListener{
            media.pause()
            imagemMusic.setImageResource(R.drawable.images)
            media = MediaPlayer.create(applicationContext, R.raw.alone)
        }
    }
}