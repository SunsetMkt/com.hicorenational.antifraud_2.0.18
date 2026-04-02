package com.bumptech.glide.load.o;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import java.io.IOException;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f2722d = "AssetPathFetcher";
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f2723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f2724c;

    public b(AssetManager assetManager, String str) {
        this.f2723b = assetManager;
        this.a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            this.f2724c = a(this.f2723b, this.a);
            aVar.a(this.f2724c);
        } catch (IOException e2) {
            Log.isLoggable(f2722d, 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        T t = this.f2724c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
