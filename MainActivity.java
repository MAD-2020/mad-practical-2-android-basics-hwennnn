package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private int last_location = 0;
    private static final String TAG = "Whack-A-Mole";
    private static final int[] BUTTON_IDS = {R.id.button_1, R.id.button_2, R.id.button_3};
    Random ran = new Random();
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.message);
        setNewMole();
        msg.setText(String.valueOf(count));
        Log.v(TAG, "Finished Pre-Initialisation!");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Starting GUI!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Paused GUI!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stop!");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v(TAG, "Restart!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroy!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "Resume!");
    }

    public void setNewMole()
    {
        int randomLocation = ran.nextInt(3);
        Button this_btn = findViewById(BUTTON_IDS[randomLocation]);
        Button last_btn = findViewById(BUTTON_IDS[last_location]);
        last_btn.setText("O");
        this_btn.setText("*");
        last_location = randomLocation;
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
        if (buttonText.equals("*")){
            count++;
            Log.v(TAG, "Hit, score added!");
        }else{
            if (count > 0){
                count--;
                Log.v(TAG, "Missed, score deducted!");
            }else{
                Log.v(TAG, "Missed Hit!");
            }
        }

        setNewMole();
        msg.setText(String.valueOf(count));
    }

}
