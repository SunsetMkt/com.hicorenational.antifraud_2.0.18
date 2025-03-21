package com.bumptech.glide.load.p123q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p116o.p117p.C1617b;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.p140s.C1866e;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* renamed from: com.bumptech.glide.load.q.k */
/* loaded from: classes.dex */
public final class C1692k implements InterfaceC1695n<Uri, File> {

    /* renamed from: a */
    private final Context f4714a;

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.k$a */
    public static final class a implements InterfaceC1696o<Uri, File> {

        /* renamed from: a */
        private final Context f4715a;

        public a(Context context) {
            this.f4715a = context;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<Uri, File> mo4220a(C1699r c1699r) {
            return new C1692k(this.f4715a);
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1692k(Context context) {
        this.f4714a = context;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<File> mo4217a(@NonNull Uri uri, int i2, int i3, @NonNull C1596j c1596j) {
        return new InterfaceC1695n.a<>(new C1866e(uri), new b(this.f4714a, uri));
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull Uri uri) {
        return C1617b.m3879b(uri);
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: com.bumptech.glide.load.q.k$b */
    private static class b implements InterfaceC1604d<File> {

        /* renamed from: c */
        private static final String[] f4716c = {"_data"};

        /* renamed from: a */
        private final Context f4717a;

        /* renamed from: b */
        private final Uri f4718b;

        b(Context context, Uri uri) {
            this.f4717a = context;
            this.f4718b = uri;
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
        /* renamed from: a */
        public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super File> aVar) {
            Cursor query = this.f4717a.getContentResolver().query(this.f4718b, f4716c, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (!TextUtils.isEmpty(r0)) {
                aVar.mo3857a((InterfaceC1604d.a<? super File>) new File(r0));
                return;
            }
            aVar.mo3856a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f4718b));
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
        public Class<File> mo3846a() {
            return File.class;
        }
    }
}
