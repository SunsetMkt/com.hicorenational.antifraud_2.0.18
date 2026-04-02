package ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import util.g1;

/* JADX INFO: loaded from: classes2.dex */
public class PageIndicatorView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<View> f14774g;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.a = context;
        this.f14769b = g1.a(context, this.f14769b);
        this.f14771d = g1.a(context, this.f14771d);
        this.f14770c = g1.a(context, this.f14770c);
    }

    public void setSelectedPage(int i2) {
        if (this.f14773f == 1) {
            setBackgroundResource(R.drawable.white_radius);
        } else {
            this.f14774g.get(0).setTranslationX(((this.f14769b - this.f14771d) / (r0 - 1)) * i2);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.f14769b = 25;
        this.f14770c = 4;
        this.f14771d = 12;
        this.f14772e = 4;
        this.f14774g = null;
        a(context);
    }

    public void a(int i2) {
        this.f14773f = i2;
        List<View> list = this.f14774g;
        if (list == null) {
            this.f14774g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f14771d, this.f14770c);
        View view = new View(this.a);
        view.setBackgroundResource(R.drawable.white_radius);
        addView(view, layoutParams);
        this.f14774g.add(view);
    }
}
