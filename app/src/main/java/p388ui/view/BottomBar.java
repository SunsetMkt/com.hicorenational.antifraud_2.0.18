package p388ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bean.module.BottomLocalBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomBar extends LinearLayout {

    /* renamed from: a */
    private List<BottomBarTab> f24454a;

    /* renamed from: b */
    private LinearLayout f24455b;

    /* renamed from: c */
    private LinearLayout.LayoutParams f24456c;

    /* renamed from: d */
    private int f24457d;

    /* renamed from: e */
    private InterfaceC7164a f24458e;

    /* renamed from: f */
    private int f24459f;

    /* renamed from: g */
    private BottomBarTab f24460g;

    /* renamed from: ui.view.BottomBar$a */
    public interface InterfaceC7164a {
        /* renamed from: a */
        void mo25435a(BottomLocalBean bottomLocalBean, int i2, int i3);
    }

    public BottomBar(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m25729a(Context context) {
        setOrientation(1);
        this.f24455b = new LinearLayout(context);
        this.f24455b.setBackgroundColor(-1);
        this.f24455b.setOrientation(0);
        addView(this.f24455b, new LinearLayout.LayoutParams(-1, -1));
        this.f24456c = new LinearLayout.LayoutParams(0, -1);
        this.f24456c.weight = 1.0f;
    }

    /* renamed from: b */
    public /* synthetic */ void m25736b(int i2) {
        for (int i3 = 0; i3 < this.f24459f; i3++) {
            this.f24455b.getChildAt(i3).setSelected(false);
        }
        this.f24457d = i2;
        this.f24455b.getChildAt(i2).setSelected(true);
    }

    public int getCurrentItemPosition() {
        return this.f24457d;
    }

    public void setCurrentItem(final int i2) {
        this.f24455b.post(new Runnable() { // from class: ui.view.b
            @Override // java.lang.Runnable
            public final void run() {
                BottomBar.this.m25736b(i2);
            }
        });
    }

    public void setCurrentPosition(int i2) {
        this.f24457d = i2;
    }

    public void setOnTabSelectedListener(InterfaceC7164a interfaceC7164a) {
        this.f24458e = interfaceC7164a;
    }

    public BottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24454a = new ArrayList();
        this.f24457d = 0;
        m25729a(context);
    }

    /* renamed from: a */
    public void m25731a() {
        this.f24459f = 3;
        this.f24454a.clear();
        this.f24455b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f24459f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2);
            m25733a(bottomBarTab, (BottomLocalBean) null);
            m25728a(i2, bottomBarTab);
        }
    }

    /* renamed from: a */
    public void m25732a(BottomLocalBean bottomLocalBean) {
        this.f24459f = 4;
        this.f24454a.clear();
        this.f24455b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f24459f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2, bottomLocalBean);
            m25733a(bottomBarTab, bottomLocalBean);
            m25728a(i2, bottomBarTab);
        }
    }

    /* renamed from: a */
    private void m25728a(int i2, BottomBarTab bottomBarTab) {
        if (i2 == this.f24459f - 1) {
            this.f24460g = bottomBarTab;
        }
    }

    /* renamed from: a */
    public void m25735a(boolean z) {
        BottomBarTab bottomBarTab = this.f24460g;
        if (bottomBarTab != null) {
            bottomBarTab.m25740a(z);
        }
    }

    /* renamed from: a */
    public void m25733a(final BottomBarTab bottomBarTab, final BottomLocalBean bottomLocalBean) {
        bottomBarTab.setOnClickListener(new View.OnClickListener() { // from class: ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomBar.this.m25734a(bottomBarTab, bottomLocalBean, view);
            }
        });
        bottomBarTab.m25739a(this.f24455b.getChildCount(), this.f24457d);
        bottomBarTab.setLayoutParams(this.f24456c);
        this.f24455b.addView(bottomBarTab);
        this.f24454a.add(bottomBarTab);
    }

    /* renamed from: a */
    public /* synthetic */ void m25734a(BottomBarTab bottomBarTab, BottomLocalBean bottomLocalBean, View view) {
        int tabPosition;
        int i2;
        if (this.f24458e == null || (i2 = this.f24457d) == (tabPosition = bottomBarTab.getTabPosition())) {
            return;
        }
        if (bottomLocalBean != null) {
            this.f24458e.mo25435a(bottomLocalBean, tabPosition, i2);
        } else {
            this.f24458e.mo25435a(null, tabPosition, this.f24459f);
        }
        bottomBarTab.setSelected(true);
        this.f24454a.get(this.f24457d).setSelected(false);
        this.f24457d = tabPosition;
    }

    /* renamed from: a */
    public BottomBarTab m25730a(int i2) {
        if (this.f24454a.size() < i2) {
            return null;
        }
        return this.f24454a.get(i2);
    }
}
