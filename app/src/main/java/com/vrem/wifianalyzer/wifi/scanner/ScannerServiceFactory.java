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

package com.vrem.wifianalyzer.wifi.scanner;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;

import com.vrem.wifianalyzer.MainActivity;
import com.vrem.wifianalyzer.settings.Settings;

import androidx.annotation.NonNull;

public class ScannerServiceFactory {
    private ScannerServiceFactory() {
        throw new IllegalStateException("Factory class");
    }

    @NonNull
    public static ScannerService makeScannerService(
        @NonNull MainActivity mainActivity,
        @NonNull Handler handler,
        @NonNull Settings settings) {

        Context context = mainActivity.getApplicationContext();
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WiFiManagerWrapper wiFiManagerWrapper = new WiFiManagerWrapper(wifiManager);

        return new Scanner(wiFiManagerWrapper, handler, settings);
    }
}
