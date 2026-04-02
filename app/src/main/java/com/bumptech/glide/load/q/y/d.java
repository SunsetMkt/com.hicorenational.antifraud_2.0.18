package com.bumptech.glide.load.q.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements n<Uri, InputStream> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements o<Uri, InputStream> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new d(this.a);
        }

        @Override // com.bumptech.glide.load.q.o
        public void a() {
        }
    }

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<InputStream> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        if (com.bumptech.glide.load.o.p.b.a(i2, i3)) {
            return new n.a<>(new com.bumptech.glide.s.e(uri), com.bumptech.glide.load.o.p.c.a(this.a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.o.p.b.a(uri);
    }
}
