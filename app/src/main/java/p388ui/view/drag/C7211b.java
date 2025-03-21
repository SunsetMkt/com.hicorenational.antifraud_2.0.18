package p388ui.view.drag;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* compiled from: Children.java */
/* renamed from: ui.view.drag.b */
/* loaded from: classes2.dex */
public class C7211b {

    /* renamed from: a */
    private LinkedHashMap<View, C7210a> f24842a = new LinkedHashMap<>();

    /* renamed from: b */
    private LinkedList<C7210a> f24843b = new LinkedList<>();

    /* renamed from: c */
    private HandyGridView f24844c;

    public C7211b(HandyGridView handyGridView) {
        this.f24844c = handyGridView;
    }

    /* renamed from: a */
    public void m25938a(int i2, View view) {
        C7210a c7210a = this.f24842a.get(view);
        if (c7210a == null) {
            c7210a = new C7210a(view);
            c7210a.m25933a(this.f24844c);
            this.f24842a.put(view, c7210a);
        }
        this.f24843b.add(i2, c7210a);
    }

    /* renamed from: b */
    public void m25941b(int i2) {
        this.f24843b.remove(i2);
    }

    /* renamed from: b */
    public int m25940b() {
        return this.f24843b.size();
    }

    /* renamed from: a */
    public boolean m25939a(C7210a c7210a) {
        return this.f24843b.remove(c7210a);
    }

    /* renamed from: a */
    public C7210a m25936a(int i2) {
        return this.f24843b.get(i2);
    }

    /* renamed from: a */
    public int m25935a(View view) {
        C7210a c7210a = this.f24842a.get(view);
        if (c7210a == null) {
            return -2;
        }
        return this.f24843b.indexOf(c7210a);
    }

    /* renamed from: a */
    public void m25937a() {
        this.f24842a.clear();
        Iterator<C7210a> it = this.f24843b.iterator();
        while (it.hasNext()) {
            it.next().m25934b();
            it.remove();
        }
    }
}
