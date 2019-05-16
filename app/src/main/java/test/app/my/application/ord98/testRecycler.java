package test.app.my.application.ord98;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class testRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler);


        RecyclerView recycler = findViewById(R.id.recycler);
        testAdapter adapter = new testAdapter();

        recycler.setAdapter(adapter);

        recycler.setLayoutManager(new LinearLayoutManager(testRecycler.this, RecyclerView.VERTICAL, false));


    }
}
