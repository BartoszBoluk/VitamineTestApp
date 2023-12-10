package com.example.vitaminetestapp.eyequestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vitaminetestapp.MainActivity;
import com.example.vitaminetestapp.R;

import java.util.ArrayList;

public class EyeResultActivity extends AppCompatActivity {

    TextView mEyeResult;
    Button mButtonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_result);

        ArrayList<Boolean> myList = (ArrayList<Boolean>) getIntent().getSerializableExtra("StringKey");

        mEyeResult = findViewById(R.id.mResult);
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

        if (list.get(0).equals(false) && list.get(1).equals(false))
            resultText = "Nie brakuje ci witamin";
        if (list.get(0).equals(true))
            resultText += "- Brakuje ci witaminy B i K\n";
        if (list.get(1).equals(true))
            resultText += "- Brakuje ci witaminy A\n";

        mEyeResult.setText(resultText);
    }
}