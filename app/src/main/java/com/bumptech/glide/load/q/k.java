package com.bumptech.glide.load.q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n<Uri, File> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, File> a(r rVar) {
            return new k(this.a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public k(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<File> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), new b(this.a, uri));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.o.p.b.b(uri);
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.o.d<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f3083c = {"_data"};
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f3084b;

        b(Context context, Uri uri) {
            this.a = context;
            this.f3084b = uri;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super File> aVar) {
            Cursor cursorQuery = this.a.getContentResolver().query(this.f3084b, f3083c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.a(new File(string));
                return;
            }
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f3084b));
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }
    }
}
