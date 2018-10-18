package com.adityayogapradipta.resepmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String nama = intent.getStringExtra("Nama");
        String ingredients = intent.getStringExtra("Ingredients");
        String process = intent.getStringExtra("Process");
        TextView tnama = findViewById(R.id.resep_nama);
        tnama.setText(nama);
        TextView tingredients = findViewById(R.id.resep_ingredients);
        tingredients.setText(ingredients);
        TextView tprocess = findViewById(R.id.resep_process);
        tprocess.setText(process);
    }

}
