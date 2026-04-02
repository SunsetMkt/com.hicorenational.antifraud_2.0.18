package com.bumptech.glide.load.o;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2744d = "LocalUriFetcher";
    private final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f2745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f2746c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f2745b = contentResolver;
        this.a = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.o.d
    public final void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            this.f2746c = a(this.a, this.f2745b);
            aVar.a(this.f2746c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f2744d, 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        T t = this.f2746c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
    }
}
