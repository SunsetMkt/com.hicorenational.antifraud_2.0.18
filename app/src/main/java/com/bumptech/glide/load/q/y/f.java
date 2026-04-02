package com.bumptech.glide.load.q.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.q.n;
import com.bumptech.glide.load.q.o;
import com.bumptech.glide.load.q.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: QMediaStoreUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class f<DataT> implements n<Uri, DataT> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f3115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f3116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<DataT> f3117d;

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static abstract class a<DataT> implements o<Uri, DataT> {
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<DataT> f3118b;

        a(Context context, Class<DataT> cls) {
            this.a = context;
            this.f3118b = cls;
        }

        @Override // com.bumptech.glide.load.q.o
        @NonNull
        public final n<Uri, DataT> a(@NonNull r rVar) {
            return new f(this.a, rVar.a(File.class, this.f3118b), rVar.a(Uri.class, this.f3118b), this.f3118b);
        }

        @Override // com.bumptech.glide.load.q.o
        public final void a() {
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    f(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.f3115b = nVar;
        this.f3116c = nVar2;
        this.f3117d = cls;
    }

    @Override // com.bumptech.glide.load.q.n
    public n.a<DataT> a(@NonNull Uri uri, int i2, int i3, @NonNull j jVar) {
        return new n.a<>(new com.bumptech.glide.s.e(uri), new d(this.a, this.f3115b, this.f3116c, uri, i2, i3, jVar, this.f3117d));
    }

    @Override // com.bumptech.glide.load.q.n
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.o.p.b.b(uri);
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static final class d<DataT> implements com.bumptech.glide.load.o.d<DataT> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String[] f3119k = {"_data"};
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n<File, DataT> f3120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n<Uri, DataT> f3121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f3122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f3123e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f3124f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final j f3125g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Class<DataT> f3126h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile boolean f3127i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private volatile com.bumptech.glide.load.o.d<DataT> f3128j;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, j jVar, Class<DataT> cls) {
            this.a = context.getApplicationContext();
            this.f3120b = nVar;
            this.f3121c = nVar2;
            this.f3122d = uri;
            this.f3123e = i2;
            this.f3124f = i3;
            this.f3125g = jVar;
            this.f3126h = cls;
        }

        @Nullable
        private n.a<DataT> d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f3120b.a(a(this.f3122d), this.f3123e, this.f3124f, this.f3125g);
            }
            return this.f3121c.a(f() ? MediaStore.setRequireOriginal(this.f3122d) : this.f3122d, this.f3123e, this.f3124f, this.f3125g);
        }

        @Nullable
        private com.bumptech.glide.load.o.d<DataT> e() throws FileNotFoundException {
            n.a<DataT> aVarD = d();
            if (aVarD != null) {
                return aVarD.f3091c;
            }
            return null;
        }

        private boolean f() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.o.d
        public void a(@NonNull h hVar, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.o.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f3122d));
                    return;
                }
                this.f3128j = dVarE;
                if (this.f3127i) {
                    cancel();
                } else {
                    dVarE.a(hVar, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.o.d
        public void b() {
            com.bumptech.glide.load.o.d<DataT> dVar = this.f3128j;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.o.d
        public void cancel() {
            this.f3127i = true;
            com.bumptech.glide.load.o.d<DataT> dVar = this.f3128j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.o.d
        @NonNull
        public Class<DataT> a() {
            return this.f3126h;
        }

        @NonNull
        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.a.getContentResolver().query(uri, f3119k, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
