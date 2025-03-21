package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* renamed from: com.bumptech.glide.load.q.b */
/* loaded from: classes.dex */
public class C1683b<Data> implements InterfaceC1695n<byte[], Data> {

    /* renamed from: a */
    private final b<Data> f4673a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.q.b$a */
    public static class a implements InterfaceC1696o<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.q.b$a$a, reason: collision with other inner class name */
        class C7361a implements b<ByteBuffer> {
            C7361a() {
            }

            @Override // com.bumptech.glide.load.p123q.C1683b.b
            /* renamed from: a, reason: avoid collision after fix types in other method */
            public ByteBuffer mo4223a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.p123q.C1683b.b
            /* renamed from: a */
            public Class<ByteBuffer> mo4222a() {
                return ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<byte[], ByteBuffer> mo4220a(@NonNull C1699r c1699r) {
            return new C1683b(new C7361a());
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.q.b$b */
    public interface b<Data> {
        /* renamed from: a */
        Class<Data> mo4222a();

        /* renamed from: a */
        Data mo4223a(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.q.b$d */
    public static class d implements InterfaceC1696o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.q.b$d$a */
        class a implements b<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.p123q.C1683b.b
            /* renamed from: a */
            public InputStream mo4223a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.p123q.C1683b.b
            /* renamed from: a */
            public Class<InputStream> mo4222a() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<byte[], InputStream> mo4220a(@NonNull C1699r c1699r) {
            return new C1683b(new a());
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1683b(b<Data> bVar) {
        this.f4673a = bVar;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull byte[] bArr) {
        return true;
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.q.b$c */
    private static class c<Data> implements InterfaceC1604d<Data> {

        /* renamed from: a */
        private final byte[] f4675a;

        /* renamed from: b */
        private final b<Data> f4676b;

        c(byte[] bArr, b<Data> bVar) {
            this.f4675a = bArr;
            this.f4676b = bVar;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super Data> aVar) {
            aVar.mo3857a((InterfaceC1604d.a<? super Data>) this.f4676b.mo4223a(this.f4675a));
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
        public Class<Data> mo3846a() {
            return this.f4676b.mo4222a();
        }
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull byte[] bArr, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(bArr), new c(bArr, this.f4673a));
    }
}
