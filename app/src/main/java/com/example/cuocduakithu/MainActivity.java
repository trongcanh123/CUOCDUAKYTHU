package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button batdau;
    TextView diem;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    int d=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
        Chon();
        CountDownTimer countDownTimer = new CountDownTimer(20000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int n=3;
                Random random = new Random();
                int s = random.nextInt(n);
                int s2 = random.nextInt(n);
                int s3 = random.nextInt(n);
                if(sb1.getProgress()>=sb1.getMax()){
                    this.cancel();
                    batdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Chicken win", Toast.LENGTH_SHORT).show();
                    if(cb1.isChecked()){
                        co();
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                        d+=5;
                        diem.setText(d+" ");
                    }
                    else{
                        co();
                        Toast.makeText(MainActivity.this, "You loss", Toast.LENGTH_SHORT).show();
                        d-=5;
                        diem.setText(d+" ");
                    }
                }
                else if(sb2.getProgress()>=sb2.getMax()){
                    this.cancel();
                    batdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dog win", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        co();
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                        d+=5;
                        diem.setText(d+" ");
                    }
                    else{
                        co();
                        Toast.makeText(MainActivity.this, "You loss", Toast.LENGTH_SHORT).show();
                        d-=5;
                        diem.setText(d+" ");
                    }
                }
                else if(sb3.getProgress()>=sb3.getMax()){
                    this.cancel();
                    batdau.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Pig win", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        co();
                        Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                        d+=5;
                        diem.setText(d+" ");
                    }
                    else{
                        co();
                        Toast.makeText(MainActivity.this, "You loss", Toast.LENGTH_SHORT).show();
                        d-=5;
                        diem.setText(d+" ");
                    }
                }
                sb1.setProgress(sb1.getProgress()+s);
                sb2.setProgress(sb3.getProgress()+s2);
                sb3.setProgress(sb3.getProgress()+s3);
            }

            @Override
            public void onFinish() {

            }
        };
        batdau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked()||cb2.isChecked()||cb3.isChecked()) {
                    ko();
                    batdau.setVisibility(View.INVISIBLE);
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    countDownTimer.start();
                }
                else{
                    Toast.makeText(MainActivity.this, "You must choice before you start!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void AnhXa(){
        batdau = (Button) findViewById(R.id.batdau);
        diem = (TextView) findViewById(R.id.diem);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        sb1 = (SeekBar) findViewById(R.id.seekbar1);
        sb2 = (SeekBar) findViewById(R.id.seekbar2);
        sb3 = (SeekBar) findViewById(R.id.seekbar3);
    }
    private void Chon(){
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb1.isChecked()){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb2.isChecked()){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb3.isChecked()){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
    }
    private void co(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void ko(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
}