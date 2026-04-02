package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bean.module.BottomLocalBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomBar extends LinearLayout {
    private List<BottomBarTab> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f14490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout.LayoutParams f14491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f14493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BottomBarTab f14495g;

    public interface a {
        void a(BottomLocalBean bottomLocalBean, int i2, int i3);
    }

    public BottomBar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(1);
        this.f14490b = new LinearLayout(context);
        this.f14490b.setBackgroundColor(-1);
        this.f14490b.setOrientation(0);
        addView(this.f14490b, new LinearLayout.LayoutParams(-1, -1));
        this.f14491c = new LinearLayout.LayoutParams(0, -1);
        this.f14491c.weight = 1.0f;
    }

    public /* synthetic */ void b(int i2) {
        for (int i3 = 0; i3 < this.f14494f; i3++) {
            this.f14490b.getChildAt(i3).setSelected(false);
        }
        this.f14492d = i2;
        this.f14490b.getChildAt(i2).setSelected(true);
    }

    public int getCurrentItemPosition() {
        return this.f14492d;
    }

    public void setCurrentItem(final int i2) {
        this.f14490b.post(new Runnable() { // from class: ui.view.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(i2);
            }
        });
    }

    public void setCurrentPosition(int i2) {
        this.f14492d = i2;
    }

    public void setOnTabSelectedListener(a aVar) {
        this.f14493e = aVar;
    }

    public BottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList();
        this.f14492d = 0;
        a(context);
    }

    public void a() {
        this.f14494f = 3;
        this.a.clear();
        this.f14490b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f14494f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2);
            a(bottomBarTab, (BottomLocalBean) null);
            a(i2, bottomBarTab);
        }
    }

    public void a(BottomLocalBean bottomLocalBean) {
        this.f14494f = 4;
        this.a.clear();
        this.f14490b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f14494f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2, bottomLocalBean);
            a(bottomBarTab, bottomLocalBean);
            a(i2, bottomBarTab);
        }
    }

    private void a(int i2, BottomBarTab bottomBarTab) {
        if (i2 == this.f14494f - 1) {
            this.f14495g = bottomBarTab;
        }
    }

    public void a(boolean z) {
        BottomBarTab bottomBarTab = this.f14495g;
        if (bottomBarTab != null) {
            bottomBarTab.a(z);
        }
    }

    public void a(final BottomBarTab bottomBarTab, final BottomLocalBean bottomLocalBean) {
        bottomBarTab.setOnClickListener(new View.OnClickListener() { // from class: ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(bottomBarTab, bottomLocalBean, view);
            }
        });
        bottomBarTab.a(this.f14490b.getChildCount(), this.f14492d);
        bottomBarTab.setLayoutParams(this.f14491c);
        this.f14490b.addView(bottomBarTab);
        this.a.add(bottomBarTab);
    }

    public /* synthetic */ void a(BottomBarTab bottomBarTab, BottomLocalBean bottomLocalBean, View view) {
        int tabPosition;
        int i2;
        if (this.f14493e == null || (i2 = this.f14492d) == (tabPosition = bottomBarTab.getTabPosition())) {
            return;
        }
        if (bottomLocalBean != null) {
            this.f14493e.a(bottomLocalBean, tabPosition, i2);
        } else {
            this.f14493e.a(null, tabPosition, this.f14494f);
        }
        bottomBarTab.setSelected(true);
        this.a.get(this.f14492d).setSelected(false);
        this.f14492d = tabPosition;
    }

    public BottomBarTab a(int i2) {
        if (this.a.size() < i2) {
            return null;
        }
        return this.a.get(i2);
    }
}
