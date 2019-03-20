package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity.FilterActivity;

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_NAME;

/**
 * Class used to navigate through the application.
 */

public class Navigator {

    private Navigator() { }

    /**
     * Goes to the filter screen.
     *
     * @param context A Context needed to open the destiny activity.
     * @param intentFlag Depending on this flag Filter is chosen.
     */
    public static void navigateToFilterActivity(Context context, int intentFlag) {
        if (context != null) {
            Intent intentToLaunch = new Intent(context, FilterActivity.class);
            intentToLaunch.putExtra(INTENT_FLAG_NAME, intentFlag);
            context.startActivity(intentToLaunch);
        }
    }

}