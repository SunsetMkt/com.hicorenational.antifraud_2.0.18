package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: OnItemSwipeListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    void a(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f2, float f3, boolean z);

    void a(RecyclerView.ViewHolder viewHolder, int i2);

    void b(RecyclerView.ViewHolder viewHolder, int i2);

    void c(RecyclerView.ViewHolder viewHolder, int i2);
}
