package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.fv */
/* loaded from: classes2.dex */
public class C4228fv {

    /* renamed from: a */
    private static C4228fv f15410a;

    /* renamed from: a */
    private Map<String, Object> f15411a = new ConcurrentHashMap();

    /* renamed from: b */
    private Map<String, Object> f15412b = new ConcurrentHashMap();

    private C4228fv() {
        m14889a();
    }

    /* renamed from: a */
    public static synchronized C4228fv m14885a() {
        C4228fv c4228fv;
        synchronized (C4228fv.class) {
            if (f15410a == null) {
                f15410a = new C4228fv();
            }
            c4228fv = f15410a;
        }
        return c4228fv;
    }

    /* renamed from: a */
    protected void m14889a() {
        XmlPullParser newPullParser;
        int eventType;
        try {
            for (ClassLoader classLoader : m14887a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        eventType = newPullParser.getEventType();
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String m14886a = m14886a(nextText, nextText2);
                                if (!this.f15412b.containsKey(m14886a)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (InterfaceC4226ft.class.isAssignableFrom(cls)) {
                                            this.f15412b.put(m14886a, cls.newInstance());
                                        } else if (C4219fm.class.isAssignableFrom(cls)) {
                                            this.f15412b.put(m14886a, cls);
                                        }
                                    } catch (ClassNotFoundException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String m14886a2 = m14886a(nextText4, nextText5);
                                if (!this.f15411a.containsKey(m14886a2)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (InterfaceC4227fu.class.isAssignableFrom(cls2)) {
                                            this.f15411a.put(m14886a2, cls2.newInstance());
                                        } else if (InterfaceC4222fp.class.isAssignableFrom(cls2)) {
                                            this.f15411a.put(m14886a2, cls2);
                                        }
                                    } catch (ClassNotFoundException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                            inputStream.close();
                            throw th;
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    inputStream.close();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a */
    public Object m14888a(String str, String str2) {
        return this.f15411a.get(m14886a(str, str2));
    }

    /* renamed from: a */
    public void m14890a(String str, String str2, Object obj) {
        if (!(obj instanceof InterfaceC4227fu) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f15411a.put(m14886a(str, str2), obj);
    }

    /* renamed from: a */
    private String m14886a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private ClassLoader[] m14887a() {
        ClassLoader[] classLoaderArr = {C4228fv.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
