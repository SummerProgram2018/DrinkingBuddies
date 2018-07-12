package com.example.jonahluton.drinkingbuddiesjonah;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonahluton.drinkingbuddiesjonah.Tab1Chat.OnListFragmentInteractionListener;
import com.example.jonahluton.drinkingbuddiesjonah.dummy.DummyContent.DummyItem;

import com.example.jonahluton.drinkingbuddiesjonah.Tab1ChatContent.ChatItem;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter2 extends RecyclerView.Adapter<MyItemRecyclerViewAdapter2.ViewHolder> {

    private final List<ChatItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter2(List<ChatItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mGroupView.setText(mValues.get(position).group);
        holder.mMessageView.setText(mValues.get(position).message);
        holder.mTimeView.setText(mValues.get(position).time);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO working here
                Toast.makeText(v.getContext() , "shut up joe",
                        Toast.LENGTH_LONG).show();
                /*
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mGroupView;
        public final TextView mMessageView;
        public final TextView mTimeView;
        public ChatItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mGroupView = (TextView) view.findViewById(R.id.group);
            mMessageView = (TextView) view.findViewById(R.id.message);
            mTimeView = (TextView) view.findViewById(R.id.time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mGroupView.getText() + "'";
        }
    }
}