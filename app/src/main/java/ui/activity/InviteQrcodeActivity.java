package ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import network.http.StatisticsHttp;
import ui.presenter.PolicInfoPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: compiled from: InviteQrcodeActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0013H\u0007J\b\u0010&\u001a\u00020'H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lui/activity/InviteQrcodeActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mIvQrcode", "getMIvQrcode", "setMIvQrcode", "mPresenter", "Lui/presenter/PolicInfoPresenter;", "getMPresenter", "()Lui/presenter/PolicInfoPresenter;", "setMPresenter", "(Lui/presenter/PolicInfoPresenter;)V", "mRlTitle", "Landroid/view/View;", "getMRlTitle", "()Landroid/view/View;", "setMRlTitle", "(Landroid/view/View;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "createQRcode", "", "content", "", "initPage", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class InviteQrcodeActivity extends BaseActivity {

    @j.c.a.e
    private PolicInfoPresenter a;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_qrcode)
    @j.c.a.d
    public ImageView mIvQrcode;

    @BindView(R.id.rl_title)
    @j.c.a.d
    public View mRlTitle;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    /* JADX INFO: compiled from: InviteQrcodeActivity.kt */
    @i.y(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    static final class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13436b;

        /* JADX INFO: renamed from: ui.activity.InviteQrcodeActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: InviteQrcodeActivity.kt */
        static final class RunnableC0285a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bitmap f13437b;

            RunnableC0285a(Bitmap bitmap) {
                this.f13437b = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InviteQrcodeActivity.this.a().setImageBitmap(this.f13437b);
            }
        }

        a(String str) {
            this.f13436b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(InviteQrcodeActivity.this.getResources(), R.drawable.iv_qrcode_polic);
            int iA = util.g1.a(InviteQrcodeActivity.this, 240.0f);
            Bitmap bitmapA = util.i1.a(this.f13436b, iA, iA, bitmapDecodeResource);
            if (InviteQrcodeActivity.this.a() != null) {
                InviteQrcodeActivity.this.a().post(new RunnableC0285a(bitmapA));
            }
        }
    }

    private final void createQRcode(String str) {
        new Thread(new a(str)).start();
    }

    @j.c.a.d
    public final ImageView a() {
        ImageView imageView = this.mIvQrcode;
        if (imageView == null) {
            i.q2.t.i0.k("mIvQrcode");
        }
        return imageView;
    }

    @j.c.a.d
    public final View b() {
        View view = this.mRlTitle;
        if (view == null) {
            i.q2.t.i0.k("mRlTitle");
        }
        return view;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.e
    public final PolicInfoPresenter getMPresenter() {
        return this.a;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(f.d.f10210j);
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        textView.setText("\u9080\u8bf7\u4e8c\u7ef4\u7801");
        initView();
    }

    public final void initView() {
        this.a = new PolicInfoPresenter(this.mActivity, null);
        View view = this.mRlTitle;
        if (view == null) {
            i.q2.t.i0.k("mRlTitle");
        }
        view.setBackgroundResource(R.color.transparent);
        PolicBean policBeanA = e.b.a();
        if (policBeanA != null) {
            createQRcode(e.a.f10142f + "/QRCode/?pcode=" + policBeanA.getPoliceUserPCode() + "&policeuserid=" + policBeanA.getId() + "&os=0");
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_invite_qrcode;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e PolicInfoPresenter policInfoPresenter) {
        this.a = policInfoPresenter;
    }

    public final void setMRlTitle(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mRlTitle = view;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void a(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvQrcode = imageView;
    }
}
