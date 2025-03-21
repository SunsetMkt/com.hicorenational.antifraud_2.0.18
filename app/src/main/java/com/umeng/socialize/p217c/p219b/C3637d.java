package com.umeng.socialize.p217c.p219b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: ImageFormat.java */
/* renamed from: com.umeng.socialize.c.b.d */
/* loaded from: classes2.dex */
public class C3637d {

    /* renamed from: a */
    public static final int f13587a = 0;

    /* renamed from: b */
    public static final int f13588b = 1;

    /* renamed from: c */
    public static final int f13589c = 2;

    /* renamed from: d */
    public static final int f13590d = 3;

    /* renamed from: e */
    public static final int f13591e = 4;

    /* renamed from: f */
    public static final int f13592f = 5;

    /* renamed from: g */
    public static final int f13593g = 6;

    /* renamed from: h */
    public static final int f13594h = 7;

    /* renamed from: i */
    public static final int f13595i = 8;

    /* renamed from: j */
    public static final int f13596j = 9;

    /* renamed from: k */
    public static final int f13597k = 10;

    /* renamed from: l */
    public static final int f13598l = 11;

    /* renamed from: m */
    public static final String[] f13599m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    /* renamed from: a */
    public static String m12636a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    int read = byteArrayInputStream.read();
                    int read2 = byteArrayInputStream.read();
                    if (read == 71 && read2 == 73) {
                        String str = f13599m[1];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            SLog.error(UmengText.IMAGE.CLOSE, e2);
                        }
                        return str;
                    }
                    if (read == 137 && read2 == 80) {
                        String str2 = f13599m[2];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e3) {
                            SLog.error(UmengText.IMAGE.CLOSE, e3);
                        }
                        return str2;
                    }
                    if (read == 255 && read2 == 216) {
                        String str3 = f13599m[0];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e4) {
                            SLog.error(UmengText.IMAGE.CLOSE, e4);
                        }
                        return str3;
                    }
                    if (read == 66 && read2 == 77) {
                        String str4 = f13599m[3];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e5) {
                            SLog.error(UmengText.IMAGE.CLOSE, e5);
                        }
                        return str4;
                    }
                    if (read == 10 && read2 < 6) {
                        String str5 = f13599m[4];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            SLog.error(UmengText.IMAGE.CLOSE, e6);
                        }
                        return str5;
                    }
                    if (read == 70 && read2 == 79) {
                        String str6 = f13599m[5];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e7) {
                            SLog.error(UmengText.IMAGE.CLOSE, e7);
                        }
                        return str6;
                    }
                    if (read == 89 && read2 == 166) {
                        String str7 = f13599m[6];
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
                        String str8 = f13599m[new int[]{7, 8, 9}[(i2 - 1) % 3]];
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e10) {
                            SLog.error(UmengText.IMAGE.CLOSE, e10);
                        }
                        return str8;
                    }
                    if (read == 56 && read2 == 66) {
                        String str9 = f13599m[10];
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
                    String str10 = f13599m[11];
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
