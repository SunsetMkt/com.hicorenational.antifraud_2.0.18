package adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadFileBean;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.activity.PreviewPictureActivity;

/* JADX INFO: loaded from: classes.dex */
public class PicturePreviewAdapter extends RecyclerView.Adapter<ListiewHolder> {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<UploadFileBean> f1139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<LocalMedia> f1140c = new ArrayList<>();

    public class ListiewHolder extends RecyclerView.ViewHolder {
        public ImageView a;

        public ListiewHolder(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.picture_select);
        }
    }

    public PicturePreviewAdapter(Context context, List<UploadFileBean> list) {
        this.f1139b = new ArrayList();
        this.a = context;
        if (this.f1139b != null) {
            this.f1139b = list;
            a();
        }
    }

    private void a() {
        for (int i2 = 0; i2 < this.f1139b.size(); i2++) {
            LocalMedia localMedia = new LocalMedia();
            String fileUrl = this.f1139b.get(i2).getFileUrl();
            if (TextUtils.isEmpty(fileUrl)) {
                localMedia.setPath(this.f1139b.get(i2).getFilePath());
            } else {
                localMedia.setPath(fileUrl);
            }
            localMedia.setFileName(this.f1139b.get(i2).getFileName());
            this.f1140c.add(localMedia);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f1139b.size();
    }

    public void setData(List<UploadFileBean> list) {
        this.f1139b = list;
        a();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ListiewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ListiewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_picture, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ListiewHolder listiewHolder, final int i2) {
        UploadFileBean uploadFileBean;
        if (this.f1139b.size() > 0 && (uploadFileBean = this.f1139b.get(i2)) != null) {
            if (!TextUtils.isEmpty(uploadFileBean.getFileUrl())) {
                k.d.a(this.a, uploadFileBean.getFileUrl(), listiewHolder.a, 4);
            } else if (!TextUtils.isEmpty(uploadFileBean.getFilePath())) {
                k.d.a(this.a, uploadFileBean.getFilePath(), listiewHolder.a, 4);
            }
        }
        listiewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(i2, view);
            }
        });
    }

    public /* synthetic */ void a(int i2, View view) {
        Intent intent = new Intent(this.a, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f13585f, this.f1140c);
        intent.putExtra(PreviewPictureActivity.f13586g, i2);
        this.a.startActivity(intent);
    }
}
