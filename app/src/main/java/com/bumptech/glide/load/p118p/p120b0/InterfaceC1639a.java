package com.bumptech.glide.load.p118p.p120b0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1593g;
import java.io.File;

/* compiled from: DiskCache.java */
/* renamed from: com.bumptech.glide.load.p.b0.a */
/* loaded from: classes.dex */
public interface InterfaceC1639a {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.p.b0.a$a */
    public interface a {

        /* renamed from: a */
        public static final int f4335a = 262144000;

        /* renamed from: b */
        public static final String f4336b = "image_manager_disk_cache";

        @Nullable
        InterfaceC1639a build();
    }

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.p.b0.a$b */
    public interface b {
        /* renamed from: a */
        boolean mo3983a(@NonNull File file);
    }

    @Nullable
    /* renamed from: a */
    File mo3980a(InterfaceC1593g interfaceC1593g);

    /* renamed from: a */
    void mo3981a(InterfaceC1593g interfaceC1593g, b bVar);

    /* renamed from: b */
    void mo3982b(InterfaceC1593g interfaceC1593g);

    void clear();
}
