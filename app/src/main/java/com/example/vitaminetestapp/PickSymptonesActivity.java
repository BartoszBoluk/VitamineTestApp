package com.example.vitaminetestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vitaminetestapp.eyequestions.EyeQ1Activity;
import com.example.vitaminetestapp.hairquestions.HairQ1Activity;
import com.example.vitaminetestapp.lipsquestions.LipsQ1Activity;

public class PickSymptonesActivity extends AppCompatActivity {

    private Button mButtonHair, mButtonEyes, mButtonLips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_symptones);

        mButtonHair = findViewById(R.id.mButtonHair);
        mButtonEyes = findViewById(R.id.mButtonEyes);
        mButtonLips = findViewById(R.id.mButtonLips);

        mButtonHair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, HairQ1Activity.class);
            }
        });
        mButtonEyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, EyeQ1Activity.class);
            }
        });
        mButtonLips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, LipsQ1Activity.class);
            }
        });
    }

    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        startActivity(intent);
    }
}