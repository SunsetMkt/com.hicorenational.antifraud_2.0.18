package com.hihonor.cloudservice.support.account.request;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.List;
import l.a.a.a.b;

/* JADX INFO: compiled from: SignInOptionBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.hihonor.cloudservice.support.feature.request.a {
    public a() {
    }

    public SignInOptions a() {
        return new SignInOptions(this.a, this.f4047b, this.f4048c, this.f4049d, this.f4050e, this.f4051f, this.f4052g, this.f4053h, this.f4054i, this.f4055j, this.f4056k, this.f4057l);
    }

    public a b(String str) {
        this.f4048c = str;
        return this;
    }

    public a c(String str) {
        this.f4049d = str;
        return this;
    }

    public a d() {
        return a(AbstractSignInOptions.f4035n);
    }

    public a e(boolean z) {
        this.f4054i = z;
        return this;
    }

    public a(SignInOptions signInOptions) {
        this.a.addAll(signInOptions.f());
        this.f4047b.addAll(signInOptions.d());
    }

    public a a(boolean z) {
        this.f4051f = z;
        return this;
    }

    public a b() {
        return a(AbstractSignInOptions.o);
    }

    public a c(boolean z) {
        this.f4053h = z;
        return this;
    }

    public a d(String str) {
        this.f4050e = str;
        return this;
    }

    public a e() {
        this.f4047b.add(AbstractSignInOptions.f4034m);
        return this;
    }

    public a a(String str) {
        this.f4057l = str;
        return this;
    }

    public a b(boolean z) {
        this.f4052g = z;
        return this;
    }

    public a c() {
        return a(AbstractSignInOptions.p);
    }

    public a d(boolean z) {
        this.f4055j = z;
        return this;
    }

    public a e(String str) {
        this.f4056k = str;
        return this;
    }

    public a a(Scope scope) {
        this.a.add(scope);
        return this;
    }

    public a a(List<Scope> list) {
        if (b.b(list)) {
            for (Scope scope : list) {
                if (scope != null && scope.a() != null) {
                    this.a.add(scope);
                }
            }
        }
        return this;
    }
}
