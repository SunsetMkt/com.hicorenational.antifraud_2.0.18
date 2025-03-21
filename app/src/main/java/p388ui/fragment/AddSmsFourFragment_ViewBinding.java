package p388ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class AddSmsFourFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AddSmsFourFragment f23748a;

    /* renamed from: b */
    private View f23749b;

    /* renamed from: c */
    private View f23750c;

    /* renamed from: d */
    private View f23751d;

    /* renamed from: ui.fragment.AddSmsFourFragment_ViewBinding$a */
    class C6834a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsFourFragment f23752a;

        C6834a(AddSmsFourFragment addSmsFourFragment) {
            this.f23752a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23752a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.AddSmsFourFragment_ViewBinding$b */
    class C6835b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsFourFragment f23754a;

        C6835b(AddSmsFourFragment addSmsFourFragment) {
            this.f23754a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23754a.onViewClicked(view);
        }
    }

    /* renamed from: ui.fragment.AddSmsFourFragment_ViewBinding$c */
    class C6836c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ AddSmsFourFragment f23756a;

        C6836c(AddSmsFourFragment addSmsFourFragment) {
            this.f23756a = addSmsFourFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23756a.onViewClicked(view);
        }
    }

    @UiThread
    public AddSmsFourFragment_ViewBinding(AddSmsFourFragment addSmsFourFragment, View view) {
        this.f23748a = addSmsFourFragment;
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        addSmsFourFragment.mBtnCommit = (TextView) Utils.castView(findRequiredView, C2113R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f23749b = findRequiredView;
        findRequiredView.setOnClickListener(new C6834a(addSmsFourFragment));
        addSmsFourFragment.mEtDescribe = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_describe, "field 'mEtDescribe'", EditText.class);
        addSmsFourFragment.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        addSmsFourFragment.mTvTime = (TextView) Utils.castView(findRequiredView2, C2113R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f23750c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6835b(addSmsFourFragment));
        addSmsFourFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.tv_brand, "field 'mTvBrand' and method 'onViewClicked'");
        addSmsFourFragment.mTvBrand = (TextView) Utils.castView(findRequiredView3, C2113R.id.tv_brand, "field 'mTvBrand'", TextView.class);
        this.f23751d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6836c(addSmsFourFragment));
        addSmsFourFragment.mEtBrandOther = (EditText) Utils.findRequiredViewAsType(view, C2113R.id.et_brand_other, "field 'mEtBrandOther'", EditText.class);
        addSmsFourFragment.mGpBrandOther = (Group) Utils.findRequiredViewAsType(view, C2113R.id.gp_brand_other, "field 'mGpBrandOther'", Group.class);
        addSmsFourFragment.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, C2113R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        addSmsFourFragment.mTvTipPicture = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_tip_picture, "field 'mTvTipPicture'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddSmsFourFragment addSmsFourFragment = this.f23748a;
        if (addSmsFourFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23748a = null;
        addSmsFourFragment.mBtnCommit = null;
        addSmsFourFragment.mEtDescribe = null;
        addSmsFourFragment.mEtVictimPhone = null;
        addSmsFourFragment.mTvTime = null;
        addSmsFourFragment.mRecyclerview = null;
        addSmsFourFragment.mTvBrand = null;
        addSmsFourFragment.mEtBrandOther = null;
        addSmsFourFragment.mGpBrandOther = null;
        addSmsFourFragment.mLlPicture = null;
        addSmsFourFragment.mTvTipPicture = null;
        this.f23749b.setOnClickListener(null);
        this.f23749b = null;
        this.f23750c.setOnClickListener(null);
        this.f23750c = null;
        this.f23751d.setOnClickListener(null);
        this.f23751d = null;
    }
}
