package anet.channel.strategy;

import anet.channel.strategy.C0842l;
import anet.channel.strategy.utils.C0848c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyList implements Serializable {

    /* renamed from: a */
    private List<IPConnStrategy> f1057a;

    /* renamed from: b */
    private Map<Integer, ConnHistoryItem> f1058b;

    /* renamed from: c */
    private boolean f1059c;

    /* renamed from: d */
    private transient Comparator<IPConnStrategy> f1060d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    interface Predicate<T> {
        boolean apply(T t);
    }

    public StrategyList() {
        this.f1057a = new ArrayList();
        this.f1058b = new SerialLruCache(40);
        this.f1059c = false;
        this.f1060d = null;
    }

    public void checkInit() {
        if (this.f1057a == null) {
            this.f1057a = new ArrayList();
        }
        if (this.f1058b == null) {
            this.f1058b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f1058b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().m630d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.f1057a) {
            if (!this.f1058b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.f1058b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f1057a, m650a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f1057a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.f1057a) {
            ConnHistoryItem connHistoryItem = this.f1058b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.m629c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.m716i("awcn.StrategyList", "strategy ban!", null, Constants.KEY_STRATEGY, iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(iConnStrategy instanceof IPConnStrategy) || this.f1057a.indexOf(iConnStrategy) == -1) {
            return;
        }
        this.f1058b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).m627a(connEvent.isSuccess);
        Collections.sort(this.f1057a, this.f1060d);
    }

    public boolean shouldRefresh() {
        boolean z = true;
        boolean z2 = true;
        for (IPConnStrategy iPConnStrategy : this.f1057a) {
            if (!this.f1058b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).m628b()) {
                if (iPConnStrategy.f1036a == 0) {
                    z = false;
                }
                z2 = false;
            }
        }
        return (this.f1059c && z) || z2;
    }

    public String toString() {
        return new ArrayList(this.f1057a).toString();
    }

    public void update(C0842l.b bVar) {
        Iterator<IPConnStrategy> it = this.f1057a.iterator();
        while (it.hasNext()) {
            it.next().f1038c = true;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.f1124h.length; i3++) {
            int i4 = 0;
            while (true) {
                String[] strArr = bVar.f1122f;
                if (i4 >= strArr.length) {
                    break;
                }
                m652a(strArr[i4], 1, bVar.f1124h[i3]);
                i4++;
            }
            if (bVar.f1123g != null) {
                this.f1059c = true;
                int i5 = 0;
                while (true) {
                    String[] strArr2 = bVar.f1123g;
                    if (i5 < strArr2.length) {
                        m652a(strArr2[i5], 0, bVar.f1124h[i3]);
                        i5++;
                    }
                }
            } else {
                this.f1059c = false;
            }
        }
        if (bVar.f1125i != null) {
            while (true) {
                C0842l.e[] eVarArr = bVar.f1125i;
                if (i2 >= eVarArr.length) {
                    break;
                }
                C0842l.e eVar = eVarArr[i2];
                String str = eVar.f1139a;
                m652a(str, C0848c.m709c(str) ? -1 : 1, eVar.f1140b);
                i2++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f1057a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f1038c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f1057a, m650a());
    }

    /* renamed from: a */
    private void m652a(String str, int i2, C0842l.a aVar) {
        int m649a = m649a(this.f1057a, new C0840j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (m649a != -1) {
            IPConnStrategy iPConnStrategy = this.f1057a.get(m649a);
            iPConnStrategy.cto = aVar.f1111c;
            iPConnStrategy.rto = aVar.f1112d;
            iPConnStrategy.heartbeat = aVar.f1114f;
            iPConnStrategy.f1036a = i2;
            iPConnStrategy.f1037b = 0;
            iPConnStrategy.f1038c = false;
            return;
        }
        IPConnStrategy m632a = IPConnStrategy.m632a(str, aVar);
        if (m632a != null) {
            m632a.f1036a = i2;
            m632a.f1037b = 0;
            if (!this.f1058b.containsKey(Integer.valueOf(m632a.getUniqueId()))) {
                this.f1058b.put(Integer.valueOf(m632a.getUniqueId()), new ConnHistoryItem());
            }
            this.f1057a.add(m632a);
        }
    }

    StrategyList(List<IPConnStrategy> list) {
        this.f1057a = new ArrayList();
        this.f1058b = new SerialLruCache(40);
        this.f1059c = false;
        this.f1060d = null;
        this.f1057a = list;
    }

    /* renamed from: a */
    private Comparator m650a() {
        if (this.f1060d == null) {
            this.f1060d = new C0841k(this);
        }
        return this.f1060d;
    }

    /* renamed from: a */
    private static <T> int m649a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i2 = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i2++;
        }
        if (i2 == collection.size()) {
            return -1;
        }
        return i2;
    }
}
