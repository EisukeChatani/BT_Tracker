package com.example.bttracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {
    TextView accessData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        EditText userInput = (EditText) findViewById(R.id.LogInputData);
        accessData = (TextView)findViewById(R.id.showBTData);
        Bundle transferredData = getIntent().getExtras();
        String s = transferredData.getString("BT_data");
        String txt = "Your input body temperature is " + s;
        accessData.setText(txt);
    }

    public void goToLogActivity(View view) {
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void confirmBT(View view) {
        Intent toConfirm = new Intent(this, ConfirmActivity.class);
        Notification.MessagingStyle.Message userInput = null;
        toConfirm.putExtra("BT_data", userInput.getText().toString());
        startActivity(toConfirm);
    }
}
