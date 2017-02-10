/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml),
 *            Grzesiek Rzaca (grzesiekrzaca)
 * Copyright (c) 2011-2017, FrostWire(R). All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.limegroup.gnutella.gui;

import com.limegroup.gnutella.settings.ConnectionSettings;

public class VPNBitTorrentGuard {

    public static boolean canUseBitTorrent(boolean silent) {
        if (ConnectionSettings.VPN_BITTORRENT_GUARD_ON.getValue() && !VPNs.isVPNActive()) {
            if (!silent) {

                GUIMediator.showWarning(I18n.tr("BitTorrent is off because your VPN is disconnected.") + "\r\n" +
                                        I18n.tr("To re-enable BitTorrent transfers start a VPN connection Go to Settings > Setup a VPN connection or check advanced settings."));
            }
            return false;
        }
        return true;
    }

    public static boolean canUseBitTorrent() {
        return canUseBitTorrent(false);
    }

}
