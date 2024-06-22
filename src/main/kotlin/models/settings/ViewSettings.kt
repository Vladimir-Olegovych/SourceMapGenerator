package org.example.models.settings

import org.example.models.HammerObject

class ViewSettings: HammerObject("viewsettings") {
    init {
        put("bSnapToGrid", "1")
        put("bShowGrid", "1")
        put("bShowLogicalGrid", "0")
        put("nGridSpacing", "64")
        put("bShow3DGrid", "0")
    }
}