package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
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
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (at atVar : list) {
                buildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            return au.a(context, new URL(buildUpon.toString()));
        }
    }

    public static String a(Context context, String str, List<at> list) {
        return a(context, str, list, new a(), true);
    }

    public static String a(Context context, String str, List<at> list, ch chVar, boolean z) {
        cc ccVar;
        String str2;
        String str3;
        if (au.m151a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cc m229a = cg.a().m229a(str);
                    if (m229a != null) {
                        arrayList = m229a.a(str);
                    }
                    ccVar = m229a;
                } else {
                    ccVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it = arrayList.iterator();
                String str4 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        str2 = str4;
                    }
                    if (!chVar.m239a(context, next, (List<at>) arrayList2)) {
                        break;
                    }
                    str2 = chVar.a(context, next, (List<at>) arrayList2);
                    try {
                    } catch (IOException e3) {
                        e = e3;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        if (ccVar != null) {
                            str3 = str2;
                            try {
                                ccVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(chVar, next, arrayList2, str2), null);
                            } catch (IOException e4) {
                                e = e4;
                                str2 = str3;
                            }
                        } else {
                            str3 = str2;
                        }
                        str4 = str3;
                    } else {
                        if (ccVar == null) {
                            return str2;
                        }
                        try {
                            ccVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(chVar, next, arrayList2, str2));
                            return str2;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    }
                    if (ccVar != null) {
                        str3 = str2;
                        ccVar.a(next, System.currentTimeMillis() - currentTimeMillis, a(chVar, next, arrayList2, str2), e);
                    } else {
                        str3 = str2;
                    }
                    e.printStackTrace();
                    str4 = str3;
                }
                return str4;
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
        int i2 = 0;
        for (at atVar : list) {
            if (!TextUtils.isEmpty(atVar.a())) {
                i2 += atVar.a().length();
            }
            if (!TextUtils.isEmpty(atVar.b())) {
                i2 += atVar.b().length();
            }
        }
        return i2 * 2;
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
