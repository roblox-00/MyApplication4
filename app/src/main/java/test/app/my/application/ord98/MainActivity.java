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


        final EditText EnterName = findViewById(R.id.edt_Enter_Name);
        final EditText EnterFamily = findViewById(R.id.edt_Enter_Family);
        final EditText EnterAge = findViewById(R.id.edt_Age);
        final EditText EnterEmail = findViewById(R.id.edt_Enter_Email_Address);
        final EditText EnterPhoneNumber = findViewById(R.id.edt_PhoneNumber);
        Button btnENTER = findViewById(R.id.btn_ENTER);

        EnterName.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name", ""));
        EnterFamily.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family", ""));
        EnterAge.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age", ""));
        EnterEmail.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("email", ""));
        EnterPhoneNumber.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("phone", ""));
        btnENTER.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String name = EnterName.getText().toString();
                                            String family = EnterFamily.getText().toString();
                                            String age = EnterAge.getText().toString();
                                            String email = EnterEmail.getText().toString();
                                            String PhoneNumber = EnterPhoneNumber.getText().toString();


                                            if (name.length() <= 3) {
                                                Toast.makeText(MainActivity.this, "نام را درست وارد کنید", Toast.LENGTH_LONG).show();

                                            } else if (family.length() <= 3) {
                                                Toast.makeText(MainActivity.this, "نام خانوادگی را درست وارد کنید", Toast.LENGTH_LONG).show();
                                            } else if (Integer.parseInt(age) < 0 && Integer.parseInt(age) > 999) {
                                                Toast.makeText(MainActivity.this, "سن را درست وارد کنید", Toast.LENGTH_LONG).show();

                                            } else if (email.length() <= 0 && !email.matches(email)) {
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



