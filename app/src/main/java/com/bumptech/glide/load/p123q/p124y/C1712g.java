package com.bumptech.glide.load.p123q.p124y;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.g */
/* loaded from: classes.dex */
public class C1712g implements InterfaceC1695n<URL, InputStream> {

    /* renamed from: a */
    private final InterfaceC1695n<C1688g, InputStream> f4799a;

    /* compiled from: UrlLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.g$a */
    public static class a implements InterfaceC1696o<URL, InputStream> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<URL, InputStream> mo4220a(C1699r c1699r) {
            return new C1712g(c1699r.m4276a(C1688g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1712g(InterfaceC1695n<C1688g, InputStream> interfaceC1695n) {
        this.f4799a = interfaceC1695n;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull URL url, int i2, int i3, @NonNull C1596j c1596j) {
        return this.f4799a.mo4217a(new C1688g(url), i2, i3, c1596j);
    }
}
