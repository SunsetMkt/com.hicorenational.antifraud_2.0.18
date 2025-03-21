package com.bumptech.glide.load.p123q;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.C1608h;
import com.bumptech.glide.load.p116o.C1614n;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* renamed from: com.bumptech.glide.load.q.a */
/* loaded from: classes.dex */
public class C1682a<Data> implements InterfaceC1695n<Uri, Data> {

    /* renamed from: c */
    private static final String f4666c = "android_asset";

    /* renamed from: d */
    private static final String f4667d = "file:///android_asset/";

    /* renamed from: e */
    private static final int f4668e = 22;

    /* renamed from: a */
    private final AssetManager f4669a;

    /* renamed from: b */
    private final a<Data> f4670b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.a$a */
    public interface a<Data> {
        /* renamed from: a */
        InterfaceC1604d<Data> mo4219a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.a$b */
    public static class b implements InterfaceC1696o<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {

        /* renamed from: a */
        private final AssetManager f4671a;

        public b(AssetManager assetManager) {
            this.f4671a = assetManager;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, ParcelFileDescriptor> mo4220a(C1699r c1699r) {
            return new C1682a(this.f4671a, this);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }

        @Override // com.bumptech.glide.load.p123q.C1682a.a
        /* renamed from: a */
        public InterfaceC1604d<ParcelFileDescriptor> mo4219a(AssetManager assetManager, String str) {
            return new C1608h(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.a$c */
    public static class c implements InterfaceC1696o<Uri, InputStream>, a<InputStream> {

        /* renamed from: a */
        private final AssetManager f4672a;

        public c(AssetManager assetManager) {
            this.f4672a = assetManager;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, InputStream> mo4220a(C1699r c1699r) {
            return new C1682a(this.f4672a, this);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }

        @Override // com.bumptech.glide.load.p123q.C1682a.a
        /* renamed from: a */
        public InterfaceC1604d<InputStream> mo4219a(AssetManager assetManager, String str) {
            return new C1614n(assetManager, str);
        }
    }

    public C1682a(AssetManager assetManager, a<Data> aVar) {
        this.f4669a = assetManager;
        this.f4670b = aVar;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(uri), this.f4670b.mo4219a(this.f4669a, uri.toString().substring(f4668e)));
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f4666c.equals(uri.getPathSegments().get(0));
    }
}
