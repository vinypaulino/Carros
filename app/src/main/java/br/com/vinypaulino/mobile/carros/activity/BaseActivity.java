package br.com.vinypaulino.mobile.carros.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.vinypaulino.mobile.carros.R;
import android.support.v4.app.Fragment;

import br.com.vinypaulino.mobile.carros.activity.prefs.ConfiguracoesActivity;
import br.com.vinypaulino.mobile.carros.fragments.CarrosFragment;
import br.com.vinypaulino.mobile.carros.fragments.CarrosTabFragment;
import br.com.vinypaulino.mobile.carros.fragments.SiteLivroFragment;
import livroandroid.lib.utils.IntentUtils;
import livroandroid.lib.utils.NavDrawerUtil;



/**
 * Created by Naja on 16/11/2017.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {
    protected DrawerLayout drawerLayout;


    protected void setUpToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
    //Configura o nav drawer
    protected void setUpNavDrawer() {
        // Drawer Layout
        final ActionBar actionBar = getSupportActionBar();
        // Ícone do menu do nav drawer
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null && drawerLayout != null) {
            // Atualiza a imagem e textos do header
            NavDrawerUtil.setHeaderValues(navigationView, R.id.containerNavDrawerListViewHeader, R.drawable.nav_drawer_header, R.drawable.ic_no_image, R.string.nav_drawer_username, R.string.nav_drawer_email);
            // Trata o evento de clique no menu.
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            // Seleciona a linha
                            menuItem.setChecked(true);
                            // Fecha o menu
                            drawerLayout.closeDrawers();
                            // Trata o evento do menu
                            onNavDrawerItemSelected(menuItem);
                            return true;
                        }
                    });
        }
    }
    //Trata o evento do menu Lateral
    private void onNavDrawerItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_carros_todos:
                // Nada aqui pois somente a MainActivity possui menu lateral
                break;
            case R.id.nav_item_carros_classicos:
                Intent intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.classicos);
                startActivity(intent);
                break;
            case R.id.nav_item_carros_esportivos:
                intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.esportivos);
                startActivity(intent);
                break;
            case R.id.nav_item_carros_luxo:
                intent = new Intent(getContext(), CarrosActivity.class);
                intent.putExtra("tipo", R.string.luxo);
                startActivity(intent);
                break;
            case R.id.nav_item_site_livro:
                startActivity(new Intent(getContext(), SiteLivroActivity.class));
                break;
            case R.id.nav_item_settings:
                startActivity(new Intent(this, ConfiguracoesActivity.class));
                break;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                //trata o clique no botão que abre o menu
                if (drawerLayout != null){
                    openDrawer();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }
    // Abre o menu lateral
    protected void openDrawer(){
        if(drawerLayout != null) {drawerLayout.openDrawer(GravityCompat.START);}
    }
    // Fecha o menu lateral
    protected void closeDrawer(){
        if (drawerLayout != null) {drawerLayout.closeDrawer(GravityCompat.START);}
    }

}

