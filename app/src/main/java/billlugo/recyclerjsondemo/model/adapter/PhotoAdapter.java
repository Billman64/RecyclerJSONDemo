package billlugo.recyclerjsondemo.model.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import billlugo.recyclerjsondemo.R;
import billlugo.recyclerjsondemo.model.Photo;
import billlugo.recyclerjsondemo.view.detail.DetailActivity;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> photos;

    public PhotoAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    // holder class
    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemLinearLayout;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemAlbumId;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            itemLinearLayout = (LinearLayout) itemView.findViewById(R.id.itemLinearLayout);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemAlbumId = (TextView) itemView.findViewById(R.id.itemAlbumId);
        }
    }


    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {
        holder.itemTitle.setText(photos.get(position).getTitle());
        holder.itemAlbumId.setText(photos.get(position).getAlbumId() + "");
        Glide.with(holder.itemImage.getContext()).load(photos.get(position).getThumbnailUrl()).into(holder.itemImage);

        holder.itemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemImage.getContext(), DetailActivity.class);
                intent.putExtra("photo", photos.get(position));
                holder.itemImage.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}

