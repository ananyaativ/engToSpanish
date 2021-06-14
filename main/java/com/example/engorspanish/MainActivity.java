package com.example.engorspanish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;
    public  void setLanguage(String language){
        sharedPreferences.edit().putString("language",language).apply();

        textView.setText(language);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.english:
                setLanguage("English");
                return true;
            case R.id.spanish:
                setLanguage("Spanish");
             return true;
            default:
                return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.example.engorspanish", Context.MODE_PRIVATE);
        textView = findViewById(R.id.textView);

        String language = sharedPreferences.getString("language", "Error");
        if (language.equals("Error")) {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Which language do you want?")
                    .setMessage("Choose either english or spanish")
                    .setPositiveButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setLanguage("Spanish");
                        }
                    })
                    .setNegativeButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setLanguage("English");


                        }
                    }).show();
        }
        else{
        textView.setText(language);
        }
    }
    }
