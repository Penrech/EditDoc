package com.pau_e.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DocActivity extends AppCompatActivity {

    private static final int EDIT_BODY = 1;
    private static final int EDIT_TITLE = 0;
    private TextView title;
    private TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit_title:
                edit(title.getText().toString(),EDIT_TITLE);
                break;
            case  R.id.edit_body:
                edit(body.getText().toString(),EDIT_BODY);
                break;

        }
        return true;
    }

    private  void edit(String text, int requestCode){
        Intent intent = new Intent(this,EditTextActivity.class);
        intent.putExtra("text",text);
        startActivityForResult(intent,requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case EDIT_TITLE:
                if (resultCode == RESULT_OK){
                    String text = data.getStringExtra("text");
                    title.setText(text);
                }
                break;
            case EDIT_BODY:
                if (resultCode == RESULT_OK){
                    String text = data.getStringExtra("text");
                    body.setText(text);
                }
                break;
        }
    }
}
