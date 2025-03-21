package com.bumptech.glide.load.p123q;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* renamed from: com.bumptech.glide.load.q.f */
/* loaded from: classes.dex */
public class C1687f<Data> implements InterfaceC1695n<File, Data> {

    /* renamed from: b */
    private static final String f4689b = "FileLoader";

    /* renamed from: a */
    private final d<Data> f4690a;

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.f$a */
    public static class a<Data> implements InterfaceC1696o<File, Data> {

        /* renamed from: a */
        private final d<Data> f4691a;

        public a(d<Data> dVar) {
            this.f4691a = dVar;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public final InterfaceC1695n<File, Data> mo4220a(@NonNull C1699r c1699r) {
            return new C1687f(this.f4691a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public final void mo4221a() {
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.f$b */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* renamed from: com.bumptech.glide.load.q.f$b$a */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a */
            public ParcelFileDescriptor mo4226a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, CommonNetImpl.FLAG_AUTH);
            }

            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a */
            public Class<ParcelFileDescriptor> mo4227a() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.f$d */
    public interface d<Data> {
        /* renamed from: a */
        Class<Data> mo4227a();

        /* renamed from: a */
        Data mo4226a(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.f$e */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        /* renamed from: com.bumptech.glide.load.q.f$e$a */
        class a implements d<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a */
            public InputStream mo4226a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.p123q.C1687f.d
            /* renamed from: a */
            public Class<InputStream> mo4227a() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public C1687f(d<Data> dVar) {
        this.f4690a = dVar;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull File file, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(file), new c(file, this.f4690a));
    }

    /* compiled from: FileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.f$c */
    private static final class c<Data> implements InterfaceC1604d<Data> {

        /* renamed from: a */
        private final File f4692a;

        /* renamed from: b */
        private final d<Data> f4693b;

        /* renamed from: c */
        private Data f4694c;

        c(File file, d<Data> dVar) {
            this.f4692a = file;
            this.f4693b = dVar;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super Data> aVar) {
            try {
                this.f4694c = this.f4693b.mo4226a(this.f4692a);
                aVar.mo3857a((InterfaceC1604d.a<? super Data>) this.f4694c);
            } catch (FileNotFoundException e2) {
                Log.isLoggable(C1687f.f4689b, 3);
                aVar.mo3856a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: b */
        public void mo3851b() {
            Data data = this.f4694c;
            if (data != null) {
                try {
                    this.f4693b.close(data);
                } catch (IOException unused) {
                }
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
            return this.f4693b.mo4227a();
        }
    }
}
