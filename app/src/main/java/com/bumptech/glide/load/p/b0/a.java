package com.bumptech.glide.load.p.b0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: DiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.p.b0.a$a */
    /* JADX INFO: compiled from: DiskCache.java */
    public interface InterfaceC0046a {
        public static final int a = 262144000;

        /* JADX INFO: renamed from: b */
        public static final String f2821b = "image_manager_disk_cache";

        @Nullable
        a build();
    }

    /* JADX INFO: compiled from: DiskCache.java */
    public interface b {
        boolean a(@NonNull File file);
    }

    @Nullable
    File a(com.bumptech.glide.load.g gVar);

    void a(com.bumptech.glide.load.g gVar, b bVar);

    void b(com.bumptech.glide.load.g gVar);

    void clear();
}
