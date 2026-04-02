package com.lxj.xpopup.core;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;
import com.lxj.xpopup.d.f;
import com.lxj.xpopup.e.i;

/* JADX INFO: compiled from: PopupInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5451l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i f5453n;
    public ViewGroup o;
    public int s;
    public int t;
    public f a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f5441b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f5442c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f5443d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f5444e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f5445f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f5446g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f5447h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f5448i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PointF f5449j = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f5452m = false;
    public Boolean p = true;
    public d q = null;
    public Boolean r = false;
    public Boolean u = true;
    public boolean v = false;
    public boolean w = true;
    public boolean x = true;

    public View a() {
        return this.f5445f;
    }

    public String toString() {
        return "PopupInfo{popupType=" + this.a + ", isDismissOnBackPressed=" + this.f5441b + ", isDismissOnTouchOutside=" + this.f5442c + ", hasShadowBg=" + this.f5444e + ", atView=" + this.f5445f + ", popupAnimation=" + this.f5447h + ", customAnimator=" + this.f5448i + ", touchPoint=" + this.f5449j + ", maxWidth=" + this.f5450k + ", maxHeight=" + this.f5451l + '}';
    }
}
