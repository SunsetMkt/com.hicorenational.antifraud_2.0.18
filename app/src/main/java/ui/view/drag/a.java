package ui.view.drag;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: Child.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements ui.view.drag.e.a {
    public int a;

    /* JADX INFO: renamed from: b */
    public View f14700b;

    /* JADX INFO: renamed from: d */
    private int f14702d;

    /* JADX INFO: renamed from: e */
    private int f14703e;

    /* JADX INFO: renamed from: g */
    private HandyGridView f14705g;

    /* JADX INFO: renamed from: f */
    private boolean f14704f = false;

    /* JADX INFO: renamed from: c */
    private ui.view.drag.e.c f14701c = new ui.view.drag.e.c(this);

    public a(View view) {
        this.f14700b = view;
    }

    public void a(HandyGridView handyGridView) {
        this.f14705g = handyGridView;
    }

    public void b() {
        this.f14701c.b();
        this.f14704f = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && this.f14700b == ((a) obj).f14700b) {
            return true;
        }
        return super.equals(obj);
    }

    @Override // ui.view.drag.e.a
    public Context getContext() {
        return this.f14700b.getContext();
    }

    @Override // ui.view.drag.e.a
    public boolean post(Runnable runnable) {
        return this.f14700b.post(runnable);
    }

    @Override // ui.view.drag.e.a
    public boolean removeCallbacks(Runnable runnable) {
        return this.f14700b.removeCallbacks(runnable);
    }

    public void a(int i2, int i3) {
        this.f14702d = i2;
        this.f14703e = i3;
        int[] iArrA = this.f14705g.a(i2);
        int[] iArrA2 = this.f14705g.a(i3);
        if (this.f14701c.e()) {
            this.f14704f = true;
        } else {
            b(iArrA2[0] - iArrA[0], iArrA2[1] - iArrA[1]);
        }
    }

    private void b(int i2, int i3) {
        this.f14701c.a(i2, i3);
    }

    @Override // ui.view.drag.e.a
    public void a() {
        int[] iArr = {this.f14700b.getLeft(), this.f14700b.getTop()};
        this.f14702d = this.f14705g.pointToPosition(iArr[0], iArr[1]);
        int[] iArrA = this.f14705g.a(this.f14703e);
        if (this.f14704f) {
            if (this.f14702d != this.f14703e) {
                b(iArrA[0] - iArr[0], iArrA[1] - iArr[1]);
            }
            this.f14704f = false;
        }
    }

    @Override // ui.view.drag.e.a
    public void a(int i2, int i3, int i4, int i5) {
        this.f14700b.offsetLeftAndRight(i4 - i2);
        this.f14700b.offsetTopAndBottom(i5 - i3);
    }
}
