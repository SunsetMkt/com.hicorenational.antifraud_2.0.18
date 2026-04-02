package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.b0.a;
import java.io.File;

/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes.dex */
class e<DataType> implements a.b {
    private final com.bumptech.glide.load.d<DataType> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f2921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.j f2922c;

    e(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, com.bumptech.glide.load.j jVar) {
        this.a = dVar;
        this.f2921b = datatype;
        this.f2922c = jVar;
    }

    @Override // com.bumptech.glide.load.p.b0.a.b
    public boolean a(@NonNull File file) {
        return this.a.a(this.f2921b, file, this.f2922c);
    }
}
