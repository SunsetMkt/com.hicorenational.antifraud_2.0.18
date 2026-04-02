package com.hihonor.cloudservice.support.feature.request;

import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: AbstractSignInOptionBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f4051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f4052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f4053h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f4056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f4057l;
    public Set<Scope> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<PermissionInfo> f4047b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f4048c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f4049d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f4050e = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f4054i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f4055j = true;

    public a() {
    }

    public a(AbstractSignInOptions abstractSignInOptions) {
    }
}
