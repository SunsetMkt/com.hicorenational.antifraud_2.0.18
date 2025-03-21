package com.bumptech.glide.p137r.p138l;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.util.C1878l;

/* compiled from: CustomTarget.java */
/* renamed from: com.bumptech.glide.r.l.e */
/* loaded from: classes.dex */
public abstract class AbstractC1837e<T> implements InterfaceC1848p<T> {

    /* renamed from: a */
    private final int f5379a;

    /* renamed from: b */
    private final int f5380b;

    /* renamed from: c */
    @Nullable
    private InterfaceC1825d f5381c;

    public AbstractC1837e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3706a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public final void mo3707a(@Nullable InterfaceC1825d interfaceC1825d) {
        this.f5381c = interfaceC1825d;
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public final void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public void mo3710b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public final void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
        interfaceC1847o.mo4867a(this.f5379a, this.f5380b);
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
    }

    public AbstractC1837e(int i2, int i3) {
        if (C1878l.m5008b(i2, i3)) {
            this.f5379a = i2;
            this.f5380b = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    @Nullable
    /* renamed from: a */
    public final InterfaceC1825d mo3705a() {
        return this.f5381c;
    }
}
