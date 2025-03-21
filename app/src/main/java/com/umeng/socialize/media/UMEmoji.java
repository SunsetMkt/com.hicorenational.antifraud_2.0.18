package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import com.umeng.social.tool.UMImageMark;
import java.io.File;

/* loaded from: classes2.dex */
public class UMEmoji extends UMImage {
    public UMEmoji(Context context, File file) {
        super(context, file);
    }

    public UMEmoji(Context context, String str) {
        super(context, str);
    }

    public UMEmoji(Context context, int i2) {
        super(context, i2);
    }

    public UMEmoji(Context context, byte[] bArr) {
        super(context, bArr);
    }

    public UMEmoji(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public UMEmoji(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        super(context, bitmap, uMImageMark);
    }

    public UMEmoji(Context context, int i2, UMImageMark uMImageMark) {
        super(context, i2, uMImageMark);
    }

    public UMEmoji(Context context, byte[] bArr, UMImageMark uMImageMark) {
        super(context, bArr, uMImageMark);
    }
}
