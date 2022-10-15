package com.domain.deepcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private int imagemClicada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1 = findViewById(R.id.ivDounts);
        TextView tvDonut = findViewById(R.id.tvLegendaDonut);

        ImageView img2 = findViewById(R.id.ivSorvete);
        ImageView img3 = findViewById(R.id.ivBiscoito);

        img1.setOnClickListener(view -> {
            imagemClicada = 1;
            Toast.makeText(this, "Donut", Toast.LENGTH_LONG).show();
            tvDonut.setBackgroundColor(Color.CYAN);
        });

        img2.setOnClickListener(view -> {
            imagemClicada = 2;
            Toast.makeText(this, "Sorvete", Toast.LENGTH_LONG).show();
        });

        img3.setOnClickListener(view -> {
            imagemClicada = 3;
            Toast.makeText(this, "Biscoito", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton button = findViewById(R.id.floatingActionButton);

        button.setOnClickListener(view -> {

            Intent intencao = new Intent(this, MainActivity3.class);

            intencao.putExtra("KEY_TELA1", imagemClicada);

            startActivity(intencao);

        });

    }
}