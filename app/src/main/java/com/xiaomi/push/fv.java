package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class fv {

    /* renamed from: a, reason: collision with root package name */
    private static fv f12897a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Object> f540a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f12898b = new ConcurrentHashMap();

    private fv() {
        m439a();
    }

    public static synchronized fv a() {
        fv fvVar;
        synchronized (fv.class) {
            if (f12897a == null) {
                f12897a = new fv();
            }
            fvVar = f12897a;
        }
        return fvVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    protected void m439a() {
        XmlPullParser newPullParser;
        int eventType;
        try {
            for (ClassLoader classLoader : m437a()) {
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
                                String a2 = a(nextText, nextText2);
                                if (!this.f12898b.containsKey(a2)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (ft.class.isAssignableFrom(cls)) {
                                            this.f12898b.put(a2, cls.newInstance());
                                        } else if (fm.class.isAssignableFrom(cls)) {
                                            this.f12898b.put(a2, cls);
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
                                String a3 = a(nextText4, nextText5);
                                if (!this.f540a.containsKey(a3)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (fu.class.isAssignableFrom(cls2)) {
                                            this.f540a.put(a3, cls2.newInstance());
                                        } else if (fp.class.isAssignableFrom(cls2)) {
                                            this.f540a.put(a3, cls2);
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

    /* renamed from: a, reason: collision with other method in class */
    public Object m438a(String str, String str2) {
        return this.f540a.get(a(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof fu) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f540a.put(a(str, str2), obj);
    }

    private String a(String str, String str2) {
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

    /* renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m437a() {
        ClassLoader[] classLoaderArr = {fv.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
