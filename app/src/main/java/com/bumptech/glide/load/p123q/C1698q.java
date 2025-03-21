package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p118p.C1672q;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.util.C1876j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* renamed from: com.bumptech.glide.load.q.q */
/* loaded from: classes.dex */
class C1698q<Model, Data> implements InterfaceC1695n<Model, Data> {

    /* renamed from: a */
    private final List<InterfaceC1695n<Model, Data>> f4733a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f4734b;

    C1698q(@NonNull List<InterfaceC1695n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f4733a = list;
        this.f4734b = pool;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull Model model, int i2, int i3, @NonNull C1596j c1596j) {
        InterfaceC1695n.a<Data> mo4217a;
        int size = this.f4733a.size();
        ArrayList arrayList = new ArrayList(size);
        InterfaceC1593g interfaceC1593g = null;
        for (int i4 = 0; i4 < size; i4++) {
            InterfaceC1695n<Model, Data> interfaceC1695n = this.f4733a.get(i4);
            if (interfaceC1695n.mo4218a(model) && (mo4217a = interfaceC1695n.mo4217a(model, i2, i3, c1596j)) != null) {
                interfaceC1593g = mo4217a.f4726a;
                arrayList.add(mo4217a.f4728c);
            }
        }
        if (arrayList.isEmpty() || interfaceC1593g == null) {
            return null;
        }
        return new InterfaceC1695n.a<>(interfaceC1593g, new a(arrayList, this.f4734b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f4733a.toArray()) + '}';
    }

    /* compiled from: MultiModelLoader.java */
    /* renamed from: com.bumptech.glide.load.q.q$a */
    static class a<Data> implements InterfaceC1604d<Data>, InterfaceC1604d.a<Data> {

        /* renamed from: a */
        private final List<InterfaceC1604d<Data>> f4735a;

        /* renamed from: b */
        private final Pools.Pool<List<Throwable>> f4736b;

        /* renamed from: c */
        private int f4737c;

        /* renamed from: d */
        private EnumC1582h f4738d;

        /* renamed from: e */
        private InterfaceC1604d.a<? super Data> f4739e;

        /* renamed from: f */
        @Nullable
        private List<Throwable> f4740f;

        /* renamed from: g */
        private boolean f4741g;

        a(@NonNull List<InterfaceC1604d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f4736b = pool;
            C1876j.m4988a(list);
            this.f4735a = list;
            this.f4737c = 0;
        }

        /* renamed from: d */
        private void m4271d() {
            if (this.f4741g) {
                return;
            }
            if (this.f4737c < this.f4735a.size() - 1) {
                this.f4737c++;
                mo3849a(this.f4738d, this.f4739e);
            } else {
                C1876j.m4985a(this.f4740f);
                this.f4739e.mo3856a((Exception) new C1672q("Fetch failed", new ArrayList(this.f4740f)));
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super Data> aVar) {
            this.f4738d = enumC1582h;
            this.f4739e = aVar;
            this.f4740f = this.f4736b.acquire();
            this.f4735a.get(this.f4737c).mo3849a(enumC1582h, this);
            if (this.f4741g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: b */
        public void mo3851b() {
            List<Throwable> list = this.f4740f;
            if (list != null) {
                this.f4736b.release(list);
            }
            this.f4740f = null;
            Iterator<InterfaceC1604d<Data>> it = this.f4735a.iterator();
            while (it.hasNext()) {
                it.next().mo3851b();
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        @NonNull
        /* renamed from: c */
        public EnumC1587a mo3852c() {
            return this.f4735a.get(0).mo3852c();
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        public void cancel() {
            this.f4741g = true;
            Iterator<InterfaceC1604d<Data>> it = this.f4735a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        @NonNull
        /* renamed from: a */
        public Class<Data> mo3846a() {
            return this.f4735a.get(0).mo3846a();
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
        /* renamed from: a */
        public void mo3857a(@Nullable Data data) {
            if (data != null) {
                this.f4739e.mo3857a((InterfaceC1604d.a<? super Data>) data);
            } else {
                m4271d();
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
        /* renamed from: a */
        public void mo3856a(@NonNull Exception exc) {
            ((List) C1876j.m4985a(this.f4740f)).add(exc);
            m4271d();
        }
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public boolean mo4218a(@NonNull Model model) {
        Iterator<InterfaceC1695n<Model, Data>> it = this.f4733a.iterator();
        while (it.hasNext()) {
            if (it.next().mo4218a(model)) {
                return true;
            }
        }
        return false;
    }
}
