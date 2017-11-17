package br.com.vinypaulino.mobile.carros.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.vinypaulino.mobile.carros.R;
import br.com.vinypaulino.mobile.carros.fragments.AboutDialog;
import br.com.vinypaulino.mobile.carros.fragments.CarrosFragment;

import static br.com.vinypaulino.mobile.carros.fragments.AboutDialog.*;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setUpNavDrawer();
        //inicia o layout Principal com o fragment dos carros
        replaceFragment(new CarrosFragment().newInstance(R.string.carros));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_about){
            showAbout(getSupportFragmentManager());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
