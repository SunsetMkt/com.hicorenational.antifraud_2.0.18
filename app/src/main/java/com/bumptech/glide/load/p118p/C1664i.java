package com.bumptech.glide.load.p118p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import com.bumptech.glide.load.p125r.p130h.InterfaceC1766e;
import com.bumptech.glide.util.C1876j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* renamed from: com.bumptech.glide.load.p.i */
/* loaded from: classes.dex */
public class C1664i<DataType, ResourceType, Transcode> {

    /* renamed from: f */
    private static final String f4531f = "DecodePath";

    /* renamed from: a */
    private final Class<DataType> f4532a;

    /* renamed from: b */
    private final List<? extends InterfaceC1598l<DataType, ResourceType>> f4533b;

    /* renamed from: c */
    private final InterfaceC1766e<ResourceType, Transcode> f4534c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f4535d;

    /* renamed from: e */
    private final String f4536e;

    /* compiled from: DecodePath.java */
    /* renamed from: com.bumptech.glide.load.p.i$a */
    interface a<ResourceType> {
        @NonNull
        /* renamed from: a */
        InterfaceC1677v<ResourceType> mo4124a(@NonNull InterfaceC1677v<ResourceType> interfaceC1677v);
    }

    public C1664i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends InterfaceC1598l<DataType, ResourceType>> list, InterfaceC1766e<ResourceType, Transcode> interfaceC1766e, Pools.Pool<List<Throwable>> pool) {
        this.f4532a = cls;
        this.f4533b = list;
        this.f4534c = interfaceC1766e;
        this.f4535d = pool;
        this.f4536e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public InterfaceC1677v<Transcode> m4137a(InterfaceC1605e<DataType> interfaceC1605e, int i2, int i3, @NonNull C1596j c1596j, a<ResourceType> aVar) throws C1672q {
        return this.f4534c.mo4432a(aVar.mo4124a(m4135a(interfaceC1605e, i2, i3, c1596j)), c1596j);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f4532a + ", decoders=" + this.f4533b + ", transcoder=" + this.f4534c + '}';
    }

    @NonNull
    /* renamed from: a */
    private InterfaceC1677v<ResourceType> m4135a(InterfaceC1605e<DataType> interfaceC1605e, int i2, int i3, @NonNull C1596j c1596j) throws C1672q {
        List<Throwable> list = (List) C1876j.m4985a(this.f4535d.acquire());
        try {
            return m4136a(interfaceC1605e, i2, i3, c1596j, list);
        } finally {
            this.f4535d.release(list);
        }
    }

    @NonNull
    /* renamed from: a */
    private InterfaceC1677v<ResourceType> m4136a(InterfaceC1605e<DataType> interfaceC1605e, int i2, int i3, @NonNull C1596j c1596j, List<Throwable> list) throws C1672q {
        int size = this.f4533b.size();
        InterfaceC1677v<ResourceType> interfaceC1677v = null;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC1598l<DataType, ResourceType> interfaceC1598l = this.f4533b.get(i4);
            try {
                if (interfaceC1598l.mo3843a(interfaceC1605e.mo3858a(), c1596j)) {
                    interfaceC1677v = interfaceC1598l.mo3842a(interfaceC1605e.mo3858a(), i2, i3, c1596j);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f4531f, 2)) {
                    String str = "Failed to decode data for " + interfaceC1598l;
                }
                list.add(e2);
            }
            if (interfaceC1677v != null) {
                break;
            }
        }
        if (interfaceC1677v != null) {
            return interfaceC1677v;
        }
        throw new C1672q(this.f4536e, new ArrayList(list));
    }
}
