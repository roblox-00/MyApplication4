package test.app.my.application.ord98;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtEnterName = findViewById(R.id.txt_Enter_Name);
        final EditText txtFamily = findViewById(R.id.txt_family);
        final EditText txtAge = findViewById(R.id.txt_Age);
        final EditText txtEmail = findViewById(R.id.txt_Enter_Email_Address);
        final EditText txtPhoneNumber = findViewById(R.id.txt_PhoneNumber);
        Button btnENTER = findViewById(R.id.btn_ENTER);

        txtEnterName.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name", ""));
        txtFamily.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family", ""));
        txtAge.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age", ""));
        txtPhoneNumber.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("PhoneNumber", ""));
        txtEmail.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("email", ""));
        btnENTER.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String name = txtEnterName.getText().toString();
                                            String family = txtFamily.getText().toString();
                                            String age = txtAge.getText().toString();
                                            String email = txtEmail.getText().toString();
                                            String PhoneNumber = txtPhoneNumber.getText().toString();


                                            if (name.length() <= 3) {
                                                Toast.makeText(MainActivity.this, "نام را درست وارد کنید", Toast.LENGTH_LONG).show();

                                            } else if (family.length() <= 3) {
                                                Toast.makeText(MainActivity.this, "نام خانوادگی را درست وارد کنید", Toast.LENGTH_LONG).show();
                                            } else if (Integer.parseInt(age) < 0 && Integer.parseInt(age) > 999) {
                                                Toast.makeText(MainActivity.this, "سن را درست وارد کنید", Toast.LENGTH_LONG).show();

                                            } else if (!email.matches(email) && txtEmail.length() <= 0) {
                                                Toast.makeText(MainActivity.this, "ايميل را درست وارد کنید", Toast.LENGTH_LONG).show();

                                            } else if (PhoneNumber.length() >= 12) {
                                                Toast.makeText(MainActivity.this, "شماره موبایل را درست وارد کنید", Toast.LENGTH_LONG).show();
                                            } else {

                                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                                intent.putExtra("name", name);
                                                intent.putExtra("family", family);
                                                intent.putExtra("age", age);
                                                intent.putExtra("email", email);
                                                intent.putExtra("phone", PhoneNumber);
                                                startActivityForResult(intent, 999);
                                            }


                                        }
                                    }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 999)) {
            if (resultCode == RESULT_OK) {

                Toast.makeText(this, "***Info... was saved***", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "***Info... Could not be saved***", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestart");
    }
}



