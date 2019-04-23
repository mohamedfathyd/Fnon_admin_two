package epl.eldaf_electrony.fnon_admin.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_teacher extends AppCompatActivity {
    TextInputLayout textInputLayoutname,textInputLayoutaddress,textInputLayoutphone,
            textInputLayoutpassword;
    TextInputEditText textInputEditTextname,textInputEditTextaddress,textInputEditTextphone,
            textInputEditTextpassword;
    AppCompatButton regesiter;
    Spinner spin;
    ProgressDialog progressDialog;
    Response_api apiinterface;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
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
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(textInputEditTextaddress.getText()==null||textInputEditTextname.getText()==null||
               textInputEditTextpassword.getText()==null||textInputEditTextphone.getText()==null){
                   Toast.makeText(Add_teacher.this, "يجب ملئ الحقول الفارغة " ,Toast.LENGTH_LONG).show();
               }
               else{
                fetchInfo();}
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
    public void fetchInfo(){
        progressDialog = ProgressDialog.show(Add_teacher.this,"جارى تسجيل الكود","Please wait...",false,false);
        progressDialog.show();

        apiinterface= ApiConfigration.getapiClient().create(Response_api.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_teacher(textInputEditTextname.getText().toString(),
                textInputEditTextphone.getText().toString(),textInputEditTextpassword.getText().toString(),
                spin.getSelectedItem().toString(),textInputEditTextaddress.getText().toString()
        );

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Add_teacher.this);
                dlgAlert.setMessage("تم تسجيل المدرس بنجاح ");
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
