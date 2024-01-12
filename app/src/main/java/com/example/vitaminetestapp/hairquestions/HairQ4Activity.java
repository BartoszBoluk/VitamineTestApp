package com.example.vitaminetestapp.hairquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class HairQ4Activity extends AppCompatActivity {


    private Button mButtonBack, mButtonYes, mButtonNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_q4);

        ArrayList<Boolean> HairAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mButtonBack = findViewById(R.id.mButtonBack);
        mButtonYes = findViewById(R.id.mButtonYes);
        mButtonNo = findViewById(R.id.mButtonNo);

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, HairQ3Activity.class);
            }
        });

        mButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(3, false);

                startActivity(v, HairResultActivity.class, HairAnswers);
            }
        });
        mButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HairAnswers.add(3, true);

                startActivity(v, HairResultActivity.class, HairAnswers);
            }
        });
    }

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> HairAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", HairAnswers);
        startActivity(intent);
    }
    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        startActivity(intent);
    }
}