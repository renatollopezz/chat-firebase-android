package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean.Usuario;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.LoginActivity;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.MainActivity;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis.Alerta;

/**
 * Created by renato on 22/01/17.
 */

public class FirebaseLogin {
    private  Alerta alerta;
    private Context context;
    FirebaseAuth auth;

    public FirebaseLogin(Activity context){
        this.context = context;
        this.auth = FirebaseAuth.getInstance();
    }

    public void logar(String email,String senha){

        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        alerta = new Alerta();
                        Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
                        context.startActivity(intent);
                        Activity  ac = (Activity) context;
                        ac.finish();

                    }else{
                        Activity  ac = (Activity) context;
                        Toast toast = Toast.makeText(ac.getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT);
                        toast.show();
                    }
            }
        });


    }


    public void cadastrar(final String email, String senha, final String nome){

        auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(user.getUid().toString());
                    usuario.setTxEmail(email);
                    usuario.setTxNome(nome);
                    Activity ac = (Activity) context;
                    Toast toast = Toast.makeText(ac,"Conta criada com sucesso!",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Activity ac = (Activity) context;
                    Log.i("Retorno erro",task.getException().getMessage());
                    Toast toast = Toast.makeText(ac,task.getException().getMessage(),Toast.LENGTH_SHORT);
                    toast.show();
                    }

            }
        });
    }


    public Boolean verificarLogado(){
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser != null){
            return true;
        }else{
            return false;
        }
    }

}
