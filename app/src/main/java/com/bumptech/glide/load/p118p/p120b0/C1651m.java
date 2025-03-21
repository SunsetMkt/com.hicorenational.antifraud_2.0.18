package com.bumptech.glide.load.p118p.p120b0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.util.C1873g;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.C1878l;
import com.bumptech.glide.util.p141n.AbstractC1882c;
import com.bumptech.glide.util.p141n.C1880a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* renamed from: com.bumptech.glide.load.p.b0.m */
/* loaded from: classes.dex */
public class C1651m {

    /* renamed from: a */
    private final C1873g<InterfaceC1593g, String> f4386a = new C1873g<>(1000);

    /* renamed from: b */
    private final Pools.Pool<b> f4387b = C1880a.m5020b(10, new a());

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: com.bumptech.glide.load.p.b0.m$a */
    class a implements C1880a.d<b> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.p141n.C1880a.d
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: com.bumptech.glide.load.p.b0.m$b */
    private static final class b implements C1880a.f {

        /* renamed from: a */
        final MessageDigest f4389a;

        /* renamed from: b */
        private final AbstractC1882c f4390b = AbstractC1882c.m5029b();

        b(MessageDigest messageDigest) {
            this.f4389a = messageDigest;
        }

        @Override // com.bumptech.glide.util.p141n.C1880a.f
        @NonNull
        /* renamed from: c */
        public AbstractC1882c mo4024c() {
            return this.f4390b;
        }
    }

    /* renamed from: b */
    private String m4022b(InterfaceC1593g interfaceC1593g) {
        b bVar = (b) C1876j.m4985a(this.f4387b.acquire());
        try {
            interfaceC1593g.mo3827a(bVar.f4389a);
            return C1878l.m4999a(bVar.f4389a.digest());
        } finally {
            this.f4387b.release(bVar);
        }
    }

    /* renamed from: a */
    public String m4023a(InterfaceC1593g interfaceC1593g) {
        String m4977b;
        synchronized (this.f4386a) {
            m4977b = this.f4386a.m4977b(interfaceC1593g);
        }
        if (m4977b == null) {
            m4977b = m4022b(interfaceC1593g);
        }
        synchronized (this.f4386a) {
            this.f4386a.m4978b(interfaceC1593g, m4977b);
        }
        return m4977b;
    }
}
