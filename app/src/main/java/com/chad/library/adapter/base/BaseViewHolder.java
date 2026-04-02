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

/* JADX INFO: loaded from: classes.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> a;

    /* JADX INFO: renamed from: b */
    private final HashSet<Integer> f3605b;

    /* JADX INFO: renamed from: c */
    private final LinkedHashSet<Integer> f3606c;

    /* JADX INFO: renamed from: d */
    private final LinkedHashSet<Integer> f3607d;

    /* JADX INFO: renamed from: e */
    private BaseQuickAdapter f3608e;

    /* JADX INFO: renamed from: f */
    @Deprecated
    public View f3609f;

    /* JADX INFO: renamed from: g */
    Object f3610g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseViewHolder.this.f3608e.o() != null) {
                BaseViewHolder.this.f3608e.o().onItemChildClick(BaseViewHolder.this.f3608e, view, BaseViewHolder.this.f());
            }
        }
    }

    class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return BaseViewHolder.this.f3608e.p() != null && BaseViewHolder.this.f3608e.p().a(BaseViewHolder.this.f3608e, view, BaseViewHolder.this.f());
        }
    }

    public BaseViewHolder(View view) {
        super(view);
        this.a = new SparseArray<>();
        this.f3606c = new LinkedHashSet<>();
        this.f3607d = new LinkedHashSet<>();
        this.f3605b = new HashSet<>();
        this.f3609f = view;
    }

    public int f() {
        if (getLayoutPosition() >= this.f3608e.j()) {
            return getLayoutPosition() - this.f3608e.j();
        }
        return 0;
    }

    @Deprecated
    public View c() {
        return this.f3609f;
    }

    public HashSet<Integer> d() {
        return this.f3607d;
    }

    public Set<Integer> e() {
        return this.f3605b;
    }

    public BaseViewHolder g(@IdRes int i2, @ColorInt int i3) {
        ((TextView) c(i2)).setTextColor(i3);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, CharSequence charSequence) {
        ((TextView) c(i2)).setText(charSequence);
        return this;
    }

    public HashSet<Integer> b() {
        return this.f3606c;
    }

    public BaseViewHolder c(@IdRes int i2, @DrawableRes int i3) {
        ((ImageView) c(i2)).setImageResource(i3);
        return this;
    }

    public BaseViewHolder d(@IdRes int i2) {
        Linkify.addLinks((TextView) c(i2), 15);
        return this;
    }

    public BaseViewHolder e(@IdRes int i2, int i3) {
        ((ProgressBar) c(i2)).setProgress(i3);
        return this;
    }

    public BaseViewHolder b(@IdRes int i2, @DrawableRes int i3) {
        c(i2).setBackgroundResource(i3);
        return this;
    }

    public BaseViewHolder f(@IdRes int i2, @StringRes int i3) {
        ((TextView) c(i2)).setText(i3);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, @ColorInt int i3) {
        c(i2).setBackgroundColor(i3);
        return this;
    }

    public BaseViewHolder c(@IdRes int i2, boolean z) {
        c(i2).setVisibility(z ? 0 : 4);
        return this;
    }

    public BaseViewHolder d(@IdRes int i2, int i3) {
        ((ProgressBar) c(i2)).setMax(i3);
        return this;
    }

    public BaseViewHolder e(@IdRes int i2) {
        a(i2);
        b(i2);
        this.f3605b.add(Integer.valueOf(i2));
        return this;
    }

    public BaseViewHolder b(@IdRes int i2, boolean z) {
        c(i2).setVisibility(z ? 0 : 8);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, Drawable drawable) {
        ((ImageView) c(i2)).setImageDrawable(drawable);
        return this;
    }

    public <T extends View> T c(@IdRes int i2) {
        T t = (T) this.a.get(i2);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i2);
        this.a.put(i2, t2);
        return t2;
    }

    public BaseViewHolder b(@IdRes int i2, float f2) {
        ((RatingBar) c(i2)).setRating(f2);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, Bitmap bitmap) {
        ((ImageView) c(i2)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder b(@IdRes int i2) {
        this.f3607d.add(Integer.valueOf(i2));
        View viewC = c(i2);
        if (viewC != null) {
            if (!viewC.isLongClickable()) {
                viewC.setLongClickable(true);
            }
            viewC.setOnLongClickListener(new b());
        }
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            c(i2).setAlpha(f2);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f2);
            alphaAnimation.setDuration(0L);
            alphaAnimation.setFillAfter(true);
            c(i2).startAnimation(alphaAnimation);
        }
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, Typeface typeface) {
        TextView textView = (TextView) c(i2);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    public BaseViewHolder a(Typeface typeface, int... iArr) {
        for (int i2 : iArr) {
            TextView textView = (TextView) c(i2);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, int i3, int i4) {
        ProgressBar progressBar = (ProgressBar) c(i2);
        progressBar.setMax(i4);
        progressBar.setProgress(i3);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, float f2, int i3) {
        RatingBar ratingBar = (RatingBar) c(i2);
        ratingBar.setMax(i3);
        ratingBar.setRating(f2);
        return this;
    }

    @Deprecated
    public BaseViewHolder a(@IdRes int i2, View.OnClickListener onClickListener) {
        c(i2).setOnClickListener(onClickListener);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2) {
        this.f3606c.add(Integer.valueOf(i2));
        View viewC = c(i2);
        if (viewC != null) {
            if (!viewC.isClickable()) {
                viewC.setClickable(true);
            }
            viewC.setOnClickListener(new a());
        }
        return this;
    }

    @Deprecated
    public BaseViewHolder a(@IdRes int i2, View.OnTouchListener onTouchListener) {
        c(i2).setOnTouchListener(onTouchListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder a(@IdRes int i2, View.OnLongClickListener onLongClickListener) {
        c(i2).setOnLongClickListener(onLongClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder a(@IdRes int i2, AdapterView.OnItemClickListener onItemClickListener) {
        ((AdapterView) c(i2)).setOnItemClickListener(onItemClickListener);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((AdapterView) c(i2)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((AdapterView) c(i2)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((CompoundButton) c(i2)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, Object obj) {
        c(i2).setTag(obj);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, int i3, Object obj) {
        c(i2).setTag(i3, obj);
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, boolean z) {
        KeyEvent.Callback callbackC = c(i2);
        if (callbackC instanceof Checkable) {
            ((Checkable) callbackC).setChecked(z);
        }
        return this;
    }

    public BaseViewHolder a(@IdRes int i2, Adapter adapter2) {
        ((AdapterView) c(i2)).setAdapter(adapter2);
        return this;
    }

    protected BaseViewHolder a(BaseQuickAdapter baseQuickAdapter) {
        this.f3608e = baseQuickAdapter;
        return this;
    }

    public Object a() {
        return this.f3610g;
    }

    public void a(Object obj) {
        this.f3610g = obj;
    }
}
