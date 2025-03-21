package p388ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import util.C7264c1;

/* loaded from: classes2.dex */
public class PageIndicatorView extends FrameLayout {

    /* renamed from: a */
    private Context f24948a;

    /* renamed from: b */
    private int f24949b;

    /* renamed from: c */
    private int f24950c;

    /* renamed from: d */
    private int f24951d;

    /* renamed from: e */
    private int f24952e;

    /* renamed from: f */
    private int f24953f;

    /* renamed from: g */
    private List<View> f24954g;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m26015a(Context context) {
        this.f24948a = context;
        this.f24949b = C7264c1.m26285a(context, this.f24949b);
        this.f24951d = C7264c1.m26285a(context, this.f24951d);
        this.f24950c = C7264c1.m26285a(context, this.f24950c);
    }

    public void setSelectedPage(int i2) {
        if (this.f24953f == 1) {
            setBackgroundResource(C2113R.drawable.white_radius);
        } else {
            this.f24954g.get(0).setTranslationX(((this.f24949b - this.f24951d) / (r0 - 1)) * i2);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24948a = null;
        this.f24949b = 25;
        this.f24950c = 4;
        this.f24951d = 12;
        this.f24952e = 4;
        this.f24954g = null;
        m26015a(context);
    }

    /* renamed from: a */
    public void m26016a(int i2) {
        this.f24953f = i2;
        List<View> list = this.f24954g;
        if (list == null) {
            this.f24954g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f24951d, this.f24950c);
        View view = new View(this.f24948a);
        view.setBackgroundResource(C2113R.drawable.white_radius);
        addView(view, layoutParams);
        this.f24954g.add(view);
    }
}
