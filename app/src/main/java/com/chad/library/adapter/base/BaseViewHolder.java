package com.chad.library.adapter.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final SparseArray<View> f5597a;

    /* renamed from: b */
    private final HashSet<Integer> f5598b;

    /* renamed from: c */
    private final LinkedHashSet<Integer> f5599c;

    /* renamed from: d */
    private final LinkedHashSet<Integer> f5600d;

    /* renamed from: e */
    private BaseQuickAdapter f5601e;

    /* renamed from: f */
    @Deprecated
    public View f5602f;

    /* renamed from: g */
    Object f5603g;

    /* renamed from: com.chad.library.adapter.base.BaseViewHolder$a */
    class ViewOnClickListenerC1902a implements View.OnClickListener {
        ViewOnClickListenerC1902a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseViewHolder.this.f5601e.m5173o() != null) {
                BaseViewHolder.this.f5601e.m5173o().onItemChildClick(BaseViewHolder.this.f5601e, view, BaseViewHolder.this.m5193f());
            }
        }
    }

    /* renamed from: com.chad.library.adapter.base.BaseViewHolder$b */
    class ViewOnLongClickListenerC1903b implements View.OnLongClickListener {
        ViewOnLongClickListenerC1903b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return BaseViewHolder.this.f5601e.m5174p() != null && BaseViewHolder.this.f5601e.m5174p().m5185a(BaseViewHolder.this.f5601e, view, BaseViewHolder.this.m5193f());
        }
    }

    public BaseViewHolder(View view) {
        super(view);
        this.f5597a = new SparseArray<>();
        this.f5599c = new LinkedHashSet<>();
        this.f5600d = new LinkedHashSet<>();
        this.f5598b = new HashSet<>();
        this.f5602f = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public int m5193f() {
        if (getLayoutPosition() >= this.f5601e.m5164j()) {
            return getLayoutPosition() - this.f5601e.m5164j();
        }
        return 0;
    }

    @Deprecated
    /* renamed from: c */
    public View m5223c() {
        return this.f5602f;
    }

    /* renamed from: d */
    public HashSet<Integer> m5229d() {
        return this.f5600d;
    }

    /* renamed from: e */
    public Set<Integer> m5232e() {
        return this.f5598b;
    }

    /* renamed from: g */
    public BaseViewHolder m5234g(@IdRes int i2, @ColorInt int i3) {
        ((TextView) m5224c(i2)).setTextColor(i3);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5211a(@IdRes int i2, CharSequence charSequence) {
        ((TextView) m5224c(i2)).setText(charSequence);
        return this;
    }

    /* renamed from: b */
    public HashSet<Integer> m5222b() {
        return this.f5599c;
    }

    /* renamed from: c */
    public BaseViewHolder m5225c(@IdRes int i2, @DrawableRes int i3) {
        ((ImageView) m5224c(i2)).setImageResource(i3);
        return this;
    }

    /* renamed from: d */
    public BaseViewHolder m5227d(@IdRes int i2) {
        Linkify.addLinks((TextView) m5224c(i2), 15);
        return this;
    }

    /* renamed from: e */
    public BaseViewHolder m5231e(@IdRes int i2, int i3) {
        ((ProgressBar) m5224c(i2)).setProgress(i3);
        return this;
    }

    /* renamed from: b */
    public BaseViewHolder m5220b(@IdRes int i2, @DrawableRes int i3) {
        m5224c(i2).setBackgroundResource(i3);
        return this;
    }

    /* renamed from: f */
    public BaseViewHolder m5233f(@IdRes int i2, @StringRes int i3) {
        ((TextView) m5224c(i2)).setText(i3);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5197a(@IdRes int i2, @ColorInt int i3) {
        m5224c(i2).setBackgroundColor(i3);
        return this;
    }

    /* renamed from: c */
    public BaseViewHolder m5226c(@IdRes int i2, boolean z) {
        m5224c(i2).setVisibility(z ? 0 : 4);
        return this;
    }

    /* renamed from: d */
    public BaseViewHolder m5228d(@IdRes int i2, int i3) {
        ((ProgressBar) m5224c(i2)).setMax(i3);
        return this;
    }

    /* renamed from: e */
    public BaseViewHolder m5230e(@IdRes int i2) {
        m5194a(i2);
        m5218b(i2);
        this.f5598b.add(Integer.valueOf(i2));
        return this;
    }

    /* renamed from: b */
    public BaseViewHolder m5221b(@IdRes int i2, boolean z) {
        m5224c(i2).setVisibility(z ? 0 : 8);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5202a(@IdRes int i2, Drawable drawable) {
        ((ImageView) m5224c(i2)).setImageDrawable(drawable);
        return this;
    }

    /* renamed from: c */
    public <T extends View> T m5224c(@IdRes int i2) {
        T t = (T) this.f5597a.get(i2);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i2);
        this.f5597a.put(i2, t2);
        return t2;
    }

    /* renamed from: b */
    public BaseViewHolder m5219b(@IdRes int i2, float f2) {
        ((RatingBar) m5224c(i2)).setRating(f2);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5200a(@IdRes int i2, Bitmap bitmap) {
        ((ImageView) m5224c(i2)).setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: b */
    public BaseViewHolder m5218b(@IdRes int i2) {
        this.f5600d.add(Integer.valueOf(i2));
        View m5224c = m5224c(i2);
        if (m5224c != null) {
            if (!m5224c.isLongClickable()) {
                m5224c.setLongClickable(true);
            }
            m5224c.setOnLongClickListener(new ViewOnLongClickListenerC1903b());
        }
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5195a(@IdRes int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            m5224c(i2).setAlpha(f2);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f2);
            alphaAnimation.setDuration(0L);
            alphaAnimation.setFillAfter(true);
            m5224c(i2).startAnimation(alphaAnimation);
        }
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5201a(@IdRes int i2, Typeface typeface) {
        TextView textView = (TextView) m5224c(i2);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5214a(Typeface typeface, int... iArr) {
        for (int i2 : iArr) {
            TextView textView = (TextView) m5224c(i2);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5198a(@IdRes int i2, int i3, int i4) {
        ProgressBar progressBar = (ProgressBar) m5224c(i2);
        progressBar.setMax(i4);
        progressBar.setProgress(i3);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5196a(@IdRes int i2, float f2, int i3) {
        RatingBar ratingBar = (RatingBar) m5224c(i2);
        ratingBar.setMax(i3);
        ratingBar.setRating(f2);
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public BaseViewHolder m5203a(@IdRes int i2, View.OnClickListener onClickListener) {
        m5224c(i2).setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5194a(@IdRes int i2) {
        this.f5599c.add(Integer.valueOf(i2));
        View m5224c = m5224c(i2);
        if (m5224c != null) {
            if (!m5224c.isClickable()) {
                m5224c.setClickable(true);
            }
            m5224c.setOnClickListener(new ViewOnClickListenerC1902a());
        }
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public BaseViewHolder m5205a(@IdRes int i2, View.OnTouchListener onTouchListener) {
        m5224c(i2).setOnTouchListener(onTouchListener);
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public BaseViewHolder m5204a(@IdRes int i2, View.OnLongClickListener onLongClickListener) {
        m5224c(i2).setOnLongClickListener(onLongClickListener);
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public BaseViewHolder m5207a(@IdRes int i2, AdapterView.OnItemClickListener onItemClickListener) {
        ((AdapterView) m5224c(i2)).setOnItemClickListener(onItemClickListener);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5208a(@IdRes int i2, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((AdapterView) m5224c(i2)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5209a(@IdRes int i2, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((AdapterView) m5224c(i2)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5210a(@IdRes int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((CompoundButton) m5224c(i2)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5212a(@IdRes int i2, Object obj) {
        m5224c(i2).setTag(obj);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5199a(@IdRes int i2, int i3, Object obj) {
        m5224c(i2).setTag(i3, obj);
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5213a(@IdRes int i2, boolean z) {
        KeyEvent.Callback m5224c = m5224c(i2);
        if (m5224c instanceof Checkable) {
            ((Checkable) m5224c).setChecked(z);
        }
        return this;
    }

    /* renamed from: a */
    public BaseViewHolder m5206a(@IdRes int i2, Adapter adapter2) {
        ((AdapterView) m5224c(i2)).setAdapter(adapter2);
        return this;
    }

    /* renamed from: a */
    protected BaseViewHolder m5215a(BaseQuickAdapter baseQuickAdapter) {
        this.f5601e = baseQuickAdapter;
        return this;
    }

    /* renamed from: a */
    public Object m5216a() {
        return this.f5603g;
    }

    /* renamed from: a */
    public void m5217a(Object obj) {
        this.f5603g = obj;
    }
}
