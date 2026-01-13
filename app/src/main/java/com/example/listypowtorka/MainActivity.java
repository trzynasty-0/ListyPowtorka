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
import android.widget.Spinner;
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
    private ArrayAdapter<Rzecz> arrayAdapter;
    private ArrayList<Rzecz> rzeczyDoZrobienia;
    private EditText opisNotatki;
    private Spinner priorytetSp;


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
        priorytetSp = findViewById(R.id.priorytetSp);

        rzeczyDoZrobienia = new ArrayList<>();
        rzeczyDoZrobienia.add(new Rzecz("Wyjście  do kina", (byte) 1));
        rzeczyDoZrobienia.add(new Rzecz("Nauczyć się robienia list w mobilnej", (byte) 2));
        rzeczyDoZrobienia.add(new Rzecz("Pomyśleć o projekcie", (byte) 0));

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
                        byte priorytet = (byte) priorytetSp.getSelectedItemPosition();
                        rzeczyDoZrobienia.add(new Rzecz(opis, priorytet));
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