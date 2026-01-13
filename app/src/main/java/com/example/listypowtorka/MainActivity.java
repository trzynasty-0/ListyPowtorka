package com.example.listypowtorka;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button dodajB;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> rzeczyDoZrobienia;
    private EditText opisNotatki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dodajB = findViewById(R.id.dodajB);
        listView = findViewById(R.id.lista);
        opisNotatki = findViewById(R.id.elementET);

        rzeczyDoZrobienia = new ArrayList<>();
        rzeczyDoZrobienia.add("Wyjście  do kina");
        rzeczyDoZrobienia.add("nauczyć sie");
        rzeczyDoZrobienia.add("fdsjkfrz");

        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                rzeczyDoZrobienia);

        listView.setAdapter(arrayAdapter);
    }
}