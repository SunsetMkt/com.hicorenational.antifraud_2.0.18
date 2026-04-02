package com.bumptech.glide.r.m;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
public interface f<R> {

    /* JADX INFO: compiled from: Transition.java */
    public interface a {
        @Nullable
        Drawable b();

        void d(Drawable drawable);

        View getView();
    }

    boolean a(R r, a aVar);
}
