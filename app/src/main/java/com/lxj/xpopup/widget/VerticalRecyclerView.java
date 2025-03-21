package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColor(C2766R.color._xpopup_list_divider));
        gradientDrawable.setSize(10, C2819c.m8449a(context, 0.4f));
        dividerItemDecoration.setDrawable(gradientDrawable);
        addItemDecoration(dividerItemDecoration);
    }
}
