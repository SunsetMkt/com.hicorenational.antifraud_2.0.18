package ui.activity;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.callview.FeedbackDetailCallView;
import ui.presenter.FeedbackDetailPresenter;
import ui.view.swip.SwipBackLayout;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackDetailActivity extends BaseActivity implements FeedbackDetailCallView {
    private boolean isClickSolve = false;

    @BindView(R.id.iv_not_solve)
    ImageView mIvNotSolve;

    @BindView(R.id.iv_solve)
    ImageView mIvSolve;
    private FeedbackDetailPresenter mPresenter;

    @BindView(R.id.tv_answer)
    TextView mTvAnswer;

    @BindView(R.id.tv_go_feedback)
    TextView mTvGoFeedback;

    @BindView(R.id.tv_not_solve_tip)
    TextView mTvNotSolveTip;

    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    @BindView(R.id.tv_solve_tip)
    TextView mTvSolveTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void clickSolve(boolean z) {
        if (this.isClickSolve) {
            return;
        }
        this.isClickSolve = true;
        if (z) {
            this.mIvSolve.setImageResource(R.mipmap.ic_solve_select);
            this.mTvSolveTip.setTextColor(getResources().getColor(R.color.red_1));
        } else {
            this.mIvNotSolve.setImageResource(R.mipmap.ic_not_solve_select);
            this.mTvNotSolveTip.setTextColor(getResources().getColor(R.color.red_1));
        }
        this.mPresenter.getSolve(getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_ID), z);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("\u95ee\u9898\u8be6\u60c5");
        String stringExtra = getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_QUESTION);
        String stringExtra2 = getIntent().getStringExtra(FeedbackHelpActivity.EXTRA_ANSWER);
        this.mTvQuestion.setText(stringExtra);
        this.mTvAnswer.setText(stringExtra2);
        this.mTvGoFeedback.setText(Html.fromHtml("\u8fd8\u6ca1\u6709\u89e3\u51b3\u60a8\u7684\u95ee\u9898\uff1f\u524d\u5f80<font color=#2B4CFF>\u610f\u89c1\u53cd\u9988</font>"));
        this.mPresenter = new FeedbackDetailPresenter(this.mActivity, this);
    }

    @Override // ui.callview.FeedbackDetailCallView
    public void onSuccessRequestt() {
        util.f1.b(this, false, 1, "\u8c22\u8c22\u60a8\u7684\u53cd\u9988", R.mipmap.ic_white_ok);
    }

    @OnClick({R.id.iv_back, R.id.ll_solve, R.id.ll_not_solve, R.id.tv_go_feedback})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296808 */:
                finish();
                break;
            case R.id.ll_not_solve /* 2131297009 */:
                clickSolve(false);
                break;
            case R.id.ll_solve /* 2131297038 */:
                clickSolve(true);
                break;
            case R.id.tv_go_feedback /* 2131297718 */:
                startActivity(FeedbackActivity.class);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_feedback_question;
    }
}
