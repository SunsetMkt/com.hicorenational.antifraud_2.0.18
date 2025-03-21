package com.luck.picture.lib.compress;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import p286h.C5230f1;

/* loaded from: classes.dex */
enum Checker {
    SINGLE;

    private static final String JPG = ".jpg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = {-1, -40, -1};

    Checker() {
    }

    private int pack(byte[] bArr, int i2, int i3, boolean z) {
        int i4;
        if (z) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return i5;
            }
            i5 = (bArr[i2] & C5230f1.f20085c) | (i5 << 8);
            i2 += i4;
            i3 = i6;
        }
    }

    private byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } catch (Exception unused2) {
                    byte[] bArr2 = new byte[0];
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    return bArr2;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    String extSuffix(InputStreamProvider inputStreamProvider) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
            return options.outMimeType.replace("image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    boolean needCompress(int i2, String str) {
        if (i2 <= 0) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > ((long) (i2 << 10));
    }

    boolean needCompressToLocalMedia(int i2, String str) {
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > ((long) (i2 << 10));
    }

    private int getOrientation(byte[] bArr) {
        int i2;
        int pack;
        int i3;
        if (bArr == null) {
            return 0;
        }
        int i4 = 0;
        while (i4 + 3 < bArr.length) {
            int i5 = i4 + 1;
            if ((bArr[i4] & C5230f1.f20085c) == 255) {
                int i6 = bArr[i5] & C5230f1.f20085c;
                if (i6 != 255) {
                    i5++;
                    if (i6 != 216 && i6 != 1) {
                        if (i6 != 217 && i6 != 218) {
                            int pack2 = pack(bArr, i5, 2, false);
                            if (pack2 >= 2 && (i3 = i5 + pack2) <= bArr.length) {
                                if (i6 == 225 && pack2 >= 8 && pack(bArr, i5 + 2, 4, false) == 1165519206 && pack(bArr, i5 + 6, 2, false) == 0) {
                                    i4 = i5 + 8;
                                    i2 = pack2 - 8;
                                    break;
                                }
                                i4 = i3;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
                i4 = i5;
            }
            i4 = i5;
        }
        i2 = 0;
        if (i2 <= 8 || !((pack = pack(bArr, i4, 4, false)) == 1229531648 || pack == 1296891946)) {
            return 0;
        }
        boolean z = pack == 1229531648;
        int pack3 = pack(bArr, i4 + 4, 4, z) + 2;
        if (pack3 >= 10 && pack3 <= i2) {
            int i7 = i4 + pack3;
            int i8 = i2 - pack3;
            int pack4 = pack(bArr, i7 - 2, 2, z);
            while (true) {
                int i9 = pack4 - 1;
                if (pack4 <= 0 || i8 < 12) {
                    break;
                }
                if (pack(bArr, i7, 2, z) == 274) {
                    int pack5 = pack(bArr, i7 + 8, 2, z);
                    if (pack5 == 1) {
                        return 0;
                    }
                    if (pack5 == 3) {
                        return 180;
                    }
                    if (pack5 == 6) {
                        return 90;
                    }
                    if (pack5 != 8) {
                        return 0;
                    }
                    return SubsamplingScaleImageView.ORIENTATION_270;
                }
                i7 += 12;
                i8 -= 12;
                pack4 = i9;
            }
        }
        return 0;
    }

    boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpeg") || str.startsWith("image/jpg");
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    String extSuffix(String str) {
        try {
            return TextUtils.isEmpty(str) ? ".jpg" : str.startsWith("video") ? str.replace("video/", ".") : str.replace("image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }
}
