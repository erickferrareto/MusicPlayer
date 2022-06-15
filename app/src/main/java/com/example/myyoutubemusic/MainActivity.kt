package com.example.myyoutubemusic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var botaoPlay      : ImageView
    private lateinit var botaoPause     : ImageView
    private lateinit var botaoNext      : ImageView
    private lateinit var botaoBack      : ImageView
    private lateinit var imagemMusic    : ImageView
    private lateinit var TextMusic      : TextView
    private lateinit var TextName       : TextView
    private lateinit var seekBar        : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoPause = findViewById(R.id.pause)
        imagemMusic = findViewById(R.id.image1)
        botaoPlay = findViewById(R.id.play)
        botaoNext = findViewById(R.id.next)
        botaoBack = findViewById(R.id.back)
        TextMusic = findViewById(R.id.nameMusic)
        TextName = findViewById(R.id.nameSinger)
        seekBar = findViewById(R.id.seekBar)

        var media = MediaPlayer.create(applicationContext, R.raw.alone)


        botaoPause.setOnClickListener{
            media.pause()
            botaoPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        }
        botaoPlay.setOnClickListener{
            if (media.isPlaying){
                media.pause()
                botaoPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            } else {
                media.start()
                botaoPlay.setImageResource(R.drawable.ic_baseline_pause_24)
                if (media.isPlaying){
                    for (x in 0..100){
                        seekBar.progress += 1
                    }
                }
            }
        }
        botaoNext.setOnClickListener{
            media.pause()
            imagemMusic.setImageResource(R.drawable.image2)
            media = MediaPlayer.create(applicationContext, R.raw.`in`)
            TextMusic.text = "In your eyes"
            TextName.text = "Alida"
        }
        botaoBack.setOnClickListener{
            media.pause()
            imagemMusic.setImageResource(R.drawable.images)
            media = MediaPlayer.create(applicationContext, R.raw.alone)
            TextMusic.text = "When I'm Alone"
            TextName.text = "Post Malone"
        }
    }

}