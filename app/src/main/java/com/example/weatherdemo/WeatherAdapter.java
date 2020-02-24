package com.example.weatherdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final int ITEM_VIEW_TYPE_CONTENT = 1;
    private static final int ITEM_VIEW_TYPE_IMAGE = 2;
    private static final int ITEM_VIEW_NON = 3;
    private Context mContext;
    private List<Object> mList;
    private OnItemClickListener onItemClickListener;

    WeatherAdapter(Context context, List<Object> list) {
        this.mContext = context;
        this.mList = list;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public int getItemViewType(int position) {
        Object obj = mList.get(position);
        if (obj instanceof String) {
            return ITEM_VIEW_TYPE_CONTENT;
        } else if (obj instanceof Drawable) {
            return ITEM_VIEW_TYPE_IMAGE;
        } else {
            return ITEM_VIEW_NON;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM_VIEW_TYPE_CONTENT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_weather_content, parent, false);
            ContentViewHolder contentViewHolder = new ContentViewHolder(view);
            view.setOnClickListener(this);
            return contentViewHolder;
        } else if (viewType == ITEM_VIEW_TYPE_IMAGE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_weather_image, parent, false);
            ImageViewHolder imageViewHolder = new ImageViewHolder(view);
            return imageViewHolder;
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ITEM_VIEW_TYPE_CONTENT) {
            holder.itemView.setTag(position);
            ((ContentViewHolder) holder).tvTime.setText((String) mList.get(position));
        } else if (holder.getItemViewType() == ITEM_VIEW_TYPE_IMAGE) {
            Glide.with(mContext)
                    .load(mList.get(position))
                    .into(((ImageViewHolder) holder).ivImage);
        }
    }

    void upDateItem(List<Object> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.mList != null ? this.mList.size() : 0;
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time)
        TextView tvTime;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
