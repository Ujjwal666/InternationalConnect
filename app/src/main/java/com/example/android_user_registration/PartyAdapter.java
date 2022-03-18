package com.example.android_user_registration;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolder> {
    private Context context;
    private List<Party> parties;

    public PartyAdapter(Context context, List<Party> parties){
        this.context=context;
        this.parties=parties;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Party party=parties.get(position);
        holder.bind(party);
    }

    public void clear(){
        parties.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parties.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHandle;
        private ImageView ivImage;
        private TextView tvDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHandle=itemView.findViewById(R.id.tvHandle);
            ivImage=itemView.findViewById(R.id.ivImage);
            tvDescription=itemView.findViewById(R.id.tvDescription);
        }
        public void bind(Party post){
            tvHandle.setText("@"+post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image!=null){
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
            tvDescription.setText(post.getDescription());
        }
    }
}
