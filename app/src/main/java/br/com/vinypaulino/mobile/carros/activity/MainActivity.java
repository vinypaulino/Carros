package br.com.vinypaulino.mobile.carros.activity;

import android.os.Bundle;
import br.com.vinypaulino.mobile.carros.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setUpNavDrawer();
    }
}
