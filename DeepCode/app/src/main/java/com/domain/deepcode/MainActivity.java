package com.domain.deepcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int contadorDeClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btToast = findViewById(R.id.btToast);

        // PEGAR A REFERÊNCIA DO BOTÃO E TO TEXTVIEW

        Button mCount = findViewById(R.id.btCount);

        TextView mTvNumber = findViewById(R.id.tvNumber);
        mTvNumber.setText("0");

        btToast.setOnClickListener(view -> {
            Toast.makeText(this, "Hello Toast" + contadorDeClicks, Toast.LENGTH_LONG).show();
        });

        // COLOCAR UM CLICK NO BOTÃO
        mCount.setOnClickListener(view -> {

            contadorDeClicks += 1;
            mTvNumber.setText(String.valueOf(contadorDeClicks));

        });

    }
}