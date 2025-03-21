package com.bumptech.glide.load.p123q.p124y;

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
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p116o.p117p.C1617b;
import com.bumptech.glide.load.p123q.C1699r;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p123q.InterfaceC1696o;
import com.bumptech.glide.p140s.C1866e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader.java */
@RequiresApi(29)
/* renamed from: com.bumptech.glide.load.q.y.f */
/* loaded from: classes.dex */
public final class C1711f<DataT> implements InterfaceC1695n<Uri, DataT> {

    /* renamed from: a */
    private final Context f4782a;

    /* renamed from: b */
    private final InterfaceC1695n<File, DataT> f4783b;

    /* renamed from: c */
    private final InterfaceC1695n<Uri, DataT> f4784c;

    /* renamed from: d */
    private final Class<DataT> f4785d;

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.f$a */
    private static abstract class a<DataT> implements InterfaceC1696o<Uri, DataT> {

        /* renamed from: a */
        private final Context f4786a;

        /* renamed from: b */
        private final Class<DataT> f4787b;

        a(Context context, Class<DataT> cls) {
            this.f4786a = context;
            this.f4787b = cls;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public final InterfaceC1695n<Uri, DataT> mo4220a(@NonNull C1699r c1699r) {
            return new C1711f(this.f4786a, c1699r.m4276a(File.class, this.f4787b), c1699r.m4276a(Uri.class, this.f4787b), this.f4787b);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public final void mo4221a() {
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    /* renamed from: com.bumptech.glide.load.q.y.f$b */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    /* renamed from: com.bumptech.glide.load.q.y.f$c */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    C1711f(Context context, InterfaceC1695n<File, DataT> interfaceC1695n, InterfaceC1695n<Uri, DataT> interfaceC1695n2, Class<DataT> cls) {
        this.f4782a = context.getApplicationContext();
        this.f4783b = interfaceC1695n;
        this.f4784c = interfaceC1695n2;
        this.f4785d = cls;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<DataT> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(uri), new d(this.f4782a, this.f4783b, this.f4784c, uri, i2, i3, c1596j, this.f4785d));
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && C1617b.m3879b(uri);
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: com.bumptech.glide.load.q.y.f$d */
    private static final class d<DataT> implements InterfaceC1604d<DataT> {

        /* renamed from: k */
        private static final String[] f4788k = {"_data"};

        /* renamed from: a */
        private final Context f4789a;

        /* renamed from: b */
        private final InterfaceC1695n<File, DataT> f4790b;

        /* renamed from: c */
        private final InterfaceC1695n<Uri, DataT> f4791c;

        /* renamed from: d */
        private final Uri f4792d;

        /* renamed from: e */
        private final int f4793e;

        /* renamed from: f */
        private final int f4794f;

        /* renamed from: g */
        private final C1596j f4795g;

        /* renamed from: h */
        private final Class<DataT> f4796h;

        /* renamed from: i */
        private volatile boolean f4797i;

        /* renamed from: j */
        @Nullable
        private volatile InterfaceC1604d<DataT> f4798j;

        d(Context context, InterfaceC1695n<File, DataT> interfaceC1695n, InterfaceC1695n<Uri, DataT> interfaceC1695n2, Uri uri, int i2, int i3, C1596j c1596j, Class<DataT> cls) {
            this.f4789a = context.getApplicationContext();
            this.f4790b = interfaceC1695n;
            this.f4791c = interfaceC1695n2;
            this.f4792d = uri;
            this.f4793e = i2;
            this.f4794f = i3;
            this.f4795g = c1596j;
            this.f4796h = cls;
        }

        @Nullable
        /* renamed from: d */
        private InterfaceC1695n.a<DataT> m4298d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f4790b.mo4217a(m4297a(this.f4792d), this.f4793e, this.f4794f, this.f4795g);
            }
            return this.f4791c.mo4217a(m4300f() ? MediaStore.setRequireOriginal(this.f4792d) : this.f4792d, this.f4793e, this.f4794f, this.f4795g);
        }

        @Nullable
        /* renamed from: e */
        private InterfaceC1604d<DataT> m4299e() throws FileNotFoundException {
            InterfaceC1695n.a<DataT> m4298d = m4298d();
            if (m4298d != null) {
                return m4298d.f4728c;
            }
            return null;
        }

        /* renamed from: f */
        private boolean m4300f() {
            return this.f4789a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super DataT> aVar) {
            try {
                InterfaceC1604d<DataT> m4299e = m4299e();
                if (m4299e == null) {
                    aVar.mo3856a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f4792d));
                    return;
                }
                this.f4798j = m4299e;
                if (this.f4797i) {
                    cancel();
                } else {
                    m4299e.mo3849a(enumC1582h, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.mo3856a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: b */
        public void mo3851b() {
            InterfaceC1604d<DataT> interfaceC1604d = this.f4798j;
            if (interfaceC1604d != null) {
                interfaceC1604d.mo3851b();
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
            this.f4797i = true;
            InterfaceC1604d<DataT> interfaceC1604d = this.f4798j;
            if (interfaceC1604d != null) {
                interfaceC1604d.cancel();
            }
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        @NonNull
        /* renamed from: a */
        public Class<DataT> mo3846a() {
            return this.f4796h;
        }

        @NonNull
        /* renamed from: a */
        private File m4297a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.f4789a.getContentResolver().query(uri, f4788k, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (query != null) {
                            query.close();
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
