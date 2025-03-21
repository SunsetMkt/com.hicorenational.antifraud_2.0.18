package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.util.C1876j;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* renamed from: com.bumptech.glide.load.q.n */
/* loaded from: classes.dex */
public interface InterfaceC1695n<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* renamed from: com.bumptech.glide.load.q.n$a */
    public static class a<Data> {

        /* renamed from: a */
        public final InterfaceC1593g f4726a;

        /* renamed from: b */
        public final List<InterfaceC1593g> f4727b;

        /* renamed from: c */
        public final InterfaceC1604d<Data> f4728c;

        public a(@NonNull InterfaceC1593g interfaceC1593g, @NonNull InterfaceC1604d<Data> interfaceC1604d) {
            this(interfaceC1593g, Collections.emptyList(), interfaceC1604d);
        }

        public a(@NonNull InterfaceC1593g interfaceC1593g, @NonNull List<InterfaceC1593g> list, @NonNull InterfaceC1604d<Data> interfaceC1604d) {
            this.f4726a = (InterfaceC1593g) C1876j.m4985a(interfaceC1593g);
            this.f4727b = (List) C1876j.m4985a(list);
            this.f4728c = (InterfaceC1604d) C1876j.m4985a(interfaceC1604d);
        }
    }

    @Nullable
    /* renamed from: a */
    a<Data> mo4217a(@NonNull Model model, int i2, int i3, @NonNull C1596j c1596j);

    /* renamed from: a */
    boolean mo4218a(@NonNull Model model);
}
