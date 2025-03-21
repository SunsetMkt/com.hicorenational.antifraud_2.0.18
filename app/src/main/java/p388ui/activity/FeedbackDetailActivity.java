package p388ui.activity;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p388ui.callview.FeedbackDetailCallView;
import p388ui.presenter.FeedbackDetailPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;

/* loaded from: classes2.dex */
public class FeedbackDetailActivity extends BaseActivity implements FeedbackDetailCallView {
    private boolean isClickSolve = false;

    @BindView(C2113R.id.iv_not_solve)
    ImageView mIvNotSolve;

    @BindView(C2113R.id.iv_solve)
    ImageView mIvSolve;
    private FeedbackDetailPresenter mPresenter;

    @BindView(C2113R.id.tv_answer)
    TextView mTvAnswer;

    @BindView(C2113R.id.tv_go_feedback)
    TextView mTvGoFeedback;

    @BindView(C2113R.id.tv_not_solve_tip)
    TextView mTvNotSolveTip;

    @BindView(C2113R.id.tv_question)
    TextView mTvQuestion;

    @BindView(C2113R.id.tv_solve_tip)
    TextView mTvSolveTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    private void clickSolve(boolean z) {
        if (this.isClickSolve) {
            return;
        }
        this.isClickSolve = true;
        if (z) {
            this.mIvSolve.setImageResource(C2113R.mipmap.ic_solve_select);
            this.mTvSolveTip.setTextColor(getResources().getColor(C2113R.color.red_1));
        } else {
            this.mIvNotSolve.setImageResource(C2113R.mipmap.ic_not_solve_select);
            this.mTvNotSolveTip.setTextColor(getResources().getColor(C2113R.color.red_1));
        }
        this.mPresenter.getSolve(getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_ID), z);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("问题详情");
        String stringExtra = getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_QUESTION);
        String stringExtra2 = getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_ANSWER);
        this.mTvQuestion.setText(stringExtra);
        this.mTvAnswer.setText(stringExtra2);
        this.mTvGoFeedback.setText(Html.fromHtml("还没有解决您的问题？前往<font color=#2B4CFF>意见反馈</font>"));
        this.mPresenter = new FeedbackDetailPresenter(this.mActivity, this);
    }

    @Override // p388ui.callview.FeedbackDetailCallView
    public void onSuccessRequestt() {
        C7257b1.m26212b(this, false, 1, "谢谢您的反馈", C2113R.mipmap.ic_white_ok);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_solve, C2113R.id.ll_not_solve, C2113R.id.tv_go_feedback})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.ll_not_solve /* 2131296959 */:
                clickSolve(false);
                break;
            case C2113R.id.ll_solve /* 2131296988 */:
                clickSolve(true);
                break;
            case C2113R.id.tv_go_feedback /* 2131297559 */:
                startActivity(FeedbackActivity.class);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_feedback_question;
    }
}
