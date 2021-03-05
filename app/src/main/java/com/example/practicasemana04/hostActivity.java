package com.example.practicasemana04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class hostActivity extends AppCompatActivity {

    private TextView host;
    private Button btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        host = findViewById(R.id.host);
        btnBack2 = findViewById(R.id.btnBack2);

        new  Thread(
                ()->{
                    String base = "192.168.20.";

                    for (int i=1;i<255;i++){
                        String ipHost = base + i;
                        InetAddress inet2;

                        try {
                            inet2 = InetAddress.getByName(ipHost);
                            boolean conectado = inet2.isReachable(1000);
                            if(conectado){
                                runOnUiThread(
                                        ()->{
                                            host.append(ipHost+"\n");
                                        }
                                );
                                Log.e("----->"," " + inet2);
                            }

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        btnBack2.setOnClickListener(
                (v)->{
                    Intent z = new Intent(this, MainActivity.class);
                    startActivity(z);
                    finish();
                }
        );
    }
}