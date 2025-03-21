package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p118p.C1664i;
import com.bumptech.glide.util.C1876j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* renamed from: com.bumptech.glide.load.p.t */
/* loaded from: classes.dex */
public class C1675t<Data, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<Data> f4625a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f4626b;

    /* renamed from: c */
    private final List<? extends C1664i<Data, ResourceType, Transcode>> f4627c;

    /* renamed from: d */
    private final String f4628d;

    public C1675t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<C1664i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f4625a = cls;
        this.f4626b = pool;
        this.f4627c = (List) C1876j.m4988a(list);
        this.f4628d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public InterfaceC1677v<Transcode> m4202a(InterfaceC1605e<Data> interfaceC1605e, @NonNull C1596j c1596j, int i2, int i3, C1664i.a<ResourceType> aVar) throws C1672q {
        List<Throwable> list = (List) C1876j.m4985a(this.f4626b.acquire());
        try {
            return m4201a(interfaceC1605e, c1596j, i2, i3, aVar, list);
        } finally {
            this.f4626b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4627c.toArray()) + '}';
    }

    /* renamed from: a */
    private InterfaceC1677v<Transcode> m4201a(InterfaceC1605e<Data> interfaceC1605e, @NonNull C1596j c1596j, int i2, int i3, C1664i.a<ResourceType> aVar, List<Throwable> list) throws C1672q {
        int size = this.f4627c.size();
        InterfaceC1677v<Transcode> interfaceC1677v = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                interfaceC1677v = this.f4627c.get(i4).m4137a(interfaceC1605e, i2, i3, c1596j, aVar);
            } catch (C1672q e2) {
                list.add(e2);
            }
            if (interfaceC1677v != null) {
                break;
            }
        }
        if (interfaceC1677v != null) {
            return interfaceC1677v;
        }
        throw new C1672q(this.f4628d, new ArrayList(list));
    }

    /* renamed from: a */
    public Class<Data> m4203a() {
        return this.f4625a;
    }
}
