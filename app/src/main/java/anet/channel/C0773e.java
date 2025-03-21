package anet.channel;

import anet.channel.entity.C0783c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* renamed from: anet.channel.e */
/* loaded from: classes.dex */
class C0773e {

    /* renamed from: a */
    private final Map<SessionRequest, List<Session>> f813a = new HashMap();

    /* renamed from: b */
    private final ReentrantReadWriteLock f814b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private final ReentrantReadWriteLock.ReadLock f815c = this.f814b.readLock();

    /* renamed from: d */
    private final ReentrantReadWriteLock.WriteLock f816d = this.f814b.writeLock();

    C0773e() {
    }

    /* renamed from: a */
    public void m487a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.m429a() == null || session == null) {
            return;
        }
        this.f816d.lock();
        try {
            List<Session> list = this.f813a.get(sessionRequest);
            if (list == null) {
                list = new ArrayList<>();
                this.f813a.put(sessionRequest, list);
            }
            if (list.indexOf(session) != -1) {
                return;
            }
            list.add(session);
            Collections.sort(list);
        } finally {
            this.f816d.unlock();
        }
    }

    /* renamed from: b */
    public void m488b(SessionRequest sessionRequest, Session session) {
        this.f816d.lock();
        try {
            List<Session> list = this.f813a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.f813a.remove(sessionRequest);
            }
        } finally {
            this.f816d.unlock();
        }
    }

    /* renamed from: c */
    public boolean m489c(SessionRequest sessionRequest, Session session) {
        this.f815c.lock();
        try {
            List<Session> list = this.f813a.get(sessionRequest);
            boolean z = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.f815c.unlock();
        }
    }

    /* renamed from: a */
    public List<Session> m486a(SessionRequest sessionRequest) {
        this.f815c.lock();
        try {
            List<Session> list = this.f813a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f815c.unlock();
        }
    }

    /* renamed from: a */
    public Session m484a(SessionRequest sessionRequest, int i2) {
        this.f815c.lock();
        try {
            List<Session> list = this.f813a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i2 == C0783c.f845c || session2.f692j.getType() == i2)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f815c.unlock();
        }
    }

    /* renamed from: a */
    public List<SessionRequest> m485a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f815c.lock();
        try {
            return this.f813a.isEmpty() ? list : new ArrayList(this.f813a.keySet());
        } finally {
            this.f815c.unlock();
        }
    }
}
