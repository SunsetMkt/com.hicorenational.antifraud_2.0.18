package com.bumptech.glide.load.p118p.p119a0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* renamed from: com.bumptech.glide.load.p.a0.f */
/* loaded from: classes.dex */
public class C1627f implements InterfaceC1626e {
    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public void mo3921a() {
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public void mo3922a(float f2) {
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public void mo3923a(int i2) {
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: a */
    public void mo3924a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    /* renamed from: b */
    public long mo3925b() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    @NonNull
    /* renamed from: b */
    public Bitmap mo3926b(int i2, int i3, Bitmap.Config config) {
        return mo3920a(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e
    @NonNull
    /* renamed from: a */
    public Bitmap mo3920a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
