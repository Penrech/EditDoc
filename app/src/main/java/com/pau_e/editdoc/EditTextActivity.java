package com.pau_e.editdoc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    private EditText edit_text;
    private String text_after_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        edit_text = findViewById(R.id.edit_text);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        if (text != null){
            edit_text.setText(text);
            text_after_edit = text;
        }
    }

    @Override
    public void onBackPressed() {
        if (!text_after_edit.equals(edit_text.getText().toString())){
            String msg = getString(R.string.NoSavedChanges);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.NoSavedChangesAlert);
            builder.setMessage(msg);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        }
        else{
            finish();
        }
    }
    public void onSave(View view) {
        Intent data = new Intent();
        data.putExtra("text",edit_text.getText().toString());
        setResult(RESULT_OK,data);
        finish();
    }
}
