package com.adityayogapradipta.resepmakanan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private final LinkedList<String> mWordListDetail;
    private final LinkedList<String> mWordListIngredients;
    private final LinkedList<String> mWordListProcess;
    private LayoutInflater mInflater;
    public WordListAdapter(Context context, LinkedList<String> wordList, LinkedList<String> wordListDetail, LinkedList<String> wordListIngredients, LinkedList<String> wordListProcess) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.mWordListDetail = wordListDetail;
        this.mWordListIngredients = wordListIngredients;
        this.mWordListProcess = wordListProcess;
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
        String mCurrent2 = mWordListDetail.get(position);
        holder.wordItemDetailView.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView wordItemDetailView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.resep_nama);
            wordItemDetailView = itemView.findViewById(R.id.resep_detail);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mWordListIngredients.get(mPosition);
            String element2 = mWordListProcess.get(mPosition);
            String element3 = mWordList.get(mPosition);
            Intent intent = new Intent(v.getContext(), Main2Activity.class);
            intent.putExtra("Nama", element3);
            intent.putExtra("Ingredients", element);
            intent.putExtra("Process", element2);
            v.getContext().startActivity(intent);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}
