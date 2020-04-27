package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    private static final String TAG = "Whack-A-Mole";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");

    }

    public void onClickBtn(View v)
    {
        switch(v.getId()) {
            case R.id.button_1:
                Log.v(TAG, "Button Left Clicked!");
                break;
            case R.id.button_2:
                Log.v(TAG, "Button Middle Clicked!");
                break;
            default:
                Log.v(TAG, "Button Right Clicked!");
        }

        Button b = (Button)v;
        String buttonText = b.getText().toString();
        if (buttonText == "*"){
            count++;
            Log.v(TAG, "Hit, score added!");
        }else{
            count--;
            Log.v(TAG, "Missed, score deducted!");
        }

        setNewMole();
        displayMarks();
    }

    public void displayMarks()
    {
        String c = String.valueOf(count);
        TextView msg = (TextView)findViewById(R.id.message);
        msg.setText(c);
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        displayMarks();

        Log.v(TAG, "Starting GUI!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        Button p1_button = (Button)findViewById(R.id.button_1);
        Button p2_button = (Button)findViewById(R.id.button_2);
        Button p3_button = (Button)findViewById(R.id.button_3);
        Button[] all = {p1_button,p2_button,p3_button};
        Button id = all[ran.nextInt(all.length)];

        for (int i = 0; i < all.length; i++) {
            if (all[i] == id){
                id.setText("O");
            }else{
                all[i].setText("*");
            }
        }


    }
}
