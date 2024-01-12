package com.example.vitaminetestapp.lipsquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.PickSymptonesActivity;
import com.example.vitaminetestapp.R;
import com.example.vitaminetestapp.eyequestions.EyeQ2Activity;

import java.util.ArrayList;

public class LipsQ1Activity extends AppCompatActivity {

    private Button mButtonBack, mButtonYes, mButtonNo;
    public ArrayList<Boolean> lipsAnswers = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lips_q1);

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

                lipsAnswers.add(0, false);

                startActivity(v, LipsQ2Activity.class);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lipsAnswers.add(0, true);

                startActivity(v, LipsQ2Activity.class);
            }
        });

    }

    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", lipsAnswers);
        startActivity(intent);
    }
}