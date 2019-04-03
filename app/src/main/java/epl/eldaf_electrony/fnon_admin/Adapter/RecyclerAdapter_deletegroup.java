package epl.eldaf_electrony.fnon_admin.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import epl.eldaf_electrony.fnon_admin.Model.ApiConfigration;
import epl.eldaf_electrony.fnon_admin.Model.Response_api;
import epl.eldaf_electrony.fnon_admin.Model.contact_group;
import epl.eldaf_electrony.fnon_admin.Model.contact_teacher;
import epl.eldaf_electrony.fnon_admin.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter_deletegroup extends RecyclerView.Adapter<RecyclerAdapter_deletegroup.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_group> contactslist;
     Response_api apiinterface;
    public RecyclerAdapter_deletegroup(Context context, List<contact_group> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

     //   myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/flat.ttf");
    holder.Name.setText(contactslist.get(position).getGroup_name());
  //  holder.Name.setTypeface(myTypeface);
    holder.phone.setText(contactslist.get(position).getTeacher_name());

         holder.delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int id=contactslist.get(position).getId();
               fetchInfo(id);
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;

        TextView phone;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.txt_fish_title);
        phone=itemView.findViewById(R.id.numtext);
        delete=(ImageView)itemView.findViewById(R.id.delete);

    }
}
    public void fetchInfo(int id) {

        apiinterface= ApiConfigration.getapiClient().create(Response_api.class);
        Call<ResponseBody> call = null;
        call=apiinterface.getcontacts_delete_group(id);



        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Toast.makeText(context,"تم المسح",Toast.LENGTH_LONG).show();
                ((Activity)context).finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }
}