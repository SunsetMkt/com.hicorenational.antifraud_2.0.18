package com.bumptech.glide.load.p125r.p126d;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1673r;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p128f.AbstractC1755b;
import com.bumptech.glide.util.C1878l;

/* compiled from: BitmapDrawableResource.java */
/* renamed from: com.bumptech.glide.load.r.d.c */
/* loaded from: classes.dex */
public class C1720c extends AbstractC1755b<BitmapDrawable> implements InterfaceC1673r {

    /* renamed from: b */
    private final InterfaceC1626e f4823b;

    public C1720c(BitmapDrawable bitmapDrawable, InterfaceC1626e interfaceC1626e) {
        super(bitmapDrawable);
        this.f4823b = interfaceC1626e;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return C1878l.m4995a(((BitmapDrawable) this.f4970a).getBitmap());
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<BitmapDrawable> mo4184b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.p125r.p128f.AbstractC1755b, com.bumptech.glide.load.p118p.InterfaceC1673r
    /* renamed from: c */
    public void mo4195c() {
        ((BitmapDrawable) this.f4970a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
        this.f4823b.mo3924a(((BitmapDrawable) this.f4970a).getBitmap());
    }
}
