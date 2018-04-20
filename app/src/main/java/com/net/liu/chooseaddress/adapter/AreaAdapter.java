package com.net.liu.chooseaddress.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.net.liu.chooseaddress.R;

/**
 * Created by lll on 2018/4/19.
 */

public class AreaAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private String[] mData;


    public AreaAdapter(Context context, String[] data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_area, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).setData(position);
        }
        if (mOnItemClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClick.click(mData[position], position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv;

        public ViewHolder(View view) {
            super(view);
            mTv = view.findViewById(R.id.iv);

        }

        public void setData(int pos) {
            mTv.setText(mData[pos]);
        }
    }

    private OnItemClick mOnItemClick;

    public interface OnItemClick {
        void click(String name, int pos);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }

}
