package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p118p.InterfaceC1661f;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* renamed from: com.bumptech.glide.load.p.w */
/* loaded from: classes.dex */
class C1678w implements InterfaceC1661f, InterfaceC1604d.a<Object> {

    /* renamed from: a */
    private final InterfaceC1661f.a f4634a;

    /* renamed from: b */
    private final C1662g<?> f4635b;

    /* renamed from: c */
    private int f4636c;

    /* renamed from: d */
    private int f4637d = -1;

    /* renamed from: e */
    private InterfaceC1593g f4638e;

    /* renamed from: f */
    private List<InterfaceC1695n<File, ?>> f4639f;

    /* renamed from: g */
    private int f4640g;

    /* renamed from: h */
    private volatile InterfaceC1695n.a<?> f4641h;

    /* renamed from: i */
    private File f4642i;

    /* renamed from: j */
    private C1679x f4643j;

    C1678w(C1662g<?> c1662g, InterfaceC1661f.a aVar) {
        this.f4635b = c1662g;
        this.f4634a = aVar;
    }

    /* renamed from: b */
    private boolean m4208b() {
        return this.f4640g < this.f4639f.size();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    /* renamed from: a */
    public boolean mo4026a() {
        List<InterfaceC1593g> m4082c = this.f4635b.m4082c();
        boolean z = false;
        if (m4082c.isEmpty()) {
            return false;
        }
        List<Class<?>> m4091k = this.f4635b.m4091k();
        if (m4091k.isEmpty()) {
            if (File.class.equals(this.f4635b.m4093m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f4635b.m4088h() + " to " + this.f4635b.m4093m());
        }
        while (true) {
            if (this.f4639f != null && m4208b()) {
                this.f4641h = null;
                while (!z && m4208b()) {
                    List<InterfaceC1695n<File, ?>> list = this.f4639f;
                    int i2 = this.f4640g;
                    this.f4640g = i2 + 1;
                    this.f4641h = list.get(i2).mo4217a(this.f4642i, this.f4635b.m4094n(), this.f4635b.m4086f(), this.f4635b.m4089i());
                    if (this.f4641h != null && this.f4635b.m4083c(this.f4641h.f4728c.mo3846a())) {
                        this.f4641h.f4728c.mo3849a(this.f4635b.m4090j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f4637d++;
            if (this.f4637d >= m4091k.size()) {
                this.f4636c++;
                if (this.f4636c >= m4082c.size()) {
                    return false;
                }
                this.f4637d = 0;
            }
            InterfaceC1593g interfaceC1593g = m4082c.get(this.f4636c);
            Class<?> cls = m4091k.get(this.f4637d);
            this.f4643j = new C1679x(this.f4635b.m4080b(), interfaceC1593g, this.f4635b.m4092l(), this.f4635b.m4094n(), this.f4635b.m4086f(), this.f4635b.m4079b(cls), cls, this.f4635b.m4089i());
            this.f4642i = this.f4635b.m4084d().mo3980a(this.f4643j);
            File file = this.f4642i;
            if (file != null) {
                this.f4638e = interfaceC1593g;
                this.f4639f = this.f4635b.m4075a(file);
                this.f4640g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1661f
    public void cancel() {
        InterfaceC1695n.a<?> aVar = this.f4641h;
        if (aVar != null) {
            aVar.f4728c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
    /* renamed from: a */
    public void mo3857a(Object obj) {
        this.f4634a.mo4070a(this.f4638e, obj, this.f4641h.f4728c, EnumC1587a.RESOURCE_DISK_CACHE, this.f4643j);
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d.a
    /* renamed from: a */
    public void mo3856a(@NonNull Exception exc) {
        this.f4634a.mo4069a(this.f4643j, exc, this.f4641h.f4728c, EnumC1587a.RESOURCE_DISK_CACHE);
    }
}
