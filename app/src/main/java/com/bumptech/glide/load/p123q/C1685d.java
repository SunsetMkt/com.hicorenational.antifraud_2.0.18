package com.bumptech.glide.load.p123q;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import com.bumptech.glide.util.C1867a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* renamed from: com.bumptech.glide.load.q.d */
/* loaded from: classes.dex */
public class C1685d implements InterfaceC1695n<File, ByteBuffer> {

    /* renamed from: a */
    private static final String f4679a = "ByteBufferFileLoader";

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.d$b */
    public static class b implements InterfaceC1696o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<File, ByteBuffer> mo4220a(@NonNull C1699r c1699r) {
            return new C1685d();
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<ByteBuffer> mo4217a(@NonNull File file, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(file), new a(file));
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.d$a */
    private static final class a implements InterfaceC1604d<ByteBuffer> {

        /* renamed from: a */
        private final File f4680a;

        a(File file) {
            this.f4680a = file;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super ByteBuffer> aVar) {
            try {
                aVar.mo3857a((InterfaceC1604d.a<? super ByteBuffer>) C1867a.m4951a(this.f4680a));
            } catch (IOException e2) {
                Log.isLoggable(C1685d.f4679a, 3);
                aVar.mo3856a((Exception) e2);
            }
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
        public Class<ByteBuffer> mo3846a() {
            return ByteBuffer.class;
        }
    }
}
