package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.C2113R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ManualView;
import p388ui.presenter.ManualPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;

/* compiled from: ManualActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, m23546d2 = {"Lui/activity/ManualActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualView;", "()V", "checkBtn", "Landroid/widget/TextView;", "mEtCheckInfo", "Landroid/widget/EditText;", "mIvBack", "Landroid/widget/ImageView;", "mIvClean", "mIvRight", "mPresenter", "Lui/presenter/ManualPresenter;", "getMPresenter", "()Lui/presenter/ManualPresenter;", "setMPresenter", "(Lui/presenter/ManualPresenter;)V", "mTvTitle", "initListener", "", "initPage", "onClick", "view", "Landroid/view/View;", "onSuccess", "bean", "Lbean/CheckUserBean;", "onfail", "msg", "", "setLayoutView", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualActivity extends BaseActivity implements View.OnClickListener, ManualView {
    private TextView checkBtn;
    private EditText mEtCheckInfo;
    private ImageView mIvBack;
    private ImageView mIvClean;
    private ImageView mIvRight;

    @InterfaceC5817e
    private ManualPresenter mPresenter;
    private TextView mTvTitle;

    /* compiled from: ManualActivity.kt */
    /* renamed from: ui.activity.ManualActivity$a */
    public static final class C6371a implements IEditAfterListener {
        C6371a() {
        }

        @Override // interfaces.IEditAfterListener
        public void editLength(int i2) {
            if (i2 > 0) {
                ImageView access$getMIvClean$p = ManualActivity.access$getMIvClean$p(ManualActivity.this);
                if (access$getMIvClean$p == null) {
                    C5544i0.m22545f();
                }
                access$getMIvClean$p.setVisibility(0);
            } else {
                ImageView access$getMIvClean$p2 = ManualActivity.access$getMIvClean$p(ManualActivity.this);
                if (access$getMIvClean$p2 == null) {
                    C5544i0.m22545f();
                }
                access$getMIvClean$p2.setVisibility(4);
            }
            if (i2 > 10) {
                ManualActivity.access$getCheckBtn$p(ManualActivity.this).setEnabled(true);
            } else {
                ManualActivity.access$getCheckBtn$p(ManualActivity.this).setEnabled(false);
            }
        }
    }

    public static final /* synthetic */ TextView access$getCheckBtn$p(ManualActivity manualActivity) {
        TextView textView = manualActivity.checkBtn;
        if (textView == null) {
            C5544i0.m22554k("checkBtn");
        }
        return textView;
    }

    public static final /* synthetic */ ImageView access$getMIvClean$p(ManualActivity manualActivity) {
        ImageView imageView = manualActivity.mIvClean;
        if (imageView == null) {
            C5544i0.m22554k("mIvClean");
        }
        return imageView;
    }

    @InterfaceC5817e
    public final ManualPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mIvClean;
        if (imageView2 == null) {
            C5544i0.m22554k("mIvClean");
        }
        if (imageView2 == null) {
            C5544i0.m22545f();
        }
        imageView2.setOnClickListener(this);
        TextView textView = this.checkBtn;
        if (textView == null) {
            C5544i0.m22554k("checkBtn");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setOnClickListener(this);
        ImageView imageView3 = this.mIvRight;
        if (imageView3 == null) {
            C5544i0.m22554k("mIvRight");
        }
        if (imageView3 == null) {
            C5544i0.m22545f();
        }
        imageView3.setOnClickListener(this);
        EditText editText = this.mEtCheckInfo;
        if (editText == null) {
            C5544i0.m22554k("mEtCheckInfo");
        }
        C7268d1.m26310a(editText, new C6371a());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        View findViewById = findViewById(C2113R.id.iv_back);
        C5544i0.m22521a((Object) findViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C2113R.id.tv_title);
        C5544i0.m22521a((Object) findViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(C2113R.id.iv_right);
        C5544i0.m22521a((Object) findViewById3, "findViewById(R.id.iv_right)");
        this.mIvRight = (ImageView) findViewById3;
        View findViewById4 = findViewById(C2113R.id.iv_clear);
        C5544i0.m22521a((Object) findViewById4, "findViewById(R.id.iv_clear)");
        this.mIvClean = (ImageView) findViewById4;
        View findViewById5 = findViewById(C2113R.id.confirm);
        C5544i0.m22521a((Object) findViewById5, "findViewById(R.id.confirm)");
        this.checkBtn = (TextView) findViewById5;
        View findViewById6 = findViewById(C2113R.id.et_check_info);
        C5544i0.m22521a((Object) findViewById6, "findViewById(R.id.et_check_info)");
        this.mEtCheckInfo = (EditText) findViewById6;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("人工审核");
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            C5544i0.m22554k("mIvRight");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setBackgroundResource(C2113R.drawable.iv_report_record);
        this.mPresenter = new ManualPresenter(this.mActivity, this);
        initListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                ManualPresenter manualPresenter = this.mPresenter;
                if (manualPresenter == null) {
                    C5544i0.m22545f();
                }
                EditText editText = this.mEtCheckInfo;
                if (editText == null) {
                    C5544i0.m22554k("mEtCheckInfo");
                }
                if (editText == null) {
                    C5544i0.m22545f();
                }
                manualPresenter.getCheckInfo(editText.getText().toString());
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                m8092a();
                break;
            case C2113R.id.iv_clear /* 2131296772 */:
                EditText editText2 = this.mEtCheckInfo;
                if (editText2 == null) {
                    C5544i0.m22554k("mEtCheckInfo");
                }
                if (editText2 == null) {
                    C5544i0.m22545f();
                }
                editText2.setText("");
                break;
            case C2113R.id.iv_right /* 2131296826 */:
                startActivity(new Intent(this.mActivity, (Class<?>) ManualListActivity.class));
                break;
        }
    }

    @Override // p388ui.callview.ManualView
    public void onSuccess(@InterfaceC5816d CheckUserBean checkUserBean) {
        C5544i0.m22546f(checkUserBean, "bean");
        if (checkUserBean.getAuditStatus() == Integer.parseInt("1")) {
            C7257b1.m26182a(this.mActivity, "提示", "该用户已通过认证审核", "确定", (IOneClickListener) null);
        } else {
            if (checkUserBean.getAuditStatus() != Integer.parseInt("2")) {
                onfail("");
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) ManualDetailActivity.class);
            intent.putExtra(C7292k1.f25391c, checkUserBean);
            startActivity(intent);
        }
    }

    @Override // p388ui.callview.ManualView
    public void onfail(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "msg");
        C7257b1.m26182a(this.mActivity, "未找到该用户", "请确认用户是否成功提交人工审核", "确定", (IOneClickListener) null);
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_manual_check;
    }

    public final void setMPresenter(@InterfaceC5817e ManualPresenter manualPresenter) {
        this.mPresenter = manualPresenter;
    }
}
