package com.domain.deepcode;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        int imagemSelecionada = getIntent().getIntExtra("KEY_TELA1", 0);

        TextView tvNomeDoDoce = findViewById(R.id.tvNomeDoDoce);
        ImageView imageView = findViewById(R.id.ivDoce);

        String doce = "";

        if (imagemSelecionada == 1) {
            doce = "Donut";
            imageView.setImageResource(R.drawable.donut_circle);
        }
        else if (imagemSelecionada == 2) {
            doce = "Sorvete";
        }
        else if(imagemSelecionada == 3) {
            doce = "Biscoito";
        }
        else {
            doce = "Não encontrado";
        }

        tvNomeDoDoce.setText(doce);

    }
}
