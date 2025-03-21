package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p118p.InterfaceC1661f;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* renamed from: com.bumptech.glide.load.p.c */
/* loaded from: classes.dex */
class C1652c implements InterfaceC1661f, InterfaceC1604d.a<Object> {

    /* renamed from: a */
    private final List<InterfaceC1593g> f4391a;

    /* renamed from: b */
    private final C1662g<?> f4392b;

    /* renamed from: c */
    private final InterfaceC1661f.a f4393c;

    /* renamed from: d */
    private int f4394d;

    /* renamed from: e */
    private InterfaceC1593g f4395e;

    /* renamed from: f */
    private List<InterfaceC1695n<File, ?>> f4396f;

    /* renamed from: g */
    private int f4397g;

    /* renamed from: h */
    private volatile InterfaceC1695n.a<?> f4398h;

    /* renamed from: i */
    private File f4399i;

    C1652c(C1662g<?> c1662g, InterfaceC1661f.a aVar) {
        this(c1662g.m4082c(), c1662g, aVar);
    }

    /* renamed from: b */
    private boolean m4025b() {
        return this.f4397g < this.f4396f.size();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    /* renamed from: a */
    public boolean mo4026a() {
        while (true) {
            boolean z = false;
            if (this.f4396f != null && m4025b()) {
                this.f4398h = null;
                while (!z && m4025b()) {
                    List<InterfaceC1695n<File, ?>> list = this.f4396f;
                    int i2 = this.f4397g;
                    this.f4397g = i2 + 1;
                    this.f4398h = list.get(i2).mo4217a(this.f4399i, this.f4392b.m4094n(), this.f4392b.m4086f(), this.f4392b.m4089i());
                    if (this.f4398h != null && this.f4392b.m4083c(this.f4398h.f4728c.mo3846a())) {
                        this.f4398h.f4728c.mo3849a(this.f4392b.m4090j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4394d++;
            if (this.f4394d >= this.f4391a.size()) {
                return false;
            }
            InterfaceC1593g interfaceC1593g = this.f4391a.get(this.f4394d);
            this.f4399i = this.f4392b.m4084d().mo3980a(new C1655d(interfaceC1593g, this.f4392b.m4092l()));
            File file = this.f4399i;
            if (file != null) {
                this.f4395e = interfaceC1593g;
                this.f4396f = this.f4392b.m4075a(file);
                this.f4397g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    public void cancel() {
        InterfaceC1695n.a<?> aVar = this.f4398h;
        if (aVar != null) {
            aVar.f4728c.cancel();
        }
    }

    C1652c(List<InterfaceC1593g> list, C1662g<?> c1662g, InterfaceC1661f.a aVar) {
        this.f4394d = -1;
        this.f4391a = list;
        this.f4392b = c1662g;
        this.f4393c = aVar;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
    /* renamed from: a */
    public void mo3857a(Object obj) {
        this.f4393c.mo4070a(this.f4395e, obj, this.f4398h.f4728c, EnumC1587a.DATA_DISK_CACHE, this.f4395e);
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
    /* renamed from: a */
    public void mo3856a(@NonNull Exception exc) {
        this.f4393c.mo4069a(this.f4395e, exc, this.f4398h.f4728c, EnumC1587a.DATA_DISK_CACHE);
    }
}
