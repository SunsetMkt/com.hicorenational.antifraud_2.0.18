package com.bumptech.glide.load.p123q.p124y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.p117p.C1617b;
import com.bumptech.glide.load.p116o.p117p.C1618c;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import com.bumptech.glide.p140s.C1866e;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.d */
/* loaded from: classes.dex */
public class C1709d implements InterfaceC1695n<Uri, InputStream> {

    /* renamed from: a */
    private final Context f4778a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.d$a */
    public static class a implements InterfaceC1696o<Uri, InputStream> {

        /* renamed from: a */
        private final Context f4779a;

        public a(Context context) {
            this.f4779a = context;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, InputStream> mo4220a(C1699r c1699r) {
            return new C1709d(this.f4779a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1709d(Context context) {
        this.f4778a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        if (C1617b.m3877a(i2, i3)) {
            return new InterfaceC1695n.a<>(new C1866e(uri), C1618c.m3882a(this.f4778a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return C1617b.m3878a(uri);
    }
}
