package com.example.umix.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //generate random number using Math.random
    int rNumber;
    public void randomNumberMethod(){
        Random rand = new Random();
        rNumber = rand.nextInt(20)+1;
    }
    //boolean variable to identify if game is won
    boolean gameWon = false;

    //find if number is guessed
    public void guessAttempt(){
        //retrieve data from user's input
        EditText editText = (EditText)findViewById(R.id.editText);
        //convert entry
        String input = editText.getText().toString();
        String popupMessage = "";
        int nInput = Integer.parseInt(input);
        //compare user's input with number
        if(nInput > rNumber){
            popupMessage = "Your guess is  larger than correct number";
        }
        else if(nInput < rNumber){
            popupMessage=  "Your guess is  smaller than correct number";
        }
        else {
            gameWon = true;
            popupMessage = "You Won";
            randomNumberMethod();
        }
        Toast.makeText(this, popupMessage, Toast.LENGTH_LONG).show();
    }
    //Click button function.
    public void guessNumber(View view){
        guessAttempt();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumberMethod();
    }
}
