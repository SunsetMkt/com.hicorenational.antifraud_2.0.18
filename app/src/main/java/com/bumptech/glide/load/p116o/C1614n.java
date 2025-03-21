package com.bumptech.glide.load.p116o;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher.java */
/* renamed from: com.bumptech.glide.load.o.n */
/* loaded from: classes.dex */
public class C1614n extends AbstractC1602b<InputStream> {
    public C1614n(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p116o.AbstractC1602b
    /* renamed from: a */
    public InputStream mo3848a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p116o.AbstractC1602b
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo3850a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo3846a() {
        return InputStream.class;
    }
}
