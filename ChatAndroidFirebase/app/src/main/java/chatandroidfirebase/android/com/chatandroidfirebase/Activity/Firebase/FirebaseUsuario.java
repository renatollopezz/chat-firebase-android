package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean.Usuario;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis.Alerta;

/**
 * Created by renato on 28/01/17.
 */

public class FirebaseUsuario {
    private Alerta alerta;
    private Context context;
    private FirebaseAuth auth;

    private FirebaseDatabase firebaseDatabase;

    public FirebaseUsuario(Context context){
        this.context = context;
        this.auth = FirebaseAuth.getInstance();
        this.firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void cadastrarUsuairo(Usuario usuario){

        DatabaseReference reference = firebaseDatabase.getReference();
        reference.child("Usuarios").child(usuario.getIdUsuario()).setValue(usuario);
    }

    public void buscarUsuarioEmail(String email){
        FirebaseUser u = auth.getCurrentUser();

        DatabaseReference reference = firebaseDatabase.getReference();
        reference.child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Usuario> usuarios = new ArrayList<>();

                for (DataSnapshot retornoSnap : dataSnapshot.getChildren()){
                    Log.i("RETORNO SNAP",retornoSnap.toString());
                    usuarios.add(retornoSnap.getValue(Usuario.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void buscarTodos(){}


}
