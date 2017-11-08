package fiot.iot.babymonitor.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by hay on 11/8/17.
 */

public class DialogUtils {
    private static SweetAlertDialog mDialog;

    private static void showDialog(final Context mContext, final int alertType, final String title,
                                   final String content, final String confirmText, final String cancelText,
                                   final SweetAlertDialog.OnSweetClickListener mConfirmListener,
                                   final SweetAlertDialog.OnSweetClickListener mCancelListener) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    dismissDialog();
                    mDialog = new SweetAlertDialog(mContext, alertType);
                    mDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    mDialog.setTitleText(title);
                    mDialog.setContentText(content);
                    mDialog.setConfirmText(confirmText);
                    mDialog.setCancelText(cancelText);
                    mDialog.setConfirmClickListener(mConfirmListener);
                    mDialog.setCancelClickListener(mCancelListener);
                    mDialog.setCancelable(false);
                    mDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void showProgressDialog(final Context mContext) {
        showDialog(mContext, SweetAlertDialog.PROGRESS_TYPE, "Processing", "Please wait...",
                null, null, null, null);
    }


    public static void showSuccessDialog(final Context mContext, final String content) {
        showDialog(mContext, SweetAlertDialog.SUCCESS_TYPE, "Success", content,
                null, null, null, null);
    }

    public static void showWarningDialog(final Context mContext, final String content) {
        showDialog(mContext, SweetAlertDialog.WARNING_TYPE, "Warning",
                content, null, null, null, null);
    }

    public static void showWarningDialog(final Context mContext, final String content, String confirmText,
                                         String cancelText, SweetAlertDialog.OnSweetClickListener confirmListener) {
        showDialog(mContext, SweetAlertDialog.WARNING_TYPE, "Warning",
                content, confirmText, cancelText, confirmListener, null);
    }
    public static void showLogOutDialog(final Context mContext, final String content,
                                        String confirmText, String cancelText, SweetAlertDialog.OnSweetClickListener confirmListener) {
        showDialog(mContext, SweetAlertDialog.WARNING_TYPE, "Log out",
                content, confirmText, cancelText, confirmListener, null);
    }

    public static void showErrorDialog(final Context mContext, final String content) {
        showDialog(mContext, SweetAlertDialog.ERROR_TYPE, "Error",
                content, null, null, null, null);
    }

    public static void dismissDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
