package com.scwang.smartrefresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;
import com.scwang.smartrefresh.layout.b.f;
import com.scwang.smartrefresh.layout.b.h;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class RefreshFooterWrapper extends InternalAbstract implements f {
    public RefreshFooterWrapper(View view) {
        super(view);
    }

    @Override // com.scwang.smartrefresh.layout.b.f
    public boolean a(boolean z) {
        h hVar = this.f5665c;
        return (hVar instanceof f) && ((f) hVar).a(z);
    }
}
