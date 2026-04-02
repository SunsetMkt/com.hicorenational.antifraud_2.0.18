package com.bumptech.glide.load.o.p;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.h;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.o.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.o.d<InputStream> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2754d = "MediaStoreThumbFetcher";
    private final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f2755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f2756c;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f2757b = {"_data"};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f2758c = "kind = 1 AND image_id = ?";
        private final ContentResolver a;

        a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.o.p.d
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f2757b, f2758c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f2759b = {"_data"};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f2760c = "kind = 1 AND video_id = ?";
        private final ContentResolver a;

        b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.o.p.d
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f2759b, f2760c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.a = uri;
        this.f2755b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws Throwable {
        InputStream inputStreamB = this.f2755b.b(this.a);
        int iA = inputStreamB != null ? this.f2755b.a(this.a) : -1;
        return iA != -1 ? new g(inputStreamB, iA) : inputStreamB;
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.a(context).h().a(), dVar, com.bumptech.glide.b.a(context).c(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        InputStream inputStream = this.f2756c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull h hVar, @NonNull d.a<? super InputStream> aVar) {
        try {
            this.f2756c = d();
            aVar.a(this.f2756c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f2754d, 3);
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
