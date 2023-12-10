package com.example.vitaminetestapp.lipsquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;
import com.example.vitaminetestapp.eyequestions.EyeResultActivity;

import java.util.ArrayList;

public class LipsQ2Activity extends AppCompatActivity {

    private CheckBox mCheckBoxYes, mCheckBoxNo;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lips_q2);

        ArrayList<Boolean> lipsAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mCheckBoxYes = findViewById(R.id.mCheckBoxYes);
        mCheckBoxNo = findViewById(R.id.mCheckBoxNo);
        mButtonNext = findViewById(R.id.mButtonNext);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCheckBoxYes.isChecked() == true)
                    lipsAnswers.add(1, true);
                else
                    lipsAnswers.add(1, false);

                startActivity(v, LipsQ3Activity.class, lipsAnswers);
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

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> lipsAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", lipsAnswers);
        startActivity(intent);
    }
}