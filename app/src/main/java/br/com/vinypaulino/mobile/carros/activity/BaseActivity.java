package br.com.vinypaulino.mobile.carros.activity;

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
import br.com.vinypaulino.mobile.carros.fragments.CarrosFragment;
import br.com.vinypaulino.mobile.carros.fragments.SiteLivroFragment;
import livroandroid.lib.utils.IntentUtils;
import livroandroid.lib.utils.NavDrawerUtil;



/**
 * Created by Naja on 16/11/2017.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {
    protected DrawerLayout drawerLayout;


    protected void setUpToolBar() {
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
    private void onNavDrawerItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.nav_item_carros_todos:
                replaceFragment(new CarrosFragment().newInstance(R.string.carros));
                break;

            case R.id.nav_item_carros_classicos:
                replaceFragment(new CarrosFragment().newInstance(R.string.classicos));
                break;

            case R.id.nav_item_carros_esportivos:
                replaceFragment(new CarrosFragment().newInstance(R.string.esportivos));
                break;

            case R.id.nav_item_carros_luxo:
                replaceFragment(new CarrosFragment().newInstance(R.string.luxo));
                break;

            case R.id.nav_item_site_livro:
                replaceFragment(new SiteLivroFragment());
                break;

            case R.id.nav_item_settings:
                toast("Clicou em Configurações");
                break;
        }

    }

    protected void replaceFragment(Fragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,frag, "TAG").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                //trata o clique nno botão que abre o menu
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

