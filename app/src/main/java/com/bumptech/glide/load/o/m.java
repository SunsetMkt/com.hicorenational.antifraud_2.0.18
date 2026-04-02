package com.bumptech.glide.load.o;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.o.e;
import java.io.IOException;

/* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements e<ParcelFileDescriptor> {
    private final b a;

    /* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<ParcelFileDescriptor> a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new m(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
    @RequiresApi(21)
    private static final class b {
        private final ParcelFileDescriptor a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        ParcelFileDescriptor a() throws IOException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e2) {
                throw new IOException(e2);
            }
        }
    }

    @RequiresApi(21)
    public m(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new b(parcelFileDescriptor);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.o.e
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor a() throws IOException {
        return this.a.a();
    }
}
