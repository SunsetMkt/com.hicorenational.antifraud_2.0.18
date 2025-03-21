package com.bumptech.glide.load.p118p.p120b0;

import android.content.Context;
import com.bumptech.glide.load.p118p.p120b0.C1642d;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import java.io.File;

/* compiled from: ExternalCacheDiskCacheFactory.java */
@Deprecated
/* renamed from: com.bumptech.glide.load.p.b0.f */
/* loaded from: classes.dex */
public final class C1644f extends C1642d {

    /* compiled from: ExternalCacheDiskCacheFactory.java */
    /* renamed from: com.bumptech.glide.load.p.b0.f$a */
    class a implements C1642d.c {

        /* renamed from: a */
        final /* synthetic */ Context f4357a;

        /* renamed from: b */
        final /* synthetic */ String f4358b;

        a(Context context, String str) {
            this.f4357a = context;
            this.f4358b = str;
        }

        @Override // com.bumptech.glide.load.p118p.p120b0.C1642d.c
        /* renamed from: a */
        public File mo3988a() {
            File externalCacheDir = this.f4357a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            String str = this.f4358b;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public C1644f(Context context) {
        this(context, InterfaceC1639a.a.f4336b, InterfaceC1639a.a.f4335a);
    }

    public C1644f(Context context, int i2) {
        this(context, InterfaceC1639a.a.f4336b, i2);
    }

    public C1644f(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
