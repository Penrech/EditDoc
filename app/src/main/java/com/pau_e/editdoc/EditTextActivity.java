package com.pau_e.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        edit_text = findViewById(R.id.edit_text);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        if (text != null){
            edit_text.setText(text);
        }
    }

    public void onSave(View view) {
        Intent data = new Intent();
        data.putExtra("text",edit_text.getText().toString());
        setResult(RESULT_OK,data);
        finish();
    }
}
