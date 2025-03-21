package com.bumptech.glide.load.p118p.p120b0;

import android.content.Context;
import com.bumptech.glide.load.p118p.p120b0.C1642d;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* renamed from: com.bumptech.glide.load.p.b0.h */
/* loaded from: classes.dex */
public final class C1646h extends C1642d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.h$a */
    class a implements C1642d.c {

        /* renamed from: a */
        final /* synthetic */ Context f4361a;

        /* renamed from: b */
        final /* synthetic */ String f4362b;

        a(Context context, String str) {
            this.f4361a = context;
            this.f4362b = str;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1642d.c
        /* renamed from: a */
        public File mo3988a() {
            File cacheDir = this.f4361a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.f4362b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }
    }

    public C1646h(Context context) {
        this(context, InterfaceC1639a.a.f4336b, 262144000L);
    }

    public C1646h(Context context, long j2) {
        this(context, InterfaceC1639a.a.f4336b, j2);
    }

    public C1646h(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
