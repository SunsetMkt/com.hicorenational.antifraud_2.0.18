package com.chad.library.adapter.base.p144c;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.chad.library.adapter.base.BaseViewHolder;

/* compiled from: LoadMoreView.java */
/* renamed from: com.chad.library.adapter.base.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC1914a {

    /* renamed from: c */
    public static final int f5613c = 1;

    /* renamed from: d */
    public static final int f5614d = 2;

    /* renamed from: e */
    public static final int f5615e = 3;

    /* renamed from: f */
    public static final int f5616f = 4;

    /* renamed from: a */
    private int f5617a = 1;

    /* renamed from: b */
    private boolean f5618b = false;

    /* renamed from: b */
    private void m5249b(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.m5226c(mo5256c(), z);
    }

    /* renamed from: c */
    private void m5250c(BaseViewHolder baseViewHolder, boolean z) {
        baseViewHolder.m5226c(mo5258e(), z);
    }

    @LayoutRes
    /* renamed from: a */
    public abstract int mo5251a();

    /* renamed from: a */
    public void m5252a(int i2) {
        this.f5617a = i2;
    }

    @IdRes
    /* renamed from: b */
    protected abstract int mo5255b();

    @IdRes
    /* renamed from: c */
    protected abstract int mo5256c();

    /* renamed from: d */
    public int m5257d() {
        return this.f5617a;
    }

    @IdRes
    /* renamed from: e */
    protected abstract int mo5258e();

    @Deprecated
    /* renamed from: f */
    public boolean m5259f() {
        return this.f5618b;
    }

    /* renamed from: g */
    public final boolean m5260g() {
        if (mo5255b() == 0) {
            return true;
        }
        return this.f5618b;
    }

    /* renamed from: a */
    public void m5253a(BaseViewHolder baseViewHolder) {
        int i2 = this.f5617a;
        if (i2 == 1) {
            m5250c(baseViewHolder, false);
            m5249b(baseViewHolder, false);
            m5248a(baseViewHolder, false);
            return;
        }
        if (i2 == 2) {
            m5250c(baseViewHolder, true);
            m5249b(baseViewHolder, false);
            m5248a(baseViewHolder, false);
        } else if (i2 == 3) {
            m5250c(baseViewHolder, false);
            m5249b(baseViewHolder, true);
            m5248a(baseViewHolder, false);
        } else {
            if (i2 != 4) {
                return;
            }
            m5250c(baseViewHolder, false);
            m5249b(baseViewHolder, false);
            m5248a(baseViewHolder, true);
        }
    }

    /* renamed from: a */
    private void m5248a(BaseViewHolder baseViewHolder, boolean z) {
        int mo5255b = mo5255b();
        if (mo5255b != 0) {
            baseViewHolder.m5226c(mo5255b, z);
        }
    }

    /* renamed from: a */
    public final void m5254a(boolean z) {
        this.f5618b = z;
    }
}
