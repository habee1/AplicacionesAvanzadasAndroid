package com.android.aaa;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity{

    private AdView AdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView = (AdView)findViewById(R.id.anuncio_view);
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        AdView.loadAd(adRequest);
    }

    @Override
    protected void onDestroy() {
        if(AdView != null){
            AdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (AdView != null){
            AdView.resume();
        }
    }

    @Override
    protected void onPause() {
        if(AdView != null){
            AdView.pause();
        }
        super.onPause();
    }

}