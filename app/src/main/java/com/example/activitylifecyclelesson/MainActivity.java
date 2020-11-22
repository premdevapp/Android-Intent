package com.example.activitylifecyclelesson;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showGuessButton;
    private EditText showPersonName;
    private final int  REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Log.d("Cycle", "onCreate: ");
        Toast.makeText(MainActivity.this, "Main Activity on Create", Toast.LENGTH_SHORT).show();*/

        showGuessButton = findViewById(R.id.buttonGuess);
        showPersonName = findViewById(R.id.personName);

        showGuessButton.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                assert data != null;
                String message = data.getStringExtra("message");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {

        String guess = showPersonName.getText().toString().trim();
        if(! guess.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, ShowGuess.class);

            intent.putExtra("guess", guess);
            intent.putExtra("name", "Premnath");
            intent.putExtra("age", 29);

            //startActivity(intent);

            startActivityForResult(intent, REQUEST_CODE);

        }else {
            Toast.makeText(MainActivity.this, "Enter Something to Procced", Toast.LENGTH_LONG).show();
        }
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Log.d("Cycle", "onStart: ");
        Toast.makeText(MainActivity.this, "Main Activity on Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Cycle", "onResume: ");
        Toast.makeText(MainActivity.this, "Main Activity on Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Cycle", "onPause: ");
        Toast.makeText(MainActivity.this, "Main Activity on Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Cycle", "onStop: ");
        Toast.makeText(MainActivity.this, "Main Activity on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Cycle", "onDestroy: ");
        Toast.makeText(MainActivity.this, "Main Activity on Destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Cycle", "onRestart: ");
        Toast.makeText(MainActivity.this, "Main Activity on Restart", Toast.LENGTH_SHORT).show();
    }*/

}