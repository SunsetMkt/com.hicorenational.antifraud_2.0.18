package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4096ay;
import com.xiaomi.push.C4411z;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4245gl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ah */
/* loaded from: classes2.dex */
public class C4356ah {

    /* renamed from: a */
    private static volatile C4356ah f16531a;

    /* renamed from: a */
    protected SharedPreferences f16532a;

    /* renamed from: a */
    private HashSet<a> f16533a = new HashSet<>();

    /* renamed from: b */
    protected SharedPreferences f16534b;

    /* renamed from: com.xiaomi.push.service.ah$a */
    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i2, String str) {
            this.mId = i2;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        protected abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private C4356ah(Context context) {
        this.f16532a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f16534b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    /* renamed from: a */
    public synchronized void m15932a(a aVar) {
        if (!this.f16533a.contains(aVar)) {
            this.f16533a.add(aVar);
        }
    }

    /* renamed from: b */
    void m15936b() {
        AbstractC4022b.m13359c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f16533a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    /* renamed from: a */
    public synchronized void m15931a() {
        this.f16533a.clear();
    }

    /* renamed from: a */
    public static C4356ah m15923a(Context context) {
        if (f16531a == null) {
            synchronized (C4356ah.class) {
                if (f16531a == null) {
                    f16531a = new C4356ah(context);
                }
            }
        }
        return f16531a;
    }

    /* renamed from: a */
    public void m15934a(List<Pair<EnumC4245gl, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (!C4411z.m16370a(list) && !C4411z.m16370a(list2)) {
            SharedPreferences.Editor edit = this.f16532a.edit();
            edit.clear();
            for (Pair<EnumC4245gl, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    edit.putInt(m15925a((EnumC4245gl) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    m15926a(edit, pair2, m15924a(((Integer) obj2).intValue()));
                }
            }
            edit.apply();
            return;
        }
        AbstractC4022b.m13347a("not update oc, because versions or configs are empty");
    }

    /* renamed from: a */
    public void m15933a(List<Pair<Integer, Object>> list) {
        if (C4411z.m16370a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f16534b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String m15924a = m15924a(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(m15924a);
                } else {
                    m15926a(edit, pair, m15924a);
                }
            }
        }
        edit.apply();
    }

    /* renamed from: a */
    private void m15926a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(m15924a(EnumC4244gk.AppIsInstalledList.m15014a()))) {
                editor.putString(str, C4096ay.m13839a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    /* renamed from: a */
    public int m15927a(int i2, int i3) {
        try {
            String m15924a = m15924a(i2);
            if (this.f16534b.contains(m15924a)) {
                return this.f16534b.getInt(m15924a, 0);
            }
            return this.f16532a.contains(m15924a) ? this.f16532a.getInt(m15924a, 0) : i3;
        } catch (Exception e2) {
            AbstractC4022b.m13347a(i2 + " oc int error " + e2);
            return i3;
        }
    }

    /* renamed from: a */
    public long m15929a(int i2, long j2) {
        try {
            String m15924a = m15924a(i2);
            if (this.f16534b.contains(m15924a)) {
                return this.f16534b.getLong(m15924a, 0L);
            }
            return this.f16532a.contains(m15924a) ? this.f16532a.getLong(m15924a, 0L) : j2;
        } catch (Exception e2) {
            AbstractC4022b.m13347a(i2 + " oc long error " + e2);
            return j2;
        }
    }

    /* renamed from: a */
    public String m15930a(int i2, String str) {
        try {
            String m15924a = m15924a(i2);
            if (this.f16534b.contains(m15924a)) {
                return this.f16534b.getString(m15924a, null);
            }
            return this.f16532a.contains(m15924a) ? this.f16532a.getString(m15924a, null) : str;
        } catch (Exception e2) {
            AbstractC4022b.m13347a(i2 + " oc string error " + e2);
            return str;
        }
    }

    /* renamed from: a */
    public boolean m15935a(int i2, boolean z) {
        try {
            String m15924a = m15924a(i2);
            if (this.f16534b.contains(m15924a)) {
                return this.f16534b.getBoolean(m15924a, false);
            }
            return this.f16532a.contains(m15924a) ? this.f16532a.getBoolean(m15924a, false) : z;
        } catch (Exception e2) {
            AbstractC4022b.m13347a(i2 + " oc boolean error " + e2);
            return z;
        }
    }

    /* renamed from: a */
    public int m15928a(EnumC4245gl enumC4245gl, int i2) {
        try {
            return this.f16532a.getInt(m15925a(enumC4245gl), i2);
        } catch (Exception e2) {
            AbstractC4022b.m13347a(enumC4245gl + " version error " + e2);
            return i2;
        }
    }

    /* renamed from: a */
    private String m15924a(int i2) {
        return "oc_" + i2;
    }

    /* renamed from: a */
    private String m15925a(EnumC4245gl enumC4245gl) {
        return "oc_version_" + enumC4245gl.m15016a();
    }
}
