package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SurveyAudioActivity_ViewBinding implements Unbinder {
    private SurveyAudioActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f13892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f13893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f13894e;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ SurveyAudioActivity a;

        a(SurveyAudioActivity surveyAudioActivity) {
            this.a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {
        final /* synthetic */ SurveyAudioActivity a;

        b(SurveyAudioActivity surveyAudioActivity) {
            this.a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {
        final /* synthetic */ SurveyAudioActivity a;

        c(SurveyAudioActivity surveyAudioActivity) {
            this.a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {
        final /* synthetic */ SurveyAudioActivity a;

        d(SurveyAudioActivity surveyAudioActivity) {
            this.a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity) {
        this(surveyAudioActivity, surveyAudioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SurveyAudioActivity surveyAudioActivity = this.a;
        if (surveyAudioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        surveyAudioActivity.mTvTitle = null;
        surveyAudioActivity.mRecyclerview = null;
        surveyAudioActivity.mTvAdd = null;
        surveyAudioActivity.mRecyclerviewSuspect = null;
        surveyAudioActivity.mBtnCommit = null;
        surveyAudioActivity.mTvSuspectTip = null;
        surveyAudioActivity.mLlAddBtn = null;
        this.f13891b.setOnClickListener(null);
        this.f13891b = null;
        this.f13892c.setOnClickListener(null);
        this.f13892c = null;
        this.f13893d.setOnClickListener(null);
        this.f13893d = null;
        this.f13894e.setOnClickListener(null);
        this.f13894e = null;
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity, View view) {
        this.a = surveyAudioActivity;
        surveyAudioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        surveyAudioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        surveyAudioActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        surveyAudioActivity.mRecyclerviewSuspect = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_suspect, "field 'mRecyclerviewSuspect'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        surveyAudioActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f13891b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(surveyAudioActivity));
        surveyAudioActivity.mTvSuspectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_suspect_tip, "field 'mTvSuspectTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add_suspect, "field 'mLlAddBtn' and method 'onViewClicked'");
        surveyAudioActivity.mLlAddBtn = viewFindRequiredView2;
        this.f13892c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(surveyAudioActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13893d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(surveyAudioActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_add, "method 'onViewClicked'");
        this.f13894e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(surveyAudioActivity));
    }
}
