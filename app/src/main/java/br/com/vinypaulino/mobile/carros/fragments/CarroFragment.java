package br.com.vinypaulino.mobile.carros.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import br.com.vinypaulino.mobile.carros.CarrosApplication;
import br.com.vinypaulino.mobile.carros.R;
import br.com.vinypaulino.mobile.carros.activity.CarroActivity;
import br.com.vinypaulino.mobile.carros.domain.Carro;
import br.com.vinypaulino.mobile.carros.domain.CarroDB;
import br.com.vinypaulino.mobile.carros.fragments.dialog.DeletarCarroDialog;
import br.com.vinypaulino.mobile.carros.fragments.dialog.EditarCarroDialog;

public class CarroFragment extends BaseFragment {
    private Carro carro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carro, container, false);
        carro = Parcels.unwrap(getArguments().getParcelable("carro"));
        setHasOptionsMenu(true); // Precisamos informar o android que este fragment contém menu
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //Atualiza a view do fragment com os dados do carro
        setTextString(R.id.tDesc, carro.desc);
        final ImageView imgView = (ImageView) getView().findViewById(R.id.img);
        Picasso.with(getContext()).load(carro.urlFoto).fit().into(imgView);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_frag_carro, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit){
           // toast("Editar: " + carro.nome);
            EditarCarroDialog.show(getFragmentManager(), carro, new EditarCarroDialog.Callback() {
                @Override
                public void onCarroUpdated(Carro carro) {
                    toast("Carro [" + carro.nome + "] atualizado");
                    // Salva o carro
                    CarroDB db = new CarroDB(getContext());
                    db.save(carro);
                    // Atualiza o título com o novo nome
                    CarroActivity a = (CarroActivity) getActivity();
                    a.setTitle(carro.nome);
                    // Envia o evento para o bus
                    CarrosApplication.getInstance().getBus().post("refresh");
                }
            });
            return true;
        } else if (item.getItemId() == R.id.action_delete){
           // toast("Deletar: " + carro.nome);
            DeletarCarroDialog.show(getFragmentManager(), new DeletarCarroDialog.Callback() {
                @Override
                public void onClickYes() {
                    toast("Carro [" + carro.nome + "] deletado.");
                    // Deleta o carro
                    CarroDB db = new CarroDB(getActivity());
                    db.delete(carro);
                    // Fecha a activity
                    getActivity().finish();
                    // Envia o evento para o bus
                    CarrosApplication.getInstance().getBus().post("refresh");
                }
            });
            return true;
        } else if (item.getItemId() == R.id.action_share){
            toast("Compartilhar");
        } else if(item.getItemId() == R.id.action_maps){
            toast("Mapa");
        } else if (item.getItemId() == R.id.action_video){
            toast("Video");
        }

        return super.onOptionsItemSelected(item);
    }
}
