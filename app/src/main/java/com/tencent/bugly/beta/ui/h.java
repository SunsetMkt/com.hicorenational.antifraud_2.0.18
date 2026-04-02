package com.tencent.bugly.beta.ui;

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
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class h extends a {
    public static h v = new h();

    /* JADX INFO: renamed from: n */
    protected TextView f6069n;
    protected TextView o;
    public y p;
    public DownloadTask q;
    public Runnable r;
    public Runnable s;
    public BitmapDrawable u;
    public UILifecycleListener w;
    private d C = null;
    protected Bitmap t = null;
    View.OnClickListener x = new com.tencent.bugly.beta.global.b(9, this);
    View.OnClickListener y = new com.tencent.bugly.beta.global.b(4, this);
    View.OnClickListener z = new com.tencent.bugly.beta.global.b(5, this);
    View.OnClickListener A = new com.tencent.bugly.beta.global.b(6, this);
    DownloadListener B = new com.tencent.bugly.beta.download.a(2, this);

    /* JADX WARN: Removed duplicated region for block: B:43:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(DownloadTask downloadTask) {
        String str;
        View.OnClickListener onClickListener;
        int status = downloadTask.getStatus();
        if (status == 0) {
            str = Beta.strUpgradeDialogUpgradeBtn;
            onClickListener = this.y;
        } else if (status == 1) {
            str = Beta.strUpgradeDialogInstallBtn;
            onClickListener = this.x;
        } else if (status == 2) {
            str = String.format(Locale.getDefault(), "%.1f%%", Float.valueOf((downloadTask.getSavedLength() / downloadTask.getTotalLength()) * 100.0f));
            onClickListener = this.z;
        } else if (status == 3) {
            str = Beta.strUpgradeDialogContinueBtn;
            onClickListener = this.y;
        } else if (status != 4) {
            if (status != 5) {
                str = "";
                onClickListener = null;
            } else {
                str = Beta.strUpgradeDialogRetryBtn;
                onClickListener = this.y;
            }
        }
        if (this.p.f6600g != 2) {
            a(Beta.strUpgradeDialogCancelBtn, this.A, str, onClickListener);
        } else {
            a(null, null, str, onClickListener);
        }
    }

    public synchronized void c() {
        try {
        } catch (Exception e2) {
            if (this.f6044l != 0) {
                an.e("please confirm your argument: [Beta.upgradeDialogLayoutId] is correct", new Object[0]);
            }
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f6034b != null && this.p != null && this.q != null) {
            Bitmap bitmapA = null;
            if (this.f6044l != 0) {
                this.f6038f.setText(this.p.a);
                if (this.f6037e != null) {
                    this.f6037e.setAdjustViewBounds(true);
                    if (this.f6043k != 0) {
                        this.t = com.tencent.bugly.beta.global.a.a(this.a, 0, this.f6042j.a("IMG_title"));
                        this.u = null;
                        if (this.t != null) {
                            bitmapA = this.t;
                        } else if (com.tencent.bugly.beta.global.e.G.f6026j != 0) {
                            bitmapA = com.tencent.bugly.beta.global.a.a(this.a, 1, Integer.valueOf(com.tencent.bugly.beta.global.e.G.f6026j));
                        }
                        this.f6037e.setImageBitmap(bitmapA);
                    }
                }
            } else if (this.f6043k != 0) {
                this.t = com.tencent.bugly.beta.global.a.a(this.a, 0, this.f6042j.a("IMG_title"));
                this.u = null;
                if (this.t != null) {
                    bitmapA = this.t;
                } else if (com.tencent.bugly.beta.global.e.G.f6026j != 0) {
                    bitmapA = com.tencent.bugly.beta.global.a.a(this.a, 1, Integer.valueOf(com.tencent.bugly.beta.global.e.G.f6026j));
                }
                this.f6038f.getViewTreeObserver().removeOnPreDrawListener(this.C);
                this.C = new d(1, this, this.f6038f, bitmapA, Integer.valueOf(this.f6043k));
                this.f6038f.getViewTreeObserver().addOnPreDrawListener(this.C);
            } else {
                this.f6038f.setHeight(com.tencent.bugly.beta.global.a.a(this.a, 42.0f));
                this.f6038f.setText(this.p.a);
            }
            this.o.setText(this.p.f6595b.length() > 500 ? this.p.f6595b.substring(0, 500) : this.p.f6595b);
            if (com.tencent.bugly.beta.global.e.G.W) {
                StringBuilder sb = new StringBuilder();
                sb.append(Beta.strUpgradeDialogVersionLabel);
                sb.append(": ");
                sb.append(this.p.f6598e.f6575d);
                sb.append("\n");
                sb.append(Beta.strUpgradeDialogFileSizeLabel);
                sb.append(": ");
                float f2 = this.p.f6599f.f6570d;
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
                sb.append(simpleDateFormat.format(new Date(this.p.o)));
                this.f6069n.setText(sb);
            }
            a(this.q);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        this.f6044l = eVar.f6027k;
        this.w = eVar.f6029m;
        try {
            this.f6043k = Integer.parseInt(ResBean.a.a("VAL_style"));
        } catch (Exception e2) {
            an.a(e2.getMessage(), new Object[0]);
            this.f6043k = 0;
        }
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f6044l != 0) {
            this.f6069n = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.o = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ResBean resBean = ResBean.a;
            if (com.tencent.bugly.beta.global.e.G.W) {
                this.f6069n = new TextView(this.a);
                this.f6069n.setLayoutParams(layoutParams2);
                TextView textView = this.f6069n;
                resBean.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                this.f6069n.setTextSize(14);
                this.f6069n.setTag(Beta.TAG_UPGRADE_INFO);
                this.f6069n.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.f6069n);
            }
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(layoutParams2);
            resBean.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            float f2 = 14;
            textView2.setTextSize(f2);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(String.valueOf(Beta.strUpgradeDialogFeatureLabel + ": "));
            textView2.setPadding(0, com.tencent.bugly.beta.global.a.a(this.a, 8.0f), 0, 0);
            linearLayout.addView(textView2);
            this.o = new TextView(this.a);
            this.o.setLayoutParams(layoutParams2);
            TextView textView3 = this.o;
            resBean.getClass();
            textView3.setTextColor(Color.parseColor("#273238"));
            this.o.setTextSize(f2);
            this.o.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.o.setMaxHeight(com.tencent.bugly.beta.global.a.a(this.a, 200.0f));
            this.o.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.o);
            this.f6041i.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            y yVar = this.p;
            uILifecycleListener.onCreate(activity, viewOnCreateView, yVar != null ? new UpgradeInfo(yVar) : null);
        }
        return viewOnCreateView;
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            this.f6069n = null;
            this.o = null;
            synchronized (this) {
                this.C = null;
            }
            if (this.u != null) {
                this.u.setCallback(null);
            }
            if (this.w != null) {
                this.w.onDestroy(this.a, this.f6034b, this.p != null ? new UpgradeInfo(this.p) : null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.bugly.beta.ui.b, androidx.fragment.app.Fragment
    public void onPause() {
        DownloadTask downloadTask;
        super.onPause();
        DownloadListener downloadListener = this.B;
        if (downloadListener != null && (downloadTask = this.q) != null) {
            downloadTask.removeListener(downloadListener);
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.a;
            View view = this.f6034b;
            y yVar = this.p;
            uILifecycleListener.onPause(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // com.tencent.bugly.beta.ui.b, androidx.fragment.app.Fragment
    public void onResume() {
        DownloadTask downloadTask;
        super.onResume();
        DownloadListener downloadListener = this.B;
        if (downloadListener != null && (downloadTask = this.q) != null) {
            downloadTask.addListener(downloadListener);
        }
        c();
        if (this.f6043k != 0 && this.t == null) {
            com.tencent.bugly.beta.global.f.a.a(new com.tencent.bugly.beta.global.d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.a;
            View view = this.f6034b;
            y yVar = this.p;
            uILifecycleListener.onResume(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.a;
            View view = this.f6034b;
            y yVar = this.p;
            uILifecycleListener.onStart(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.a;
            View view = this.f6034b;
            y yVar = this.p;
            uILifecycleListener.onStop(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    public synchronized void a(y yVar, DownloadTask downloadTask) {
        this.p = yVar;
        this.q = downloadTask;
        this.q.addListener(this.B);
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(7, this));
    }

    @Override // com.tencent.bugly.beta.ui.b
    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.p.f6600g == 2) {
            return true;
        }
        Runnable runnable = this.s;
        if (runnable != null) {
            runnable.run();
        }
        a();
        return true;
    }
}
