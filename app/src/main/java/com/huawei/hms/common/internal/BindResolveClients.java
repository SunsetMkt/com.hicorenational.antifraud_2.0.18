package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class BindResolveClients {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4550b = new Object();
    private ArrayList<ResolveClientBean> a;

    private static class b {
        private static final BindResolveClients a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (f4550b) {
            zContains = this.a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (f4550b) {
            ListIterator<ResolveClientBean> listIterator = this.a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f4550b) {
            if (!this.a.contains(resolveClientBean)) {
                this.a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f4550b) {
            if (this.a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f4550b) {
            this.a.clear();
        }
    }

    private BindResolveClients() {
        this.a = new ArrayList<>();
    }
}
