package br.com.vinypaulino.mobile.carros.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.vinypaulino.mobile.carros.R;
import br.com.vinypaulino.mobile.carros.fragments.CarrosFragment;

public class CarrosActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Titulo
        getSupportActionBar().setTitle(getString(getIntent().getIntExtra("tipo", 0)));
        //Adiciona o framgment com o mesmo Budle (args) da Intent
        if (savedInstanceState == null){
            CarrosFragment frag = new CarrosFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, frag).commit();
        }
    }
}
