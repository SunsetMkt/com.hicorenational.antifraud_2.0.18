package com.bumptech.glide.load.p125r.p126d;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.util.C1867a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ExifInterfaceImageHeaderParser.java */
@RequiresApi(27)
/* renamed from: com.bumptech.glide.load.r.d.t */
/* loaded from: classes.dex */
public final class C1745t implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo3815a(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo3816a(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo3813a(@NonNull InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo3814a(@NonNull ByteBuffer byteBuffer, @NonNull InterfaceC1623b interfaceC1623b) throws IOException {
        return mo3813a(C1867a.m4956c(byteBuffer), interfaceC1623b);
    }
}
