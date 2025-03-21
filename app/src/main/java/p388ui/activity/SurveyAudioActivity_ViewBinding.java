package p388ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class SurveyAudioActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SurveyAudioActivity f23250a;

    /* renamed from: b */
    private View f23251b;

    /* renamed from: c */
    private View f23252c;

    /* renamed from: d */
    private View f23253d;

    /* renamed from: e */
    private View f23254e;

    /* renamed from: ui.activity.SurveyAudioActivity_ViewBinding$a */
    class C6617a extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SurveyAudioActivity f23255a;

        C6617a(SurveyAudioActivity surveyAudioActivity) {
            this.f23255a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23255a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SurveyAudioActivity_ViewBinding$b */
    class C6618b extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SurveyAudioActivity f23257a;

        C6618b(SurveyAudioActivity surveyAudioActivity) {
            this.f23257a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23257a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SurveyAudioActivity_ViewBinding$c */
    class C6619c extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SurveyAudioActivity f23259a;

        C6619c(SurveyAudioActivity surveyAudioActivity) {
            this.f23259a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23259a.onViewClicked(view);
        }
    }

    /* renamed from: ui.activity.SurveyAudioActivity_ViewBinding$d */
    class C6620d extends DebouncingOnClickListener {

        /* renamed from: a */
        final /* synthetic */ SurveyAudioActivity f23261a;

        C6620d(SurveyAudioActivity surveyAudioActivity) {
            this.f23261a = surveyAudioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f23261a.onViewClicked(view);
        }
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity) {
        this(surveyAudioActivity, surveyAudioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SurveyAudioActivity surveyAudioActivity = this.f23250a;
        if (surveyAudioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f23250a = null;
        surveyAudioActivity.mTvTitle = null;
        surveyAudioActivity.mRecyclerview = null;
        surveyAudioActivity.mTvAdd = null;
        surveyAudioActivity.mRecyclerviewSuspect = null;
        surveyAudioActivity.mBtnCommit = null;
        surveyAudioActivity.mTvSuspectTip = null;
        surveyAudioActivity.mLlAddBtn = null;
        this.f23251b.setOnClickListener(null);
        this.f23251b = null;
        this.f23252c.setOnClickListener(null);
        this.f23252c = null;
        this.f23253d.setOnClickListener(null);
        this.f23253d = null;
        this.f23254e.setOnClickListener(null);
        this.f23254e = null;
    }

    @UiThread
    public SurveyAudioActivity_ViewBinding(SurveyAudioActivity surveyAudioActivity, View view) {
        this.f23250a = surveyAudioActivity;
        surveyAudioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_title, "field 'mTvTitle'", TextView.class);
        surveyAudioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        surveyAudioActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_add, "field 'mTvAdd'", TextView.class);
        surveyAudioActivity.mRecyclerviewSuspect = (RecyclerView) Utils.findRequiredViewAsType(view, C2113R.id.recyclerview_suspect, "field 'mRecyclerviewSuspect'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, C2113R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        surveyAudioActivity.mBtnCommit = (Button) Utils.castView(findRequiredView, C2113R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f23251b = findRequiredView;
        findRequiredView.setOnClickListener(new C6617a(surveyAudioActivity));
        surveyAudioActivity.mTvSuspectTip = (TextView) Utils.findRequiredViewAsType(view, C2113R.id.tv_suspect_tip, "field 'mTvSuspectTip'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, C2113R.id.ll_add_suspect, "field 'mLlAddBtn' and method 'onViewClicked'");
        surveyAudioActivity.mLlAddBtn = findRequiredView2;
        this.f23252c = findRequiredView2;
        findRequiredView2.setOnClickListener(new C6618b(surveyAudioActivity));
        View findRequiredView3 = Utils.findRequiredView(view, C2113R.id.iv_back, "method 'onViewClicked'");
        this.f23253d = findRequiredView3;
        findRequiredView3.setOnClickListener(new C6619c(surveyAudioActivity));
        View findRequiredView4 = Utils.findRequiredView(view, C2113R.id.ll_add, "method 'onViewClicked'");
        this.f23254e = findRequiredView4;
        findRequiredView4.setOnClickListener(new C6620d(surveyAudioActivity));
    }
}
