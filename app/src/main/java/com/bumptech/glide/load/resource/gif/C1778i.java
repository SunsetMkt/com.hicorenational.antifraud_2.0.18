package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1592f;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* renamed from: com.bumptech.glide.load.resource.gif.i */
/* loaded from: classes.dex */
public class C1778i implements InterfaceC1598l<InputStream, GifDrawable> {

    /* renamed from: d */
    private static final String f5047d = "StreamGifDecoder";

    /* renamed from: a */
    private final List<ImageHeaderParser> f5048a;

    /* renamed from: b */
    private final InterfaceC1598l<ByteBuffer, GifDrawable> f5049b;

    /* renamed from: c */
    private final InterfaceC1623b f5050c;

    public C1778i(List<ImageHeaderParser> list, InterfaceC1598l<ByteBuffer, GifDrawable> interfaceC1598l, InterfaceC1623b interfaceC1623b) {
        this.f5048a = list;
        this.f5049b = interfaceC1598l;
        this.f5050c = interfaceC1623b;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull InputStream inputStream, @NonNull C1596j c1596j) throws IOException {
        return !((Boolean) c1596j.m3840a(C1777h.f5046b)).booleanValue() && C1592f.m3824b(this.f5048a, inputStream, this.f5050c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<GifDrawable> mo3842a(@NonNull InputStream inputStream, int i2, int i3, @NonNull C1596j c1596j) throws IOException {
        byte[] m4496a = m4496a(inputStream);
        if (m4496a == null) {
            return null;
        }
        return this.f5049b.mo3842a(ByteBuffer.wrap(m4496a), i2, i3, c1596j);
    }

    /* renamed from: a */
    private static byte[] m4496a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            Log.isLoggable(f5047d, 5);
            return null;
        }
    }
}
