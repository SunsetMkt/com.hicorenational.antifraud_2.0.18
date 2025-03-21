package com.bumptech.glide.p137r.p139m;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.EnumC1587a;

/* compiled from: DrawableCrossFadeFactory.java */
/* renamed from: com.bumptech.glide.r.m.c */
/* loaded from: classes.dex */
public class C1853c implements InterfaceC1857g<Drawable> {

    /* renamed from: a */
    private final int f5438a;

    /* renamed from: b */
    private final boolean f5439b;

    /* renamed from: c */
    private C1854d f5440c;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: com.bumptech.glide.r.m.c$a */
    public static class a {

        /* renamed from: c */
        private static final int f5441c = 300;

        /* renamed from: a */
        private final int f5442a;

        /* renamed from: b */
        private boolean f5443b;

        public a() {
            this(300);
        }

        /* renamed from: a */
        public a m4937a(boolean z) {
            this.f5443b = z;
            return this;
        }

        public a(int i2) {
            this.f5442a = i2;
        }

        /* renamed from: a */
        public C1853c m4938a() {
            return new C1853c(this.f5442a, this.f5443b);
        }
    }

    protected C1853c(int i2, boolean z) {
        this.f5438a = i2;
        this.f5439b = z;
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1857g
    /* renamed from: a */
    public InterfaceC1856f<Drawable> mo4934a(EnumC1587a enumC1587a, boolean z) {
        return enumC1587a == EnumC1587a.MEMORY_CACHE ? C1855e.m4939a() : m4936a();
    }

    /* renamed from: a */
    private InterfaceC1856f<Drawable> m4936a() {
        if (this.f5440c == null) {
            this.f5440c = new C1854d(this.f5438a, this.f5439b);
        }
        return this.f5440c;
    }
}
