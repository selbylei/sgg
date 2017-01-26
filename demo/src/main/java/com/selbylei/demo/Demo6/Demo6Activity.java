package com.selbylei.demo.Demo6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.selbylei.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Demo6Activity extends AppCompatActivity {

    public final int REQUEST_CODE =1;

    @BindView(R.id.et_contacts)
    EditText etContacts;
    @BindView(R.id.btn_select)
    Button btnSelect;
    @BindView(R.id.activity_demo6)
    LinearLayout activityDemo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_select)
    public void onClick() {
        Intent intent = new Intent(Demo6Activity.this, ContactsActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==ContactsActivity.RESULT_CODE){
            Bundle bundle = data.getExtras();
            if (bundle!=null){
                etContacts.setText(bundle.getString("name")+bundle.getString("phone"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
