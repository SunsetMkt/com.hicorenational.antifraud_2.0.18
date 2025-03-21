package adapter;

import android.text.TextUtils;
import bean.CallBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class CallNewAdapter extends BaseQuickAdapter<CallBean, BaseViewHolder> {
    public CallNewAdapter(int i2, List<CallBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CallBean callBean) {
        baseViewHolder.m5211a(C2113R.id.tv_phone, (CharSequence) callBean.getNumber()).m5211a(C2113R.id.tv_occur_time, (CharSequence) callBean.getCrime_time()).m5211a(C2113R.id.tv_duration, (CharSequence) callBean.getTalkTime()).m5194a(C2113R.id.iv_edit).m5194a(C2113R.id.iv_clear);
        if (TextUtils.isEmpty(callBean.getVictimTel())) {
            baseViewHolder.m5224c(C2113R.id.group_victim).setVisibility(8);
        } else {
            baseViewHolder.m5224c(C2113R.id.group_victim).setVisibility(0);
            baseViewHolder.m5211a(C2113R.id.tv_victim_phone, (CharSequence) callBean.getVictimTel());
        }
    }
}
