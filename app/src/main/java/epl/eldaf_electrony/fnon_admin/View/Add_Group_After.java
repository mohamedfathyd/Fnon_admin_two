package epl.eldaf_electrony.fnon_admin.View;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import epl.eldaf_electrony.fnon_admin.R;

public class Add_Group_After extends AppCompatActivity {
    TextInputLayout textInputLayoutgroup,textInputLayoutnumstudent,
            textInputLayoutprice;
    TextInputEditText textInputEditTextgroup,textInputEditTextnumstudent,textInputEditTextprice;
    AppCompatButton regesiter;
    TextView name;
    Intent intent;
    Spinner spin,spinyear,spintype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__group__after);
        inisialize();
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void inisialize() {
        textInputLayoutgroup = (TextInputLayout) findViewById(R.id.textInputLayoutgroup);
        spin=findViewById(R.id.spin);
        textInputLayoutnumstudent = (TextInputLayout) findViewById(R.id.textInputLayoutnumstudent);
        textInputLayoutprice = (TextInputLayout) findViewById(R.id.textInputLayoutprice);

        textInputEditTextgroup = (TextInputEditText) findViewById(R.id.textInputEditTextgroup);
        textInputEditTextnumstudent = (TextInputEditText) findViewById(R.id.textInputEditTextnumstudent);
        textInputEditTextprice = (TextInputEditText) findViewById(R.id.textInputEditTextprice);
        regesiter = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        name=findViewById(R.id.name);
        spin=findViewById(R.id.spin);
        spinyear=findViewById(R.id.spin1);
        spintype=findViewById(R.id.spin2);
    }
}
