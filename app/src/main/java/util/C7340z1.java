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
import p388ui.activity.BaseActivity;
import p388ui.activity.VerifyFaceActivity;
import p388ui.presenter.HelperPresenter;

/* compiled from: VerifiedUtil.java */
/* renamed from: util.z1 */
/* loaded from: classes2.dex */
public class C7340z1 {

    /* renamed from: a */
    public static final int f25753a = -1;

    /* renamed from: b */
    public static final int f25754b = 1011;

    /* renamed from: c */
    public static final int f25755c = 1012;

    /* renamed from: d */
    public static final int f25756d = 1013;

    /* renamed from: e */
    public static final int f25757e = 1014;

    /* renamed from: f */
    public static final int f25758f = 3;

    /* renamed from: g */
    public static final int f25759g = 4;

    /* renamed from: h */
    public static final int f25760h = 6;

    /* renamed from: i */
    public static final int f25761i = 7;

    /* renamed from: j */
    public static final int f25762j = 8;

    /* renamed from: k */
    public static final int f25763k = 9;

    /* renamed from: l */
    public static final int f25764l = 10;

    /* renamed from: m */
    public static final int f25765m = 11;

    /* renamed from: n */
    public static final int f25766n = 12;

    /* renamed from: o */
    public static final int f25767o = 13;

    /* renamed from: p */
    public static final int f25768p = 15;

    /* renamed from: q */
    public static final int f25769q = 16;

    /* renamed from: r */
    public static final int f25770r = 17;

    /* renamed from: s */
    public static final int f25771s = 18;

    /* renamed from: t */
    public static final int f25772t = 19;

    /* renamed from: u */
    public static final int f25773u = 20;

    /* renamed from: v */
    public static HashMap<String, Object> f25774v = null;

    /* renamed from: w */
    public static boolean f25775w = false;

    /* renamed from: x */
    private static Context f25776x;

    /* renamed from: y */
    private static C7340z1 f25777y;

    /* renamed from: z */
    private static HelperPresenter f25778z;

    /* compiled from: VerifiedUtil.java */
    /* renamed from: util.z1$a */
    class a implements ICheckVerifyListener {

        /* renamed from: a */
        final /* synthetic */ int f25779a;

        /* renamed from: b */
        final /* synthetic */ HashMap f25780b;

        /* renamed from: c */
        final /* synthetic */ IVerifyListener f25781c;

        a(int i2, HashMap hashMap, IVerifyListener iVerifyListener) {
            this.f25779a = i2;
            this.f25780b = hashMap;
            this.f25781c = iVerifyListener;
        }

        @Override // interfaces.ICheckVerifyListener
        public void onSuccessVerify(CheckUserBean checkUserBean) {
            C7307p1.m26478a(C7307p1.f25503l, checkUserBean);
            C7340z1.this.m26806a(this.f25779a, checkUserBean, this.f25780b, this.f25781c);
        }
    }

    /* compiled from: VerifiedUtil.java */
    /* renamed from: util.z1$b */
    class b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f25783a;

        /* renamed from: b */
        final /* synthetic */ HashMap f25784b;

        b(int i2, HashMap hashMap) {
            this.f25783a = i2;
            this.f25784b = hashMap;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7325u1.m26628b(C7325u1.f25707x0, this.f25783a);
            HashMap hashMap = this.f25784b;
            if (hashMap != null && !hashMap.isEmpty()) {
                C7340z1.f25774v = this.f25784b;
            }
            C7340z1.f25776x.startActivity(new Intent(C7340z1.f25776x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* compiled from: VerifiedUtil.java */
    /* renamed from: util.z1$c */
    class c implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f25786a;

        /* renamed from: b */
        final /* synthetic */ HashMap f25787b;

        c(int i2, HashMap hashMap) {
            this.f25786a = i2;
            this.f25787b = hashMap;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7325u1.m26628b(C7325u1.f25707x0, this.f25786a);
            HashMap hashMap = this.f25787b;
            if (hashMap != null && !hashMap.isEmpty()) {
                C7340z1.f25774v = this.f25787b;
            }
            C7340z1.f25776x.startActivity(new Intent(C7340z1.f25776x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* compiled from: VerifiedUtil.java */
    /* renamed from: util.z1$d */
    class d implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f25789a;

        /* renamed from: b */
        final /* synthetic */ HashMap f25790b;

        d(int i2, HashMap hashMap) {
            this.f25789a = i2;
            this.f25790b = hashMap;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            C7325u1.m26628b(C7325u1.f25707x0, this.f25789a);
            HashMap hashMap = this.f25790b;
            if (hashMap != null && !hashMap.isEmpty()) {
                C7340z1.f25774v = this.f25790b;
            }
            C7340z1.f25775w = true;
            Intent intent = new Intent("com.deraud.regiestPersonal");
            intent.setFlags(CommonNetImpl.FLAG_AUTH);
            intent.addCategory("android.intent.category.DEFAULT");
            C7340z1.f25776x.startActivity(intent);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000b. Please report as an issue. */
    /* renamed from: a */
    private String m26804a(int i2) {
        if (i2 == 3 || i2 == 1011 || i2 == 1014) {
            return "请先进行实名认证";
        }
        switch (i2) {
        }
        return "请先进行实名认证";
    }

    /* renamed from: b */
    private void m26809b(int i2, HashMap hashMap, IVerifyListener iVerifyListener) {
        if (i2 > -1) {
            f25778z.checkisverify(new a(i2, hashMap, iVerifyListener));
        }
    }

    /* renamed from: a */
    public static C7340z1 m26805a(Context context) {
        f25776x = context;
        f25778z = new HelperPresenter(context);
        if (f25777y == null) {
            f25777y = new C7340z1();
        }
        return f25777y;
    }

    /* renamed from: b */
    public void m26815b() {
        Context context = f25776x;
        if (context instanceof Activity) {
            C7257b1.m26210b((Activity) context, "您的实名认证已转人工审核，请联 系派出所民警审核通过后使用该功能", "我知道了", null);
        }
    }

    /* renamed from: a */
    public boolean m26814a() {
        return AccountManager.isVerified();
    }

    /* renamed from: a */
    public void m26811a(int i2, IVerifyListener iVerifyListener) {
        f25774v = null;
        f25775w = false;
        if (m26814a()) {
            iVerifyListener.onSuccessVerify();
        } else if (i2 > -1) {
            m26809b(i2, null, iVerifyListener);
        }
    }

    /* renamed from: a */
    public void m26813a(int i2, HashMap hashMap, IVerifyListener iVerifyListener) {
        f25774v = null;
        f25775w = false;
        if (m26814a()) {
            iVerifyListener.onSuccessVerify();
            hashMap.clear();
        } else if (i2 > -1) {
            m26809b(i2, hashMap, iVerifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m26806a(int i2, CheckUserBean checkUserBean, HashMap hashMap, IVerifyListener iVerifyListener) {
        String str;
        String str2;
        String m26804a = m26804a(i2);
        String str3 = "我知道了";
        if (checkUserBean.getAuditStatus() == 2) {
            C7257b1.m26210b((BaseActivity) f25776x, "您的实名认证人工审核中，请联系 所在辖区派出所民警审核通过后 使用该功能", "我知道了", null);
            return;
        }
        if (checkUserBean.getAuditStatus() == 3) {
            str = "未通过原因：" + checkUserBean.getAuditMessage();
            m26804a = "实名认证未通过，无法使用该功能";
            str2 = "重新验证";
        } else if (checkUserBean.getAuditStatus() == 1) {
            AccountManager.setVerified(true, checkUserBean.getName(), checkUserBean.getIdNumber());
            iVerifyListener.onSuccessVerify();
            return;
        } else {
            str = "";
            str3 = "取消";
            str2 = "身份验证";
        }
        C7257b1.m26211b((BaseActivity) f25776x, m26804a, str, str3, str2, new b(i2, hashMap));
    }

    /* renamed from: a */
    public void m26812a(int i2, HashMap hashMap) {
        C7257b1.m26189a(f25776x, "提示", m26804a(i2), "取消", "身份验证", new c(i2, hashMap));
    }

    /* renamed from: a */
    private void m26807a(Context context, int i2, HashMap hashMap) {
        C7257b1.m26189a(context, "提示", m26804a(i2), "取消", "身份验证", new d(i2, hashMap));
    }
}
