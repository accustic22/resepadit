package com.adityayogapradipta.resepmakanan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Resep> resep = new LinkedList<Resep>();
    private LinkedList<String> resep_nama = new LinkedList<String>();
    private LinkedList<String> resep_detail = new LinkedList<String>();
    private LinkedList<String> resep_ingredients = new LinkedList<String>();
    private LinkedList<String> resep_process = new LinkedList<String>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resep.add(new Resep("Nasi Uduk","Nasi adalah Nasi yang proses merebusnya menggunakan air santan", "1. Beras\n2. santan\n3. telur dadar\n4. garam\n5. bawang putih\n6. bawang merah", "1.process"));
        resep.add(new Resep("Nasi Pecel","Nasi Pecel adalah Nasi yang dicampur dengan sayuran dan bumbu kacang", "1. Nasi\n2. Sayur\n3. Bumbu Kacang", "1.process"));
        resep.add(new Resep("Nasi Rames","Nasi Rames adalah nasi campur sayurdan lauk. biasanya dcampur dengan lauk lain.", "1. Nasi\n2. Sayuran", "1.process"));
        resep_process.add("1.process");
        setContentView(R.layout.activity_main);
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        for(int i = 0; i < resep.size(); i++){
            resep_nama.add(resep.get(i).nama);
            resep_detail.add(resep.get(i).detail);
            resep_ingredients.add(resep.get(i).ingredients);
            resep_process.add(resep.get(i).proses);
        }
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, resep_nama, resep_detail, resep_ingredients, resep_process);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

