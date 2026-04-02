package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ci {

    public static class a extends ch {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.ch
        public String a(Context context, String str, List<at> list) {
            if (list == null) {
                return au.a(context, new URL(str));
            }
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            for (at atVar : list) {
                builderBuildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            return au.a(context, new URL(builderBuildUpon.toString()));
        }
    }

    public static String a(Context context, String str, List<at> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009d A[Catch: MalformedURLException -> 0x00bc, TRY_ENTER, TryCatch #3 {MalformedURLException -> 0x00bc, blocks: (B:4:0x000f, B:6:0x0016, B:8:0x0020, B:11:0x0027, B:13:0x002d, B:14:0x0030, B:15:0x0035, B:17:0x003b, B:19:0x0044, B:21:0x004c, B:46:0x009d, B:48:0x00b3), top: B:61:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, List<at> list, ch chVar, boolean z) {
        cc ccVar;
        String strA;
        String str2;
        if (au.m149a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cc ccVarM227a = cg.a().m227a(str);
                    if (ccVarM227a != null) {
                        arrayList = ccVarM227a.a(str);
                    }
                    ccVar = ccVarM227a;
                } else {
                    ccVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                String str3 = null;
                for (String str4 : arrayList) {
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        strA = str3;
                    }
                    if (!chVar.m237a(context, str4, (List<at>) arrayList2)) {
                        break;
                    }
                    strA = chVar.a(context, str4, (List<at>) arrayList2);
                    try {
                    } catch (IOException e3) {
                        e = e3;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        if (ccVar != null) {
                            str2 = strA;
                            try {
                                ccVar.a(str4, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str4, arrayList2, strA), null);
                            } catch (IOException e4) {
                                e = e4;
                                strA = str2;
                                if (ccVar == null) {
                                }
                                e.printStackTrace();
                            }
                        } else {
                            str2 = strA;
                        }
                        str3 = str2;
                    } else {
                        if (ccVar == null) {
                            return strA;
                        }
                        try {
                            ccVar.a(str4, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str4, arrayList2, strA));
                            return strA;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    }
                    if (ccVar == null) {
                        str2 = strA;
                        ccVar.a(str4, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, str4, arrayList2, strA), e);
                    } else {
                        str2 = strA;
                    }
                    e.printStackTrace();
                    str3 = str2;
                }
                return str3;
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    private static int a(ch chVar, String str, List<at> list, String str2) {
        if (chVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (chVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    static int a(List<at> list) {
        int length = 0;
        for (at atVar : list) {
            if (!TextUtils.isEmpty(atVar.a())) {
                length += atVar.a().length();
            }
            if (!TextUtils.isEmpty(atVar.b())) {
                length += atVar.b().length();
            }
        }
        return length * 2;
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(int i2, int i3) {
        return (((i3 + 243) / 1448) * 132) + 1080 + i2 + i3;
    }

    static int a(int i2, int i3, int i4) {
        return (((i3 + 200) / 1448) * 132) + 1011 + i3 + i2 + i4;
    }
}
