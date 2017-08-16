package net.androidbootcamp.animalvoincesapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpCow, mpPig;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate buttons
        button1 = (Button) findViewById(R.id.btnCows);
        button2 = (Button) findViewById(R.id.btnPigs);

        button1.setOnClickListener(bCows);
        button2.setOnClickListener(bPigs);

        mpCow = new MediaPlayer();
        mpCow = MediaPlayer.create(this, R.raw.cow);
        mpPig = new MediaPlayer();
        mpPig = MediaPlayer.create(this, R.raw.pig);
        playing = 0;
    }

    Button.OnClickListener bCows = new Button.OnClickListener(){
        @Override
    public void onClick(View v){
        switch (playing){
            case 0:
                mpCow.start();
                playing = 1;
                button1.setText("Pause Cows");
                button2.setVisibility(View.INVISIBLE);
                break;
            case 1:
                mpCow.pause();
                playing = 0;
                button1.setText("Listen To Cows");
                button2.setVisibility(View.VISIBLE);
                break;
            }
        }
    };
    Button.OnClickListener bPigs = new Button.OnClickListener(){
        @Override
    public void onClick(View v){
            switch (playing){
                case 0:
                    mpPig.start();
                    playing = 1;
                    button2.setText("Pause Pigs");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPig.pause();
                    playing = 0;
                    button2.setText("Listen To Pigs");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}//end class
