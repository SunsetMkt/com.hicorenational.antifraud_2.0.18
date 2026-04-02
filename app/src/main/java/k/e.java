package k;

import android.app.Activity;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;

/* JADX INFO: compiled from: PictureLib.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b */
    private static PictureParameterStyle f12657b;

    /* JADX INFO: renamed from: c */
    private static PictureCropParameterStyle f12658c;

    /* JADX INFO: renamed from: g */
    private static boolean f12662g;
    private static int a = PictureMimeType.ofImage();

    /* JADX INFO: renamed from: d */
    private static PictureWindowAnimationStyle f12659d = new PictureWindowAnimationStyle();

    /* JADX INFO: renamed from: e */
    private static int f12660e = R.style.picture_default_style;

    /* JADX INFO: renamed from: f */
    private static boolean f12661f = false;

    /* JADX INFO: renamed from: h */
    private static boolean f12663h = true;

    public static PictureSelectionModel a(Activity activity, long j2, int i2, int i3) {
        f12660e = R.style.picture_default_style;
        f12661f = false;
        f12662g = false;
        a(activity);
        return c(activity, j2, i2, i3);
    }

    public static PictureSelectionModel b(Activity activity, long j2, int i2, int i3) {
        f12660e = 2131886848;
        f12661f = true;
        f12662g = true;
        b(activity);
        return c(activity, j2, i2, i3);
    }

    private static PictureSelectionModel c(Activity activity, long j2, int i2, int i3) {
        return PictureSelector.create(activity).openGallery(i2).loadImageEngine(b.a()).theme(f12660e).isWeChatStyle(f12661f).setLanguage(-1).setPictureStyle(f12657b).setPictureCropStyle(f12658c).setPictureWindowAnimationStyle(f12659d).isWithVideoImage(true).loadCacheResourcesCallback(a.a()).maxSelectNum(i3).minSelectNum(1).maxVideoSelectNum(i3).imageSpanCount(4).isReturnEmpty(false).setRequestedOrientation(1).previewImage(true).previewVideo(true).enablePreviewAudio(true).isCamera(f12663h).isZoomAnim(true).isGif(true).cutOutQuality(90).enableCrop(f12662g).freeStyleCropEnabled(true).showCropFrame(true).showCropGrid(true).queryMaxFileSize((int) j2).minimumCompressSize(100);
    }

    public static PictureSelectionModel a(Activity activity, long j2, int i2, int i3, boolean z) {
        f12660e = R.style.picture_default_style;
        f12661f = false;
        f12662g = false;
        f12663h = z;
        a(activity);
        return c(activity, j2, i2, i3);
    }

    private static void b(Activity activity) {
        f12657b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f12657b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = true;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f12657b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        f12657b.pictureContainerBackgroundColor = ContextCompat.getColor(activity, R.color.app_color_black);
        PictureParameterStyle pictureParameterStyle2 = f12657b;
        pictureParameterStyle2.pictureTitleUpResId = R.drawable.picture_icon_wechat_up;
        pictureParameterStyle2.pictureTitleDownResId = R.drawable.picture_icon_wechat_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = R.drawable.picture_icon_close;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.pictureCancelTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f12657b.pictureRightDefaultTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f12657b.pictureRightSelectedTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f12657b;
        pictureParameterStyle3.pictureUnCompleteBackgroundStyle = R.drawable.picture_send_button_default_bg;
        pictureParameterStyle3.pictureCompleteBackgroundStyle = R.drawable.picture_send_button_bg;
        pictureParameterStyle3.pictureCheckedStyle = R.drawable.picture_wechat_num_selector;
        pictureParameterStyle3.pictureWeChatTitleBackgroundStyle = R.drawable.picture_album_bg;
        pictureParameterStyle3.pictureWeChatChooseStyle = R.drawable.picture_wechat_select_cb;
        pictureParameterStyle3.pictureWeChatLeftBackStyle = R.drawable.picture_icon_back;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f12657b;
        pictureParameterStyle4.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_9b);
        f12657b.pictureCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_53575e);
        f12657b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_half_grey);
        PictureParameterStyle pictureParameterStyle5 = f12657b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, R.color.app_color_white);
        PictureParameterStyle pictureParameterStyle6 = f12657b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
        f12658c = new PictureCropParameterStyle(ContextCompat.getColor(activity, R.color.app_color_grey), ContextCompat.getColor(activity, R.color.app_color_grey), Color.parseColor("#393a3e"), ContextCompat.getColor(activity, R.color.app_color_white), f12657b.isChangeStatusBarFontColor);
    }

    public static PictureSelectionModel a(Fragment fragment, long j2, int i2, int i3) {
        return PictureSelector.create(fragment).openGallery(i2).loadImageEngine(b.a()).loadCacheResourcesCallback(a.a()).previewImage(true).previewVideo(true).enablePreviewAudio(true).maxSelectNum(i3).imageSpanCount(4).queryMaxFileSize((int) j2).minimumCompressSize(100);
    }

    private static void a(Activity activity) {
        if (f12657b != null) {
            return;
        }
        f12657b = new PictureParameterStyle();
        PictureParameterStyle pictureParameterStyle = f12657b;
        pictureParameterStyle.isChangeStatusBarFontColor = false;
        pictureParameterStyle.isOpenCompletedNumStyle = false;
        pictureParameterStyle.isOpenCheckNumStyle = false;
        pictureParameterStyle.pictureStatusBarColor = Color.parseColor("#393a3e");
        f12657b.pictureTitleBarBackgroundColor = Color.parseColor("#393a3e");
        PictureParameterStyle pictureParameterStyle2 = f12657b;
        pictureParameterStyle2.pictureTitleUpResId = R.drawable.picture_icon_arrow_up;
        pictureParameterStyle2.pictureTitleDownResId = R.drawable.picture_icon_arrow_down;
        pictureParameterStyle2.pictureFolderCheckedDotStyle = R.drawable.picture_orange_oval;
        pictureParameterStyle2.pictureLeftBackIcon = R.drawable.picture_icon_back;
        pictureParameterStyle2.pictureTitleTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.pictureCancelTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        PictureParameterStyle pictureParameterStyle3 = f12657b;
        pictureParameterStyle3.pictureCheckedStyle = R.drawable.picture_checkbox_selector;
        pictureParameterStyle3.pictureBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle4 = f12657b;
        pictureParameterStyle4.pictureCheckNumBgStyle = R.drawable.picture_num_oval;
        pictureParameterStyle4.picturePreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_fa632d);
        f12657b.pictureUnPreviewTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.pictureCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_fa632d);
        f12657b.pictureUnCompleteTextColor = ContextCompat.getColor(activity, R.color.picture_color_white);
        f12657b.picturePreviewBottomBgColor = ContextCompat.getColor(activity, R.color.picture_color_grey);
        PictureParameterStyle pictureParameterStyle5 = f12657b;
        pictureParameterStyle5.pictureExternalPreviewDeleteStyle = R.drawable.picture_icon_delete;
        pictureParameterStyle5.pictureOriginalControlStyle = R.drawable.picture_original_wechat_checkbox;
        pictureParameterStyle5.pictureOriginalFontColor = ContextCompat.getColor(activity, R.color.white);
        PictureParameterStyle pictureParameterStyle6 = f12657b;
        pictureParameterStyle6.pictureExternalPreviewGonePreviewDelete = true;
        pictureParameterStyle6.pictureNavBarColor = Color.parseColor("#393a3e");
    }
}
