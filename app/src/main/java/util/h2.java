package util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import bean.CheckUserBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.ICheckVerifyListener;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import java.util.HashMap;
import manager.AccountManager;
import ui.activity.BaseActivity;
import ui.activity.VerifyFaceActivity;
import ui.presenter.HelperPresenter;

/* JADX INFO: compiled from: VerifiedUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class h2 {
    public static final int a = -1;

    /* JADX INFO: renamed from: b */
    public static final int f14904b = 1011;

    /* JADX INFO: renamed from: c */
    public static final int f14905c = 1012;

    /* JADX INFO: renamed from: d */
    public static final int f14906d = 1013;

    /* JADX INFO: renamed from: e */
    public static final int f14907e = 1014;

    /* JADX INFO: renamed from: f */
    public static final int f14908f = 3;

    /* JADX INFO: renamed from: g */
    public static final int f14909g = 4;

    /* JADX INFO: renamed from: h */
    public static final int f14910h = 6;

    /* JADX INFO: renamed from: i */
    public static final int f14911i = 7;

    /* JADX INFO: renamed from: j */
    public static final int f14912j = 8;

    /* JADX INFO: renamed from: k */
    public static final int f14913k = 9;

    /* JADX INFO: renamed from: l */
    public static final int f14914l = 10;

    /* JADX INFO: renamed from: m */
    public static final int f14915m = 11;

    /* JADX INFO: renamed from: n */
    public static final int f14916n = 12;
    public static final int o = 13;
    public static final int p = 15;
    public static final int q = 16;
    public static final int r = 17;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static HashMap<String, Object> v = null;
    public static boolean w = false;
    private static Context x;
    private static h2 y;
    private static HelperPresenter z;

    /* JADX INFO: compiled from: VerifiedUtil.java */
    class a implements ICheckVerifyListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ HashMap f14917b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ IVerifyListener f14918c;

        a(int i2, HashMap map, IVerifyListener iVerifyListener) {
            this.a = i2;
            this.f14917b = map;
            this.f14918c = iVerifyListener;
        }

        @Override // interfaces.ICheckVerifyListener
        public void onSuccessVerify(CheckUserBean checkUserBean) {
            u1.a(u1.f15089l, checkUserBean);
            h2.this.a(this.a, checkUserBean, this.f14917b, this.f14918c);
        }
    }

    /* JADX INFO: compiled from: VerifiedUtil.java */
    class b implements IClickListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ HashMap f14920b;

        b(int i2, HashMap map) {
            this.a = i2;
            this.f14920b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            c2.b(c2.x0, this.a);
            HashMap map = this.f14920b;
            if (map != null && !map.isEmpty()) {
                h2.v = this.f14920b;
            }
            h2.x.startActivity(new Intent(h2.x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* JADX INFO: compiled from: VerifiedUtil.java */
    class c implements IClickListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ HashMap f14922b;

        c(int i2, HashMap map) {
            this.a = i2;
            this.f14922b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            c2.b(c2.x0, this.a);
            HashMap map = this.f14922b;
            if (map != null && !map.isEmpty()) {
                h2.v = this.f14922b;
            }
            h2.x.startActivity(new Intent(h2.x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* JADX INFO: compiled from: VerifiedUtil.java */
    class d implements IClickListener {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ HashMap f14924b;

        d(int i2, HashMap map) {
            this.a = i2;
            this.f14924b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            c2.b(c2.x0, this.a);
            HashMap map = this.f14924b;
            if (map != null && !map.isEmpty()) {
                h2.v = this.f14924b;
            }
            h2.w = true;
            Intent intent = new Intent("com.deraud.regiestPersonal");
            intent.setFlags(CommonNetImpl.FLAG_AUTH);
            intent.addCategory("android.intent.category.DEFAULT");
            h2.x.startActivity(intent);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x000b. Please report as an issue. */
    private String a(int i2) {
        if (i2 == 3 || i2 == 1011 || i2 == 1014) {
            return "\u8bf7\u5148\u8fdb\u884c\u5b9e\u540d\u8ba4\u8bc1";
        }
        switch (i2) {
        }
        return "\u8bf7\u5148\u8fdb\u884c\u5b9e\u540d\u8ba4\u8bc1";
    }

    private void b(int i2, HashMap map, IVerifyListener iVerifyListener) {
        if (i2 > -1) {
            z.checkisverify(new a(i2, map, iVerifyListener));
        }
    }

    public static h2 a(Context context) {
        x = context;
        z = new HelperPresenter(context);
        if (y == null) {
            y = new h2();
        }
        return y;
    }

    public void b() {
        Context context = x;
        if (context instanceof Activity) {
            f1.b((Activity) context, "\u60a8\u7684\u5b9e\u540d\u8ba4\u8bc1\u5df2\u8f6c\u4eba\u5de5\u5ba1\u6838\uff0c\u8bf7\u8054 \u7cfb\u6d3e\u51fa\u6240\u6c11\u8b66\u5ba1\u6838\u901a\u8fc7\u540e\u4f7f\u7528\u8be5\u529f\u80fd", "\u6211\u77e5\u9053\u4e86", null);
        }
    }

    public boolean a() {
        return AccountManager.isVerified();
    }

    public void a(int i2, IVerifyListener iVerifyListener) {
        v = null;
        w = false;
        if (a()) {
            iVerifyListener.onSuccessVerify();
        } else if (i2 > -1) {
            b(i2, null, iVerifyListener);
        }
    }

    public void a(int i2, HashMap map, IVerifyListener iVerifyListener) {
        v = null;
        w = false;
        if (a()) {
            iVerifyListener.onSuccessVerify();
            map.clear();
        } else if (i2 > -1) {
            b(i2, map, iVerifyListener);
        }
    }

    public void a(int i2, CheckUserBean checkUserBean, HashMap map, IVerifyListener iVerifyListener) {
        String str;
        String str2;
        String strA = a(i2);
        String str3 = "\u6211\u77e5\u9053\u4e86";
        if (checkUserBean.getAuditStatus() == 2) {
            f1.b((BaseActivity) x, "\u60a8\u7684\u5b9e\u540d\u8ba4\u8bc1\u4eba\u5de5\u5ba1\u6838\u4e2d\uff0c\u8bf7\u8054\u7cfb \u6240\u5728\u8f96\u533a\u6d3e\u51fa\u6240\u6c11\u8b66\u5ba1\u6838\u901a\u8fc7\u540e \u4f7f\u7528\u8be5\u529f\u80fd", "\u6211\u77e5\u9053\u4e86", null);
            return;
        }
        if (checkUserBean.getAuditStatus() == 3) {
            str = "\u672a\u901a\u8fc7\u539f\u56e0\uff1a" + checkUserBean.getAuditMessage();
            strA = "\u5b9e\u540d\u8ba4\u8bc1\u672a\u901a\u8fc7\uff0c\u65e0\u6cd5\u4f7f\u7528\u8be5\u529f\u80fd";
            str2 = "\u91cd\u65b0\u9a8c\u8bc1";
        } else if (checkUserBean.getAuditStatus() == 1) {
            AccountManager.setVerified(true, checkUserBean.getName(), checkUserBean.getIdNumber());
            iVerifyListener.onSuccessVerify();
            return;
        } else {
            str = "";
            str3 = "\u53d6\u6d88";
            str2 = "\u8eab\u4efd\u9a8c\u8bc1";
        }
        f1.b((BaseActivity) x, strA, str, str3, str2, new b(i2, map));
    }

    public void a(int i2, HashMap map) {
        f1.a(x, "\u63d0\u793a", a(i2), "\u53d6\u6d88", "\u8eab\u4efd\u9a8c\u8bc1", new c(i2, map));
    }

    private void a(Context context, int i2, HashMap map) {
        f1.a(context, "\u63d0\u793a", a(i2), "\u53d6\u6d88", "\u8eab\u4efd\u9a8c\u8bc1", new d(i2, map));
    }
}
