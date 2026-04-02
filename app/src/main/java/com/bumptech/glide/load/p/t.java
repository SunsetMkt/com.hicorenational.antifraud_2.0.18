package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes.dex */
public class t<Data, ResourceType, Transcode> {
    private final Class<Data> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f3021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f3022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3023d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.f3021b = pool;
        this.f3022c = (List) com.bumptech.glide.util.j.a(list);
        this.f3023d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.o.e<Data> eVar, @NonNull com.bumptech.glide.load.j jVar, int i2, int i3, i.a<ResourceType> aVar) throws q {
        List<Throwable> list = (List) com.bumptech.glide.util.j.a(this.f3021b.acquire());
        try {
            return a(eVar, jVar, i2, i3, aVar, list);
        } finally {
            this.f3021b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f3022c.toArray()) + '}';
    }

    private v<Transcode> a(com.bumptech.glide.load.o.e<Data> eVar, @NonNull com.bumptech.glide.load.j jVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f3022c.size();
        v<Transcode> vVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                vVarA = this.f3022c.get(i4).a(eVar, i2, i3, jVar, aVar);
            } catch (q e2) {
                list.add(e2);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f3023d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.a;
    }
}
