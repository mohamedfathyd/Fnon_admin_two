package epl.eldaf_electrony.fnon_admin.Adapter;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.Model.contact_teacher;

import epl.eldaf_electrony.fnon_admin.R;
import epl.eldaf_electrony.fnon_admin.View.Add_Group_After;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_users extends RecyclerView.Adapter<RecyclerAdapter_users.MyViewHolder> {
    Typeface myTypeface;
    int points ;
    private Context context;
    List<contact_teacher> contactslist;
    Response_api apiinterface;

    public RecyclerAdapter_users(Context context, List<contact_teacher> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.teachers_list,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

       //  myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");

         holder.Name.setText(contactslist.get(position).getName());
     //    holder.Name.setTypeface(myTypeface);
        holder.phone.setText(contactslist.get(position).getPhone());
     //   holder.phone.setTypeface(myTypeface);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent= new Intent(context, Add_Group_After.class);
              intent.putExtra("id",contactslist.get(position).getId());
              intent.putExtra("name",contactslist.get(position).getName());
              context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,phone;


    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.name);
        phone=itemView.findViewById(R.id.phone);


    }
}

}