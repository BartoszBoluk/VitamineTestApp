package com.example.vitaminetestapp.eyequestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class EyeQ1Activity extends AppCompatActivity {

    private CheckBox mCheckBoxYes, mCheckBoxNo;
    private Button mButtonNext;
    public ArrayList<Boolean> HairAnswers = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_q1);

        mCheckBoxYes = findViewById(R.id.mCheckBoxYes);
        mCheckBoxNo = findViewById(R.id.mCheckBoxNo);
        mButtonNext = findViewById(R.id.mButtonNext);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCheckBoxYes.isChecked() == true)
                    HairAnswers.add(0, true);
                else
                    HairAnswers.add(0, false);

                startActivity(v, EyeQ2Activity.class);
            }
        });

        mCheckBoxYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBoxNo.isChecked() == true) {
                    mCheckBoxNo.setChecked(false);
                }
            }
        });

        mCheckBoxNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBoxYes.isChecked() == true) {
                    mCheckBoxYes.setChecked(false);
                }
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