package p388ui.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.C2113R;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.statusbarcompat.C7161b;

/* compiled from: SurveyDealActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m23546d2 = {"Lui/activity/SurveyDealActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "mIvBack", "Landroid/widget/ImageView;", "mTvCancle", "Landroid/widget/TextView;", "mTvConfirm", "mTvTitle", "initListener", "", "initPage", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SurveyDealActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f23263a;

    /* renamed from: b */
    private TextView f23264b;

    /* renamed from: c */
    private TextView f23265c;

    /* renamed from: d */
    private TextView f23266d;

    public final void initListener() {
        ImageView imageView = this.f23263a;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setOnClickListener(this);
        TextView textView = this.f23265c;
        if (textView == null) {
            C5544i0.m22554k("mTvCancle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.f23266d;
        if (textView2 == null) {
            C5544i0.m22554k("mTvConfirm");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setOnClickListener(this);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        View findViewById = findViewById(C2113R.id.iv_back);
        C5544i0.m22521a((Object) findViewById, "findViewById(R.id.iv_back)");
        this.f23263a = (ImageView) findViewById;
        View findViewById2 = findViewById(C2113R.id.tv_title);
        C5544i0.m22521a((Object) findViewById2, "findViewById(R.id.tv_title)");
        this.f23264b = (TextView) findViewById2;
        View findViewById3 = findViewById(C2113R.id.cancle);
        C5544i0.m22521a((Object) findViewById3, "findViewById(R.id.cancle)");
        this.f23265c = (TextView) findViewById3;
        View findViewById4 = findViewById(C2113R.id.confirm);
        C5544i0.m22521a((Object) findViewById4, "findViewById(R.id.confirm)");
        this.f23266d = (TextView) findViewById4;
        TextView textView = this.f23264b;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("报案助手");
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.cancle) {
            finish();
        } else if (id == C2113R.id.confirm) {
            finish();
        } else {
            if (id != C2113R.id.iv_back) {
                return;
            }
            onBackPressed();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_survey_deal;
    }
}
