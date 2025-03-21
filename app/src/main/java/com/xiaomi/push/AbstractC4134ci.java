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

/* renamed from: com.xiaomi.push.ci */
/* loaded from: classes2.dex */
public abstract class AbstractC4134ci {

    /* renamed from: com.xiaomi.push.ci$a */
    public static class a extends AbstractC4133ch {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.AbstractC4133ch
        /* renamed from: a */
        public String mo14100a(Context context, String str, List<InterfaceC4091at> list) {
            if (list == null) {
                return C4092au.m13790a(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (InterfaceC4091at interfaceC4091at : list) {
                buildUpon.appendQueryParameter(interfaceC4091at.mo13777a(), interfaceC4091at.mo13778b());
            }
            return C4092au.m13790a(context, new URL(buildUpon.toString()));
        }
    }

    /* renamed from: a */
    public static String m14107a(Context context, String str, List<InterfaceC4091at> list) {
        return m14108a(context, str, list, new a(), true);
    }

    /* renamed from: a */
    public static String m14108a(Context context, String str, List<InterfaceC4091at> list, AbstractC4133ch abstractC4133ch, boolean z) {
        C4128cc c4128cc;
        String str2;
        String str3;
        if (C4092au.m13799a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    C4128cc m14076a = C4132cg.m14066a().m14076a(str);
                    if (m14076a != null) {
                        arrayList = m14076a.m14035a(str);
                    }
                    c4128cc = m14076a;
                } else {
                    c4128cc = null;
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
                    if (!abstractC4133ch.m14101a(context, next, (List<InterfaceC4091at>) arrayList2)) {
                        break;
                    }
                    str2 = abstractC4133ch.mo14100a(context, next, (List<InterfaceC4091at>) arrayList2);
                    try {
                    } catch (IOException e3) {
                        e = e3;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        if (c4128cc != null) {
                            str3 = str2;
                            try {
                                c4128cc.m14044a(next, System.currentTimeMillis() - currentTimeMillis, m14104a(abstractC4133ch, next, arrayList2, str2), null);
                            } catch (IOException e4) {
                                e = e4;
                                str2 = str3;
                            }
                        } else {
                            str3 = str2;
                        }
                        str4 = str3;
                    } else {
                        if (c4128cc == null) {
                            return str2;
                        }
                        try {
                            c4128cc.m14043a(next, System.currentTimeMillis() - currentTimeMillis, m14104a(abstractC4133ch, next, arrayList2, str2));
                            return str2;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    }
                    if (c4128cc != null) {
                        str3 = str2;
                        c4128cc.m14044a(next, System.currentTimeMillis() - currentTimeMillis, m14104a(abstractC4133ch, next, arrayList2, str2), e);
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

    /* renamed from: a */
    private static int m14104a(AbstractC4133ch abstractC4133ch, String str, List<InterfaceC4091at> list, String str2) {
        if (abstractC4133ch.m14099a() == 1) {
            return m14102a(str.length(), m14105a(str2));
        }
        if (abstractC4133ch.m14099a() != 2) {
            return -1;
        }
        return m14103a(str.length(), m14106a(list), m14105a(str2));
    }

    /* renamed from: a */
    static int m14106a(List<InterfaceC4091at> list) {
        int i2 = 0;
        for (InterfaceC4091at interfaceC4091at : list) {
            if (!TextUtils.isEmpty(interfaceC4091at.mo13777a())) {
                i2 += interfaceC4091at.mo13777a().length();
            }
            if (!TextUtils.isEmpty(interfaceC4091at.mo13778b())) {
                i2 += interfaceC4091at.mo13778b().length();
            }
        }
        return i2 * 2;
    }

    /* renamed from: a */
    static int m14105a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    static int m14102a(int i2, int i3) {
        return (((i3 + 243) / 1448) * 132) + 1080 + i2 + i3;
    }

    /* renamed from: a */
    static int m14103a(int i2, int i3, int i4) {
        return (((i3 + 200) / 1448) * 132) + 1011 + i3 + i2 + i4;
    }
}
