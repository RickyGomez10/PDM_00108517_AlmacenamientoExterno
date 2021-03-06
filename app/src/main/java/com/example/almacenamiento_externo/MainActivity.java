package com.example.almacenamiento_externo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "example.txt";

    EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mEditText = findViewById(R.id.edit_text);

        }

        public void save(View v){
            String text = mEditText.getText().toString();
            FileOutputStream fos = null;
            try {
                     fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
                             fos.write(text.getBytes());
                     mEditText.getText().clear();
                Toast.makeText(this, "Saved to"+getFilesDir()+"/"+FILE_NAME, Toast.LENGTH_SHORT).show();

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        public void load(View v){
        FileInputStream fis = null;
            try {
                fis=openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }






}
