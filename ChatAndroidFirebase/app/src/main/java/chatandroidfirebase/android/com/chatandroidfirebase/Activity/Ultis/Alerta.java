package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by renato on 22/01/17.
 */

public class Alerta {
    private Toast toast;

    public void alertaSimples(Context context, String msg, Integer duracao){
        if(duracao == 0){
            toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            toast = Toast.makeText(context,msg,Toast.LENGTH_LONG);

        }
    }
}
