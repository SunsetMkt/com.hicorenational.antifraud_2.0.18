package com.bumptech.glide.load.p118p.p120b0;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.p120b0.C1642d;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import java.io.File;

/* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
/* renamed from: com.bumptech.glide.load.p.b0.g */
/* loaded from: classes.dex */
public final class C1645g extends C1642d {

    /* compiled from: ExternalPreferredCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.g$a */
    class a implements C1642d.c {

        /* renamed from: a */
        final /* synthetic */ Context f4359a;

        /* renamed from: b */
        final /* synthetic */ String f4360b;

        a(Context context, String str) {
            this.f4359a = context;
            this.f4360b = str;
        }

        @Nullable
        /* renamed from: b */
        private File m3993b() {
            File cacheDir = this.f4359a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f4360b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1642d.c
        /* renamed from: a */
        public File mo3988a() {
            File externalCacheDir;
            File m3993b = m3993b();
            if ((m3993b != null && m3993b.exists()) || (externalCacheDir = this.f4359a.getExternalCacheDir()) == null || !externalCacheDir.canWrite()) {
                return m3993b;
            }
            String str = this.f4360b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public C1645g(Context context) {
        this(context, InterfaceC1639a.a.f4336b, 262144000L);
    }

    public C1645g(Context context, long j2) {
        this(context, InterfaceC1639a.a.f4336b, j2);
    }

    public C1645g(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
