package p388ui.view;

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
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p357j.C5844c;
import p388ui.Hicore;
import util.C7316r1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class PicItemView extends LinearLayout {

    /* renamed from: a */
    private View f24594a;

    /* renamed from: b */
    private List<AppBean> f24595b;

    /* renamed from: c */
    private List<AppInfoBean> f24596c;

    /* renamed from: d */
    Handler f24597d;

    /* renamed from: e */
    Runnable f24598e;

    /* renamed from: ui.view.PicItemView$a */
    class HandlerC7187a extends Handler {
        HandlerC7187a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (PicItemView.this.f24596c != null) {
                PicItemView picItemView = PicItemView.this;
                picItemView.setAppListData(picItemView.f24596c);
            }
            C6049c.m24987f().m25000d(new C7265a(1, PicItemView.this.f24596c));
        }
    }

    /* renamed from: ui.view.PicItemView$b */
    class RunnableC7188b implements Runnable {
        RunnableC7188b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < PicItemView.this.f24595b.size(); i2++) {
                AppBean appBean = (AppBean) PicItemView.this.f24595b.get(i2);
                Bitmap m24589a = C5844c.m24589a(appBean.getName(), appBean.getVersionName(), PicItemView.getPathName());
                if (m24589a == null) {
                    AppInfoBean m25804a = PicItemView.this.m25804a(appBean.getPkgName());
                    if (m25804a != null) {
                        PicItemView.this.f24596c.add(AppBean.AppBean2AppInfoBean(appBean, m25804a.getAppIcon(), appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
                    }
                } else {
                    PicItemView.this.f24596c.add(AppBean.AppBean2AppInfoBean(appBean, new BitmapDrawable(m24589a), appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
                }
            }
            PicItemView.this.f24597d.sendEmptyMessage(0);
        }
    }

    public PicItemView(Context context) {
        super(context);
        this.f24596c = new ArrayList();
        this.f24597d = new HandlerC7187a();
        this.f24598e = new RunnableC7188b();
        m25808a((AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPathName() {
        return Hicore.fromPageReport ? C5844c.f21112a : C5844c.f21113b;
    }

    public void setAppListData(List<AppInfoBean> list) {
        removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            View inflate = LayoutInflater.from(getContext()).inflate(C2113R.layout.pic_item_view, (ViewGroup) this, false);
            ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.imageview);
            TextView textView = (TextView) inflate.findViewById(C2113R.id.tvDot);
            if (i2 > 2) {
                textView.setVisibility(0);
                imageView.setVisibility(8);
                addView(inflate);
                return;
            } else {
                Drawable appIcon = list.get(i2).getAppIcon();
                if (appIcon != null) {
                    imageView.setImageDrawable(appIcon);
                }
                textView.setVisibility(8);
                imageView.setVisibility(0);
                addView(inflate);
            }
        }
    }

    public void setAppSData(List<AppBean> list) {
        this.f24596c.clear();
        this.f24595b = list;
        this.f24597d.post(this.f24598e);
    }

    public void setPicListData(List<LocalMedia> list) {
        removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            View inflate = LayoutInflater.from(getContext()).inflate(C2113R.layout.pic_item_view, (ViewGroup) this, false);
            ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.imageview);
            TextView textView = (TextView) inflate.findViewById(C2113R.id.tvDot);
            if (i2 > 2) {
                textView.setVisibility(0);
                imageView.setVisibility(8);
                addView(inflate);
                return;
            } else {
                ComponentCallbacks2C1576b.m3649e(getContext()).mo3719a(list.get(i2).getPath()).m3768a(imageView);
                textView.setVisibility(8);
                imageView.setVisibility(0);
                addView(inflate);
            }
        }
    }

    /* renamed from: a */
    private void m25808a(AttributeSet attributeSet) {
        this.f24594a = LayoutInflater.from(getContext()).inflate(C2113R.layout.pic_item, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AppInfoBean m25804a(String str) {
        AppInfoBean appInfoBean = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C7316r1 c7316r1 = new C7316r1(getContext());
        List<AppInfoBean> m26537a = C7316r1.m26537a(new String[]{C7316r1.f25586d});
        List<AppInfoBean> m26557a = c7316r1.m26557a();
        m26557a.addAll(m26537a);
        if (m26557a != null && m26557a.size() > 0) {
            for (int i2 = 0; i2 < m26557a.size(); i2++) {
                if (str.equalsIgnoreCase(m26557a.get(i2).getPkgName())) {
                    appInfoBean = m26557a.get(i2);
                }
            }
        }
        return appInfoBean;
    }

    public PicItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24596c = new ArrayList();
        this.f24597d = new HandlerC7187a();
        this.f24598e = new RunnableC7188b();
        m25808a(attributeSet);
    }

    public PicItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24596c = new ArrayList();
        this.f24597d = new HandlerC7187a();
        this.f24598e = new RunnableC7188b();
        m25808a(attributeSet);
    }
}
