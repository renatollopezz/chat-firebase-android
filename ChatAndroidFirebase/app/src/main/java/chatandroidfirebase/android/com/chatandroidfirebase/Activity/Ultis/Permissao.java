package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by renato on 22/01/17.
 */

public class Permissao {

    public static Boolean validarPermissoes(Activity activity,String[] permissoes,Integer requestCode){
        if (Build.VERSION.SDK_INT >= 23){
            for(String permissao :permissoes){
                if(ContextCompat.checkSelfPermission(activity,permissao)== PackageManager.PERMISSION_GRANTED){
                }else {
                    ActivityCompat.requestPermissions(activity,new String[] {permissao},requestCode);
                }
            }
        }
        return true;
    }
}
