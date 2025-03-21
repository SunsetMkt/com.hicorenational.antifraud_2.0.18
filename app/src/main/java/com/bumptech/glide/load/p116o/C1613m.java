package com.bumptech.glide.load.p116o;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.p116o.InterfaceC1605e;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder.java */
/* renamed from: com.bumptech.glide.load.o.m */
/* loaded from: classes.dex */
public final class C1613m implements InterfaceC1605e<ParcelFileDescriptor> {

    /* renamed from: a */
    private final b f4234a;

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    /* renamed from: com.bumptech.glide.load.o.m$a */
    public static final class a implements InterfaceC1605e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC1605e<ParcelFileDescriptor> mo3860a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new C1613m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.p116o.InterfaceC1605e.a
        @NonNull
        /* renamed from: a */
        public Class<ParcelFileDescriptor> mo3861a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    /* renamed from: com.bumptech.glide.load.o.m$b */
    private static final class b {

        /* renamed from: a */
        private final ParcelFileDescriptor f4235a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f4235a = parcelFileDescriptor;
        }

        /* renamed from: a */
        ParcelFileDescriptor m3871a() throws IOException {
            try {
                Os.lseek(this.f4235a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f4235a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    @RequiresApi(21)
    public C1613m(ParcelFileDescriptor parcelFileDescriptor) {
        this.f4234a = new b(parcelFileDescriptor);
    }

    /* renamed from: c */
    public static boolean m3870c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    /* renamed from: b */
    public void mo3859b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p116o.InterfaceC1605e
    @NonNull
    @RequiresApi(21)
    /* renamed from: a */
    public ParcelFileDescriptor mo3858a() throws IOException {
        return this.f4234a.m3871a();
    }
}
