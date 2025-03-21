package com.scwang.smartrefresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2874h;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class RefreshFooterWrapper extends InternalAbstract implements InterfaceC2872f {
    public RefreshFooterWrapper(View view) {
        super(view);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2872f
    /* renamed from: a */
    public boolean mo8712a(boolean z) {
        InterfaceC2874h interfaceC2874h = this.f9234c;
        return (interfaceC2874h instanceof InterfaceC2872f) && ((InterfaceC2872f) interfaceC2874h).mo8712a(z);
    }
}
