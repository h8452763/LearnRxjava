package com.cloudtp.learnrxjava.ui.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cloudtp.learnrxjava.MainActivity;
import com.cloudtp.learnrxjava.R;

import java.util.ArrayList;

/**
 * Created by JYD on 2016/8/25.
 */
public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.VH> {

    public FragmentActivity mContext;
    public ArrayList list;
    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    public ApiAdapter(FragmentActivity context, ArrayList arrayList){
        mContext=context;
        list=arrayList;
    }
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(mContext, R.layout.api_item,null));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.apiBtn.setText(list.get(position).toString());
        // 如果设置了回调，则设置点击事件
        if(mOnItemClickLitener!=null) {
            holder.apiBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        private Button apiBtn;
    public VH(View itemView) {
        super(itemView);
        apiBtn= (Button) itemView.findViewById(R.id.api_btn);
    }
}
}
