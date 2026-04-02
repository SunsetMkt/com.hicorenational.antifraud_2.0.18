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
import com.zhy.view.flowlayout.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class TagFlowLayout extends FlowLayout implements b.a {
    private static final String o = "TagFlowLayout";
    private static final String p = "key_choose_pos";
    private static final String q = "key_default";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.zhy.view.flowlayout.b f9431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Set<Integer> f9433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f9434m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f9435n;

    class a implements View.OnClickListener {
        final /* synthetic */ TagView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9436b;

        a(TagView tagView, int i2) {
            this.a = tagView;
            this.f9436b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TagFlowLayout.this.a(this.a, this.f9436b);
            if (TagFlowLayout.this.f9435n != null) {
                TagFlowLayout.this.f9435n.a(this.a, this.f9436b, TagFlowLayout.this);
            }
        }
    }

    public interface b {
        void a(Set<Integer> set);
    }

    public interface c {
        boolean a(View view, int i2, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9432k = -1;
        this.f9433l = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f9432k = typedArrayObtainStyledAttributes.getInt(R.styleable.TagFlowLayout_max_select, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b() {
        removeAllViews();
        com.zhy.view.flowlayout.b bVar = this.f9431j;
        HashSet<Integer> hashSetB = bVar.b();
        for (int i2 = 0; i2 < bVar.a(); i2++) {
            View viewA = bVar.a(this, i2, bVar.a(i2));
            TagView tagView = new TagView(getContext());
            viewA.setDuplicateParentStateEnabled(true);
            if (viewA.getLayoutParams() != null) {
                tagView.setLayoutParams(viewA.getLayoutParams());
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(a(getContext(), 5.0f), a(getContext(), 5.0f), a(getContext(), 5.0f), a(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            viewA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            tagView.addView(viewA);
            addView(tagView);
            if (hashSetB.contains(Integer.valueOf(i2))) {
                a(i2, tagView);
            }
            if (this.f9431j.a(i2, bVar.a(i2))) {
                a(i2, tagView);
            }
            viewA.setClickable(false);
            tagView.setOnClickListener(new a(tagView, i2));
        }
        this.f9433l.addAll(hashSetB);
    }

    public com.zhy.view.flowlayout.b getAdapter() {
        return this.f9431j;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f9433l);
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
        String string = bundle.getString(p);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("\\|")) {
                int i2 = Integer.parseInt(str);
                this.f9433l.add(Integer.valueOf(i2));
                TagView tagView = (TagView) getChildAt(i2);
                if (tagView != null) {
                    a(i2, tagView);
                }
            }
        }
        super.onRestoreInstanceState(bundle.getParcelable(q));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(q, super.onSaveInstanceState());
        String strSubstring = "";
        if (this.f9433l.size() > 0) {
            Iterator<Integer> it = this.f9433l.iterator();
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next().intValue() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        bundle.putString(p, strSubstring);
        return bundle;
    }

    public void setAdapter(com.zhy.view.flowlayout.b bVar) {
        this.f9431j = bVar;
        this.f9431j.setOnDataChangedListener(this);
        this.f9433l.clear();
        b();
    }

    public void setMaxSelectCount(int i2) {
        if (this.f9433l.size() > i2) {
            String str = "you has already select more than " + i2 + " views , so it will be clear .";
            this.f9433l.clear();
        }
        this.f9432k = i2;
    }

    public void setOnSelectListener(b bVar) {
        this.f9434m = bVar;
    }

    public void setOnTagClickListener(c cVar) {
        this.f9435n = cVar;
    }

    private void a(int i2, TagView tagView) {
        tagView.setChecked(true);
        this.f9431j.a(i2, tagView.getTagView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TagView tagView, int i2) {
        if (!tagView.isChecked()) {
            if (this.f9432k == 1 && this.f9433l.size() == 1) {
                Integer next = this.f9433l.iterator().next();
                b(next.intValue(), (TagView) getChildAt(next.intValue()));
                a(i2, tagView);
                this.f9433l.remove(next);
                this.f9433l.add(Integer.valueOf(i2));
            } else {
                if (this.f9432k > 0 && this.f9433l.size() >= this.f9432k) {
                    return;
                }
                a(i2, tagView);
                this.f9433l.add(Integer.valueOf(i2));
            }
        } else {
            b(i2, tagView);
            this.f9433l.remove(Integer.valueOf(i2));
        }
        b bVar = this.f9434m;
        if (bVar != null) {
            bVar.a(new HashSet(this.f9433l));
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    @Override // com.zhy.view.flowlayout.b.a
    public void a() {
        this.f9433l.clear();
        b();
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b(int i2, TagView tagView) {
        tagView.setChecked(false);
        this.f9431j.b(i2, tagView.getTagView());
    }
}
