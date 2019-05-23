package test.app.my.application.ord98;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.orhanobut.hawk.Hawk;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import test.app.my.application.ord98.json.OghatJson;

public class OghatSharei extends AppCompatActivity {
    TextView txtfajr, txttolo, txtzohr, txtasr, txtmaghreb, txtesha;
    EditText txtcity;
    Button btncity;
    String fajr, tolo, zohr, asr, maghreb, esha;
    RecyclerView recyclerView;
    ArrayList<String> citylist = new ArrayList<>();
    OghatAdapter oghatAdapter = new OghatAdapter(citylist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oghat_sharei);
        recyclerView = findViewById(R.id.recycler_oghat);
        txtfajr = findViewById(R.id.txt_fajr);
        txttolo = findViewById(R.id.txt_tolo);
        txtzohr = findViewById(R.id.txt_zohr);
        txtasr = findViewById(R.id.txt_asr);
        txtmaghreb = findViewById(R.id.txt_maghreb);
        txtesha = findViewById(R.id.txt_esha);
        txtcity = findViewById(R.id.txt_city);
        btncity = findViewById(R.id.btn_city);
        txtcity.setText("");
        btncity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtcity.length() == 0) {
                    Toast.makeText(OghatSharei.this, " شهر را وارد کنید", Toast.LENGTH_SHORT).show();
                    txtcity.findFocus();
                    return;
                }
            }
        });
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://api.aladhan.com/v1/timingsByCity?city=" + txtcity.getText().toString() + "&country=Iran&method=8", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    getoghat(response);
                } catch (Exception e) {
                    Toast.makeText(OghatSharei.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
        recyclerView.setAdapter(oghatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(OghatSharei.this, RecyclerView.HORIZONTAL, true));
    }

    public void getoghat(JSONObject response) {
        Gson gson = new Gson();
        OghatJson oghatJson = gson.fromJson(response.toString(), OghatJson.class);
        fajr = oghatJson.getData().getTimings().getFajr();
        tolo = oghatJson.getData().getTimings().getSunrise();
        zohr = oghatJson.getData().getTimings().getDhuhr();
        asr = oghatJson.getData().getTimings().getAsr();
        maghreb = oghatJson.getData().getTimings().getMaghrib();
        esha = oghatJson.getData().getTimings().getIsha();
        txtfajr.setText(fajr);
        txtasr.setText(asr);
        txtesha.setText(esha);
        txtmaghreb.setText(maghreb);
        txttolo.setText(tolo);
        txtzohr.setText(zohr);
    }

    private void sethawk() {
        Hawk.init(this).build();
        Hawk.put("fajrkey", fajr);
        Hawk.put("tolokey", tolo);
        Hawk.put("zohrkey", zohr);
        Hawk.put("asrkey", asr);
        Hawk.put("maghrebkey", maghreb);
        Hawk.put("eshakey", esha);
    }
}

