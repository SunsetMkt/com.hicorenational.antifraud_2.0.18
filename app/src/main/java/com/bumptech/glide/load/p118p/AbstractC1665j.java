package com.bumptech.glide.load.p118p;

import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.EnumC1589c;

/* compiled from: DiskCacheStrategy.java */
/* renamed from: com.bumptech.glide.load.p.j */
/* loaded from: classes.dex */
public abstract class AbstractC1665j {

    /* renamed from: a */
    public static final AbstractC1665j f4537a = new a();

    /* renamed from: b */
    public static final AbstractC1665j f4538b = new b();

    /* renamed from: c */
    public static final AbstractC1665j f4539c = new c();

    /* renamed from: d */
    public static final AbstractC1665j f4540d = new d();

    /* renamed from: e */
    public static final AbstractC1665j f4541e = new e();

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.j$a */
    class a extends AbstractC1665j {
        a() {
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4138a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4139a(EnumC1587a enumC1587a) {
            return enumC1587a == EnumC1587a.REMOTE;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: b */
        public boolean mo4141b() {
            return true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c) {
            return (enumC1587a == EnumC1587a.RESOURCE_DISK_CACHE || enumC1587a == EnumC1587a.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.j$b */
    class b extends AbstractC1665j {
        b() {
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4138a() {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4139a(EnumC1587a enumC1587a) {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c) {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: b */
        public boolean mo4141b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.j$c */
    class c extends AbstractC1665j {
        c() {
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4138a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4139a(EnumC1587a enumC1587a) {
            return (enumC1587a == EnumC1587a.DATA_DISK_CACHE || enumC1587a == EnumC1587a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c) {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: b */
        public boolean mo4141b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.j$d */
    class d extends AbstractC1665j {
        d() {
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4138a() {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4139a(EnumC1587a enumC1587a) {
            return false;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c) {
            return (enumC1587a == EnumC1587a.RESOURCE_DISK_CACHE || enumC1587a == EnumC1587a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: b */
        public boolean mo4141b() {
            return true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.j$e */
    class e extends AbstractC1665j {
        e() {
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4138a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4139a(EnumC1587a enumC1587a) {
            return enumC1587a == EnumC1587a.REMOTE;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: b */
        public boolean mo4141b() {
            return true;
        }

        @Override // com.bumptech.glide.load.p118p.AbstractC1665j
        /* renamed from: a */
        public boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c) {
            return ((z && enumC1587a == EnumC1587a.DATA_DISK_CACHE) || enumC1587a == EnumC1587a.LOCAL) && enumC1589c == EnumC1589c.TRANSFORMED;
        }
    }

    /* renamed from: a */
    public abstract boolean mo4138a();

    /* renamed from: a */
    public abstract boolean mo4139a(EnumC1587a enumC1587a);

    /* renamed from: a */
    public abstract boolean mo4140a(boolean z, EnumC1587a enumC1587a, EnumC1589c enumC1589c);

    /* renamed from: b */
    public abstract boolean mo4141b();
}
