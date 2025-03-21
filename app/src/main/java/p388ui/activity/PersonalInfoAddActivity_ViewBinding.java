package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public final class PersonalInfoAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PersonalInfoAddActivity f22659a;

    /* renamed from: b */
    private View f22660b;

    /* renamed from: c */
    private View f22661c;

    /* renamed from: d */
    private View f22662d;

    /* renamed from: ui.activity.PersonalInfoAddActivity_ViewBinding$a */
    class C6423a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PersonalInfoAddActivity f22663a;

        C6423a(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f22663a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22663a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PersonalInfoAddActivity_ViewBinding$b */
    class C6424b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PersonalInfoAddActivity f22665a;

        C6424b(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f22665a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22665a.onClick(view);
        }
    }

    /* renamed from: ui.activity.PersonalInfoAddActivity_ViewBinding$c */
    class C6425c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ PersonalInfoAddActivity f22667a;

        C6425c(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f22667a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f22667a.onClick(view);
        }
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity) {
        this(personalInfoAddActivity, personalInfoAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PersonalInfoAddActivity personalInfoAddActivity = this.f22659a;
        if (personalInfoAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f22659a = null;
        personalInfoAddActivity.mIvBack = null;
        personalInfoAddActivity.mTvTitle = null;
        personalInfoAddActivity.mClArea = null;
        personalInfoAddActivity.mClAreaDetail = null;
        personalInfoAddActivity.mEtArea = null;
        personalInfoAddActivity.mEtAddres = null;
        personalInfoAddActivity.mBtnConfirm = null;
        this.f22660b.setOnClickListener(null);
        this.f22660b = null;
        this.f22661c.setOnClickListener(null);
        this.f22661c = null;
        this.f22662d.setOnClickListener(null);
        this.f22662d = null;
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity, View view) {
        this.f22659a = personalInfoAddActivity;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        personalInfoAddActivity.mIvBack = (ImageView) Utils.castView(findRequiredView, C2113R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f22660b = findRequiredView;
        findRequiredView.setOnClickListener(new C6423a(personalInfoAddActivity));
        personalInfoAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        personalInfoAddActivity.mClArea = Utils.findRequiredView(view, C2113R.id.cl_area_cont, "field 'mClArea'");
        personalInfoAddActivity.mClAreaDetail = Utils.findRequiredView(view, C2113R.id.cl_area_detail_content, "field 'mClAreaDetail'");
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.et_area, "field 'mEtArea' and method 'onClick'");
        personalInfoAddActivity.mEtArea = (TextView) Utils.castView(findRequiredView2, C2113R.id.et_area, "field 'mEtArea'", TextView.class);
        this.f22661c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6424b(personalInfoAddActivity));
        personalInfoAddActivity.mEtAddres = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_address, "field 'mEtAddres'", EditText.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.btn_confirm, "field 'mBtnConfirm' and method 'onClick'");
        personalInfoAddActivity.mBtnConfirm = (Button) Utils.castView(findRequiredView3, C2113R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f22662d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6425c(personalInfoAddActivity));
    }
}
