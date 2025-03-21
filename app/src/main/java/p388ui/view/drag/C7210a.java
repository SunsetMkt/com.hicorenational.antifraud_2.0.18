package p388ui.view.drag;

import android.content.Context;
import android.view.View;
import p388ui.view.drag.p393e.InterfaceC7215a;
import p388ui.view.drag.p393e.RunnableC7217c;

/* compiled from: Child.java */
/* renamed from: ui.view.drag.a */
/* loaded from: classes2.dex */
public class C7210a implements InterfaceC7215a {

    /* renamed from: a */
    public int f24835a;

    /* renamed from: b */
    public View f24836b;

    /* renamed from: d */
    private int f24838d;

    /* renamed from: e */
    private int f24839e;

    /* renamed from: g */
    private HandyGridView f24841g;

    /* renamed from: f */
    private boolean f24840f = false;

    /* renamed from: c */
    private RunnableC7217c f24837c = new RunnableC7217c(this);

    public C7210a(View view) {
        this.f24836b = view;
    }

    /* renamed from: a */
    public void m25933a(HandyGridView handyGridView) {
        this.f24841g = handyGridView;
    }

    /* renamed from: b */
    public void m25934b() {
        this.f24837c.m25954b();
        this.f24840f = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof C7210a) && this.f24836b == ((C7210a) obj).f24836b) {
            return true;
        }
        return super.equals(obj);
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    public Context getContext() {
        return this.f24836b.getContext();
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    public boolean post(Runnable runnable) {
        return this.f24836b.post(runnable);
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    public boolean removeCallbacks(Runnable runnable) {
        return this.f24836b.removeCallbacks(runnable);
    }

    /* renamed from: a */
    public void m25932a(int i2, int i3) {
        this.f24838d = i2;
        this.f24839e = i3;
        int[] m25922a = this.f24841g.m25922a(i2);
        int[] m25922a2 = this.f24841g.m25922a(i3);
        if (this.f24837c.m25957e()) {
            this.f24840f = true;
        } else {
            m25931b(m25922a2[0] - m25922a[0], m25922a2[1] - m25922a[1]);
        }
    }

    /* renamed from: b */
    private void m25931b(int i2, int i3) {
        this.f24837c.m25949a(i2, i3);
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    /* renamed from: a */
    public void mo25919a() {
        int[] iArr = {this.f24836b.getLeft(), this.f24836b.getTop()};
        this.f24838d = this.f24841g.pointToPosition(iArr[0], iArr[1]);
        int[] m25922a = this.f24841g.m25922a(this.f24839e);
        if (this.f24840f) {
            if (this.f24838d != this.f24839e) {
                m25931b(m25922a[0] - iArr[0], m25922a[1] - iArr[1]);
            }
            this.f24840f = false;
        }
    }

    @Override // p388ui.view.drag.p393e.InterfaceC7215a
    /* renamed from: a */
    public void mo25920a(int i2, int i3, int i4, int i5) {
        this.f24836b.offsetLeftAndRight(i4 - i2);
        this.f24836b.offsetTopAndBottom(i5 - i3);
    }
}
