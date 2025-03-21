package com.bumptech.glide.load.p123q;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.util.C1867a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* renamed from: com.bumptech.glide.load.q.c */
/* loaded from: classes.dex */
public class C1684c implements InterfaceC1590d<ByteBuffer> {

    /* renamed from: a */
    private static final String f4678a = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.InterfaceC1590d
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3817a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull C1596j c1596j) {
        try {
            C1867a.m4953a(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f4678a, 3);
            return false;
        }
    }
}
