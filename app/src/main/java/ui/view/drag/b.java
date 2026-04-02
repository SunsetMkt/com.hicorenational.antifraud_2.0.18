package ui.view.drag;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* JADX INFO: compiled from: Children.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private LinkedHashMap<View, a> a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: b */
    private LinkedList<a> f14706b = new LinkedList<>();

    /* JADX INFO: renamed from: c */
    private HandyGridView f14707c;

    public b(HandyGridView handyGridView) {
        this.f14707c = handyGridView;
    }

    public void a(int i2, View view) {
        a aVar = this.a.get(view);
        if (aVar == null) {
            aVar = new a(view);
            aVar.a(this.f14707c);
            this.a.put(view, aVar);
        }
        this.f14706b.add(i2, aVar);
    }

    public void b(int i2) {
        this.f14706b.remove(i2);
    }

    public int b() {
        return this.f14706b.size();
    }

    public boolean a(a aVar) {
        return this.f14706b.remove(aVar);
    }

    public a a(int i2) {
        return this.f14706b.get(i2);
    }

    public int a(View view) {
        a aVar = this.a.get(view);
        if (aVar == null) {
            return -2;
        }
        return this.f14706b.indexOf(aVar);
    }

    public void a() {
        this.a.clear();
        Iterator<a> it = this.f14706b.iterator();
        while (it.hasNext()) {
            it.next().b();
            it.remove();
        }
    }
}
