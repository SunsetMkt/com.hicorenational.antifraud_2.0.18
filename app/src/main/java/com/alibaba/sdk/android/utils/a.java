package com.alibaba.sdk.android.utils;

import android.app.Application;
import java.util.Map;

/* JADX INFO: compiled from: DataTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private boolean a = false;

    public void a(Application application, Map<String, String> map) {
    }

    public void sendCustomHit(String str, long j2, Map<String, String> map) {
        b.a("Utils:DataTracker", "no ut version, do nothing");
    }
}
