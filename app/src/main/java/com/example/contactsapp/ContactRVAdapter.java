package com.example.contactsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder> {

    private ArrayList<ContactModal> contactModalArrayList;
    private Context context;

    public ContactRVAdapter(ArrayList<ContactModal> contactModalArrayList, Context context) {
        this.contactModalArrayList = contactModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModal modal = contactModalArrayList.get(position);
        holder.nameTV.setText(modal.getName());
        holder.surnameTV.setText(modal.getSurname());
        holder.emailAddressTV.setText(modal.getEmailAddress());
    }

    @Override
    public int getItemCount() {
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, surnameTV, emailAddressTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.idTVName);
            surnameTV = itemView.findViewById(R.id.idTVSurname);
            emailAddressTV = itemView.findViewById(R.id.idTVEmailAddress);
        }

    }

}
