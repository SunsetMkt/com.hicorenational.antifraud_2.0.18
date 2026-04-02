package com.bumptech.glide.r.m;

import android.view.View;
import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: ViewPropertyTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class j<R> implements f<R> {
    private final a a;

    /* JADX INFO: compiled from: ViewPropertyTransition.java */
    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(R r, f.a aVar) {
        if (aVar.getView() == null) {
            return false;
        }
        this.a.a(aVar.getView());
        return false;
    }
}
