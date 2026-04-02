package com.luck.picture.lib.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PictureSelectionConfig config;
    private Context context;
    private OnPhotoSelectChangedListener imageSelectChangedListener;
    private boolean isGo;
    private boolean showCamera;
    private List<LocalMedia> images = new ArrayList();
    private List<LocalMedia> selectImages = new ArrayList();

    public class CameraViewHolder extends RecyclerView.ViewHolder {
        View headerView;
        TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            this.headerView = view;
            this.tvCamera = (TextView) view.findViewById(R.id.tvCamera);
            this.tvCamera.setText(PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.this.context.getString(R.string.picture_tape) : PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture));
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View btnCheck;
        View contentView;
        ImageView ivPicture;
        TextView tvCheck;
        TextView tvDuration;
        TextView tvIsGif;
        TextView tvLongChart;
        TextView tvName;

        public ViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
            this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
            this.btnCheck = view.findViewById(R.id.btnCheck);
            this.tvDuration = (TextView) view.findViewById(R.id.tv_duration);
            this.tvIsGif = (TextView) view.findViewById(R.id.tv_isGif);
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvLongChart = (TextView) view.findViewById(R.id.tv_long_chart);
            if (PictureImageGridAdapter.this.config.style == null || PictureImageGridAdapter.this.config.style.pictureCheckedStyle == 0) {
                return;
            }
            this.tvCheck.setBackgroundResource(PictureImageGridAdapter.this.config.style.pictureCheckedStyle);
        }
    }

    public PictureImageGridAdapter(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x02fe  */
    @SuppressLint({"StringFormatMatches"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void changeCheckboxState(ViewHolder viewHolder, LocalMedia localMedia) throws Throwable {
        int i2;
        int i3;
        boolean zIsSelected = viewHolder.tvCheck.isSelected();
        int size = this.selectImages.size();
        int i4 = 0;
        String mimeType = size > 0 ? this.selectImages.get(0).getMimeType() : "";
        if (this.config.isWithVideoImage) {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                if (PictureMimeType.eqVideo(this.selectImages.get(i7).getMimeType())) {
                    i6++;
                } else {
                    i5++;
                }
            }
            if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                int i8 = this.config.maxVideoSelectNum;
                if (i8 <= 0) {
                    Context context = this.context;
                    ToastUtils.s(context, context.getString(R.string.picture_rule));
                    return;
                }
                if (i6 >= i8 && !zIsSelected) {
                    Context context2 = this.context;
                    ToastUtils.s(context2, StringUtils.getMsg(context2, localMedia.getMimeType(), this.config.maxVideoSelectNum));
                    return;
                } else if (!zIsSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                    ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                    return;
                } else if (!zIsSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                    ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                    return;
                }
            }
            if (PictureMimeType.eqImage(localMedia.getMimeType()) && i5 >= this.config.maxSelectNum && !zIsSelected) {
                Context context3 = this.context;
                ToastUtils.s(context3, StringUtils.getMsg(context3, localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            }
        } else {
            if (!TextUtils.isEmpty(mimeType) && !PictureMimeType.isMimeTypeSame(mimeType, localMedia.getMimeType())) {
                Context context4 = this.context;
                ToastUtils.s(context4, context4.getString(R.string.picture_rule));
                return;
            }
            if (!PictureMimeType.eqVideo(mimeType) || (i2 = this.config.maxVideoSelectNum) <= 0) {
                int i9 = this.config.maxSelectNum;
                if (size >= i9 && !zIsSelected) {
                    Context context5 = this.context;
                    ToastUtils.s(context5, StringUtils.getMsg(context5, mimeType, i9));
                    return;
                } else if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                    if (!zIsSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                        ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!zIsSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                        ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                }
            } else if (size >= i2 && !zIsSelected) {
                Context context6 = this.context;
                ToastUtils.s(context6, StringUtils.getMsg(context6, mimeType, i2));
                return;
            } else if (!zIsSelected && this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                return;
            } else if (!zIsSelected && this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                return;
            }
        }
        if (zIsSelected) {
            while (i4 < size) {
                LocalMedia localMedia2 = this.selectImages.get(i4);
                if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                    this.selectImages.remove(localMedia2);
                    subSelectPosition();
                    AnimUtils.disZoom(viewHolder.ivPicture, this.config.zoomAnim);
                    break;
                }
                i4++;
            }
        } else {
            if (this.config.selectionMode == 1) {
                singleRadioMediaImage();
            }
            if (localMedia.getWidth() == 0 || localMedia.getHeight() == 0) {
                localMedia.setOrientation(-1);
                if (PictureMimeType.isContent(localMedia.getPath())) {
                    if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                        int[] videoSizeForUri = MediaUtils.getVideoSizeForUri(this.context, Uri.parse(localMedia.getPath()));
                        i4 = videoSizeForUri[0];
                        i3 = videoSizeForUri[1];
                    } else if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                        int[] imageSizeForUri = MediaUtils.getImageSizeForUri(this.context, Uri.parse(localMedia.getPath()));
                        i4 = imageSizeForUri[0];
                        i3 = imageSizeForUri[1];
                    } else {
                        i3 = 0;
                    }
                    localMedia.setWidth(i4);
                    localMedia.setHeight(i3);
                } else {
                    if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                        int[] videoSizeForUrl = MediaUtils.getVideoSizeForUrl(localMedia.getPath());
                        i4 = videoSizeForUrl[0];
                        i3 = videoSizeForUrl[1];
                    } else if (PictureMimeType.eqImage(localMedia.getMimeType())) {
                        int[] imageSizeForUrl = MediaUtils.getImageSizeForUrl(localMedia.getPath());
                        i4 = imageSizeForUrl[0];
                        i3 = imageSizeForUrl[1];
                    }
                    localMedia.setWidth(i4);
                    localMedia.setHeight(i3);
                }
            }
            MediaUtils.setOrientation(this.context, localMedia);
            this.selectImages.add(localMedia);
            localMedia.setNum(this.selectImages.size());
            VoiceUtils.getInstance().play();
            AnimUtils.zoom(viewHolder.ivPicture, this.config.zoomAnim);
            viewHolder.tvCheck.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.picture_anim_modal_in));
        }
        notifyItemChanged(viewHolder.getAdapterPosition());
        selectImage(viewHolder, !zIsSelected);
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectImages);
        }
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(String.valueOf(localMedia.getNum()));
            }
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectImages;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.isGo = true;
        int i2 = 0;
        LocalMedia localMedia = this.selectImages.get(0);
        if (this.config.isCamera || this.isGo) {
            i2 = localMedia.position;
        } else {
            int i3 = localMedia.position;
            if (i3 > 0) {
                i2 = i3 - 1;
            }
        }
        notifyItemChanged(i2);
        this.selectImages.clear();
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectImages.size();
            int i2 = 0;
            while (i2 < size) {
                LocalMedia localMedia = this.selectImages.get(i2);
                i2++;
                localMedia.setNum(i2);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    public /* synthetic */ void a(View view) {
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
    }

    public void bindImagesData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.images = list;
        notifyDataSetChanged();
    }

    public void bindSelectImages(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list.get(i2));
        }
        this.selectImages = arrayList;
        if (this.config.isSingleDirectReturn) {
            return;
        }
        subSelectPosition();
        OnPhotoSelectChangedListener onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectImages);
        }
    }

    public List<LocalMedia> getImages() {
        List<LocalMedia> list = this.images;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.showCamera ? this.images.size() + 1 : this.images.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.showCamera && i2 == 0) ? 1 : 2;
    }

    public List<LocalMedia> getSelectedImages() {
        List<LocalMedia> list = this.selectImages;
        return list == null ? new ArrayList() : list;
    }

    public int getSize() {
        List<LocalMedia> list = this.images;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.images;
        return list == null || list.size() == 0;
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@j.c.a.d RecyclerView.ViewHolder viewHolder, final int i2) {
        if (getItemViewType(i2) == 1) {
            ((CameraViewHolder) viewHolder).headerView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.a(view);
                }
            });
            return;
        }
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final LocalMedia localMedia = this.images.get(this.showCamera ? i2 - 1 : i2);
        localMedia.position = viewHolder2.getAdapterPosition();
        final String path = localMedia.getPath();
        final String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (!this.config.isSingleDirectReturn) {
            selectImage(viewHolder2, isSelected(localMedia));
        }
        boolean zIsGif = PictureMimeType.isGif(mimeType);
        viewHolder2.tvCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.btnCheck.setVisibility(this.config.isSingleDirectReturn ? 8 : 0);
        viewHolder2.tvIsGif.setVisibility(zIsGif ? 0 : 8);
        if (PictureMimeType.eqImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = MediaUtils.isLongImg(localMedia);
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean zEqVideo = PictureMimeType.eqVideo(mimeType);
        boolean zEqAudio = PictureMimeType.eqAudio(mimeType);
        if (zEqVideo || zEqAudio) {
            viewHolder2.tvDuration.setVisibility(0);
            viewHolder2.tvDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
            viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(zEqVideo ? R.drawable.picture_icon_video : R.drawable.picture_icon_audio, 0, 0, 0);
        } else {
            viewHolder2.tvDuration.setVisibility(8);
        }
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enablePreview || pictureSelectionConfig.enPreviewVideo || pictureSelectionConfig.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    this.a.a(path, mimeType, localMedia, viewHolder2, view);
                }
            });
        }
        viewHolder2.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                this.a.a(path, mimeType, i2, localMedia, viewHolder2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new CameraViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_item_camera, viewGroup, false)) : new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_image_grid_item, viewGroup, false));
    }

    public void selectImage(ViewHolder viewHolder, boolean z) {
        viewHolder.tvCheck.setSelected(z);
        if (z) {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, R.color.picture_color_80), PorterDuff.Mode.SRC_ATOP);
        } else {
            viewHolder.ivPicture.setColorFilter(ContextCompat.getColor(this.context, R.color.picture_color_20), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }

    public void setShowCamera(boolean z) {
        this.showCamera = z;
    }

    public /* synthetic */ void a(String str, String str2, LocalMedia localMedia, ViewHolder viewHolder, View view) throws Throwable {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            str = PictureFileUtils.getPath(this.context, Uri.parse(str));
        }
        if (!TextUtils.isEmpty(str) && !new File(str).exists()) {
            Context context = this.context;
            ToastUtils.s(context, PictureMimeType.s(context, str2));
        } else {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                localMedia.setRealPath(str);
            }
            MediaUtils.setOrientation(this.context, localMedia);
            changeCheckboxState(viewHolder, localMedia);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void a(String str, String str2, int i2, LocalMedia localMedia, ViewHolder viewHolder, View view) throws Throwable {
        boolean z;
        if (SdkVersionUtils.checkedAndroid_Q()) {
            str = PictureFileUtils.getPath(this.context, Uri.parse(str));
        }
        if (!TextUtils.isEmpty(str) && !new File(str).exists()) {
            Context context = this.context;
            ToastUtils.s(context, PictureMimeType.s(context, str2));
            return;
        }
        if (this.showCamera) {
            i2--;
        }
        if (i2 == -1) {
            return;
        }
        if (SdkVersionUtils.checkedAndroid_Q()) {
            localMedia.setRealPath(str);
        }
        MediaUtils.setOrientation(this.context, localMedia);
        if (!PictureMimeType.eqImage(str2) || !this.config.enablePreview) {
            if (PictureMimeType.eqVideo(str2)) {
                PictureSelectionConfig pictureSelectionConfig = this.config;
                if (pictureSelectionConfig.enPreviewVideo || pictureSelectionConfig.selectionMode == 1) {
                    z = true;
                } else {
                    if (PictureMimeType.eqAudio(str2)) {
                        PictureSelectionConfig pictureSelectionConfig2 = this.config;
                        if (pictureSelectionConfig2.enablePreviewAudio || pictureSelectionConfig2.selectionMode == 1) {
                        }
                    }
                    z = false;
                }
            }
        }
        if (z) {
            if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                if (this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                    ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                    return;
                } else if (this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                    ToastUtils.s(this.context, viewHolder.itemView.getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                    return;
                }
            }
            this.imageSelectChangedListener.onPictureClick(localMedia, i2);
            return;
        }
        changeCheckboxState(viewHolder, localMedia);
    }
}
