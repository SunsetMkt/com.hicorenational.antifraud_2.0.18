package com.bumptech.glide.load.p116o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p125r.p126d.C1719b0;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* renamed from: com.bumptech.glide.load.o.k */
/* loaded from: classes.dex */
public final class C1611k implements InterfaceC1605e<InputStream> {

    /* renamed from: b */
    private static final int f4227b = 5242880;

    /* renamed from: a */
    private final C1719b0 f4228a;

    /* compiled from: InputStreamRewinder.java */
    /* renamed from: com.bumptech.glide.load.o.k$a */
    public static final class a implements InterfaceC1605e.a<InputStream> {

        /* renamed from: a */
        private final InterfaceC1623b f4229a;

        public a(InterfaceC1623b interfaceC1623b) {
            this.f4229a = interfaceC1623b;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC1605e<InputStream> mo3860a(InputStream inputStream) {
            return new C1611k(inputStream, this.f4229a);
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a */
        public Class<InputStream> mo3861a() {
            return InputStream.class;
        }
    }

    public C1611k(InputStream inputStream, InterfaceC1623b interfaceC1623b) {
        this.f4228a = new C1719b0(inputStream, interfaceC1623b);
        this.f4228a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    /* renamed from: b */
    public void mo3859b() {
        this.f4228a.m4307d();
    }

    /* renamed from: c */
    public void m3869c() {
        this.f4228a.m4306c();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    @NonNull
    /* renamed from: a */
    public InputStream mo3858a() throws IOException {
        this.f4228a.reset();
        return this.f4228a;
    }
}
