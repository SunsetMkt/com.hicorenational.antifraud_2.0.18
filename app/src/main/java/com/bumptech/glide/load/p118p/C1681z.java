package com.bumptech.glide.load.p118p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p118p.InterfaceC1661f;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.util.C1872f;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator.java */
/* renamed from: com.bumptech.glide.load.p.z */
/* loaded from: classes.dex */
class C1681z implements InterfaceC1661f, InterfaceC1661f.a {

    /* renamed from: h */
    private static final String f4656h = "SourceGenerator";

    /* renamed from: a */
    private final C1662g<?> f4657a;

    /* renamed from: b */
    private final InterfaceC1661f.a f4658b;

    /* renamed from: c */
    private int f4659c;

    /* renamed from: d */
    private C1652c f4660d;

    /* renamed from: e */
    private Object f4661e;

    /* renamed from: f */
    private volatile InterfaceC1695n.a<?> f4662f;

    /* renamed from: g */
    private C1655d f4663g;

    C1681z(C1662g<?> c1662g, InterfaceC1661f.a aVar) {
        this.f4657a = c1662g;
        this.f4658b = aVar;
    }

    /* renamed from: b */
    private void m4212b(InterfaceC1695n.a<?> aVar) {
        this.f4662f.f4728c.mo3849a(this.f4657a.m4090j(), new a(aVar));
    }

    /* renamed from: c */
    private boolean m4213c() {
        return this.f4659c < this.f4657a.m4087g().size();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    /* renamed from: a */
    public boolean mo4026a() {
        Object obj = this.f4661e;
        if (obj != null) {
            this.f4661e = null;
            m4211a(obj);
        }
        C1652c c1652c = this.f4660d;
        if (c1652c != null && c1652c.mo4026a()) {
            return true;
        }
        this.f4660d = null;
        this.f4662f = null;
        boolean z = false;
        while (!z && m4213c()) {
            List<InterfaceC1695n.a<?>> m4087g = this.f4657a.m4087g();
            int i2 = this.f4659c;
            this.f4659c = i2 + 1;
            this.f4662f = m4087g.get(i2);
            if (this.f4662f != null && (this.f4657a.m4085e().mo4139a(this.f4662f.f4728c.mo3852c()) || this.f4657a.m4083c(this.f4662f.f4728c.mo3846a()))) {
                m4212b(this.f4662f);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    public void cancel() {
        InterfaceC1695n.a<?> aVar = this.f4662f;
        if (aVar != null) {
            aVar.f4728c.cancel();
        }
    }

    /* compiled from: SourceGenerator.java */
    /* renamed from: com.bumptech.glide.load.p.z$a */
    class a implements InterfaceC1604d.a<Object> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC1695n.a f4664a;

        a(InterfaceC1695n.a aVar) {
            this.f4664a = aVar;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
        /* renamed from: a */
        public void mo3857a(@Nullable Object obj) {
            if (C1681z.this.m4216a(this.f4664a)) {
                C1681z.this.m4215a(this.f4664a, obj);
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
        /* renamed from: a */
        public void mo3856a(@NonNull Exception exc) {
            if (C1681z.this.m4216a(this.f4664a)) {
                C1681z.this.m4214a(this.f4664a, exc);
            }
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: b */
    public void mo4071b() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    boolean m4216a(InterfaceC1695n.a<?> aVar) {
        InterfaceC1695n.a<?> aVar2 = this.f4662f;
        return aVar2 != null && aVar2 == aVar;
    }

    /* renamed from: a */
    private void m4211a(Object obj) {
        long m4970a = C1872f.m4970a();
        try {
            InterfaceC1590d<X> m4072a = this.f4657a.m4072a((C1662g<?>) obj);
            C1660e c1660e = new C1660e(m4072a, obj, this.f4657a.m4089i());
            this.f4663g = new C1655d(this.f4662f.f4726a, this.f4657a.m4092l());
            this.f4657a.m4084d().mo3981a(this.f4663g, c1660e);
            if (Log.isLoggable(f4656h, 2)) {
                String str = "Finished encoding source to cache, key: " + this.f4663g + ", data: " + obj + ", encoder: " + m4072a + ", duration: " + C1872f.m4969a(m4970a);
            }
            this.f4662f.f4728c.mo3851b();
            this.f4660d = new C1652c(Collections.singletonList(this.f4662f.f4726a), this.f4657a, this);
        } catch (Throwable th) {
            this.f4662f.f4728c.mo3851b();
            throw th;
        }
    }

    /* renamed from: a */
    void m4215a(InterfaceC1695n.a<?> aVar, Object obj) {
        AbstractC1665j m4085e = this.f4657a.m4085e();
        if (obj != null && m4085e.mo4139a(aVar.f4728c.mo3852c())) {
            this.f4661e = obj;
            this.f4658b.mo4071b();
        } else {
            InterfaceC1661f.a aVar2 = this.f4658b;
            InterfaceC1593g interfaceC1593g = aVar.f4726a;
            InterfaceC1604d<?> interfaceC1604d = aVar.f4728c;
            aVar2.mo4070a(interfaceC1593g, obj, interfaceC1604d, interfaceC1604d.mo3852c(), this.f4663g);
        }
    }

    /* renamed from: a */
    void m4214a(InterfaceC1695n.a<?> aVar, @NonNull Exception exc) {
        InterfaceC1661f.a aVar2 = this.f4658b;
        C1655d c1655d = this.f4663g;
        InterfaceC1604d<?> interfaceC1604d = aVar.f4728c;
        aVar2.mo4069a(c1655d, exc, interfaceC1604d, interfaceC1604d.mo3852c());
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: a */
    public void mo4070a(InterfaceC1593g interfaceC1593g, Object obj, InterfaceC1604d<?> interfaceC1604d, EnumC1587a enumC1587a, InterfaceC1593g interfaceC1593g2) {
        this.f4658b.mo4070a(interfaceC1593g, obj, interfaceC1604d, this.f4662f.f4728c.mo3852c(), interfaceC1593g);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f.a
    /* renamed from: a */
    public void mo4069a(InterfaceC1593g interfaceC1593g, Exception exc, InterfaceC1604d<?> interfaceC1604d, EnumC1587a enumC1587a) {
        this.f4658b.mo4069a(interfaceC1593g, exc, interfaceC1604d, this.f4662f.f4728c.mo3852c());
    }
}
