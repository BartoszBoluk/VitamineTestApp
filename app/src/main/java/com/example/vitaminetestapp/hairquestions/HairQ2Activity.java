package com.example.vitaminetestapp.hairquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class HairQ2Activity extends AppCompatActivity {

    private CheckBox mCheckBoxYes, mCheckBoxNo;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_q2);

        ArrayList<Boolean> HairAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mCheckBoxYes = findViewById(R.id.mCheckBoxYes);
        mCheckBoxNo = findViewById(R.id.mCheckBoxNo);
        mButtonNext = findViewById(R.id.mButtonNext);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCheckBoxYes.isChecked() == true)
                    HairAnswers.add(1,true);
                else
                    HairAnswers.add(1,false);

                startActivity(v, HairQ3Activity.class, HairAnswers);
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

    private void startActivity(View v, Class directed_class, ArrayList<Boolean> HairAnswers) {
        Intent intent = new Intent(this, directed_class);
        intent.putExtra("StringKey", HairAnswers);
        startActivity(intent);
    }
}