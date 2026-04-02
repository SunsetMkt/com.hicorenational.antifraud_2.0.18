package ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.AppBean;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class PicItemView extends LinearLayout {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<AppBean> f14582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<AppInfoBean> f14583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Handler f14584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f14585e;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PicItemView.this.f14583c != null) {
                PicItemView picItemView = PicItemView.this;
                picItemView.setAppListData(picItemView.f14583c);
            }
            org.greenrobot.eventbus.c.f().d(new util.n2.a(1, PicItemView.this.f14583c));
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < PicItemView.this.f14582b.size(); i2++) {
                AppBean appBean = (AppBean) PicItemView.this.f14582b.get(i2);
                Bitmap bitmapA = k.c.a(appBean.getName(), appBean.getVersionName(), PicItemView.getPathName());
                if (bitmapA == null) {
                    AppInfoBean appInfoBeanA = PicItemView.this.a(appBean.getPkgName());
                    if (appInfoBeanA != null) {
                        PicItemView.this.f14583c.add(AppBean.AppBean2AppInfoBean(appBean, appInfoBeanA.getAppIcon(), appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
                    }
                } else {
                    PicItemView.this.f14583c.add(AppBean.AppBean2AppInfoBean(appBean, new BitmapDrawable(bitmapA), appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
                }
            }
            PicItemView.this.f14584d.sendEmptyMessage(0);
        }
    }

    public PicItemView(Context context) {
        super(context);
        this.f14583c = new ArrayList();
        this.f14584d = new a();
        this.f14585e = new b();
        a((AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPathName() {
        return Hicore.fromPageReport ? k.c.a : k.c.f12649b;
    }

    public void setAppListData(List<AppInfoBean> list) {
        removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pic_item_view, (ViewGroup) this, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageview);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvDot);
            if (i2 > 2) {
                textView.setVisibility(0);
                imageView.setVisibility(8);
                addView(viewInflate);
                return;
            } else {
                Drawable appIcon = list.get(i2).getAppIcon();
                if (appIcon != null) {
                    imageView.setImageDrawable(appIcon);
                }
                textView.setVisibility(8);
                imageView.setVisibility(0);
                addView(viewInflate);
            }
        }
    }

    public void setAppSData(List<AppBean> list) {
        this.f14583c.clear();
        this.f14582b = list;
        this.f14584d.post(this.f14585e);
    }

    public void setPicListData(List<LocalMedia> list) {
        removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pic_item_view, (ViewGroup) this, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageview);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvDot);
            if (i2 > 2) {
                textView.setVisibility(0);
                imageView.setVisibility(8);
                addView(viewInflate);
                return;
            } else {
                com.bumptech.glide.b.e(getContext()).a(list.get(i2).getPath()).a(imageView);
                textView.setVisibility(8);
                imageView.setVisibility(0);
                addView(viewInflate);
            }
        }
    }

    private void a(AttributeSet attributeSet) {
        this.a = LayoutInflater.from(getContext()).inflate(R.layout.pic_item, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppInfoBean a(String str) {
        AppInfoBean appInfoBean = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        x1 x1Var = new x1(getContext());
        List<AppInfoBean> listA = x1.a(new String[]{x1.f15111d});
        List<AppInfoBean> listA2 = x1Var.a();
        listA2.addAll(listA);
        if (listA2 != null && listA2.size() > 0) {
            for (int i2 = 0; i2 < listA2.size(); i2++) {
                if (str.equalsIgnoreCase(listA2.get(i2).getPkgName())) {
                    appInfoBean = listA2.get(i2);
                }
            }
        }
        return appInfoBean;
    }

    public PicItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14583c = new ArrayList();
        this.f14584d = new a();
        this.f14585e = new b();
        a(attributeSet);
    }

    public PicItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14583c = new ArrayList();
        this.f14584d = new a();
        this.f14585e = new b();
        a(attributeSet);
    }
}
