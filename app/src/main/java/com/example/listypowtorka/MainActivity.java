package com.example.listypowtorka;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
        rzeczyDoZrobienia.add("Nauczyć się robienia list w mobilnej");
        rzeczyDoZrobienia.add("Pomyśleć o projekcie");

        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                rzeczyDoZrobienia);

        listView.setAdapter(arrayAdapter);

        dodajB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String opis = opisNotatki.getText().toString();
                        rzeczyDoZrobienia.add(opis);
                        arrayAdapter.notifyDataSetChanged();
                        opisNotatki.setText("");
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        TextView textView = (TextView) view;
                        if(textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG){
                            textView.setPaintFlags(0);
                            view.setBackgroundColor(Color.WHITE);

                        }
                        else{
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            view.setBackgroundColor(Color.GRAY);

                        }
                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        rzeczyDoZrobienia.remove(i);
                        arrayAdapter.notifyDataSetChanged();

                        return false;
                    }
                }
        );
    }
}