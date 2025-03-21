package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        this.mFragmentWhos = new ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            FragmentTransaction.C0547Op c0547Op = backStackRecord.mOps.get(i2);
            int i4 = i3 + 1;
            this.mOps[i3] = c0547Op.mCmd;
            ArrayList<String> arrayList = this.mFragmentWhos;
            Fragment fragment = c0547Op.mFragment;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.mOps;
            int i5 = i4 + 1;
            iArr[i4] = c0547Op.mEnterAnim;
            int i6 = i5 + 1;
            iArr[i5] = c0547Op.mExitAnim;
            int i7 = i6 + 1;
            iArr[i6] = c0547Op.mPopEnterAnim;
            iArr[i7] = c0547Op.mPopExitAnim;
            this.mOldMaxLifecycleStates[i2] = c0547Op.mOldMaxState.ordinal();
            this.mCurrentMaxLifecycleStates[i2] = c0547Op.mCurrentMaxState.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.mTransition = backStackRecord.mTransition;
        this.mTransitionStyle = backStackRecord.mTransitionStyle;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
        this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
        this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mOps.length) {
            FragmentTransaction.C0547Op c0547Op = new FragmentTransaction.C0547Op();
            int i4 = i2 + 1;
            c0547Op.mCmd = this.mOps[i2];
            if (FragmentManagerImpl.DEBUG) {
                String str = "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + this.mOps[i4];
            }
            String str2 = this.mFragmentWhos.get(i3);
            if (str2 != null) {
                c0547Op.mFragment = fragmentManagerImpl.mActive.get(str2);
            } else {
                c0547Op.mFragment = null;
            }
            c0547Op.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i3]];
            c0547Op.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i3]];
            int[] iArr = this.mOps;
            int i5 = i4 + 1;
            c0547Op.mEnterAnim = iArr[i4];
            int i6 = i5 + 1;
            c0547Op.mExitAnim = iArr[i5];
            int i7 = i6 + 1;
            c0547Op.mPopEnterAnim = iArr[i6];
            c0547Op.mPopExitAnim = iArr[i7];
            backStackRecord.mEnterAnim = c0547Op.mEnterAnim;
            backStackRecord.mExitAnim = c0547Op.mExitAnim;
            backStackRecord.mPopEnterAnim = c0547Op.mPopEnterAnim;
            backStackRecord.mPopExitAnim = c0547Op.mPopExitAnim;
            backStackRecord.addOp(c0547Op);
            i3++;
            i2 = i7 + 1;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
