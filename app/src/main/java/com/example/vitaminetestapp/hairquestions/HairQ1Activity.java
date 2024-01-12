package com.example.vitaminetestapp.hairquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.MainActivity;
import com.example.vitaminetestapp.PickSymptonesActivity;
import com.example.vitaminetestapp.R;
import com.example.vitaminetestapp.eyequestions.EyeQ2Activity;

import java.util.ArrayList;

public class HairQ1Activity extends AppCompatActivity {

    private Button mButtonBack, mButtonYes, mButtonNo;
    public ArrayList<Boolean> HairAnswers = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_q1);

        mButtonBack = findViewById(R.id.mButtonBack);
        mButtonYes = findViewById(R.id.mButtonYes);
        mButtonNo = findViewById(R.id.mButtonNo);

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(0, false);

                startActivity(v, HairQ2Activity.class);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(0, true);

                startActivity(v, HairQ2Activity.class);
            }
        });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, PickSymptonesActivity.class);
            }
        });

    }

    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", HairAnswers);
        startActivity(intent);
    }
}