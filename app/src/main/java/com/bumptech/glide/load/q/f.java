package com.bumptech.glide.load.q;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3064b = "FileLoader";
    private final d<Data> a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {
        private final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.a);
        }

        @Override // com.bumptech.glide.load.q.o
        public final void a() {
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.f.d
            public ParcelFileDescriptor a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, CommonNetImpl.FLAG_AUTH);
            }

            @Override // com.bumptech.glide.load.q.f.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.q.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.f.d
            public InputStream a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // com.bumptech.glide.load.q.f.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.q.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull File file, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(file), new c(file, this.a));
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.o.d<Data> {
        private final File a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<Data> f3065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f3066c;

        c(File file, d<Data> dVar) {
            this.a = file;
            this.f3065b = dVar;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f3066c = this.f3065b.a(this.a);
                aVar.a(this.f3066c);
            } catch (FileNotFoundException e2) {
                Log.isLoggable(f.f3064b, 3);
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            Data data = this.f3066c;
            if (data != null) {
                try {
                    this.f3065b.close(data);
                } catch (IOException unused) {
                }
            }
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
            return this.f3065b.a();
        }
    }
}
