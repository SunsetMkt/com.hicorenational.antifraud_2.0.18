package cn.jzvd;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class JZDataSource {
    public static final String URL_KEY_DEFAULT = "URL_KEY_DEFAULT";
    public int currentUrlIndex;
    public HashMap<String, String> headerMap;
    public boolean looping;
    public Object[] objects;
    public String title;
    public LinkedHashMap urlsMap;

    public JZDataSource(String str) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap<>();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, str);
        this.currentUrlIndex = 0;
    }

    public JZDataSource cloneMe() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.urlsMap);
        return new JZDataSource(linkedHashMap, this.title);
    }

    public boolean containsTheUrl(Object obj) {
        if (obj != null) {
            return this.urlsMap.containsValue(obj);
        }
        return false;
    }

    public Object getCurrentKey() {
        return getKeyFromDataSource(this.currentUrlIndex);
    }

    public Object getCurrentUrl() {
        return getValueFromLinkedMap(this.currentUrlIndex);
    }

    public String getKeyFromDataSource(int i2) {
        int i3 = 0;
        for (Object obj : this.urlsMap.keySet()) {
            if (i3 == i2) {
                return obj.toString();
            }
            i3++;
        }
        return null;
    }

    public Object getValueFromLinkedMap(int i2) {
        int i3 = 0;
        for (Object obj : this.urlsMap.keySet()) {
            if (i3 == i2) {
                return this.urlsMap.get(obj);
            }
            i3++;
        }
        return null;
    }

    public JZDataSource(String str, String str2) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap<>();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, str);
        this.title = str2;
        this.currentUrlIndex = 0;
    }

    public JZDataSource(Object obj) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap<>();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, obj);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(LinkedHashMap linkedHashMap) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap<>();
        this.looping = false;
        this.urlsMap.clear();
        this.urlsMap.putAll(linkedHashMap);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(LinkedHashMap linkedHashMap, String str) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap<>();
        this.looping = false;
        this.urlsMap.clear();
        this.urlsMap.putAll(linkedHashMap);
        this.title = str;
        this.currentUrlIndex = 0;
    }
}
