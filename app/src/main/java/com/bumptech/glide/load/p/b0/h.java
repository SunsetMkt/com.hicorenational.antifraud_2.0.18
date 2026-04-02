package com.bumptech.glide.load.p.b0;

import android.content.Context;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
    class a implements d.c {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2838b;

        a(Context context, String str) {
            this.a = context;
            this.f2838b = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f2838b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, a.InterfaceC0046a.f2821b, 262144000L);
    }

    public h(Context context, long j2) {
        this(context, a.InterfaceC0046a.f2821b, j2);
    }

    public h(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
