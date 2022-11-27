package com.google.p000vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.vr.cardboard.UiUtils */
public class UiUtils {
    private static final String CARDBOARD_CONFIGURE_ACTION = "com.google.vrtoolkit.cardboard.CONFIGURE";
    private static final String CARDBOARD_WEBSITE = "https://google.com/cardboard/cfg";
    private static final String DAYDREAM_HELP_CENTER_LINK = "https://support.google.com/daydream?p=daydream_help_menu";
    public static AlertDialog.Builder dialogBuilderForTesting;
    public static StoragePermissionUtils permissionUtils = new StoragePermissionUtils();

    public static void launchOrInstallCardboard(Context context) {
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        Intent intent2 = new Intent();
        intent2.setAction(CARDBOARD_CONFIGURE_ACTION);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent2, 0);
        ArrayList arrayList = new ArrayList();
        Integer num = null;
        for (ResolveInfo next : queryIntentActivities) {
            String str = next.activityInfo.packageName;
            if (PackageUtils.isGooglePackage(str)) {
                int i = next.priority;
                if (PackageUtils.isSystemPackage(context, str)) {
                    i++;
                }
                if (num == null) {
                    num = Integer.valueOf(i);
                } else if (i > num.intValue()) {
                    num = Integer.valueOf(i);
                    arrayList.clear();
                } else if (i < num.intValue()) {
                }
                Intent intent3 = new Intent(intent2);
                intent3.setClassName(str, next.activityInfo.name);
                arrayList.add(intent3);
            }
        }
        if (!VrParamsProviderFactory.isContentProviderAvailable(context)) {
            permissionUtils.requestStoragePermission(context);
        }
        if (arrayList.isEmpty()) {
            showInstallDialog(context);
            return;
        }
        if (arrayList.size() == 1) {
            intent = (Intent) arrayList.get(0);
        } else {
            intent = intent2;
        }
        context.startActivity(intent);
    }

    public static AlertDialog showDaydreamHelpCenterDialog(final Context context, int i, int i2, final Runnable runnable) {
        C00421 r0 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UiUtils.DAYDREAM_HELP_CENTER_LINK)));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, C0021R.string.no_browser_text, 1).show();
                    dialogInterface.cancel();
                }
            }
        };
        AlertDialog.Builder createAlertDialogBuilder = createAlertDialogBuilder(context);
        createAlertDialogBuilder.setTitle(i).setMessage(i2).setCancelable(false).setPositiveButton(C0021R.string.dialog_button_open_help_center, r0).setNegativeButton(C0021R.string.dialog_button_got_it, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        if (runnable != null) {
            createAlertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    runnable.run();
                }
            });
        }
        AlertDialog create = createAlertDialogBuilder.create();
        create.setCanceledOnTouchOutside(false);
        return showImmersiveDialog(context, create);
    }

    private static void showInstallDialog(final Context context) {
        C00454 r0 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UiUtils.CARDBOARD_WEBSITE)));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, C0021R.string.no_browser_text, 1).show();
                }
            }
        };
        AlertDialog.Builder createAlertDialogBuilder = createAlertDialogBuilder(context);
        createAlertDialogBuilder.setTitle(C0021R.string.dialog_title).setMessage(C0021R.string.dialog_message_no_cardboard).setPositiveButton(C0021R.string.go_to_playstore_button, r0).setNegativeButton(C0021R.string.cancel_button, (DialogInterface.OnClickListener) null);
        showImmersiveDialog(context, createAlertDialogBuilder.create());
    }

    private static AlertDialog showImmersiveDialog(Context context, AlertDialog alertDialog) {
        alertDialog.getWindow().setFlags(8, 8);
        alertDialog.show();
        Activity activity = ContextUtils.getActivity(context);
        if (activity != null) {
            alertDialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        }
        alertDialog.getWindow().clearFlags(8);
        return alertDialog;
    }

    private static AlertDialog.Builder createAlertDialogBuilder(Context context) {
        if (dialogBuilderForTesting != null) {
            return dialogBuilderForTesting;
        }
        return new AlertDialog.Builder(context, C0021R.style.GvrDialogTheme);
    }
}
