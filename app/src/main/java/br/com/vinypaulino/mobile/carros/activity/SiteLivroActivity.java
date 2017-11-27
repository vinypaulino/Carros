package br.com.vinypaulino.mobile.carros.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.vinypaulino.mobile.carros.R;
import br.com.vinypaulino.mobile.carros.fragments.CarrosFragment;
import br.com.vinypaulino.mobile.carros.fragments.SiteLivroFragment;

public class SiteLivroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_livro);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Adiciona o fragment com o mesmo Bundle (args) da intent
        if (savedInstanceState == null) {
            SiteLivroFragment frag = new SiteLivroFragment();
            frag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.container, frag).commit();
        }
    }
}
