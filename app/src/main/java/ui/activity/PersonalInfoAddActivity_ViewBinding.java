package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PersonalInfoAddActivity_ViewBinding implements Unbinder {
    private PersonalInfoAddActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13556d;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ PersonalInfoAddActivity a;

        a(PersonalInfoAddActivity personalInfoAddActivity) {
            this.a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ PersonalInfoAddActivity a;

        b(PersonalInfoAddActivity personalInfoAddActivity) {
            this.a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ PersonalInfoAddActivity a;

        c(PersonalInfoAddActivity personalInfoAddActivity) {
            this.a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity) {
        this(personalInfoAddActivity, personalInfoAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PersonalInfoAddActivity personalInfoAddActivity = this.a;
        if (personalInfoAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        personalInfoAddActivity.mIvBack = null;
        personalInfoAddActivity.mTvTitle = null;
        personalInfoAddActivity.mClArea = null;
        personalInfoAddActivity.mClAreaDetail = null;
        personalInfoAddActivity.mEtArea = null;
        personalInfoAddActivity.mEtAddres = null;
        personalInfoAddActivity.mBtnConfirm = null;
        this.f13554b.setOnClickListener(null);
        this.f13554b = null;
        this.f13555c.setOnClickListener(null);
        this.f13555c = null;
        this.f13556d.setOnClickListener(null);
        this.f13556d = null;
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity, View view) {
        this.a = personalInfoAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        personalInfoAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f13554b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(personalInfoAddActivity));
        personalInfoAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        personalInfoAddActivity.mClArea = Utils.findRequiredView(view, R.id.cl_area_cont, "field 'mClArea'");
        personalInfoAddActivity.mClAreaDetail = Utils.findRequiredView(view, R.id.cl_area_detail_content, "field 'mClAreaDetail'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.et_area, "field 'mEtArea' and method 'onClick'");
        personalInfoAddActivity.mEtArea = (TextView) Utils.castView(viewFindRequiredView2, R.id.et_area, "field 'mEtArea'", TextView.class);
        this.f13555c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(personalInfoAddActivity));
        personalInfoAddActivity.mEtAddres = (EditText) Utils.findRequiredViewAsType(view, R.id.et_address, "field 'mEtAddres'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onClick'");
        personalInfoAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f13556d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(personalInfoAddActivity));
    }
}
