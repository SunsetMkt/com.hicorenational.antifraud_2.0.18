package com.bumptech.glide.load.p.b0;

import android.content.Context;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* JADX INFO: compiled from: ExternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class f extends d {

    /* JADX INFO: compiled from: ExternalCacheDiskCacheFactory.java */
    class a implements d.c {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2836b;

        a(Context context, String str) {
            this.a = context;
            this.f2836b = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File externalCacheDir = this.a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            String str = this.f2836b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, a.InterfaceC0046a.f2821b, a.InterfaceC0046a.a);
    }

    public f(Context context, int i2) {
        this(context, a.InterfaceC0046a.f2821b, i2);
    }

    public f(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
