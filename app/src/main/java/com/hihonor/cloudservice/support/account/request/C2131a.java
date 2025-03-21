package com.hihonor.cloudservice.support.account.request;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractC2138a;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.List;
import p358k.p359a.p360a.p361a.C5848b;

/* compiled from: SignInOptionBuilder.java */
/* renamed from: com.hihonor.cloudservice.support.account.request.a */
/* loaded from: classes.dex */
public class C2131a extends AbstractC2138a {
    public C2131a() {
    }

    /* renamed from: a */
    public SignInOptions m5981a() {
        return new SignInOptions(this.f6411a, this.f6412b, this.f6413c, this.f6414d, this.f6415e, this.f6416f, this.f6417g, this.f6418h, this.f6419i, this.f6420j, this.f6421k, this.f6422l);
    }

    /* renamed from: b */
    public C2131a m5987b(String str) {
        this.f6413c = str;
        return this;
    }

    /* renamed from: c */
    public C2131a m5990c(String str) {
        this.f6414d = str;
        return this;
    }

    /* renamed from: d */
    public C2131a m5992d() {
        return m5982a(AbstractSignInOptions.f6396n);
    }

    /* renamed from: e */
    public C2131a m5997e(boolean z) {
        this.f6419i = z;
        return this;
    }

    public C2131a(SignInOptions signInOptions) {
        this.f6411a.addAll(signInOptions.m6030f());
        this.f6412b.addAll(signInOptions.m6028d());
    }

    /* renamed from: a */
    public C2131a m5985a(boolean z) {
        this.f6416f = z;
        return this;
    }

    /* renamed from: b */
    public C2131a m5986b() {
        return m5982a(AbstractSignInOptions.f6397o);
    }

    /* renamed from: c */
    public C2131a m5991c(boolean z) {
        this.f6418h = z;
        return this;
    }

    /* renamed from: d */
    public C2131a m5993d(String str) {
        this.f6415e = str;
        return this;
    }

    /* renamed from: e */
    public C2131a m5995e() {
        this.f6412b.add(AbstractSignInOptions.f6395m);
        return this;
    }

    /* renamed from: a */
    public C2131a m5983a(String str) {
        this.f6422l = str;
        return this;
    }

    /* renamed from: b */
    public C2131a m5988b(boolean z) {
        this.f6417g = z;
        return this;
    }

    /* renamed from: c */
    public C2131a m5989c() {
        return m5982a(AbstractSignInOptions.f6398p);
    }

    /* renamed from: d */
    public C2131a m5994d(boolean z) {
        this.f6420j = z;
        return this;
    }

    /* renamed from: e */
    public C2131a m5996e(String str) {
        this.f6421k = str;
        return this;
    }

    /* renamed from: a */
    public C2131a m5982a(Scope scope) {
        this.f6411a.add(scope);
        return this;
    }

    /* renamed from: a */
    public C2131a m5984a(List<Scope> list) {
        if (C5848b.m24626b(list)) {
            for (Scope scope : list) {
                if (scope != null && scope.m6019a() != null) {
                    this.f6411a.add(scope);
                }
            }
        }
        return this;
    }
}
