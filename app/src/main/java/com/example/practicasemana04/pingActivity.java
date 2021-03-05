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

public class pingActivity extends AppCompatActivity {

    private TextView ping1;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        ping1= findViewById(R.id.ping1);

        btnBack = findViewById(R.id.btnBack);


        String ipFinal = getIntent().getExtras().getString("ping");


        new Thread(
                ()->{
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getByName(ipFinal);
                        for (int i = 0; i < 5; i++) {
                            boolean conectado = inet.isReachable(3000);

                            Log.e(">>>", "conectado: " + conectado);

                            runOnUiThread(
                                    ()->{
                                        if (conectado){
                                            ping1.append("Recibido\n");
                                        }else {
                                            ping1.append("Perdido\n");
                                        }
                                    }
                            );
                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();



        btnBack.setOnClickListener(
                (v) -> {
                    Intent m = new Intent(this, MainActivity.class);
                    startActivity(m);
                    finish();
                }
        );

    }
}