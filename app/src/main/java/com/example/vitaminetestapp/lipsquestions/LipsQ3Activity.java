package com.example.vitaminetestapp.lipsquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class LipsQ3Activity extends AppCompatActivity {

    private Button mButtonBack, mButtonYes, mButtonNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lips_q3);

        ArrayList<Boolean> lipsAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mButtonBack = findViewById(R.id.mButtonBack);
        mButtonYes = findViewById(R.id.mButtonYes);
        mButtonNo = findViewById(R.id.mButtonNo);

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, LipsQ2Activity.class);
            }
        });

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lipsAnswers.add(1, false);

                startActivity(v, LipsResultActivity.class, lipsAnswers);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lipsAnswers.add(1, true);

                startActivity(v, LipsResultActivity.class, lipsAnswers);
            }
        });

    }

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> lipsAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", lipsAnswers);
        startActivity(intent);
    }
    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        startActivity(intent);
    }
}