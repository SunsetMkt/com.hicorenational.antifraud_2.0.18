package com.bumptech.glide.load.p123q;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* renamed from: com.bumptech.glide.load.q.e */
/* loaded from: classes.dex */
public final class C1686e<Model, Data> implements InterfaceC1695n<Model, Data> {

    /* renamed from: b */
    private static final String f4681b = "data:image";

    /* renamed from: c */
    private static final String f4682c = ";base64";

    /* renamed from: a */
    private final a<Data> f4683a;

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.q.e$a */
    public interface a<Data> {
        /* renamed from: a */
        Class<Data> mo4224a();

        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.q.e$c */
    public static final class c<Model> implements InterfaceC1696o<Model, InputStream> {

        /* renamed from: a */
        private final a<InputStream> f4687a = new a();

        /* compiled from: DataUrlLoader.java */
        /* renamed from: com.bumptech.glide.load.q.e$c$a */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.p123q.C1686e.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.p123q.C1686e.a
            /* renamed from: a */
            public Class<InputStream> mo4224a() {
                return InputStream.class;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.p123q.C1686e.a
            public InputStream decode(String str) {
                if (!str.startsWith(C1686e.f4681b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, indexOf).endsWith(C1686e.f4682c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Model, InputStream> mo4220a(@NonNull C1699r c1699r) {
            return new C1686e(this.f4687a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1686e(a<Data> aVar) {
        this.f4683a = aVar;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull Model model, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(model), new b(model.toString(), this.f4683a));
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.q.e$b */
    private static final class b<Data> implements InterfaceC1604d<Data> {

        /* renamed from: a */
        private final String f4684a;

        /* renamed from: b */
        private final a<Data> f4685b;

        /* renamed from: c */
        private Data f4686c;

        b(String str, a<Data> aVar) {
            this.f4684a = str;
            this.f4685b = aVar;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super Data> aVar) {
            try {
                this.f4686c = this.f4685b.decode(this.f4684a);
                aVar.mo3857a((InterfaceC1604d.a<? super Data>) this.f4686c);
            } catch (IllegalArgumentException e2) {
                aVar.mo3856a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: b */
        public void mo3851b() {
            try {
                this.f4685b.close(this.f4686c);
            } catch (IOException unused) {
            }
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
            return this.f4685b.mo4224a();
        }
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a */
    public boolean mo4218a(@NonNull Model model) {
        return model.toString().startsWith(f4681b);
    }
}
