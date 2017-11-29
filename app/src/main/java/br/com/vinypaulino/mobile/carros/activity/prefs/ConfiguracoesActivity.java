package br.com.vinypaulino.mobile.carros.activity.prefs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import br.com.vinypaulino.mobile.carros.R;
import br.com.vinypaulino.mobile.carros.activity.BaseActivity;

public class ConfiguracoesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        setUpToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //adiciona o Fragment de configurações
        if (savedInstanceState == null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new PrefsFragment());
            ft.commit();
        }
    }

    public static class PrefsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            //Carrega as configurações
            addPreferencesFromResource(R.xml.preferences);

        }
    }
}
