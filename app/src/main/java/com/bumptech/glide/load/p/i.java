package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2956f = "DecodePath";
    private final Class<DataType> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.l<DataType, ResourceType>> f2957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.r.h.e<ResourceType, Transcode> f2958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f2959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2960e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        @NonNull
        v<ResourceType> a(@NonNull v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.l<DataType, ResourceType>> list, com.bumptech.glide.load.r.h.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.f2957b = list;
        this.f2958c = eVar;
        this.f2959d = pool;
        this.f2960e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar, a<ResourceType> aVar) throws q {
        return this.f2958c.a(aVar.a(a(eVar, i2, i3, jVar)), jVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.f2957b + ", transcoder=" + this.f2958c + '}';
    }

    @NonNull
    private v<ResourceType> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws q {
        List<Throwable> list = (List) com.bumptech.glide.util.j.a(this.f2959d.acquire());
        try {
            return a(eVar, i2, i3, jVar, list);
        } finally {
            this.f2959d.release(list);
        }
    }

    @NonNull
    private v<ResourceType> a(com.bumptech.glide.load.o.e<DataType> eVar, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar, List<Throwable> list) throws q {
        int size = this.f2957b.size();
        v<ResourceType> vVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.l<DataType, ResourceType> lVar = this.f2957b.get(i4);
            try {
                if (lVar.a(eVar.a(), jVar)) {
                    vVarA = lVar.a(eVar.a(), i2, i3, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f2956f, 2)) {
                    String str = "Failed to decode data for " + lVar;
                }
                list.add(e2);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f2960e, new ArrayList(list));
    }
}
