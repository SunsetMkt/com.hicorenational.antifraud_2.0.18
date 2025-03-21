package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1589c;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1867a;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* renamed from: com.bumptech.glide.load.resource.gif.c */
/* loaded from: classes.dex */
public class C1772c implements InterfaceC1599m<GifDrawable> {

    /* renamed from: a */
    private static final String f5016a = "GifEncoder";

    @Override // com.bumptech.glide.load.InterfaceC1599m
    @NonNull
    /* renamed from: a */
    public EnumC1589c mo3844a(@NonNull C1596j c1596j) {
        return EnumC1589c.SOURCE;
    }

    @Override // com.bumptech.glide.load.InterfaceC1590d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3817a(@NonNull InterfaceC1677v<GifDrawable> interfaceC1677v, @NonNull File file, @NonNull C1596j c1596j) {
        try {
            C1867a.m4953a(interfaceC1677v.get().m4450b(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f5016a, 5);
            return false;
        }
    }
}
