package com.xiaomi.push;

import java.util.Map;

/* renamed from: com.xiaomi.push.fb */
/* loaded from: classes2.dex */
public class C4208fb implements Cloneable {

    /* renamed from: a */
    public static String f15282a = "wcc-ml-test10.bj";

    /* renamed from: b */
    public static String f15283b;

    /* renamed from: a */
    private int f15284a;

    /* renamed from: a */
    private InterfaceC4211fe f15285a;

    /* renamed from: a */
    private boolean f15286a = AbstractC4207fa.f15262a;

    /* renamed from: b */
    private boolean f15287b = true;

    /* renamed from: c */
    private String f15288c;

    /* renamed from: d */
    private String f15289d;

    /* renamed from: e */
    private String f15290e;

    public C4208fb(Map<String, Integer> map, int i2, String str, InterfaceC4211fe interfaceC4211fe) {
        m14786a(map, i2, str, interfaceC4211fe);
    }

    /* renamed from: a */
    public static final String m14784a() {
        String str = f15283b;
        return str != null ? str : C4409x.m16366a() ? "sandbox.xmpush.xiaomi.com" : C4409x.m16367b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* renamed from: a */
    public byte[] mo14790a() {
        return null;
    }

    /* renamed from: b */
    public void m14792b(String str) {
        this.f15290e = str;
    }

    /* renamed from: c */
    public String m14793c() {
        if (this.f15289d == null) {
            this.f15289d = m14784a();
        }
        return this.f15289d;
    }

    /* renamed from: b */
    public String m14791b() {
        return this.f15290e;
    }

    /* renamed from: a */
    public static final void m14785a(String str) {
        if (C4409x.m16367b()) {
            return;
        }
        f15283b = str;
    }

    /* renamed from: c */
    public void m14794c(String str) {
        this.f15289d = str;
    }

    /* renamed from: a */
    private void m14786a(Map<String, Integer> map, int i2, String str, InterfaceC4211fe interfaceC4211fe) {
        this.f15284a = i2;
        this.f15288c = str;
        this.f15285a = interfaceC4211fe;
    }

    /* renamed from: a */
    public int m14787a() {
        return this.f15284a;
    }

    /* renamed from: a */
    public boolean m14789a() {
        return this.f15286a;
    }

    /* renamed from: a */
    public void m14788a(boolean z) {
        this.f15286a = z;
    }
}
