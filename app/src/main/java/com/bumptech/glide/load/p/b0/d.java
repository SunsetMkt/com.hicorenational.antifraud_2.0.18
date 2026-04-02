package com.bumptech.glide.load.p.b0;

import com.bumptech.glide.load.p.b0.a;
import java.io.File;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements a.InterfaceC0046a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f2825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f2826d;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    class a implements c {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            return new File(this.a);
        }
    }

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    class b implements c {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2827b;

        b(String str, String str2) {
            this.a = str;
            this.f2827b = str2;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            return new File(this.a, this.f2827b);
        }
    }

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface c {
        File a();
    }

    public d(String str, long j2) {
        this(new a(str), j2);
    }

    @Override // com.bumptech.glide.load.p.b0.a.InterfaceC0046a
    public com.bumptech.glide.load.p.b0.a build() {
        File fileA = this.f2826d.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.a(fileA, this.f2825c);
        }
        return null;
    }

    public d(String str, String str2, long j2) {
        this(new b(str, str2), j2);
    }

    public d(c cVar, long j2) {
        this.f2825c = j2;
        this.f2826d = cVar;
    }
}
