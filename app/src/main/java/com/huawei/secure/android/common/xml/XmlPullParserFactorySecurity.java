package com.huawei.secure.android.common.xml;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class XmlPullParserFactorySecurity {
    public static XmlPullParserFactory getInstance() throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
        return newInstance;
    }
}
