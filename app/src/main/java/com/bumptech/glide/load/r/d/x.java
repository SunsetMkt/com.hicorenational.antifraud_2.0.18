package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ImageReader.java */
/* JADX INFO: loaded from: classes.dex */
interface x {

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class a implements x {
        private final com.bumptech.glide.load.o.k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.p.a0.b f3243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f3244c;

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.b bVar) {
            this.f3243b = (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar);
            this.f3244c = (List) com.bumptech.glide.util.j.a(list);
            this.a = new com.bumptech.glide.load.o.k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.r.d.x
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public void b() {
            this.a.c();
        }

        @Override // com.bumptech.glide.load.r.d.x
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.f.b(this.f3244c, this.a.a(), this.f3243b);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public int a() throws IOException {
            return com.bumptech.glide.load.f.a(this.f3244c, this.a.a(), this.f3243b);
        }
    }

    int a() throws IOException;

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    ImageHeaderParser.ImageType c() throws IOException;

    /* JADX INFO: compiled from: ImageReader.java */
    @RequiresApi(21)
    public static final class b implements x {
        private final com.bumptech.glide.load.p.a0.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f3245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.load.o.m f3246c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.p.a0.b bVar) {
            this.a = (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar);
            this.f3245b = (List) com.bumptech.glide.util.j.a(list);
            this.f3246c = new com.bumptech.glide.load.o.m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.r.d.x
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f3246c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public void b() {
        }

        @Override // com.bumptech.glide.load.r.d.x
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.f.b(this.f3245b, this.f3246c, this.a);
        }

        @Override // com.bumptech.glide.load.r.d.x
        public int a() throws IOException {
            return com.bumptech.glide.load.f.a(this.f3245b, this.f3246c, this.a);
        }
    }
}
