package com.tencent.bugly.beta.p205ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.C3075a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.C3083f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.global.ViewOnClickListenerC3079b;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3200y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.h */
/* loaded from: classes2.dex */
public class C3097h extends AbstractC3090a {

    /* renamed from: v */
    public static C3097h f9972v = new C3097h();

    /* renamed from: n */
    protected TextView f9976n;

    /* renamed from: o */
    protected TextView f9977o;

    /* renamed from: p */
    public C3200y f9978p;

    /* renamed from: q */
    public DownloadTask f9979q;

    /* renamed from: r */
    public Runnable f9980r;

    /* renamed from: s */
    public Runnable f9981s;

    /* renamed from: u */
    public BitmapDrawable f9983u;

    /* renamed from: w */
    public UILifecycleListener f9984w;

    /* renamed from: C */
    private ViewTreeObserverOnPreDrawListenerC3093d f9975C = null;

    /* renamed from: t */
    protected Bitmap f9982t = null;

    /* renamed from: x */
    View.OnClickListener f9985x = new ViewOnClickListenerC3079b(9, this);

    /* renamed from: y */
    View.OnClickListener f9986y = new ViewOnClickListenerC3079b(4, this);

    /* renamed from: z */
    View.OnClickListener f9987z = new ViewOnClickListenerC3079b(5, this);

    /* renamed from: A */
    View.OnClickListener f9973A = new ViewOnClickListenerC3079b(6, this);

    /* renamed from: B */
    DownloadListener f9974B = new C3075a(2, this);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9363a(com.tencent.bugly.beta.download.DownloadTask r9) {
        /*
            r8 = this;
            int r0 = r9.getStatus()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L4e
            r3 = 1
            if (r0 == r3) goto L49
            if (r0 == r1) goto L24
            r9 = 3
            if (r0 == r9) goto L1f
            r9 = 4
            if (r0 == r9) goto L4e
            r9 = 5
            if (r0 == r9) goto L1a
            java.lang.String r9 = ""
            r0 = r2
            goto L52
        L1a:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogRetryBtn
            android.view.View$OnClickListener r0 = r8.f9986y
            goto L52
        L1f:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogContinueBtn
            android.view.View$OnClickListener r0 = r8.f9986y
            goto L52
        L24:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            long r5 = r9.getSavedLength()
            float r5 = (float) r5
            long r6 = r9.getTotalLength()
            float r9 = (float) r6
            float r5 = r5 / r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 * r9
            java.lang.Float r9 = java.lang.Float.valueOf(r5)
            r3[r4] = r9
            java.lang.String r9 = "%.1f%%"
            java.lang.String r9 = java.lang.String.format(r0, r9, r3)
            android.view.View$OnClickListener r0 = r8.f9987z
            goto L52
        L49:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogInstallBtn
            android.view.View$OnClickListener r0 = r8.f9985x
            goto L52
        L4e:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpgradeBtn
            android.view.View$OnClickListener r0 = r8.f9986y
        L52:
            com.tencent.bugly.proguard.y r3 = r8.f9978p
            byte r3 = r3.f10838g
            if (r3 == r1) goto L60
            java.lang.String r1 = com.tencent.bugly.beta.Beta.strUpgradeDialogCancelBtn
            android.view.View$OnClickListener r2 = r8.f9973A
            r8.m9352a(r1, r2, r9, r0)
            goto L63
        L60:
            r8.m9352a(r2, r2, r9, r0)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p205ui.C3097h.m9363a(com.tencent.bugly.beta.download.DownloadTask):void");
    }

    /* renamed from: c */
    public synchronized void m9365c() {
        try {
        } catch (Exception e2) {
            if (this.f9940l != 0) {
                C3151an.m9923e("please confirm your argument: [Beta.upgradeDialogLayoutId] is correct", new Object[0]);
            }
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f9930b != null && this.f9978p != null && this.f9979q != null) {
            Bitmap bitmap = null;
            if (this.f9940l != 0) {
                this.f9934f.setText(this.f9978p.f10832a);
                if (this.f9933e != null) {
                    this.f9933e.setAdjustViewBounds(true);
                    if (this.f9939k != 0) {
                        this.f9982t = C3078a.m9323a(this.f9929a, 0, this.f9938j.m9318a("IMG_title"));
                        this.f9983u = null;
                        if (this.f9982t != null) {
                            bitmap = this.f9982t;
                        } else if (C3082e.f9867G.f9908j != 0) {
                            bitmap = C3078a.m9323a(this.f9929a, 1, Integer.valueOf(C3082e.f9867G.f9908j));
                        }
                        this.f9933e.setImageBitmap(bitmap);
                    }
                }
            } else if (this.f9939k != 0) {
                this.f9982t = C3078a.m9323a(this.f9929a, 0, this.f9938j.m9318a("IMG_title"));
                this.f9983u = null;
                if (this.f9982t != null) {
                    bitmap = this.f9982t;
                } else if (C3082e.f9867G.f9908j != 0) {
                    bitmap = C3078a.m9323a(this.f9929a, 1, Integer.valueOf(C3082e.f9867G.f9908j));
                }
                this.f9934f.getViewTreeObserver().removeOnPreDrawListener(this.f9975C);
                this.f9975C = new ViewTreeObserverOnPreDrawListenerC3093d(1, this, this.f9934f, bitmap, Integer.valueOf(this.f9939k));
                this.f9934f.getViewTreeObserver().addOnPreDrawListener(this.f9975C);
            } else {
                this.f9934f.setHeight(C3078a.m9322a(this.f9929a, 42.0f));
                this.f9934f.setText(this.f9978p.f10832a);
            }
            this.f9977o.setText(this.f9978p.f10833b.length() > 500 ? this.f9978p.f10833b.substring(0, 500) : this.f9978p.f10833b);
            if (C3082e.f9867G.f9890W) {
                StringBuilder sb = new StringBuilder();
                sb.append(Beta.strUpgradeDialogVersionLabel);
                sb.append(": ");
                sb.append(this.f9978p.f10836e.f10805d);
                sb.append("\n");
                sb.append(Beta.strUpgradeDialogFileSizeLabel);
                sb.append(": ");
                float f2 = this.f9978p.f10837f.f10799d;
                if (f2 >= 1048576.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1048576.0f)));
                    sb.append("M");
                } else if (f2 >= 1024.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1024.0f)));
                    sb.append("K");
                } else {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2)));
                    sb.append("B");
                }
                sb.append("\n");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                sb.append(Beta.strUpgradeDialogUpdateTimeLabel);
                sb.append(": ");
                sb.append(simpleDateFormat.format(new Date(this.f9978p.f10846o)));
                this.f9976n.setText(sb);
            }
            m9363a(this.f9979q);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3082e c3082e = C3082e.f9867G;
        this.f9940l = c3082e.f9909k;
        this.f9984w = c3082e.f9911m;
        try {
            this.f9939k = Integer.parseInt(ResBean.f9856a.m9318a("VAL_style"));
        } catch (Exception e2) {
            C3151an.m9915a(e2.getMessage(), new Object[0]);
            this.f9939k = 0;
        }
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3090a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f9940l != 0) {
            this.f9976n = (TextView) onCreateView.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.f9977o = (TextView) onCreateView.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.f9929a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ResBean resBean = ResBean.f9856a;
            if (C3082e.f9867G.f9890W) {
                this.f9976n = new TextView(this.f9929a);
                this.f9976n.setLayoutParams(layoutParams2);
                TextView textView = this.f9976n;
                resBean.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                this.f9976n.setTextSize(14);
                this.f9976n.setTag(Beta.TAG_UPGRADE_INFO);
                this.f9976n.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.f9976n);
            }
            TextView textView2 = new TextView(this.f9929a);
            textView2.setLayoutParams(layoutParams2);
            resBean.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            float f2 = 14;
            textView2.setTextSize(f2);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(String.valueOf(Beta.strUpgradeDialogFeatureLabel + ": "));
            textView2.setPadding(0, C3078a.m9322a(this.f9929a, 8.0f), 0, 0);
            linearLayout.addView(textView2);
            this.f9977o = new TextView(this.f9929a);
            this.f9977o.setLayoutParams(layoutParams2);
            TextView textView3 = this.f9977o;
            resBean.getClass();
            textView3.setTextColor(Color.parseColor("#273238"));
            this.f9977o.setTextSize(f2);
            this.f9977o.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.f9977o.setMaxHeight(C3078a.m9322a(this.f9929a, 200.0f));
            this.f9977o.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.f9977o);
            this.f9937i.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.f9984w;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            C3200y c3200y = this.f9978p;
            uILifecycleListener.onCreate(activity, onCreateView, c3200y != null ? new UpgradeInfo(c3200y) : null);
        }
        return onCreateView;
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3090a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            this.f9976n = null;
            this.f9977o = null;
            synchronized (this) {
                this.f9975C = null;
            }
            if (this.f9983u != null) {
                this.f9983u.setCallback(null);
            }
            if (this.f9984w != null) {
                this.f9984w.onDestroy(this.f9929a, this.f9930b, this.f9978p != null ? new UpgradeInfo(this.f9978p) : null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3091b, androidx.fragment.app.Fragment
    public void onPause() {
        DownloadTask downloadTask;
        super.onPause();
        DownloadListener downloadListener = this.f9974B;
        if (downloadListener != null && (downloadTask = this.f9979q) != null) {
            downloadTask.removeListener(downloadListener);
        }
        UILifecycleListener uILifecycleListener = this.f9984w;
        if (uILifecycleListener != null) {
            Context context = this.f9929a;
            View view = this.f9930b;
            C3200y c3200y = this.f9978p;
            uILifecycleListener.onPause(context, view, c3200y != null ? new UpgradeInfo(c3200y) : null);
        }
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3091b, androidx.fragment.app.Fragment
    public void onResume() {
        DownloadTask downloadTask;
        super.onResume();
        DownloadListener downloadListener = this.f9974B;
        if (downloadListener != null && (downloadTask = this.f9979q) != null) {
            downloadTask.addListener(downloadListener);
        }
        m9365c();
        if (this.f9939k != 0 && this.f9982t == null) {
            C3083f.f9925a.m9342a(new RunnableC3081d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.f9984w;
        if (uILifecycleListener != null) {
            Context context = this.f9929a;
            View view = this.f9930b;
            C3200y c3200y = this.f9978p;
            uILifecycleListener.onResume(context, view, c3200y != null ? new UpgradeInfo(c3200y) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.f9984w;
        if (uILifecycleListener != null) {
            Context context = this.f9929a;
            View view = this.f9930b;
            C3200y c3200y = this.f9978p;
            uILifecycleListener.onStart(context, view, c3200y != null ? new UpgradeInfo(c3200y) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.f9984w;
        if (uILifecycleListener != null) {
            Context context = this.f9929a;
            View view = this.f9930b;
            C3200y c3200y = this.f9978p;
            uILifecycleListener.onStop(context, view, c3200y != null ? new UpgradeInfo(c3200y) : null);
        }
    }

    /* renamed from: a */
    public synchronized void m9364a(C3200y c3200y, DownloadTask downloadTask) {
        this.f9978p = c3200y;
        this.f9979q = downloadTask;
        this.f9979q.addListener(this.f9974B);
        C3105e.m9461a(new RunnableC3081d(7, this));
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3091b
    /* renamed from: a */
    public boolean mo9353a(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.f9978p.f10838g == 2) {
            return true;
        }
        Runnable runnable = this.f9981s;
        if (runnable != null) {
            runnable.run();
        }
        mo9351a();
        return true;
    }
}
