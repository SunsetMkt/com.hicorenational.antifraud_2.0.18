package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.WebInfoNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.WebInfoCallView;
import p388ui.presenter.CriminalWebInfoPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: CriminalWebInfoActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0007J\b\u00100\u001a\u00020,H\u0014J\u0012\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001e\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!¨\u00065"}, m23546d2 = {"Lui/activity/CriminalWebInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/WebInfoCallView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalWebInfoPresenter;", "getMPresenter", "()Lui/presenter/CriminalWebInfoPresenter;", "setMPresenter", "(Lui/presenter/CriminalWebInfoPresenter;)V", "mTvAppNum", "Landroid/widget/TextView;", "getMTvAppNum", "()Landroid/widget/TextView;", "setMTvAppNum", "(Landroid/widget/TextView;)V", "mTvSocialNum", "getMTvSocialNum", "setMTvSocialNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mTvWebsiteNum", "getMTvWebsiteNum", "setMTvWebsiteNum", "initPage", "", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccess", "result", "Lbean/WebInfoNumBean;", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalWebInfoActivity extends BaseActivity implements WebInfoCallView {

    @InterfaceC5816d
    private String caseInfoId = "";
    private int itemPos;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private CriminalWebInfoPresenter mPresenter;

    @BindView(C2113R.id.tv_app_num)
    @InterfaceC5816d
    public TextView mTvAppNum;

    @BindView(C2113R.id.tv_social_num)
    @InterfaceC5816d
    public TextView mTvSocialNum;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.tv_website_num)
    @InterfaceC5816d
    public TextView mTvWebsiteNum;

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
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
    public final CriminalWebInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final TextView getMTvAppNum() {
        TextView textView = this.mTvAppNum;
        if (textView == null) {
            C5544i0.m22554k("mTvAppNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvSocialNum() {
        TextView textView = this.mTvSocialNum;
        if (textView == null) {
            C5544i0.m22554k("mTvSocialNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvWebsiteNum() {
        TextView textView = this.mTvWebsiteNum;
        if (textView == null) {
            C5544i0.m22554k("mTvWebsiteNum");
        }
        return textView;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加嫌疑人互联网信息");
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new CriminalWebInfoPresenter(this.mActivity, this);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.cl_social, C2113R.id.cl_app, C2113R.id.cl_website})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.cl_app /* 2131296453 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ReportAppActivity.class);
                intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent);
                break;
            case C2113R.id.cl_social /* 2131296464 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                intent2.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case C2113R.id.cl_website /* 2131296467 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) ReportWebsiteActivity.class);
                intent3.putExtra(C7292k1.f25338C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalWebInfoPresenter criminalWebInfoPresenter = this.mPresenter;
        if (criminalWebInfoPresenter != null) {
            criminalWebInfoPresenter.getWebNum(this.caseInfoId);
        }
    }

    @Override // p388ui.callview.WebInfoCallView
    public void onSuccess(@InterfaceC5817e WebInfoNumBean webInfoNumBean) {
        if (webInfoNumBean == null) {
            C5544i0.m22545f();
        }
        if (webInfoNumBean.getNetAccountCount() > 0) {
            TextView textView = this.mTvSocialNum;
            if (textView == null) {
                C5544i0.m22554k("mTvSocialNum");
            }
            textView.setText(String.valueOf(webInfoNumBean.getNetAccountCount()));
        } else {
            TextView textView2 = this.mTvSocialNum;
            if (textView2 == null) {
                C5544i0.m22554k("mTvSocialNum");
            }
            textView2.setText("");
        }
        if (webInfoNumBean.getAppCount() > 0) {
            TextView textView3 = this.mTvAppNum;
            if (textView3 == null) {
                C5544i0.m22554k("mTvAppNum");
            }
            textView3.setText(String.valueOf(webInfoNumBean.getAppCount()));
        } else {
            TextView textView4 = this.mTvAppNum;
            if (textView4 == null) {
                C5544i0.m22554k("mTvAppNum");
            }
            textView4.setText("");
        }
        if (webInfoNumBean.getUrlCount() > 0) {
            TextView textView5 = this.mTvWebsiteNum;
            if (textView5 == null) {
                C5544i0.m22554k("mTvWebsiteNum");
            }
            textView5.setText(String.valueOf(webInfoNumBean.getUrlCount()));
            return;
        }
        TextView textView6 = this.mTvWebsiteNum;
        if (textView6 == null) {
            C5544i0.m22554k("mTvWebsiteNum");
        }
        textView6.setText("");
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setItemPos(int i2) {
        this.itemPos = i2;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_criminal_web_info;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e CriminalWebInfoPresenter criminalWebInfoPresenter) {
        this.mPresenter = criminalWebInfoPresenter;
    }

    public final void setMTvAppNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppNum = textView;
    }

    public final void setMTvSocialNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvSocialNum = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMTvWebsiteNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvWebsiteNum = textView;
    }
}
