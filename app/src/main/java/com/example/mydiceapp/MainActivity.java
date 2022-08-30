package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView ImageDice1=findViewById(R.id.imgDice1);
        ImageView ImageDice2=findViewById(R.id.imgDice2);
        int [] diceimage={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

       final MediaPlayer MP= MediaPlayer.create(this,R.raw.dice_sound);

        Button btnroll=findViewById(R.id.btnrollthedice);

        btnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rndObject = new Random();

               int  myRandomNumber =rndObject.nextInt(6);
               ImageDice1.setImageResource(diceimage[myRandomNumber]);

               myRandomNumber= rndObject.nextInt(6);
               ImageDice2.setImageResource(diceimage[myRandomNumber]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(ImageDice1);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(ImageDice2);

               MP.start();

            }
        });
    }
}