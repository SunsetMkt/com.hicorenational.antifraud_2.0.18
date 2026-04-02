package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.b.k;
import com.scwang.smartrefresh.layout.e.d;

/* JADX INFO: compiled from: ScrollBoundaryDeciderAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements k {
    public PointF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f5662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5663c = true;

    @Override // com.scwang.smartrefresh.layout.b.k
    public boolean a(View view) {
        k kVar = this.f5662b;
        return kVar != null ? kVar.a(view) : d.a(view, this.a);
    }

    @Override // com.scwang.smartrefresh.layout.b.k
    public boolean b(View view) {
        k kVar = this.f5662b;
        return kVar != null ? kVar.b(view) : d.a(view, this.a, this.f5663c);
    }
}
