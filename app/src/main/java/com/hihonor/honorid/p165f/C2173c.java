package com.hihonor.honorid.p165f;

import org.xmlpull.v1.XmlSerializer;

/* compiled from: XMLPackUtil.java */
/* renamed from: com.hihonor.honorid.f.c */
/* loaded from: classes.dex */
public class C2173c {
    /* renamed from: a */
    public static void m6330a(XmlSerializer xmlSerializer, String str, String str2) {
        if (str2 == null || xmlSerializer == null || str == null) {
            return;
        }
        xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
    }
}
