package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import com.umeng.analytics.pro.cw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class C0115a {
        public String a;

        /* JADX INFO: renamed from: b */
        public String f6736b;

        /* JADX INFO: renamed from: c */
        public String f6737c;

        /* JADX INFO: renamed from: d */
        public long f6738d;

        /* JADX INFO: renamed from: e */
        public Bundle f6739e;
    }

    public static int a(Bundle bundle, String str, int i2) {
        if (bundle == null) {
            return i2;
        }
        try {
            return bundle.getInt(str, i2);
        } catch (Exception e2) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e2.getMessage());
            return i2;
        }
    }

    public static Object a(int i2, String str) {
        try {
            switch (i2) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e2.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e2.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0115a c0115a) {
        String str;
        if (context == null || c0115a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c0115a.f6736b)) {
                String str2 = null;
                if (!b.b(c0115a.a)) {
                    str2 = c0115a.a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0115a.f6736b);
                Bundle bundle = c0115a.f6739e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0115a.f6737c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0115a.f6738d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c0115a.f6737c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0155: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:297:0x0155 */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, int i2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r8;
        ?? r0;
        Object obj;
        ?? r3;
        Exception e2;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        IOException e3;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        MalformedURLException e4;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream3;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        ByteArrayOutputStream byteArrayOutputStream5;
        ByteArrayOutputStream byteArrayOutputStream6 = null;
        if (str != null) {
            int length = str.length();
            try {
                if (length != 0) {
                    try {
                        httpURLConnection7 = (HttpURLConnection) new URL(str).openConnection();
                    } catch (MalformedURLException e5) {
                        e4 = e5;
                        httpURLConnection3 = null;
                        inputStream3 = null;
                    } catch (IOException e6) {
                        e3 = e6;
                        httpURLConnection2 = null;
                        inputStream2 = null;
                    } catch (Exception e7) {
                        e2 = e7;
                        httpURLConnection = null;
                        inputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        r8 = 0;
                        r0 = 0;
                    }
                    try {
                        try {
                        } catch (MalformedURLException e8) {
                            e4 = e8;
                            inputStream3 = null;
                            byteArrayOutputStream4 = null;
                            httpURLConnection6 = httpURLConnection7;
                        } catch (IOException e9) {
                            e3 = e9;
                            inputStream2 = null;
                            byteArrayOutputStream3 = null;
                            httpURLConnection5 = httpURLConnection7;
                        } catch (Exception e10) {
                            e2 = e10;
                            inputStream = null;
                            byteArrayOutputStream2 = null;
                            httpURLConnection4 = httpURLConnection7;
                        }
                        if (httpURLConnection7 == null) {
                            Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                            if (httpURLConnection7 != null) {
                                try {
                                    httpURLConnection7.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            return null;
                        }
                        try {
                            httpURLConnection7.setRequestMethod("GET");
                            httpURLConnection7.setConnectTimeout(i2);
                            httpURLConnection7.setReadTimeout(i2);
                            if (httpURLConnection7.getResponseCode() >= 300) {
                                Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                try {
                                    httpURLConnection7.disconnect();
                                } catch (Throwable unused2) {
                                }
                                return null;
                            }
                            InputStream inputStream4 = httpURLConnection7.getInputStream();
                            try {
                                byteArrayOutputStream5 = new ByteArrayOutputStream();
                            } catch (MalformedURLException e11) {
                                inputStream3 = inputStream4;
                                e4 = e11;
                                httpURLConnection3 = httpURLConnection7;
                                byteArrayOutputStream4 = null;
                                httpURLConnection6 = httpURLConnection3;
                            } catch (IOException e12) {
                                inputStream2 = inputStream4;
                                e3 = e12;
                                httpURLConnection2 = httpURLConnection7;
                                byteArrayOutputStream3 = null;
                                httpURLConnection5 = httpURLConnection2;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                if (httpURLConnection5 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (byteArrayOutputStream3 != null) {
                                }
                                return null;
                            } catch (Exception e13) {
                                inputStream = inputStream4;
                                e2 = e13;
                                httpURLConnection = httpURLConnection7;
                                byteArrayOutputStream2 = null;
                                httpURLConnection4 = httpURLConnection;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                if (httpURLConnection4 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream2 != null) {
                                }
                                return null;
                            } catch (Throwable th2) {
                                r0 = inputStream4;
                                th = th2;
                                r8 = httpURLConnection7;
                                if (r8 != 0) {
                                }
                                if (r0 != 0) {
                                }
                                if (byteArrayOutputStream6 != null) {
                                }
                            }
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i3 = inputStream4.read(bArr);
                                    if (i3 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream5.write(bArr, 0, i3);
                                }
                                byte[] byteArray = byteArrayOutputStream5.toByteArray();
                                Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                try {
                                    httpURLConnection7.disconnect();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    inputStream4.close();
                                } catch (Throwable unused4) {
                                }
                                try {
                                    byteArrayOutputStream5.close();
                                } catch (Throwable unused5) {
                                }
                                return byteArray;
                            } catch (MalformedURLException e14) {
                                inputStream3 = inputStream4;
                                e4 = e14;
                                byteArrayOutputStream4 = byteArrayOutputStream5;
                                httpURLConnection6 = httpURLConnection7;
                            } catch (IOException e15) {
                                inputStream2 = inputStream4;
                                e3 = e15;
                                byteArrayOutputStream3 = byteArrayOutputStream5;
                                httpURLConnection5 = httpURLConnection7;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                                if (httpURLConnection5 != null) {
                                    try {
                                        httpURLConnection5.disconnect();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                if (byteArrayOutputStream3 != null) {
                                    try {
                                        byteArrayOutputStream3.close();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                return null;
                            } catch (Exception e16) {
                                inputStream = inputStream4;
                                e2 = e16;
                                byteArrayOutputStream2 = byteArrayOutputStream5;
                                httpURLConnection4 = httpURLConnection7;
                                Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                                if (httpURLConnection4 != null) {
                                    try {
                                        httpURLConnection4.disconnect();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return null;
                            } catch (Throwable th3) {
                                byteArrayOutputStream6 = byteArrayOutputStream5;
                                r3 = inputStream4;
                                th = th3;
                                obj = httpURLConnection7;
                                r0 = r3;
                                r8 = obj;
                                if (r8 != 0) {
                                    try {
                                        r8.disconnect();
                                    } catch (Throwable unused12) {
                                    }
                                }
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (Throwable unused13) {
                                    }
                                }
                                if (byteArrayOutputStream6 != null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream6.close();
                                    throw th;
                                } catch (Throwable unused14) {
                                    throw th;
                                }
                            }
                        } catch (MalformedURLException e17) {
                            e4 = e17;
                            inputStream3 = null;
                            httpURLConnection3 = httpURLConnection7;
                        } catch (IOException e18) {
                            e3 = e18;
                            inputStream2 = null;
                            httpURLConnection2 = httpURLConnection7;
                        } catch (Exception e19) {
                            e2 = e19;
                            inputStream = null;
                            httpURLConnection = httpURLConnection7;
                        }
                        byteArrayOutputStream4 = null;
                        httpURLConnection6 = httpURLConnection3;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e4.getMessage());
                        if (httpURLConnection6 != null) {
                            try {
                                httpURLConnection6.disconnect();
                            } catch (Throwable unused15) {
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable unused16) {
                            }
                        }
                        if (byteArrayOutputStream4 != null) {
                            try {
                                byteArrayOutputStream4.close();
                            } catch (Throwable unused17) {
                            }
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        r0 = 0;
                        r8 = httpURLConnection7;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream6 = byteArrayOutputStream;
                r3 = length;
                obj = str;
            }
        }
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }

    public static byte[] a(String str, int i2, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i3 = 0;
            for (byte b2 : bArrDigest) {
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                i3 = i4 + 1;
                cArr2[i4] = cArr[b2 & cw.f7205m];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
