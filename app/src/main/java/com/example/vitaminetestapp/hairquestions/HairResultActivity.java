package com.example.vitaminetestapp.hairquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vitaminetestapp.MainActivity;
import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class HairResultActivity extends AppCompatActivity {

    TextView mHairResult;
    Button mButtonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_result);

        ArrayList<Boolean> HairAnswers = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mHairResult = findViewById(R.id.mResult);
        mButtonReturn = findViewById(R.id.mButtonReturn);

        mButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, MainActivity.class);
            }
        });

        createResultString(HairAnswers);
    }

    private void startActivity(View v, Class directed_class) {
        Intent intent = new Intent(this, directed_class);
        startActivity(intent);
    }

    /*
     * Fukcja tworzy końcowego Stringa, na podstawie odpowiedzi na poprzednie pytania. Odpowiedzi
     * bierze z ArrayListy.
     */
    private void createResultString(ArrayList<Boolean> list) {

        String resultText = "";

        if (list.get(0).equals(false) && list.get(1).equals(false) && list.get(2).equals(false) &&
                list.get(3).equals(false))
            resultText = "Nie brakuje ci witamin";
        else if (list.get(0).equals(true) && list.get(1).equals(false))
            resultText += "- Brakuje ci witaminy B \n";
        else if (list.get(0).equals(false) && list.get(1).equals(true))
            resultText += "- Brakuje ci witaminy B, białka i kwasów tłuszczowych \n";
        else if (list.get(0).equals(true) && list.get(1).equals(true))
            resultText += "- Brakuje ci witaminy B, białka i kwasów tłuszczowych \n";

        if (list.get(2).equals(true) && list.get(3).equals(false))
            resultText += "- Brakuje ci białka i cynku \n";
        else if (list.get(2).equals(false) && list.get(3).equals(true))
            resultText += "- Brakuje ci białka \n";
        else if (list.get(2).equals(true) && list.get(3).equals(true))
            resultText += "- Brakuje ci białka i cynku \n";


        mHairResult.setText(resultText);
    }
}