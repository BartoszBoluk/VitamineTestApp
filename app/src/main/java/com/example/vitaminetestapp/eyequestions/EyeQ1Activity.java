package com.example.vitaminetestapp.eyequestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.PickSymptonesActivity;
import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class EyeQ1Activity extends AppCompatActivity {

    private Button mButtonBack, mButtonYes, mButtonNo;
    public ArrayList<Boolean> HairAnswers = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_q1);

        mButtonBack = findViewById(R.id.mButtonBack);
        mButtonYes = findViewById(R.id.mButtonYes);
        mButtonNo = findViewById(R.id.mButtonNo);


        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, PickSymptonesActivity.class);
            }
        });
        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(0, false);

                startActivity(v, EyeQ2Activity.class);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(0, true);

                startActivity(v, EyeQ2Activity.class);
            }
        });
    }

    /*
     * Funkcja uruchamia nowe Activity. Dodatkowo za pomocą intentu przekazuje do nowego Activity
     * ArrayList zawierający odpowiedzie na pytania.
     */
    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", HairAnswers);
        startActivity(intent);
    }
}