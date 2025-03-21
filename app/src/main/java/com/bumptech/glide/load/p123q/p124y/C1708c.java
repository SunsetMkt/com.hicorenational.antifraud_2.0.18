package com.bumptech.glide.load.p123q.p124y;

import android.net.Uri;
import androidx.annotation.NonNull;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.c */
/* loaded from: classes.dex */
public class C1708c implements InterfaceC1695n<Uri, InputStream> {

    /* renamed from: b */
    private static final Set<String> f4776b = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpConstant.HTTP, HttpConstant.HTTPS)));

    /* renamed from: a */
    private final InterfaceC1695n<C1688g, InputStream> f4777a;

    /* compiled from: HttpUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.c$a */
    public static class a implements InterfaceC1696o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, InputStream> mo4220a(C1699r c1699r) {
            return new C1708c(c1699r.m4276a(C1688g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1708c(InterfaceC1695n<C1688g, InputStream> interfaceC1695n) {
        this.f4777a = interfaceC1695n;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        return this.f4777a.mo4217a(new C1688g(uri.toString()), i2, i3, c1596j);
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return f4776b.contains(uri.getScheme());
    }
}
