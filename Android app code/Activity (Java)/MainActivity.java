package com.example.car_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE = 100;

    String address;
    String name;
    BluetoothSocket btSocket;
    BluetoothAdapter bluetooth;
    Set<BluetoothDevice> pairedDevices;



    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bluetooth = BluetoothAdapter.getDefaultAdapter();
        pairedDevices = bluetooth.getBondedDevices();



        if (pairedDevices.size()>0)
        {
            for(BluetoothDevice bt : pairedDevices)
            {
                name = bt.getName().toString();
                address = bt.getAddress().toString();


            }
            Toast.makeText(getApplicationContext(),name+" "+address, Toast.LENGTH_SHORT).show();
            BluetoothDevice device = bluetooth.getRemoteDevice(address);
            try {
                btSocket = device.createInsecureRfcommSocketToServiceRecord(myUUID);
                btSocket.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }







    }

    public void speak(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Need to speak");
        try {
            startActivityForResult(intent, REQ_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry your device not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String voice = result.get(0).toString();
                    double[] features = DecisionTreeClassifier.getFeautres(voice);
                    int output = DecisionTreeClassifier.predict(features);

                    char command = 'g';
                    switch (output){
                        case 0: command = 'a';
                            break;
                        case 1: command = 'b';
                            break;
                        case 2: command = 'c';
                            break;
                        case 3: command = 'd';
                            break;
                        case 4: command = 'e';
                            break;
                        case 5: command = 'f';
                            break;
                        case 6: command = 'g';
                            break;

                    }

                    try {
                        btSocket.getOutputStream().write(String.valueOf(command).getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
            }
        }
    }


    public void stop(View view) {
        try {
            btSocket.getOutputStream().write(String.valueOf('g').getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}