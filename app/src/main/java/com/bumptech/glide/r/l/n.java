package com.bumptech.glide.r.l;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SimpleTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class n<Z> extends b<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3522c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@NonNull o oVar) {
        if (com.bumptech.glide.util.l.b(this.f3521b, this.f3522c)) {
            oVar.a(this.f3521b, this.f3522c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f3521b + " and height: " + this.f3522c + ", either provide dimensions in the constructor or call override()");
    }

    public n(int i2, int i3) {
        this.f3521b = i2;
        this.f3522c = i3;
    }
}
