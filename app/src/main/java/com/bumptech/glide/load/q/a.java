package com.bumptech.glide.load.q;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3055c = "android_asset";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3056d = "file:///android_asset/";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f3057e = 22;
    private final AssetManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0054a<Data> f3058b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0054a<Data> {
        com.bumptech.glide.load.o.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0054a<ParcelFileDescriptor> {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.a, this);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.a.InterfaceC0054a
        public com.bumptech.glide.load.o.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.o.h(assetManager, str);
        }
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements o<Uri, InputStream>, InterfaceC0054a<InputStream> {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.a, this);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.q.a.InterfaceC0054a
        public com.bumptech.glide.load.o.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.o.n(assetManager, str);
        }
    }

    public a(AssetManager assetManager, InterfaceC0054a<Data> interfaceC0054a) {
        this.a = assetManager;
        this.f3058b = interfaceC0054a;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), this.f3058b.a(this.a, uri.toString().substring(f3057e)));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f3055c.equals(uri.getPathSegments().get(0));
    }
}
