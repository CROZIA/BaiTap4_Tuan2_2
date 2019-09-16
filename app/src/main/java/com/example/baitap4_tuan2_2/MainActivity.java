package com.example.baitap4_tuan2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    Button add;
    EditText item;
    TextView kq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.buttonNhap);
        kq=(TextView)findViewById(R.id.textViewKq);
        item=(EditText)findViewById(R.id.editText_Item);

        myList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);

        setListAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(item.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });

    }
    @Override
    public void onListItemClick(ListView l, View v, int p, long id) {
        String item=(String)getListAdapter().getItem(p);
        kq.setText("Vị trí : "+p+"    Giá trị : "+item+"");
    }


}
