package com.bumptech.glide.load.q;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.q.n;
import java.io.InputStream;

/* JADX INFO: compiled from: ResourceLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3107c = "ResourceLoader";
    private final n<Uri, Data> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f3108b;

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class c implements o<Integer, InputStream> {
        private final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.a, rVar.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class d implements o<Integer, Uri> {
        private final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.a, v.a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f3108b = resources;
        this.a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f3108b.getResourcePackageName(num.intValue()) + '/' + this.f3108b.getResourceTypeName(num.intValue()) + '/' + this.f3108b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (!Log.isLoggable(f3107c, 5)) {
                return null;
            }
            String str = "Received invalid resource id: " + num;
            return null;
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Integer num) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Integer num, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        Uri uriB = b(num);
        if (uriB == null) {
            return null;
        }
        return this.a.a(uriB, i2, i3, jVar);
    }
}
