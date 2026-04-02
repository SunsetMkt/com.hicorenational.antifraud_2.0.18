package com.bumptech.glide.load.q;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3060b = "data:image";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3061c = ";base64";
    private final a<Data> a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> a = new a();

        /* JADX INFO: compiled from: DataUrlLoader.java */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.q.e.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.q.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.q.e.a
            public InputStream decode(String str) {
                if (!str.startsWith(e.f3060b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(e.f3061c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public e(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(model), new b(model.toString(), this.a));
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.o.d<Data> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f3062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f3063c;

        b(String str, a<Data> aVar) {
            this.a = str;
            this.f3062b = aVar;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f3063c = this.f3062b.decode(this.a);
                aVar.a(this.f3063c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            try {
                this.f3062b.close(this.f3063c);
            } catch (IOException unused) {
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
            return this.f3062b.a();
        }
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(f3060b);
    }
}
