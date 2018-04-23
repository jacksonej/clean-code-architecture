package arch.in.clean_arch_poc.ui.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import arch.in.clean_arch_poc.R;
import arch.in.clean_arch_poc.domain.model.GithubContributor;
import arch.in.clean_arch_poc.ui.detail.DetailActivity;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    ArrayList<GithubContributor> mGithubContributors;

    public CustomAdapter(Context context, ArrayList<GithubContributor> arraylist) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.mGithubContributors = arraylist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.avatar.setText(mGithubContributors.get(position).getLogin());
        RequestOptions options = new RequestOptions();
        Glide.with(holder.mImageView.getContext())
                .load(mGithubContributors.get(position).getAvatarUrl())
                .apply(options.fitCenter())
                .into(holder.mImageView);

        holder.itemView.setOnClickListener(view -> {
            Intent i=new Intent(context, DetailActivity.class);
            i.putExtra("login",mGithubContributors.get(position).getLogin());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return mGithubContributors.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView avatar;
        CircleImageView mImageView;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.text1);
            mImageView = itemView.findViewById(R.id.avatar);
            this.itemView=itemView;
        }
    }
}