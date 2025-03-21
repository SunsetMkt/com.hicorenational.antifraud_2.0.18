package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.C1579e;
import com.bumptech.glide.p137r.p138l.AbstractC1838f;
import com.bumptech.glide.p137r.p138l.InterfaceC1847o;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import java.util.Arrays;

/* compiled from: ViewPreloadSizeProvider.java */
/* renamed from: com.bumptech.glide.util.m */
/* loaded from: classes.dex */
public class C1879m<T> implements C1579e.b<T>, InterfaceC1847o {

    /* renamed from: a */
    private int[] f5501a;

    /* renamed from: b */
    private a f5502b;

    /* compiled from: ViewPreloadSizeProvider.java */
    /* renamed from: com.bumptech.glide.util.m$a */
    static final class a extends AbstractC1838f<View, Object> {
        a(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3706a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f<? super Object> interfaceC1856f) {
        }

        @Override // com.bumptech.glide.p137r.p138l.AbstractC1838f
        /* renamed from: d */
        protected void mo3805d(@Nullable Drawable drawable) {
        }
    }

    public C1879m() {
    }

    @Override // com.bumptech.glide.C1579e.b
    @Nullable
    /* renamed from: a */
    public int[] mo3704a(@NonNull T t, int i2, int i3) {
        int[] iArr = this.f5501a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public C1879m(@NonNull View view) {
        this.f5502b = new a(view);
        this.f5502b.mo3711b(this);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1847o
    /* renamed from: a */
    public void mo4867a(int i2, int i3) {
        this.f5501a = new int[]{i2, i3};
        this.f5502b = null;
    }

    /* renamed from: a */
    public void m5013a(@NonNull View view) {
        if (this.f5501a == null && this.f5502b == null) {
            this.f5502b = new a(view);
            this.f5502b.mo3711b(this);
        }
    }
}
