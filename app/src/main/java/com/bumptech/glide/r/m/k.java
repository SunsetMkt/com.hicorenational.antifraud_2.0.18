package com.bumptech.glide.r.m;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: ViewTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class k<R> implements f<R> {
    private final a a;

    /* JADX INFO: compiled from: ViewTransition.java */
    interface a {
        Animation a(Context context);
    }

    k(a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(R r, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.a.a(view.getContext()));
        return false;
    }
}
