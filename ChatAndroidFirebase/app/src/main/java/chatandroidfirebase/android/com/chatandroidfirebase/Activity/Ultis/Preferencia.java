package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by renato on 22/01/17.
 */

public class Preferencia {
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    //constantes
    private final String NOME_ARQUIVO ="ChatAndroidPreference";
    private final int MODE = 0;
    private final String CHAVE_NOME ="NOME";
    private final String CHAVE_TEL = "TEL";
    private final String CHAVE_TOKEN ="TOKEN";

    public Preferencia (Context context){
        this.context = context;
        preferences = this.context.getSharedPreferences(NOME_ARQUIVO,MODE);
        editor = preferences.edit();


    }

    public void salvarUsuarioPreferencias(String nome,String tel , String token){
        editor.putString(CHAVE_NOME,nome);
        editor.putString(CHAVE_TEL,tel);
        editor.putString(CHAVE_TOKEN,token);
        editor.commit();


    }
    public HashMap<String,String> getPregerences(){
        HashMap<String,String> dadosUsuario = new HashMap<>();

        dadosUsuario.put(CHAVE_NOME,preferences.getString(CHAVE_NOME,null));
        dadosUsuario.put(CHAVE_TEL,preferences.getString(CHAVE_TEL,null));
        dadosUsuario.put(CHAVE_TOKEN,preferences.getString(CHAVE_TOKEN,null));
        return dadosUsuario;
    }
}
