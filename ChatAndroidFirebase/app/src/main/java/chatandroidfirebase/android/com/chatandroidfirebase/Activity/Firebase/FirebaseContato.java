package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean.Contato;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean.Usuario;

/**
 * Created by renato on 30/01/17.
 */

public class FirebaseContato {
    private Context context;
    private FirebaseAuth auth;
    private DatabaseReference reference;

    private FirebaseDatabase firebaseDatabase;

    public FirebaseContato(Context context){
        this.context = context;
        this.auth = FirebaseAuth.getInstance();
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.reference = firebaseDatabase.getReference();
    }

    public void cadastroContato(final String email){

        reference.child("Usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Usuario> usuarios = new ArrayList<>();
                Boolean usuarioNaoCadastrado = false;
                for (DataSnapshot retornoSnap : dataSnapshot.getChildren()){
                    usuarios.add(retornoSnap.getValue(Usuario.class));
                }

                for (Usuario u : usuarios ) {
                    Boolean existe = u.txEmail.equals(email);
                    if (existe){
                        Contato contato = new Contato();
                        contato.setIdContato(u.getIdUsuario());
                        contato.setUsuario(u);
                        contato.setCsAtivo(true);
                        reference.child("Contatos")
                                .child(auth.getCurrentUser().getUid())
                                .child(u.getIdUsuario())
                                .setValue(contato);
                        usuarioNaoCadastrado = true;
                    }

                }
                if (usuarioNaoCadastrado){
                    Toast toast = Toast.makeText(context,"Usuário cadastrado com sucesso!",Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(context,"Email não encontrado!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void obterContatos(final View view, final ListView listView, final Adapter adapter){
        String usuarioConectado = auth.getCurrentUser().getUid();

        reference = firebaseDatabase.getReference().child("Contatos").child(usuarioConectado);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Contato>contato = new ArrayList<>();
                ArrayList<String> listaContatos = new ArrayList<String>();

                for (DataSnapshot resultadoSnapShot : dataSnapshot.getChildren()) {
                    Log.i("ResultadoSnapShot",resultadoSnapShot.getValue(Contato.class).toString());
                    Contato contatoAtual = new Contato();
                    contatoAtual = resultadoSnapShot.getValue(Contato.class);
                    listaContatos.add(contatoAtual.getUsuario().getTxNome());

                }
                ArrayAdapter adapter;
                adapter = new ArrayAdapter(view.getContext(),android.R.layout.simple_list_item_1,listaContatos);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
