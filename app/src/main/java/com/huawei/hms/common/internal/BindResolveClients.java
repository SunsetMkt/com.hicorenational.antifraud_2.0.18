package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class BindResolveClients {

    /* renamed from: b */
    private static final Object f7263b = new Object();

    /* renamed from: a */
    private ArrayList<ResolveClientBean> f7264a;

    /* renamed from: com.huawei.hms.common.internal.BindResolveClients$b */
    private static class C2335b {

        /* renamed from: a */
        private static final BindResolveClients f7265a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return C2335b.f7265a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (f7263b) {
            contains = this.f7264a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (f7263b) {
            ListIterator<ResolveClientBean> listIterator = this.f7264a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f7264a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f7263b) {
            if (!this.f7264a.contains(resolveClientBean)) {
                this.f7264a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f7263b) {
            if (this.f7264a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f7264a.listIterator();
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
        synchronized (f7263b) {
            this.f7264a.clear();
        }
    }

    private BindResolveClients() {
        this.f7264a = new ArrayList<>();
    }
}
