package com.google.gson;

import com.google.gson.p147b0.C2016i;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class JsonObject extends AbstractC2063k {
    private final C2016i<String, AbstractC2063k> members = new C2016i<>(false);

    public void add(String str, AbstractC2063k abstractC2063k) {
        C2016i<String, AbstractC2063k> c2016i = this.members;
        if (abstractC2063k == null) {
            abstractC2063k = C2065m.f6026a;
        }
        c2016i.put(str, abstractC2063k);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? C2065m.f6026a : new C2068p(str2));
    }

    public Map<String, AbstractC2063k> asMap() {
        return this.members;
    }

    public Set<Map.Entry<String, AbstractC2063k>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public AbstractC2063k get(String str) {
        return this.members.get(str);
    }

    public C2060h getAsJsonArray(String str) {
        return (C2060h) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public C2068p getAsJsonPrimitive(String str) {
        return (C2068p) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        return this.members.size() == 0;
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public AbstractC2063k remove(String str) {
        return this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? C2065m.f6026a : new C2068p(number));
    }

    @Override // com.google.gson.AbstractC2063k
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, AbstractC2063k> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? C2065m.f6026a : new C2068p(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, ch == null ? C2065m.f6026a : new C2068p(ch));
    }
}
