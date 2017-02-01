package chatandroidfirebase.android.com.chatandroidfirebase.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Adapter.TabelaAdapter;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseContato;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseLogin;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseUsuario;
import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Ultis.SlidingTabLayout;
import chatandroidfirebase.android.com.chatandroidfirebase.R;

public class MainActivity extends AppCompatActivity {
    //components
    private Toolbar toolbar;
    //tabela
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    //firebase
    private FirebaseLogin firebaseLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseLogin = new FirebaseLogin(this);
        initComponents();
    }

    public void initComponents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Chat Firebase");
        setSupportActionBar(toolbar);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_table);
        viewPager = (ViewPager) findViewById(R.id.vp_page);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(R.color.textColorPrimary);


        TabelaAdapter tabelaAdapter = new TabelaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabelaAdapter);
        slidingTabLayout.setViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_sair :
             firebaseLogin.sair();
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.item_adicionar:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setCancelable(false);
                alertDialog.setTitle("Adicionar contato");
                alertDialog.setMessage("Informe o email:");
                final EditText campoEmail = new EditText(this);
                alertDialog.setView(campoEmail);
                alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!campoEmail.getText().toString().isEmpty()){
                            FirebaseContato firebaseContato = new FirebaseContato(getApplicationContext());
                            firebaseContato.cadastroContato(campoEmail.getText().toString());
                        }

                    }
                });

                alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}