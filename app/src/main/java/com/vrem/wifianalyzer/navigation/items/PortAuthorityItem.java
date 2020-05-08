/*
 * WiFiAnalyzer
 * Copyright (C) 2015 - 2020 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.navigation.items;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;

import com.vrem.wifianalyzer.MainActivity;
import com.vrem.wifianalyzer.navigation.NavigationMenu;

import androidx.annotation.NonNull;

class PortAuthorityItem implements NavigationItem {
    private static final String PORT_AUTHORITY = "com.aaronjwood.portauthority.";
    static final String PORT_AUTHORITY_FREE = PORT_AUTHORITY + "free";
    static final String PORT_AUTHORITY_DONATE = PORT_AUTHORITY + "donate";

    @Override
    public void activate(@NonNull MainActivity mainActivity, @NonNull MenuItem menuItem, @NonNull NavigationMenu navigationMenu) {
        try {
            Context context = mainActivity.getApplicationContext();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage(PORT_AUTHORITY_DONATE);
            if (intent == null) {
                intent = packageManager.getLaunchIntentForPackage(PORT_AUTHORITY_FREE);
                if (intent == null) {
                    intent = redirectToPlayStore();
                }
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            // No Store or Port Authority Available
        }
    }

    @Override
    public boolean isRegistered() {
        return false;
    }

    @Override
    public int getVisibility() {
        return View.GONE;
    }

    Intent redirectToPlayStore() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=" + PORT_AUTHORITY_FREE));
        return intent;
    }

}
