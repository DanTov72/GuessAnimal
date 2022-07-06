package com.example.lesson1android1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    boolean isGiraffe, isDog, isCat;
    Button btnResult;
    String nameAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.animalImage);
        btnResult = findViewById(R.id.btn_result);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("key", nameAnimal);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void changeImage(View view) {
        switch (view.getId()) {
            case R.id.btn_cat:
                imageView.setImageResource(R.drawable.cat);
                nameAnimal = "Cat";
                isCat = true;
                isDog = false;
                isGiraffe = false;
                break;
            case R.id.btn_dog:
                imageView.setImageResource(R.drawable.dog);
                nameAnimal = "Dog";
                isGiraffe = false;
                isDog = true;
                isCat = false;
                break;
            case R.id.btn_giraffe:
                imageView.setImageResource(R.drawable.giraffe);
                nameAnimal = "Giraffe";
                isDog = false;
                isCat = false;
                isGiraffe = true;
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void answer(View view) {
        switch (view.getId()) {
            case R.id.btn_that_cat:
                if (isCat) {
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_that_dog:
                if (isDog) {
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_that_giraffe:
                if (isGiraffe) {
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}