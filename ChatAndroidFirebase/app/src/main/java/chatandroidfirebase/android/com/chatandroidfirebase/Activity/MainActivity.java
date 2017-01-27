package chatandroidfirebase.android.com.chatandroidfirebase.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseLogin;
import chatandroidfirebase.android.com.chatandroidfirebase.R;

public class MainActivity extends AppCompatActivity {
    //components
    private Toolbar toolbar;
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

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}