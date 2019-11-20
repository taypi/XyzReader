package com.example.xyzreader.ui;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.xyzreader.R;

public class ArticleBodyAdapter extends RecyclerView.Adapter<ArticleBodyAdapter.ParagraphViewHolder> {

    private String[] mParagraphList = new String[]{};

    public void setData(String[] paragraphs) {
        if (paragraphs != null) {
            mParagraphList = paragraphs;
            mParagraphList[0] = "<br />".concat(paragraphs[0]);
            notifyDataSetChanged();
        }
    }

    @Override
    public ArticleBodyAdapter.ParagraphViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ParagraphViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_article_body, parent, false));
    }

    @Override
    public int getItemCount() {
        return mParagraphList.length;
    }

    @Override
    public void onBindViewHolder(ArticleBodyAdapter.ParagraphViewHolder holder, int position) {
        holder.bind(mParagraphList[position]);
    }

    class ParagraphViewHolder extends RecyclerView.ViewHolder {

        private final TextView mParagraph;

        ParagraphViewHolder(View itemView) {
            super(itemView);
            mParagraph = itemView.findViewById(R.id.tv_article_body);
        }

        void bind(String paragraph) {
            mParagraph.setText(Html.fromHtml(paragraph.replaceAll("(\r\n|\n)", "<br />"), 0));
        }
    }

}
