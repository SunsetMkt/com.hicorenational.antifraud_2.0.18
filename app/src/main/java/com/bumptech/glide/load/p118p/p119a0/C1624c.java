package com.bumptech.glide.load.p118p.p119a0;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1878l;

/* compiled from: AttributeStrategy.java */
/* renamed from: com.bumptech.glide.load.p.a0.c */
/* loaded from: classes.dex */
class C1624c implements InterfaceC1633l {

    /* renamed from: a */
    private final b f4275a = new b();

    /* renamed from: b */
    private final C1629h<a, Bitmap> f4276b = new C1629h<>();

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.c$a */
    static class a implements InterfaceC1634m {

        /* renamed from: a */
        private final b f4277a;

        /* renamed from: b */
        private int f4278b;

        /* renamed from: c */
        private int f4279c;

        /* renamed from: d */
        private Bitmap.Config f4280d;

        public a(b bVar) {
            this.f4277a = bVar;
        }

        /* renamed from: a */
        public void m3915a(int i2, int i3, Bitmap.Config config) {
            this.f4278b = i2;
            this.f4279c = i3;
            this.f4280d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4278b == aVar.f4278b && this.f4279c == aVar.f4279c && this.f4280d == aVar.f4280d;
        }

        public int hashCode() {
            int i2 = ((this.f4278b * 31) + this.f4279c) * 31;
            Bitmap.Config config = this.f4280d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m
        public void offer() {
            this.f4277a.m3918a(this);
        }

        public String toString() {
            return C1624c.m3908c(this.f4278b, this.f4279c, this.f4280d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.c$b */
    static class b extends AbstractC1625d<a> {
        b() {
        }

        /* renamed from: a */
        a m3917a(int i2, int i3, Bitmap.Config config) {
            a m3919b = m3919b();
            m3919b.m3915a(i2, i3, config);
            return m3919b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.p118p.p119a0.AbstractC1625d
        /* renamed from: a */
        public a mo3916a() {
            return new a(this);
        }
    }

    C1624c() {
    }

    /* renamed from: d */
    private static String m3909d(Bitmap bitmap) {
        return m3908c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: a */
    public void mo3911a(Bitmap bitmap) {
        this.f4276b.m3933a(this.f4275a.m3917a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public String mo3913b(int i2, int i3, Bitmap.Config config) {
        return m3908c(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: c */
    public String mo3914c(Bitmap bitmap) {
        return m3909d(bitmap);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    public Bitmap removeLast() {
        return this.f4276b.m3931a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f4276b;
    }

    /* renamed from: c */
    static String m3908c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public int mo3912b(Bitmap bitmap) {
        return C1878l.m4995a(bitmap);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: a */
    public Bitmap mo3910a(int i2, int i3, Bitmap.Config config) {
        return this.f4276b.m3932a((C1629h<a, Bitmap>) this.f4275a.m3917a(i2, i3, config));
    }
}
