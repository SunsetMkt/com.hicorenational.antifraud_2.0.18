package com.bumptech.glide.load.p.b0;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.d;
import java.io.File;

/* JADX INFO: compiled from: ExternalPreferredCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: compiled from: ExternalPreferredCacheDiskCacheFactory.java */
    class a implements d.c {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f2837b;

        a(Context context, String str) {
            this.a = context;
            this.f2837b = str;
        }

        @Nullable
        private File b() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f2837b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            File externalCacheDir;
            File fileB = b();
            if ((fileB != null && fileB.exists()) || (externalCacheDir = this.a.getExternalCacheDir()) == null || !externalCacheDir.canWrite()) {
                return fileB;
            }
            String str = this.f2837b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public g(Context context) {
        this(context, a.InterfaceC0046a.f2821b, 262144000L);
    }

    public g(Context context, long j2) {
        this(context, a.InterfaceC0046a.f2821b, j2);
    }

    public g(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
