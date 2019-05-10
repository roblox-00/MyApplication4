package test.app.my.application.ord98;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final TextView tvName = findViewById(R.id.tv_name);
        final TextView tvFamily = findViewById(R.id.tv_family);
        final TextView tvAge = findViewById(R.id.tv_age);
        final TextView tvEmail = findViewById(R.id.tv_email);
        final TextView tvPhone = findViewById(R.id.tv_PhoneNumber);
        Button btnYes = findViewById(R.id.btn_yes);
        Button btnNo = findViewById(R.id.btn_no);


        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvFamily.setText(intent.getStringExtra("family"));
        tvAge.setText(intent.getStringExtra("age"));
        tvEmail.setText(intent.getStringExtra("email"));
        tvPhone.setText(intent.getStringExtra("phone"));
        btnYes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit().putString("name", tvName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit().putString("family", tvFamily.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit().putString("age", tvAge.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit().putString("email", tvEmail.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit().putString("phone", tvPhone.getText().toString()).apply();

                Intent intentOK = new Intent();
                setResult(RESULT_OK, intentOK);
                finish();
            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNo = new Intent();
                setResult(RESULT_CANCELED, intentNo);
                finish();
            }
        });
    }
}























