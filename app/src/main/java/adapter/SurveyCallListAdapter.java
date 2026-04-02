package adapter;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import bean.SurveyCallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SurveyCallListAdapter extends BaseQuickAdapter<SurveyCallBean, BaseViewHolder> {
    public SurveyCallListAdapter(int i2, @Nullable List<SurveyCallBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, SurveyCallBean surveyCallBean) {
        String startTime = surveyCallBean.getStartTime();
        String description = surveyCallBean.getDescription();
        if (TextUtils.isEmpty(description)) {
            description = "\u65e0";
        }
        baseViewHolder.a(R.id.et_call, (CharSequence) surveyCallBean.getTelNumber()).a(R.id.tv_time, (CharSequence) startTime).a(R.id.tv_call_content, (CharSequence) ("\u901a\u8bdd\u5185\u5bb9\uff1a" + description));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        baseViewHolder.a(R.id.tv_item_label, (CharSequence) ("\u6d89\u8bc8\u7535\u8bdd" + (i2 + 1))).a(R.id.iv_edit);
    }
}
