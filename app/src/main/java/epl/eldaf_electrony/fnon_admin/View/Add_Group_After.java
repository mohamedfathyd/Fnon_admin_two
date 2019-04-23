package epl.eldaf_electrony.fnon_admin.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Group_After extends AppCompatActivity {
    TextInputLayout textInputLayoutgroup,textInputLayoutnumstudent,
            textInputLayoutprice,textInputLayoutdate;
    TextInputEditText textInputEditTextgroup,textInputEditTextnumstudent,textInputEditTextprice,textInputEditTextdate;
    AppCompatButton regesiter;
    TextView name;
    ProgressDialog progressDialog;
    Intent intent;
    String namee;
    int teacher_id;
    Spinner spin,spinyear,spintype;
    Response_api apiinterface;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__group__after);
        inisialize();
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        intent=getIntent();
        namee=intent.getStringExtra("name");
        teacher_id=intent.getIntExtra("id",0);
        name.setText(namee);
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInputEditTextgroup.getText()==null||textInputEditTextnumstudent.getText()==null||
                        textInputEditTextprice.getText()==null||textInputEditTextdate.getText()==null){
                    Toast.makeText(Add_Group_After.this, "يجب ملئ الحقول الفارغة " ,Toast.LENGTH_LONG).show();
                }
                else{
                    fetchInfo();}
            }

        });
    }
    public void inisialize() {
        textInputLayoutgroup = (TextInputLayout) findViewById(R.id.textInputLayoutgroup);
        spin=findViewById(R.id.spin);
        textInputLayoutnumstudent = (TextInputLayout) findViewById(R.id.textInputLayoutnumstudent);
        textInputLayoutprice = (TextInputLayout) findViewById(R.id.textInputLayoutprice);
        textInputLayoutdate=findViewById(R.id.textInputLayoutdate);
        textInputEditTextdate=findViewById(R.id.textInputEditTextdate);
        textInputEditTextgroup = (TextInputEditText) findViewById(R.id.textInputEditTextgroup);
        textInputEditTextnumstudent = (TextInputEditText) findViewById(R.id.textInputEditTextnumstudent);
        textInputEditTextprice = (TextInputEditText) findViewById(R.id.textInputEditTextprice);
        regesiter = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        name=findViewById(R.id.name);
        spin=findViewById(R.id.spin);
        spinyear=findViewById(R.id.spin1);
        spintype=findViewById(R.id.spin2);
    }
    public void fetchInfo(){
        progressDialog = ProgressDialog.show(Add_Group_After.this,"جارى تسجيل الكود","Please wait...",false,false);
        progressDialog.show();

        apiinterface= ApiConfigration.getapiClient().create(Response_api.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_group(namee
                ,teacher_id,spinyear.getSelectedItem().toString(),textInputEditTextgroup.getText().toString(),
                spintype.getSelectedItem().toString(),spin.getSelectedItem().toString(),textInputEditTextnumstudent.getText().toString(),
                Double.parseDouble(textInputEditTextprice.getText().toString()),textInputEditTextdate.getText().toString()
                );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Add_Group_After.this);
                dlgAlert.setMessage("تم تسجيل المجموعة بنجاح ");
                dlgAlert.setTitle("Fnon");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                regesiter.setClickable(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                // Toast.makeText(add_shop.this,"تم التسجيل .. برجاء التأكد المره القادمة من الانترنت ",Toast.LENGTH_LONG).show();
            }
        });
    }
}
