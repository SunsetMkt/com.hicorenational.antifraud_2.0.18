package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: ImageFormat.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f11652a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f11653b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f11654c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f11655d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f11656e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f11657f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f11658g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f11659h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f11660i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f11661j = 9;

    /* renamed from: k, reason: collision with root package name */
    public static final int f11662k = 10;

    /* renamed from: l, reason: collision with root package name */
    public static final int f11663l = 11;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f11664m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    public static String a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    int read = byteArrayInputStream.read();
                    int read2 = byteArrayInputStream.read();
                    if (read == 71 && read2 == 73) {
                        String str = f11664m[1];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            SLog.error(UmengText.IMAGE.CLOSE, e2);
                        }
                        return str;
                    }
                    if (read == 137 && read2 == 80) {
                        String str2 = f11664m[2];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e3) {
                            SLog.error(UmengText.IMAGE.CLOSE, e3);
                        }
                        return str2;
                    }
                    if (read == 255 && read2 == 216) {
                        String str3 = f11664m[0];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e4) {
                            SLog.error(UmengText.IMAGE.CLOSE, e4);
                        }
                        return str3;
                    }
                    if (read == 66 && read2 == 77) {
                        String str4 = f11664m[3];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e5) {
                            SLog.error(UmengText.IMAGE.CLOSE, e5);
                        }
                        return str4;
                    }
                    if (read == 10 && read2 < 6) {
                        String str5 = f11664m[4];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            SLog.error(UmengText.IMAGE.CLOSE, e6);
                        }
                        return str5;
                    }
                    if (read == 70 && read2 == 79) {
                        String str6 = f11664m[5];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e7) {
                            SLog.error(UmengText.IMAGE.CLOSE, e7);
                        }
                        return str6;
                    }
                    if (read == 89 && read2 == 166) {
                        String str7 = f11664m[6];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e8) {
                            SLog.error(UmengText.IMAGE.CLOSE, e8);
                        }
                        return str7;
                    }
                    if (read == 80 && read2 >= 49 && read2 <= 54) {
                        int i2 = read2 - 48;
                        if (i2 < 1 || i2 > 6) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e9) {
                                SLog.error(UmengText.IMAGE.CLOSE, e9);
                            }
                            return "";
                        }
                        String str8 = f11664m[new int[]{7, 8, 9}[(i2 - 1) % 3]];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e10) {
                            SLog.error(UmengText.IMAGE.CLOSE, e10);
                        }
                        return str8;
                    }
                    if (read == 56 && read2 == 66) {
                        String str9 = f11664m[10];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e11) {
                            SLog.error(UmengText.IMAGE.CLOSE, e11);
                        }
                        return str9;
                    }
                    if (read != 70 || read2 != 87) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e12) {
                            SLog.error(UmengText.IMAGE.CLOSE, e12);
                        }
                        return "";
                    }
                    String str10 = f11664m[11];
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e13) {
                        SLog.error(UmengText.IMAGE.CLOSE, e13);
                    }
                    return str10;
                } catch (Exception e14) {
                    e = e14;
                    byteArrayInputStream2 = byteArrayInputStream;
                    SLog.error(UmengText.IMAGE.CHECK_FORMAT_ERROR, e);
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e15) {
                            SLog.error(UmengText.IMAGE.CLOSE, e15);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e16) {
                            SLog.error(UmengText.IMAGE.CLOSE, e16);
                        }
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
        }
    }
}
