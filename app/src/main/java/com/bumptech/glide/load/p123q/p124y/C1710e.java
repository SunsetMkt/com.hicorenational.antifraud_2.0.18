package com.bumptech.glide.load.p123q.p124y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.p117p.C1617b;
import com.bumptech.glide.load.p116o.p117p.C1618c;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import com.bumptech.glide.load.p125r.p126d.C1735j0;
import com.bumptech.glide.p140s.C1866e;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.e */
/* loaded from: classes.dex */
public class C1710e implements InterfaceC1695n<Uri, InputStream> {

    /* renamed from: a */
    private final Context f4780a;

    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.e$a */
    public static class a implements InterfaceC1696o<Uri, InputStream> {

        /* renamed from: a */
        private final Context f4781a;

        public a(Context context) {
            this.f4781a = context;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, InputStream> mo4220a(C1699r c1699r) {
            return new C1710e(this.f4781a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1710e(Context context) {
        this.f4780a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    @Nullable
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        if (C1617b.m3877a(i2, i3) && m4296a(c1596j)) {
            return new InterfaceC1695n.a<>(new C1866e(uri), C1618c.m3884b(this.f4780a, uri));
        }
        return null;
    }

    /* renamed from: a */
    private boolean m4296a(C1596j c1596j) {
        Long l2 = (Long) c1596j.m3840a(C1735j0.f4863g);
        return l2 != null && l2.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return C1617b.m3880c(uri);
    }
}
