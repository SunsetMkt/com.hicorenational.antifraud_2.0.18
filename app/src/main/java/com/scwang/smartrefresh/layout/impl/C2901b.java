package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2877k;
import com.scwang.smartrefresh.layout.p192e.C2891d;

/* compiled from: ScrollBoundaryDeciderAdapter.java */
/* renamed from: com.scwang.smartrefresh.layout.impl.b */
/* loaded from: classes.dex */
public class C2901b implements InterfaceC2877k {

    /* renamed from: a */
    public PointF f9229a;

    /* renamed from: b */
    public InterfaceC2877k f9230b;

    /* renamed from: c */
    public boolean f9231c = true;

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2877k
    /* renamed from: a */
    public boolean mo8720a(View view) {
        InterfaceC2877k interfaceC2877k = this.f9230b;
        return interfaceC2877k != null ? interfaceC2877k.mo8720a(view) : C2891d.m8741a(view, this.f9229a);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2877k
    /* renamed from: b */
    public boolean mo8721b(View view) {
        InterfaceC2877k interfaceC2877k = this.f9230b;
        return interfaceC2877k != null ? interfaceC2877k.mo8721b(view) : C2891d.m8742a(view, this.f9229a, this.f9231c);
    }
}
