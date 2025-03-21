package com.bumptech.glide.p137r.p139m;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: ViewTransition.java */
/* renamed from: com.bumptech.glide.r.m.k */
/* loaded from: classes.dex */
public class C1861k<R> implements InterfaceC1856f<R> {

    /* renamed from: a */
    private final a f5455a;

    /* compiled from: ViewTransition.java */
    /* renamed from: com.bumptech.glide.r.m.k$a */
    interface a {
        /* renamed from: a */
        Animation mo4941a(Context context);
    }

    C1861k(a aVar) {
        this.f5455a = aVar;
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f
    /* renamed from: a */
    public boolean mo4935a(R r, InterfaceC1856f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f5455a.mo4941a(view.getContext()));
        return false;
    }
}
