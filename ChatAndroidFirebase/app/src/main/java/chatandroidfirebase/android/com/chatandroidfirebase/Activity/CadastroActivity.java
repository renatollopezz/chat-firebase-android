package chatandroidfirebase.android.com.chatandroidfirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseLogin;
import chatandroidfirebase.android.com.chatandroidfirebase.R;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtNome,edtEmail,edtSenha;
    private Button btnCadastrar;
    //firebase
    FirebaseLogin criarConta ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initComponents();
        criarConta = new FirebaseLogin(this);
        carregarEventoBotoes();
    }

    public void carregarEventoBotoes(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    public void cadastrarUsuario(){
        try {
            String email = edtEmail.getText().toString();
            String nome = edtNome.getText().toString();
            String senha = edtSenha.getText().toString();
            if (!email.isEmpty() && !senha.isEmpty()){
                criarConta.cadastrar(email,nome,senha);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(),"Campos Email e Senha, não podem ser vazios!",Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
    public void initComponents(){
        edtEmail = (EditText) findViewById(R.id.idEdtEmailCadastro);
        edtNome = (EditText) findViewById(R.id.idEdtNomeCadastro);
        edtSenha = (EditText) findViewById(R.id.idEdtSenhaCadastro);
        btnCadastrar = (Button) findViewById(R.id.idBtnCadastro);
    }

}
