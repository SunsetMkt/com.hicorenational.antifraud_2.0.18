package com.bumptech.glide.load.p123q.p124y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p116o.C1610j;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.load.p123q.C1694m;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.b */
/* loaded from: classes.dex */
public class C1707b implements InterfaceC1695n<C1688g, InputStream> {

    /* renamed from: b */
    public static final C1595i<Integer> f4773b = C1595i.m3831a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a */
    @Nullable
    private final C1694m<C1688g, C1688g> f4774a;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.b$a */
    public static class a implements InterfaceC1696o<C1688g, InputStream> {

        /* renamed from: a */
        private final C1694m<C1688g, C1688g> f4775a = new C1694m<>(500);

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<C1688g, InputStream> mo4220a(C1699r c1699r) {
            return new C1707b(this.f4775a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1707b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull C1688g c1688g) {
        return true;
    }

    public C1707b(@Nullable C1694m<C1688g, C1688g> c1694m) {
        this.f4774a = c1694m;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull C1688g c1688g, int i2, int i3, @NonNull C1596j c1596j) {
        C1694m<C1688g, C1688g> c1694m = this.f4774a;
        if (c1694m != null) {
            C1688g m4251a = c1694m.m4251a(c1688g, 0, 0);
            if (m4251a == null) {
                this.f4774a.m4253a(c1688g, 0, 0, c1688g);
            } else {
                c1688g = m4251a;
            }
        }
        return new InterfaceC1695n.a<>(c1688g, new C1610j(c1688g, ((Integer) c1596j.m3840a(f4773b)).intValue()));
    }
}
