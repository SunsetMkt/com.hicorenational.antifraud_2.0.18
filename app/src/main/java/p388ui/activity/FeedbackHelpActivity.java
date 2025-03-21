package p388ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.QABean;
import bean.QATypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.tools.AnimUtils;
import java.util.List;
import p388ui.callview.FeedbackHelpCallView;
import p388ui.presenter.FeedbackHelpPresenter;
import p388ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class FeedbackHelpActivity extends BaseActivity implements FeedbackHelpCallView {
    public static final String EXTRA_ANSWER = "extra_answer";
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_QUESTION = "extra_question";

    @BindView(C2113R.id.ll_qa_content)
    LinearLayout mLlQaContent;
    private FeedbackHelpPresenter mPresenter;
    private List<QATypeBean> mQAList = null;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.FeedbackHelpActivity$a */
    class ViewOnClickListenerC6308a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ QABean f22323a;

        ViewOnClickListenerC6308a(QABean qABean) {
            this.f22323a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f22323a);
        }
    }

    /* renamed from: ui.activity.FeedbackHelpActivity$b */
    class ViewOnClickListenerC6309b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ QABean f22325a;

        ViewOnClickListenerC6309b(QABean qABean) {
            this.f22325a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f22325a);
        }
    }

    /* renamed from: ui.activity.FeedbackHelpActivity$c */
    class ViewOnClickListenerC6310c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ QABean f22327a;

        ViewOnClickListenerC6310c(QABean qABean) {
            this.f22327a = qABean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedbackHelpActivity.this.intentDetail(this.f22327a);
        }
    }

    /* renamed from: ui.activity.FeedbackHelpActivity$d */
    class ViewOnClickListenerC6311d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ LinearLayout f22329a;

        /* renamed from: b */
        final /* synthetic */ ImageView f22330b;

        ViewOnClickListenerC6311d(LinearLayout linearLayout, ImageView imageView) {
            this.f22329a = linearLayout;
            this.f22330b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f22329a.getVisibility() == 8) {
                this.f22329a.setVisibility(0);
                AnimUtils.rotateArrowUpOrDown(this.f22330b, false);
            } else {
                this.f22329a.setVisibility(8);
                AnimUtils.rotateArrowUpOrDown(this.f22330b, true);
            }
        }
    }

    /* renamed from: ui.activity.FeedbackHelpActivity$e */
    class RunnableC6312e implements Runnable {
        RunnableC6312e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedbackHelpActivity.this.initQAView();
        }
    }

    private void addView(QATypeBean qATypeBean, boolean z) throws Exception {
        ViewGroup viewGroup = null;
        View inflate = View.inflate(this, C2113R.layout.item_qa, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C2113R.id.ll_type);
        TextView textView = (TextView) inflate.findViewById(C2113R.id.type_name);
        ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.iv_type_arrow);
        TextView textView2 = (TextView) inflate.findViewById(C2113R.id.tv_content_1);
        View findViewById = inflate.findViewById(C2113R.id.inc_content_2);
        int i2 = C2113R.id.tv_content;
        TextView textView3 = (TextView) findViewById.findViewById(C2113R.id.tv_content);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(C2113R.id.tv_content_more);
        View findViewById2 = inflate.findViewById(C2113R.id.botton_line);
        if (qATypeBean.getQaList() != null && qATypeBean.getQaList().size() > 0) {
            int i3 = 0;
            while (i3 < qATypeBean.getQaList().size()) {
                QABean qABean = qATypeBean.getQaList().get(i3);
                if (i3 == 0) {
                    textView2.setText(qABean.getQuestion());
                    textView2.setOnClickListener(new ViewOnClickListenerC6308a(qABean));
                } else if (i3 == 1) {
                    String question = qABean.getQuestion();
                    if (TextUtils.isEmpty(question)) {
                        findViewById.setVisibility(8);
                    } else {
                        textView3.setText(question);
                        textView3.setOnClickListener(new ViewOnClickListenerC6309b(qABean));
                    }
                } else {
                    View inflate2 = View.inflate(this, C2113R.layout.layout_qa, viewGroup);
                    TextView textView4 = (TextView) inflate2.findViewById(i2);
                    textView4.setText(qABean.getQuestion());
                    textView4.setOnClickListener(new ViewOnClickListenerC6310c(qABean));
                    linearLayout2.addView(inflate2);
                }
                i3++;
                viewGroup = null;
                i2 = C2113R.id.tv_content;
            }
        }
        textView.setText(qATypeBean.getText());
        linearLayout.setOnClickListener(new ViewOnClickListenerC6311d(linearLayout2, imageView));
        if (z) {
            findViewById2.setVisibility(4);
        }
        linearLayout2.setVisibility(0);
        this.mLlQaContent.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initQAView() {
        try {
            if (this.mQAList != null && this.mQAList.size() > 0) {
                int i2 = 0;
                while (i2 < this.mQAList.size()) {
                    int i3 = i2 + 1;
                    addView(this.mQAList.get(i2), i3 == this.mQAList.size());
                    i2 = i3;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentDetail(QABean qABean) {
        if (isDouble()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FeedbackDetailActivity.class);
        intent.putExtra(EXTRA_ID, qABean.getId());
        intent.putExtra(EXTRA_QUESTION, qABean.getQuestion());
        intent.putExtra(EXTRA_ANSWER, qABean.getAnswer());
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("反馈与帮助");
        this.mPresenter = new FeedbackHelpPresenter(this.mActivity, this);
        this.mPresenter.getQAList();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // p388ui.callview.FeedbackHelpCallView
    public void onSuccessRequest(List<QATypeBean> list) {
        this.mQAList = list;
        this.mLlQaContent.post(new RunnableC6312e());
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_feedback})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
        } else {
            if (id != C2113R.id.tv_feedback) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) FeedbackActivity.class));
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_feedback_help;
    }
}
