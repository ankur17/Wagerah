package com.wagerah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.wagerah.model.Authorise;
import com.wagerah.model.User;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String AUTH_TOKEN = "Bearer KA.eyJ2ZXJzaW9uIjoyLCJpZCI6InpoVUFiT2ljUzcrMCt4OU84b3NaYWc9PSIsImV4cGlyZXNfYXQiOjE1MjU2Njk0NzQsInBpcGVsaW5lX2tleV9pZCI6Ik1RPT0iLCJwaXBlbGluZV9pZCI6MX0.A2citAVwXjlccmx4H8JS-F6dXddYmB_kMvdnl7DyCn4";
    private String CLIENT_ID = "saJHcmpxmjuGezNO0gHDJeN_Z32zMtFr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        retrofitExperiments();
        uberLogin();
//        loginTesting();
//        authenticate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith("wagerah://callback")) {
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // get access token
                // we'll do that in a minute
                Log.d("TOKEN",code);
            } else if (uri.getQueryParameter("error") != null) {
                // show an error message here
                Log.d("TOKEN","elese "+uri.getQueryParameter("error"));

            }
            Log.d("TOKEN","kuch nahi hua");
        }
    }

    private void uberLogin() {

        String test_url  = "https://en.wikipedia.org/wiki/Internet";
//        String another_url  = "https://login.uber.com/oauth/v2/authorize?response_type=code&client_id=saJHcmpxmjuGezNO0gHDJeN_Z32zMtFr&scope=all_trips+history+history_lite+places+profile+request+request_receipt+ride_widgets&redirect_uri=wagerah://callback";
        String loginUrl = String.format("https://login.uber.com/oauth/v2/authorize?client_id=%s" +
                "&response_type=code&scope=all_trips+history+history_lite+places+profile+request+request_receipt+ride_widgets" +
                "&redirect_uri=%s", CLIENT_ID,"wagerah://aaz");


        Intent intent = new Intent(  Intent.ACTION_VIEW,   Uri.parse(loginUrl));
        startActivity(intent);

    }

    private void retrofitExperiments() {

        textView = (TextView) findViewById(R.id.message);
        textView.setText("Ankur ji");
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.uber.com/v1.2/");

        Retrofit retrofit = builder.build();

        UberClient user = retrofit.create(UberClient.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization",AUTH_TOKEN);
        map.put("Accept-Language" ,"en_US");
        map.put("Content-Type","application/json");

        user.getUser(map).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("RETRO",call+" "+response);
                if ( call.isExecuted() && response.isSuccessful()){

                    textView.setText(response.body().toString());
                } else if ( response.message().equals("Unauthorized") ) {
                    textView.setText("Unauthorized");
                    Toast.makeText(MainActivity.this,"unauthorised",Toast.LENGTH_LONG).show();
                } else {
                    textView.setText("Error");
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("RETRO",call+" "+t);
                t.getCause();
            }
        });
    }


    private void authenticate() {



        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://login.uber.com/oauth/v2/");

        Retrofit retrofit = builder.build();

        UberClient user = retrofit.create(UberClient.class);


        Map<String, String> map = new HashMap<>();
        map.put("client_secret", "Dvgp0HRKxRgPalKQnssVSzLzpEkLkd#_");
        map.put("client_id" ,CLIENT_ID);
        map.put("grant_type","authorization_code");
        map.put("Accept-Language" ,"en_US");
        map.put("Content-Type","application/json");
        map.put("code","d3CpxrXb1sFdTbdX2oyHDk2AtcgzQl#_");

        user.getMe(map).enqueue(new Callback<Authorise>() {
            @Override
            public void onResponse(Call<Authorise> call, Response<Authorise> response) {
                Log.d("RETRO",call+" "+response);
                if ( call.isExecuted() && response.isSuccessful()){

//                    textView.setText(response.body().toString());
                } else if ( response.message().equals("Unauthorized") ) {
//                    textView.setText("Unauthorized");
                    Toast.makeText(MainActivity.this,"unauthorised",Toast.LENGTH_LONG).show();
                } else {
//                    textView.setText("Error");
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Authorise> call, Throwable t) {
                Log.d("RETRO",call+" "+t);
                t.getCause();
            }
        });
    }


    private void loginTesting(){


    }
}
