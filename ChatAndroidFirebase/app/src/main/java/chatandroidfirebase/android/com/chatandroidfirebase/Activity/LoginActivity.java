package chatandroidfirebase.android.com.chatandroidfirebase.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean.Usuario;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseLogin;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis.Mascara;
import chatandroidfirebase.android.com.chatandroidfirebase.R;

public class LoginActivity extends AppCompatActivity{
    // components Layout
    private EditText edtEmail,edtSenha;
    private Button btnEntrar;
    private TextView btnCadastrar;
    //firebase
    FirebaseLogin login ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        login = new FirebaseLogin(this);
        carregarEventoBotoes();


    }

    private void carregarEventoBotoes() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logarUsuario();
            }

            });

    }


    private void initComponents() {
        edtEmail = (EditText) findViewById(R.id.idEdtEmailLogin);
        edtSenha = (EditText) findViewById(R.id.idEdtSenhaLogin);
        btnEntrar = (Button) findViewById(R.id.idBtnEntrar);
        btnCadastrar = (TextView) findViewById(R.id.idLblRegistrar);

    }
    public void logarUsuario(){
        login.logar(edtEmail.getText().toString(),edtSenha.getText().toString());
    }

    public void cadastrarUsuario(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(login.verificarLogado()){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
