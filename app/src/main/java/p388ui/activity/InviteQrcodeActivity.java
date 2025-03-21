package p388ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import network.http.StatisticsHttp;
import p245d.C4440a;
import p245d.C4441b;
import p247e.C4447d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.presenter.PolicInfoPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.swip.SwipBackLayout;
import util.C7264c1;
import util.C7274e1;

/* compiled from: InviteQrcodeActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0013H\u0007J\b\u0010&\u001a\u00020'H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, m23546d2 = {"Lui/activity/InviteQrcodeActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mIvQrcode", "getMIvQrcode", "setMIvQrcode", "mPresenter", "Lui/presenter/PolicInfoPresenter;", "getMPresenter", "()Lui/presenter/PolicInfoPresenter;", "setMPresenter", "(Lui/presenter/PolicInfoPresenter;)V", "mRlTitle", "Landroid/view/View;", "getMRlTitle", "()Landroid/view/View;", "setMRlTitle", "(Landroid/view/View;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "createQRcode", "", "content", "", "initPage", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class InviteQrcodeActivity extends BaseActivity {

    /* renamed from: a */
    @InterfaceC5817e
    private PolicInfoPresenter f22436a;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_qrcode)
    @InterfaceC5816d
    public ImageView mIvQrcode;

    @BindView(C2113R.id.rl_title)
    @InterfaceC5816d
    public View mRlTitle;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    /* compiled from: InviteQrcodeActivity.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m23546d2 = {"<anonymous>", "", "run"}, m23547k = 3, m23548mv = {1, 1, 16})
    /* renamed from: ui.activity.InviteQrcodeActivity$a */
    static final class RunnableC6342a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String f22438b;

        /* compiled from: InviteQrcodeActivity.kt */
        /* renamed from: ui.activity.InviteQrcodeActivity$a$a */
        static final class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ Bitmap f22440b;

            a(Bitmap bitmap) {
                this.f22440b = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InviteQrcodeActivity.this.m25264a().setImageBitmap(this.f22440b);
            }
        }

        RunnableC6342a(String str) {
            this.f22438b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(InviteQrcodeActivity.this.getResources(), C2113R.drawable.iv_qrcode_polic);
            int m26285a = C7264c1.m26285a(InviteQrcodeActivity.this, 240.0f);
            Bitmap m26333a = C7274e1.m26333a(this.f22438b, m26285a, m26285a, decodeResource);
            if (InviteQrcodeActivity.this.m25264a() != null) {
                InviteQrcodeActivity.this.m25264a().post(new a(m26333a));
            }
        }
    }

    private final void createQRcode(String str) {
        new Thread(new RunnableC6342a(str)).start();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final ImageView m25264a() {
        ImageView imageView = this.mIvQrcode;
        if (imageView == null) {
            C5544i0.m22554k("mIvQrcode");
        }
        return imageView;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final View m25266b() {
        View view = this.mRlTitle;
        if (view == null) {
            C5544i0.m22554k("mRlTitle");
        }
        return view;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final PolicInfoPresenter getMPresenter() {
        return this.f22436a;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17163j);
        C7161b.m25698a((Activity) this, true, true);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        textView.setText("邀请二维码");
        initView();
    }

    public final void initView() {
        this.f22436a = new PolicInfoPresenter(this.mActivity, null);
        View view = this.mRlTitle;
        if (view == null) {
            C5544i0.m22554k("mRlTitle");
        }
        view.setBackgroundResource(C2113R.color.transparent);
        PolicBean m16412a = C4441b.m16412a();
        if (m16412a != null) {
            createQRcode(C4440a.f16884f + "/QRCode/?pcode=" + m16412a.getPoliceUserPCode() + "&policeuserid=" + m16412a.getId() + "&os=0");
        }
    }

    @OnClick({C2113R.id.iv_back})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_invite_qrcode;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e PolicInfoPresenter policInfoPresenter) {
        this.f22436a = policInfoPresenter;
    }

    public final void setMRlTitle(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mRlTitle = view;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    /* renamed from: a */
    public final void m25265a(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvQrcode = imageView;
    }
}
