package com.deanna.dhimanmatrimonial.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.deanna.dhimanmatrimonial.ClickDetails;
import com.deanna.dhimanmatrimonial.Model.DataModelClass;
import com.deanna.dhimanmatrimonial.R;
import com.squareup.picasso.Picasso;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ViewHolder> {

    private static final String TAG = "ValueAdapter";
    private Context context;
    FragmentTransaction fragmentTransaction;
    private List<DataModelClass> dataModelClasses;

    public ValueAdapter(Context context, List<DataModelClass> dataModelClasses) {
        this.context = context;
        this.dataModelClasses = dataModelClasses;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.value_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataModelClass dataModelClass = dataModelClasses.get(position);
        String name = dataModelClass.getUsername();
        String gmail = dataModelClass.getUsergmail();
        String location = dataModelClass.getUserlocation();
        String father = dataModelClass.getUserfather();
        String mother = dataModelClass.getUsermother();
        String dob = dataModelClass.getUserdob();
        String pob = dataModelClass.getUserpob();
        String tob = dataModelClass.getUsertob();
        String gender = dataModelClass.getUsergender();
        String cast = dataModelClass.getUsercast();
        String gotr = dataModelClass.getUsergotr();
        String height = dataModelClass.getUserheight();
        String complexon = dataModelClass.getUsercomplexon();
        String qualification = dataModelClass.getUserqualification();
        String ocupation = dataModelClass.getUsercupation();
        String sibling = dataModelClass.getUsersibling();
        String hobbies = dataModelClass.getUserhobbies();
        String address = dataModelClass.getUseraddress();



        holder.namevalue.setText(name);
        holder.gmailvalue.setText(gmail);
        holder.fathervalue.setText(father);
        holder.mothervalue.setText(mother);
        holder.dobvalue.setText(dob);
        holder.pobvalue.setText(pob);
        holder.tobvalue.setText(tob);
        holder.gendervalue.setText(gender);
        holder.castvalue.setText(cast);
        holder.gotrvalue.setText(gotr);
        holder.heightvalue.setText(height);
        holder.complexonvalue.setText(complexon);
        holder.qualificatiovnalue.setText(qualification);
        holder.ocupationvalue.setText(ocupation);
        holder.siblingvalue.setText(sibling);
        holder.hobbiesvalue.setText(hobbies);
        holder.addressvalue.setText(address);

        String image = dataModelClass.getDp();
        Picasso.get().load(image).into(holder.circleImageView);

        holder.editional.setVisibility(View.GONE);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Bundle valueBundle = new Bundle();
//                valueBundle.putString("dp",dataModelClass.getDp());
                valueBundle.putString("name",dataModelClass.getUsername());
                valueBundle.putString("location",dataModelClass.getUserlocation());
                valueBundle.putString("father",dataModelClass.getUserfather());
                valueBundle.putString("gmail",dataModelClass.getUsergmail());
                valueBundle.putString("mother",dataModelClass.getUsermother());
                valueBundle.putString("dob",dataModelClass.getUserdob());
                valueBundle.putString("pob",dataModelClass.getUserpob());
                valueBundle.putString("tob",dataModelClass.getUsertob());
                valueBundle.putString("gender",dataModelClass.getUsergender());
                valueBundle.putString("cast",dataModelClass.getUsercast());
                valueBundle.putString("gotr",dataModelClass.getUsergotr());
                valueBundle.putString("height",dataModelClass.getUserheight());
                valueBundle.putString("complexon",dataModelClass.getUsercomplexon());
                valueBundle.putString("qualification",dataModelClass.getUserqualification());
                valueBundle.putString("ocupation",dataModelClass.getUsercupation());
                valueBundle.putString("sibling",dataModelClass.getUsersibling());
                valueBundle.putString("hobbies",dataModelClass.getUserhobbies());
                valueBundle.putString("address",dataModelClass.getUseraddress());

                Intent intent = new Intent(context, ClickDetails.class);
                intent.putExtra("valueBundle",valueBundle);
                intent.putExtra("dp",dataModelClass.getDp());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namevalue,dobvalue,locationvalue,gmailvalue,fathervalue,mothervalue,pobvalue,tobvalue,gendervalue,castvalue,gotrvalue,heightvalue,complexonvalue,
                qualificatiovnalue,ocupationvalue,siblingvalue,hobbiesvalue,addressvalue;
        CircleImageView circleImageView;
        LinearLayout linearLayout,editional;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.clickDetail);
            editional=itemView.findViewById(R.id.editionalValues);

            circleImageView=itemView.findViewById(R.id.dpvalue);
            namevalue=itemView.findViewById(R.id.namevalue);
            dobvalue=itemView.findViewById(R.id.dobvalue);
            locationvalue=itemView.findViewById(R.id.locationvalue);
            gmailvalue=itemView.findViewById(R.id.gmailvalue);
            fathervalue=itemView.findViewById(R.id.fathervalue);
            mothervalue=itemView.findViewById(R.id.mothervalue);
            pobvalue=itemView.findViewById(R.id.pobvalue);
            tobvalue=itemView.findViewById(R.id.tobvalue);
            gendervalue=itemView.findViewById(R.id.gendervalue);
            castvalue=itemView.findViewById(R.id.castvalue);
            gotrvalue=itemView.findViewById(R.id.gotrvalue);
            heightvalue=itemView.findViewById(R.id.heightvalue);
            complexonvalue=itemView.findViewById(R.id.complexonvalue);
            qualificatiovnalue=itemView.findViewById(R.id.qualificationvalue);
            ocupationvalue=itemView.findViewById(R.id.ocupationvalue);
            siblingvalue=itemView.findViewById(R.id.siblingvalue);
            hobbiesvalue=itemView.findViewById(R.id.hobbiesvalue);
            addressvalue=itemView.findViewById(R.id.addressvalue);

        }
    }
}
