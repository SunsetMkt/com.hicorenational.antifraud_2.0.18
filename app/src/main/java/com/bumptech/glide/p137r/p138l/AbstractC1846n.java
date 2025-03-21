package com.bumptech.glide.p137r.p138l;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.C1878l;

/* compiled from: SimpleTarget.java */
@Deprecated
/* renamed from: com.bumptech.glide.r.l.n */
/* loaded from: classes.dex */
public abstract class AbstractC1846n<Z> extends AbstractC1834b<Z> {

    /* renamed from: b */
    private final int f5416b;

    /* renamed from: c */
    private final int f5417c;

    public AbstractC1846n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public final void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
        if (C1878l.m5008b(this.f5416b, this.f5417c)) {
            interfaceC1847o.mo4867a(this.f5416b, this.f5417c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f5416b + " and height: " + this.f5417c + ", either provide dimensions in the constructor or call override()");
    }

    public AbstractC1846n(int i2, int i3) {
        this.f5416b = i2;
        this.f5417c = i3;
    }
}
