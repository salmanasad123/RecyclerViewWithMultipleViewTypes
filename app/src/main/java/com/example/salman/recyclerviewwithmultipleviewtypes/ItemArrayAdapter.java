package com.example.salman.recyclerviewwithmultipleviewtypes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Salman on 10/14/2018.
 */

public class ItemArrayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    Context context;
    private ArrayList<Item> itemList;


    public ItemArrayAdapter(MainActivity mainActivity, ArrayList<Item> arrayList) {
        this.context = mainActivity;
        this.itemList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type1, parent, false);
            return new ViewHolderOne(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type2, parent, false);
            return new ViewHolderTwo(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Item item = itemList.get(position);
        if (holder instanceof ViewHolderOne) {
            ((ViewHolderOne) holder).item.setText(item.getName());
        }else if(holder instanceof ViewHolderTwo){
            ((ViewHolderTwo) holder).tvLeft.setText(item.getName());
            ((ViewHolderTwo) holder).tvRight.setText(item.getName());
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {

        Item item = itemList.get(position);
        if (item.getType() == Item.ItemType.ONE_ITEM) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }


    }

    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView item;

        public ViewHolderOne(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.row_item);
        }
    }

    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView tvLeft, tvRight;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            tvLeft = (TextView) itemView.findViewById(R.id.row_item_left);
            tvRight = (TextView) itemView.findViewById(R.id.row_item_right);
        }
    }
}

