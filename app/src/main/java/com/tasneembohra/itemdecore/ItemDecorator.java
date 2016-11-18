package com.tasneembohra.itemdecore;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tasneem on 18/11/16.
 */

public class ItemDecorator extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public ItemDecorator(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position != 0)
            outRect.top = mSpace;
    }
}
