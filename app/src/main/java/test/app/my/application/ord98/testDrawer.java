package test.app.my.application.ord98;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class testDrawer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drawer);


        TextView txtOghat = findViewById(R.id.txt_Oghat);
        txtOghat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(testDrawer.this, OghatSharei.class);
                startActivity(intent);
            }
        });


        TextView txtinstagram = findViewById(R.id.txt_instagram);
        txtinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testDrawer.this, testUri.class);
                startActivity(intent);
            }
        });


        TextView txtlistView = findViewById(R.id.txt_listview);
        txtlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testDrawer.this, testRecycler.class);
                startActivity(intent);
            }
        });


        Button btnsavedata = findViewById(R.id.btn_Save_Data);
        btnsavedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testDrawer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
