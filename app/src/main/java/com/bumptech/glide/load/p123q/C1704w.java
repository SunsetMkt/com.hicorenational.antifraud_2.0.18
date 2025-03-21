package com.bumptech.glide.load.p123q;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.C1601a;
import com.bumptech.glide.load.p116o.C1609i;
import com.bumptech.glide.load.p116o.C1615o;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* renamed from: com.bumptech.glide.load.q.w */
/* loaded from: classes.dex */
public class C1704w<Data> implements InterfaceC1695n<Uri, Data> {

    /* renamed from: b */
    private static final Set<String> f4764b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a */
    private final c<Data> f4765a;

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.w$a */
    public static final class a implements InterfaceC1696o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f4766a;

        public a(ContentResolver contentResolver) {
            this.f4766a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public InterfaceC1695n<Uri, AssetFileDescriptor> mo4220a(C1699r c1699r) {
            return new C1704w(this);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }

        @Override // com.bumptech.glide.load.p123q.C1704w.c
        /* renamed from: a */
        public InterfaceC1604d<AssetFileDescriptor> mo4291a(Uri uri) {
            return new C1601a(this.f4766a, uri);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.w$b */
    public static class b implements InterfaceC1696o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a */
        private final ContentResolver f4767a;

        public b(ContentResolver contentResolver) {
            this.f4767a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p123q.C1704w.c
        /* renamed from: a */
        public InterfaceC1604d<ParcelFileDescriptor> mo4291a(Uri uri) {
            return new C1609i(this.f4767a, uri);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, ParcelFileDescriptor> mo4220a(C1699r c1699r) {
            return new C1704w(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.w$c */
    public interface c<Data> {
        /* renamed from: a */
        InterfaceC1604d<Data> mo4291a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.w$d */
    public static class d implements InterfaceC1696o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a */
        private final ContentResolver f4768a;

        public d(ContentResolver contentResolver) {
            this.f4768a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p123q.C1704w.c
        /* renamed from: a */
        public InterfaceC1604d<InputStream> mo4291a(Uri uri) {
            return new C1615o(this.f4768a, uri);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, InputStream> mo4220a(C1699r c1699r) {
            return new C1704w(this);
        }
    }

    public C1704w(c<Data> cVar) {
        this.f4765a = cVar;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(uri), this.f4765a.mo4291a(uri));
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return f4764b.contains(uri.getScheme());
    }
}
