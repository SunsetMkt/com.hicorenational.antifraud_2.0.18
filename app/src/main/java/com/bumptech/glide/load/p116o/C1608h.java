package com.bumptech.glide.load.p116o;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: FileDescriptorAssetPathFetcher.java */
/* renamed from: com.bumptech.glide.load.o.h */
/* loaded from: classes.dex */
public class C1608h extends AbstractC1602b<ParcelFileDescriptor> {
    public C1608h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p116o.AbstractC1602b
    /* renamed from: a */
    public ParcelFileDescriptor mo3848a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p116o.AbstractC1602b
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo3850a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: a */
    public Class<ParcelFileDescriptor> mo3846a() {
        return ParcelFileDescriptor.class;
    }
}
