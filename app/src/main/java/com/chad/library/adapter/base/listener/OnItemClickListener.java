package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: classes.dex */
public abstract class OnItemClickListener extends SimpleClickListener {
    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    /* renamed from: a */
    public void mo5274a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    /* renamed from: b */
    public void mo5275b(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    /* renamed from: c */
    public void mo5276c(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        m5280e(baseQuickAdapter, view, i2);
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    /* renamed from: d */
    public void mo5277d(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
    }

    /* renamed from: e */
    public abstract void m5280e(BaseQuickAdapter baseQuickAdapter, View view, int i2);
}
