package p388ui.view;

import android.content.Context;
import android.view.View;
import com.hicorenational.antifraud.C2113R;
import com.luozm.captcha.Captcha;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.p184c.AbstractC2770b;
import interfaces.IOneClickListener;
import java.util.Random;
import util.C7331w1;

/* loaded from: classes2.dex */
public class HuaKuaiWindow extends CenterPopupView {

    /* renamed from: s */
    int[] f24520s;

    /* renamed from: t */
    private Captcha f24521t;

    /* renamed from: u */
    private Context f24522u;

    /* renamed from: v */
    private Random f24523v;

    /* renamed from: w */
    private IOneClickListener f24524w;

    public HuaKuaiWindow(Context context, IOneClickListener iOneClickListener) {
        super(context);
        this.f24520s = new int[]{C2113R.drawable.iv_ct_01, C2113R.drawable.iv_ct_02, C2113R.drawable.iv_ct_03, C2113R.drawable.iv_ct_04, C2113R.drawable.iv_ct_05};
        this.f24523v = new Random();
        this.f24522u = context;
        this.f24524w = iOneClickListener;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return C2113R.layout.layout_huakuaiwindow;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupHeight() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupWidth() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: n */
    protected void mo8389n() {
        super.mo8389n();
        this.f24521t = (Captcha) findViewById(C2113R.id.captCha);
        Captcha captcha = this.f24521t;
        int[] iArr = this.f24520s;
        captcha.setBitmap(iArr[this.f24523v.nextInt(iArr.length)]);
        this.f24521t.setMaxFailedCount(Integer.MAX_VALUE);
        this.f24521t.setCaptchaListener(new C7172a());
        findViewById(C2113R.id.iv_ct_close).setOnClickListener(new View.OnClickListener() { // from class: ui.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuaKuaiWindow.this.m25767b(view);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m25767b(View view) {
        mo8378b();
    }

    /* renamed from: ui.view.HuaKuaiWindow$a */
    class C7172a implements Captcha.InterfaceC2736f {
        C7172a() {
        }

        @Override // com.luozm.captcha.Captcha.InterfaceC2736f
        /* renamed from: a */
        public String mo8169a() {
            return "验证失败,帐号已封锁";
        }

        @Override // com.luozm.captcha.Captcha.InterfaceC2736f
        /* renamed from: a */
        public String mo8171a(long j2) {
            if (HuaKuaiWindow.this.f24524w != null) {
                HuaKuaiWindow.this.f24524w.clickOKBtn();
            }
            HuaKuaiWindow.this.mo8378b();
            return "验证通过,耗时" + j2 + "毫秒";
        }

        @Override // com.luozm.captcha.Captcha.InterfaceC2736f
        /* renamed from: a */
        public String mo8170a(int i2) {
            if (i2 != -100) {
                C7331w1.m26688a("验证失败,请重新验证");
            }
            Captcha captcha = HuaKuaiWindow.this.f24521t;
            HuaKuaiWindow huaKuaiWindow = HuaKuaiWindow.this;
            captcha.setBitmap(huaKuaiWindow.f24520s[huaKuaiWindow.f24523v.nextInt(HuaKuaiWindow.this.f24520s.length)]);
            return "验证失败,请重新验证";
        }
    }
}
