package com.example.vitaminetestapp.lipsquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vitaminetestapp.MainActivity;
import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class LipsResultActivity extends AppCompatActivity {

    TextView mLipsResult;
    Button mButtonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lips_result);

        ArrayList<Boolean> myList = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mLipsResult = findViewById(R.id.mResult);
        mButtonReturn = findViewById(R.id.mButtonReturn);

        mButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(v, MainActivity.class);
            }
        });

        createResultString(myList);
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

        if (list.get(0).equals(false) && list.get(1).equals(false) && list.get(2).equals(false))
            resultText = "Nie brakuje Ci witamin";
        else if (list.get(0).equals(true) && list.get(1).equals(false))
            resultText += "- Brakuje Ci witamin A, B-complex i cynku.\n";
        else if (list.get(0).equals(false) && list.get(1).equals(true))
            resultText += "- Brakuje Ci witaminy B-complex.\n";
        else if (list.get(0).equals(true) && list.get(1).equals(true))
            resultText += "- Brakuje Ci witamin A, B-complex i cynku.\n";

        if (list.get(2).equals(true))
            resultText += "- Brakuje Ci witamin B1, B2, B3\n";

        mLipsResult.setText(resultText);
    }
}