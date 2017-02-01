package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import chatandroidfirebase.android.com.chatandroidfirebase.Activity.Firebase.FirebaseContato;
import chatandroidfirebase.android.com.chatandroidfirebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatosFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> listaContatos;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference();

    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contatos, container, false);
        initComponents(view);
        FirebaseContato firebaseContato = new  FirebaseContato(view.getContext());
        firebaseContato.obterContatos(view,listView,adapter);


        //adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,listaContatos);
        //listView.setAdapter(adapter);



        return  view;
    }


    public void initComponents(View view){
        listView = (ListView) view.findViewById(R.id.IdLvContatos);
    }


}
