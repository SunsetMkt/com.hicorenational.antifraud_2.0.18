package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.AbstractC1586l;
import com.bumptech.glide.p137r.p139m.C1852b;
import com.bumptech.glide.p137r.p139m.C1853c;
import com.bumptech.glide.p137r.p139m.InterfaceC1857g;

/* compiled from: BitmapTransitionOptions.java */
/* renamed from: com.bumptech.glide.load.r.d.i */
/* loaded from: classes.dex */
public final class C1732i extends AbstractC1586l<C1732i, Bitmap> {
    @NonNull
    /* renamed from: b */
    public static C1732i m4338b(@NonNull C1853c c1853c) {
        return new C1732i().m4344a(c1853c);
    }

    @NonNull
    /* renamed from: c */
    public static C1732i m4339c(int i2) {
        return new C1732i().m4345b(i2);
    }

    @NonNull
    /* renamed from: d */
    public static C1732i m4341d() {
        return new C1732i().m4347c();
    }

    @NonNull
    /* renamed from: a */
    public C1732i m4344a(@NonNull C1853c c1853c) {
        return m4346b((InterfaceC1857g<Drawable>) c1853c);
    }

    @NonNull
    /* renamed from: b */
    public static C1732i m4337b(@NonNull C1853c.a aVar) {
        return new C1732i().m4343a(aVar);
    }

    @NonNull
    /* renamed from: c */
    public static C1732i m4340c(@NonNull InterfaceC1857g<Bitmap> interfaceC1857g) {
        return new C1732i().m3810a(interfaceC1857g);
    }

    @NonNull
    /* renamed from: d */
    public static C1732i m4342d(@NonNull InterfaceC1857g<Drawable> interfaceC1857g) {
        return new C1732i().m4346b(interfaceC1857g);
    }

    @NonNull
    /* renamed from: a */
    public C1732i m4343a(@NonNull C1853c.a aVar) {
        return m4346b((InterfaceC1857g<Drawable>) aVar.m4938a());
    }

    @NonNull
    /* renamed from: b */
    public C1732i m4345b(int i2) {
        return m4343a(new C1853c.a(i2));
    }

    @NonNull
    /* renamed from: c */
    public C1732i m4347c() {
        return m4343a(new C1853c.a());
    }

    @NonNull
    /* renamed from: b */
    public C1732i m4346b(@NonNull InterfaceC1857g<Drawable> interfaceC1857g) {
        return m3810a(new C1852b(interfaceC1857g));
    }
}
