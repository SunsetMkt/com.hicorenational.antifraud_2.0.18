package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;

/* compiled from: UnitModelLoader.java */
/* renamed from: com.bumptech.glide.load.q.v */
/* loaded from: classes.dex */
public class C1703v<Model> implements InterfaceC1695n<Model, Model> {

    /* renamed from: a */
    private static final C1703v<?> f4761a = new C1703v<>();

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.q.v$a */
    public static class a<Model> implements InterfaceC1696o<Model, Model> {

        /* renamed from: a */
        private static final a<?> f4762a = new a<>();

        @Deprecated
        public a() {
        }

        /* renamed from: b */
        public static <T> a<T> m4290b() {
            return (a<T>) f4762a;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Model, Model> mo4220a(C1699r c1699r) {
            return C1703v.m4289a();
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.q.v$b */
    private static class b<Model> implements InterfaceC1604d<Model> {

        /* renamed from: a */
        private final Model f4763a;

        b(Model model) {
            this.f4763a = model;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super Model> aVar) {
            aVar.mo3857a((InterfaceC1604d.a<? super Model>) this.f4763a);
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: b */
        public void mo3851b() {
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        @NonNull
        /* renamed from: c */
        public EnumC1587a mo3852c() {
            return EnumC1587a.LOCAL;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        @NonNull
        /* renamed from: a */
        public Class<Model> mo3846a() {
            return (Class<Model>) this.f4763a.getClass();
        }
    }

    @Deprecated
    public C1703v() {
    }

    /* renamed from: a */
    public static <T> C1703v<T> m4289a() {
        return (C1703v<T>) f4761a;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public boolean mo4218a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public InterfaceC1695n.a<Model> mo4217a(@NonNull Model model, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(model), new b(model));
    }
}
