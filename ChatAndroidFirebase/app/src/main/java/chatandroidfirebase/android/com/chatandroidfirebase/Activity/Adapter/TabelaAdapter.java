package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Fragment.ContatosFragment;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Fragment.ConversasFragment;

/**
 * Created by renato on 28/01/17.
 */

public class TabelaAdapter extends FragmentStatePagerAdapter {
    private String[] titulosTabela = {"Conversas","Contatos"};

    public TabelaAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // retornar o fragmento a ser usado
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new ConversasFragment();
                break;
            case 1:
                fragment = new ContatosFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        //Quantidade de  titulos
        return  titulosTabela.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Obter titulo da aba pela position
        return titulosTabela[position];
    }
}
