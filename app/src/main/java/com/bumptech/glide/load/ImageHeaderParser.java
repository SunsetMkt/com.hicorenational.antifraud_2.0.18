package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* renamed from: a */
    public static final int f4177a = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    /* renamed from: a */
    int mo3813a(@NonNull InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) throws IOException;

    /* renamed from: a */
    int mo3814a(@NonNull ByteBuffer byteBuffer, @NonNull InterfaceC1623b interfaceC1623b) throws IOException;

    @NonNull
    /* renamed from: a */
    ImageType mo3815a(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    /* renamed from: a */
    ImageType mo3816a(@NonNull ByteBuffer byteBuffer) throws IOException;
}
