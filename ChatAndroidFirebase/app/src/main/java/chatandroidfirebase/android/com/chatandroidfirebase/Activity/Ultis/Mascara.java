package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

/**
 * Created by renato on 21/01/17.
 */

public class Mascara {
   private SimpleMaskFormatter simpleMaskFormatter ;


    public void mascaraCelular(Boolean ddd,EditText editText){
        if(ddd){
            simpleMaskFormatter = new SimpleMaskFormatter("(NN) NNNNN-NNNN");

        }else{
            simpleMaskFormatter = new SimpleMaskFormatter("NNNNN-NNNN");

        }
        MaskTextWatcher maskTextWatcher =  new MaskTextWatcher(editText,simpleMaskFormatter);
        editText.addTextChangedListener(maskTextWatcher);
    }

    public void mascaraQuantidadeDigitos(Integer quantidade,EditText editText,Integer tipo){
        String mascara = new String();
        switch (tipo){
            case 1:
                for(int i = 1;i<= quantidade;i++){
                   mascara = mascara.concat("N");
                };break;
            case 2:
                for(int i = 1;i<= quantidade;i++){
                    mascara = mascara.concat("L");
                };break;
            default: mascara="";

        }
        simpleMaskFormatter = new SimpleMaskFormatter(mascara);
        MaskTextWatcher maskTextWatcher = new MaskTextWatcher(editText,simpleMaskFormatter);
        editText.addTextChangedListener(maskTextWatcher);
    }
}
