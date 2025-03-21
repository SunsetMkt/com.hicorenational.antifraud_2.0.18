package com.bumptech.glide.load.p118p.p120b0;

import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* renamed from: com.bumptech.glide.load.p.b0.d */
/* loaded from: classes.dex */
public class C1642d implements InterfaceC1639a.a {

    /* renamed from: c */
    private final long f4343c;

    /* renamed from: d */
    private final c f4344d;

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.d$a */
    class a implements c {

        /* renamed from: a */
        final /* synthetic */ String f4345a;

        a(String str) {
            this.f4345a = str;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1642d.c
        /* renamed from: a */
        public File mo3988a() {
            return new File(this.f4345a);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.d$b */
    class b implements c {

        /* renamed from: a */
        final /* synthetic */ String f4346a;

        /* renamed from: b */
        final /* synthetic */ String f4347b;

        b(String str, String str2) {
            this.f4346a = str;
            this.f4347b = str2;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1642d.c
        /* renamed from: a */
        public File mo3988a() {
            return new File(this.f4346a, this.f4347b);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.d$c */
    public interface c {
        /* renamed from: a */
        File mo3988a();
    }

    public C1642d(String str, long j2) {
        this(new a(str), j2);
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a.a
    public InterfaceC1639a build() {
        File mo3988a = this.f4344d.mo3988a();
        if (mo3988a == null) {
            return null;
        }
        if (mo3988a.mkdirs() || (mo3988a.exists() && mo3988a.isDirectory())) {
            return C1643e.m3989a(mo3988a, this.f4343c);
        }
        return null;
    }

    public C1642d(String str, String str2, long j2) {
        this(new b(str, str2), j2);
    }

    public C1642d(c cVar, long j2) {
        this.f4343c = j2;
        this.f4344d = cVar;
    }
}
