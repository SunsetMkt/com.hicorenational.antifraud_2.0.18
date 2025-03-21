package adapter;

import android.widget.ImageView;
import android.widget.TextView;
import bean.IDVarfyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class IDVarfyListAdapter extends BaseQuickAdapter<IDVarfyBean.Rows, BaseViewHolder> {

    /* renamed from: V */
    private List<IDVarfyBean.Rows> f235V;

    public IDVarfyListAdapter(List<IDVarfyBean.Rows> list) {
        super(C2113R.layout.item_idvarfy_list, list);
        this.f235V = list;
    }

    /* renamed from: a */
    public void m253a(List<IDVarfyBean.Rows> list) {
        this.f235V.clear();
        this.f235V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, IDVarfyBean.Rows rows) {
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_id_num);
        TextView textView2 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_idvarfy_time);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_state);
        textView.setText(rows.getIntivedMobile());
        if (rows.getVerifyStatus() == 0) {
            textView2.setText("过期时间：" + rows.getDeadline());
            imageView.setBackgroundResource(C2113R.drawable.iv_idvarfy_wait);
            return;
        }
        if (rows.getVerifyStatus() == 1) {
            textView2.setText("核实时间：" + rows.getVerifyTime());
            imageView.setBackgroundResource(C2113R.drawable.iv_idvarfy_ok);
            return;
        }
        if (rows.getVerifyStatus() == 2) {
            textView2.setText("过期时间：" + rows.getDeadline());
            imageView.setBackgroundResource(C2113R.drawable.iv_idvarfy_gq);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((IDVarfyListAdapter) baseViewHolder, i2);
    }
}
