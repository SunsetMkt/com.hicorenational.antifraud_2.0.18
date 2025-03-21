package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zhy.view.flowlayout.AbstractC4439b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class TagFlowLayout extends FlowLayout implements AbstractC4439b.a {

    /* renamed from: o */
    private static final String f16857o = "TagFlowLayout";

    /* renamed from: p */
    private static final String f16858p = "key_choose_pos";

    /* renamed from: q */
    private static final String f16859q = "key_default";

    /* renamed from: j */
    private AbstractC4439b f16860j;

    /* renamed from: k */
    private int f16861k;

    /* renamed from: l */
    private Set<Integer> f16862l;

    /* renamed from: m */
    private InterfaceC4436b f16863m;

    /* renamed from: n */
    private InterfaceC4437c f16864n;

    /* renamed from: com.zhy.view.flowlayout.TagFlowLayout$a */
    class ViewOnClickListenerC4435a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagView f16865a;

        /* renamed from: b */
        final /* synthetic */ int f16866b;

        ViewOnClickListenerC4435a(TagView tagView, int i2) {
            this.f16865a = tagView;
            this.f16866b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TagFlowLayout.this.m16376a(this.f16865a, this.f16866b);
            if (TagFlowLayout.this.f16864n != null) {
                TagFlowLayout.this.f16864n.mo16381a(this.f16865a, this.f16866b, TagFlowLayout.this);
            }
        }
    }

    /* renamed from: com.zhy.view.flowlayout.TagFlowLayout$b */
    public interface InterfaceC4436b {
        /* renamed from: a */
        void m16380a(Set<Integer> set);
    }

    /* renamed from: com.zhy.view.flowlayout.TagFlowLayout$c */
    public interface InterfaceC4437c {
        /* renamed from: a */
        boolean mo16381a(View view, int i2, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16861k = -1;
        this.f16862l = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4434R.styleable.TagFlowLayout);
        this.f16861k = obtainStyledAttributes.getInt(C4434R.styleable.TagFlowLayout_max_select, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m16377b() {
        removeAllViews();
        AbstractC4439b abstractC4439b = this.f16860j;
        HashSet<Integer> m16389b = abstractC4439b.m16389b();
        for (int i2 = 0; i2 < abstractC4439b.m16382a(); i2++) {
            View mo16383a = abstractC4439b.mo16383a(this, i2, abstractC4439b.m16384a(i2));
            TagView tagView = new TagView(getContext());
            mo16383a.setDuplicateParentStateEnabled(true);
            if (mo16383a.getLayoutParams() != null) {
                tagView.setLayoutParams(mo16383a.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(m16372a(getContext(), 5.0f), m16372a(getContext(), 5.0f), m16372a(getContext(), 5.0f), m16372a(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            mo16383a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            tagView.addView(mo16383a);
            addView(tagView);
            if (m16389b.contains(Integer.valueOf(i2))) {
                m16374a(i2, tagView);
            }
            if (this.f16860j.m16388a(i2, (int) abstractC4439b.m16384a(i2))) {
                m16374a(i2, tagView);
            }
            mo16383a.setClickable(false);
            tagView.setOnClickListener(new ViewOnClickListenerC4435a(tagView, i2));
        }
        this.f16862l.addAll(m16389b);
    }

    public AbstractC4439b getAdapter() {
        return this.f16860j;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f16862l);
    }

    @Override // com.zhy.view.flowlayout.FlowLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            TagView tagView = (TagView) getChildAt(i4);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        String string = bundle.getString(f16858p);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("\\|")) {
                int parseInt = Integer.parseInt(str);
                this.f16862l.add(Integer.valueOf(parseInt));
                TagView tagView = (TagView) getChildAt(parseInt);
                if (tagView != null) {
                    m16374a(parseInt, tagView);
                }
            }
        }
        super.onRestoreInstanceState(bundle.getParcelable(f16859q));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f16859q, super.onSaveInstanceState());
        String str = "";
        if (this.f16862l.size() > 0) {
            Iterator<Integer> it = this.f16862l.iterator();
            while (it.hasNext()) {
                str = str + it.next().intValue() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString(f16858p, str);
        return bundle;
    }

    public void setAdapter(AbstractC4439b abstractC4439b) {
        this.f16860j = abstractC4439b;
        this.f16860j.setOnDataChangedListener(this);
        this.f16862l.clear();
        m16377b();
    }

    public void setMaxSelectCount(int i2) {
        if (this.f16862l.size() > i2) {
            String str = "you has already select more than " + i2 + " views , so it will be clear .";
            this.f16862l.clear();
        }
        this.f16861k = i2;
    }

    public void setOnSelectListener(InterfaceC4436b interfaceC4436b) {
        this.f16863m = interfaceC4436b;
    }

    public void setOnTagClickListener(InterfaceC4437c interfaceC4437c) {
        this.f16864n = interfaceC4437c;
    }

    /* renamed from: a */
    private void m16374a(int i2, TagView tagView) {
        tagView.setChecked(true);
        this.f16860j.m16385a(i2, tagView.getTagView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16376a(TagView tagView, int i2) {
        if (!tagView.isChecked()) {
            if (this.f16861k == 1 && this.f16862l.size() == 1) {
                Integer next = this.f16862l.iterator().next();
                m16378b(next.intValue(), (TagView) getChildAt(next.intValue()));
                m16374a(i2, tagView);
                this.f16862l.remove(next);
                this.f16862l.add(Integer.valueOf(i2));
            } else {
                if (this.f16861k > 0 && this.f16862l.size() >= this.f16861k) {
                    return;
                }
                m16374a(i2, tagView);
                this.f16862l.add(Integer.valueOf(i2));
            }
        } else {
            m16378b(i2, tagView);
            this.f16862l.remove(Integer.valueOf(i2));
        }
        InterfaceC4436b interfaceC4436b = this.f16863m;
        if (interfaceC4436b != null) {
            interfaceC4436b.m16380a(new HashSet(this.f16862l));
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    @Override // com.zhy.view.flowlayout.AbstractC4439b.a
    /* renamed from: a */
    public void mo16379a() {
        this.f16862l.clear();
        m16377b();
    }

    /* renamed from: a */
    public static int m16372a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    private void m16378b(int i2, TagView tagView) {
        tagView.setChecked(false);
        this.f16860j.m16390b(i2, tagView.getTagView());
    }
}
