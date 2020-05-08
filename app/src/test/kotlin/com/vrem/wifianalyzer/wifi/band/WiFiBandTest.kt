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
package com.vrem.wifianalyzer.wifi.band

import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.wifi.band.WiFiBand.Companion.find
import org.junit.Assert.*
import org.junit.Test

class WiFiBandTest {
    @Test
    fun testWiFiBand() {
        assertEquals(2, WiFiBand.values().size)
    }

    @Test
    fun testTextResource() {
        assertEquals(R.string.wifi_band_2ghz, WiFiBand.GHZ2.textResource)
        assertEquals(R.string.wifi_band_5ghz, WiFiBand.GHZ5.textResource)
    }

    @Test
    fun testToggle() {
        assertEquals(WiFiBand.GHZ5, WiFiBand.GHZ2.toggle())
        assertEquals(WiFiBand.GHZ2, WiFiBand.GHZ5.toggle())
    }

    @Test
    fun testGHZ_5() {
        assertFalse(WiFiBand.GHZ2.GHZ5())
        assertTrue(WiFiBand.GHZ5.GHZ5())
    }

    @Test
    fun testWiFiBandFind() {
        assertEquals(WiFiBand.GHZ2, find(2399))
        assertEquals(WiFiBand.GHZ2, find(2400))
        assertEquals(WiFiBand.GHZ2, find(2499))
        assertEquals(WiFiBand.GHZ2, find(2500))
        assertEquals(WiFiBand.GHZ2, find(4899))
        assertEquals(WiFiBand.GHZ5, find(4900))
        assertEquals(WiFiBand.GHZ5, find(5899))
        assertEquals(WiFiBand.GHZ2, find(5900))
    }
}