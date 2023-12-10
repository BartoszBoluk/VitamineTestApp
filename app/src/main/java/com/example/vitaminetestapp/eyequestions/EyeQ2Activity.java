package com.example.vitaminetestapp.eyequestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;
import com.example.vitaminetestapp.hairquestions.HairQ2Activity;

import java.util.ArrayList;

public class EyeQ2Activity extends AppCompatActivity {

    private CheckBox mCheckBoxYes, mCheckBoxNo;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_q2);

        ArrayList<Boolean> eyeAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mCheckBoxYes = findViewById(R.id.mCheckBoxYes);
        mCheckBoxNo = findViewById(R.id.mCheckBoxNo);
        mButtonNext = findViewById(R.id.mButtonNext);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCheckBoxYes.isChecked() == true)
                    eyeAnswers.add(1, true);
                else
                    eyeAnswers.add(1, false);

                startActivity(v, EyeResultActivity.class, eyeAnswers);
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

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> EyeAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", EyeAnswers);
        startActivity(intent);
    }
}