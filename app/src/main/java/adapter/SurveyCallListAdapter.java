package adapter;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import bean.SurveyCallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class SurveyCallListAdapter extends BaseQuickAdapter<SurveyCallBean, BaseViewHolder> {
    public SurveyCallListAdapter(int i2, @Nullable List<SurveyCallBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, SurveyCallBean surveyCallBean) {
        String startTime = surveyCallBean.getStartTime();
        String description = surveyCallBean.getDescription();
        if (TextUtils.isEmpty(description)) {
            description = "无";
        }
        baseViewHolder.m5211a(C2113R.id.et_call, (CharSequence) surveyCallBean.getTelNumber()).m5211a(C2113R.id.tv_time, (CharSequence) startTime).m5211a(C2113R.id.tv_call_content, (CharSequence) ("通话内容：" + description));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((SurveyCallListAdapter) baseViewHolder, i2);
        baseViewHolder.m5211a(C2113R.id.tv_item_label, (CharSequence) ("涉诈电话" + (i2 + 1))).m5194a(C2113R.id.iv_edit);
    }
}
