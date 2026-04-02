package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {
    private final InterfaceC0056b<Data> a;

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class a implements o<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: com.bumptech.glide.load.q.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class C0055a implements InterfaceC0056b<ByteBuffer> {
            C0055a() {
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0056b
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0056b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new C0055a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.q.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public interface InterfaceC0056b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class d implements o<byte[], InputStream> {

        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class a implements InterfaceC0056b<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.b.InterfaceC0056b
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.q.b.InterfaceC0056b
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new a());
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public b(InterfaceC0056b<Data> interfaceC0056b) {
        this.a = interfaceC0056b;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    private static class c<Data> implements com.bumptech.glide.load.o.d<Data> {
        private final byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0056b<Data> f3059b;

        c(byte[] bArr, InterfaceC0056b<Data> interfaceC0056b) {
            this.a = bArr;
            this.f3059b = interfaceC0056b;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            aVar.a(this.f3059b.a(this.a));
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<Data> a() {
            return this.f3059b.a();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull byte[] bArr, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(bArr), new c(bArr, this.a));
    }
}
