package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by manpreetbahia on 3/15/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    //private String[] mDataset;
    private List<Notes.Note> mDataset;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        /*public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }*/

        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        //public ReminderContent.Reminder mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Notes myDataset) {
        mDataset = myDataset.ITEMS;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_content, null);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mIdView.setText(mDataset.get(position).title);

        final String s = holder.mIdView.getText().toString();
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                    Context context = v.getContext();
                    Intent intent = new Intent(context, NotesView.class);
                    intent.putExtra("item_id", s);
                    context.startActivity(intent);
                }
            });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
