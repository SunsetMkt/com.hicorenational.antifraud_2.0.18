package com.bumptech.glide.p137r.p139m;

import android.view.View;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: ViewPropertyTransition.java */
/* renamed from: com.bumptech.glide.r.m.j */
/* loaded from: classes.dex */
public class C1860j<R> implements InterfaceC1856f<R> {

    /* renamed from: a */
    private final a f5454a;

    /* compiled from: ViewPropertyTransition.java */
    /* renamed from: com.bumptech.glide.r.m.j$a */
    public interface a {
        /* renamed from: a */
        void m4942a(View view);
    }

    public C1860j(a aVar) {
        this.f5454a = aVar;
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f
    /* renamed from: a */
    public boolean mo4935a(R r, InterfaceC1856f.a aVar) {
        if (aVar.getView() == null) {
            return false;
        }
        this.f5454a.m4942a(aVar.getView());
        return false;
    }
}
