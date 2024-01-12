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

public class EyeQ2Activity extends AppCompatActivity {

    private Button mButtonBack, mButtonYes, mButtonNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_q2);

        ArrayList<Boolean> eyeAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mButtonBack = findViewById(R.id.mButtonBack);
        mButtonYes = findViewById(R.id.mButtonYes);
        mButtonNo = findViewById(R.id.mButtonNo);


        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, EyeQ1Activity.class);
            }
        });

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eyeAnswers.add(1, false);

                startActivity(v, EyeResultActivity.class, eyeAnswers);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eyeAnswers.add(1, true);

                startActivity(v, EyeResultActivity.class, eyeAnswers);
            }
        });


    }

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> EyeAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", EyeAnswers);
        startActivity(intent);
    }
    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        startActivity(intent);
    }
}