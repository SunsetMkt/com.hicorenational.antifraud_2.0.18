package com.bumptech.glide.load.p116o.p117p;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.C1607g;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* renamed from: com.bumptech.glide.load.o.p.c */
/* loaded from: classes.dex */
public class C1618c implements InterfaceC1604d<InputStream> {

    /* renamed from: d */
    private static final String f4244d = "MediaStoreThumbFetcher";

    /* renamed from: a */
    private final Uri f4245a;

    /* renamed from: b */
    private final C1620e f4246b;

    /* renamed from: c */
    private InputStream f4247c;

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.o.p.c$a */
    static class a implements InterfaceC1619d {

        /* renamed from: b */
        private static final String[] f4248b = {"_data"};

        /* renamed from: c */
        private static final String f4249c = "kind = 1 AND image_id = ?";

        /* renamed from: a */
        private final ContentResolver f4250a;

        a(ContentResolver contentResolver) {
            this.f4250a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p116o.p117p.InterfaceC1619d
        /* renamed from: a */
        public Cursor mo3886a(Uri uri) {
            return this.f4250a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4248b, f4249c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: com.bumptech.glide.load.o.p.c$b */
    static class b implements InterfaceC1619d {

        /* renamed from: b */
        private static final String[] f4251b = {"_data"};

        /* renamed from: c */
        private static final String f4252c = "kind = 1 AND video_id = ?";

        /* renamed from: a */
        private final ContentResolver f4253a;

        b(ContentResolver contentResolver) {
            this.f4253a = contentResolver;
        }

        @Override // com.bumptech.glide.load.p116o.p117p.InterfaceC1619d
        /* renamed from: a */
        public Cursor mo3886a(Uri uri) {
            return this.f4253a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4251b, f4252c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    C1618c(Uri uri, C1620e c1620e) {
        this.f4245a = uri;
        this.f4246b = c1620e;
    }

    /* renamed from: a */
    public static C1618c m3882a(Context context, Uri uri) {
        return m3883a(context, uri, new a(context.getContentResolver()));
    }

    /* renamed from: b */
    public static C1618c m3884b(Context context, Uri uri) {
        return m3883a(context, uri, new b(context.getContentResolver()));
    }

    /* renamed from: d */
    private InputStream m3885d() throws FileNotFoundException {
        InputStream m3890b = this.f4246b.m3890b(this.f4245a);
        int m3889a = m3890b != null ? this.f4246b.m3889a(this.f4245a) : -1;
        return m3889a != -1 ? new C1607g(m3890b, m3889a) : m3890b;
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

    /* renamed from: a */
    private static C1618c m3883a(Context context, Uri uri, InterfaceC1619d interfaceC1619d) {
        return new C1618c(uri, new C1620e(ComponentCallbacks2C1576b.m3633a(context).m3664h().m3735a(), interfaceC1619d, ComponentCallbacks2C1576b.m3633a(context).m3659c(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: b */
    public void mo3851b() {
        InputStream inputStream = this.f4247c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: a */
    public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super InputStream> aVar) {
        try {
            this.f4247c = m3885d();
            aVar.mo3857a((InterfaceC1604d.a<? super InputStream>) this.f4247c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f4244d, 3);
            aVar.mo3856a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo3846a() {
        return InputStream.class;
    }
}
