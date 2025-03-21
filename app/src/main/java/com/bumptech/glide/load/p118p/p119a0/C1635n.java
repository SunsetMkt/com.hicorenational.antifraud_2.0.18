package com.bumptech.glide.load.p118p.p119a0;

import java.util.Map;
import java.util.TreeMap;

/* compiled from: PrettyPrintTreeMap.java */
/* renamed from: com.bumptech.glide.load.p.a0.n */
/* loaded from: classes.dex */
class C1635n<K, V> extends TreeMap<K, V> {
    C1635n() {
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append('{');
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
