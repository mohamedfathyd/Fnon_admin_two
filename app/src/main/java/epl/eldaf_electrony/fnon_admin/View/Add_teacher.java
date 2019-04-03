package epl.eldaf_electrony.fnon_admin.View;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Spinner;

import epl.eldaf_electrony.fnon_admin.R;

public class Add_teacher extends AppCompatActivity {
    TextInputLayout textInputLayoutname,textInputLayoutaddress,textInputLayoutphone,
            textInputLayoutpassword;
    TextInputEditText textInputEditTextname,textInputEditTextaddress,textInputEditTextphone,
            textInputEditTextpassword;
    AppCompatButton regesiter;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        inisialize();
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void inisialize() {
        textInputLayoutname = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        spin=findViewById(R.id.spin);
        textInputLayoutphone = (TextInputLayout) findViewById(R.id.textInputLayoutphone);
        textInputLayoutpassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutaddress = (TextInputLayout) findViewById(R.id.textInputLayoutaddress);
        textInputEditTextname = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextphone = (TextInputEditText) findViewById(R.id.textInputEditTextphone);
        textInputEditTextpassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextaddress = (TextInputEditText) findViewById(R.id.textInputEditTextaddress);
        regesiter = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

    }

}
