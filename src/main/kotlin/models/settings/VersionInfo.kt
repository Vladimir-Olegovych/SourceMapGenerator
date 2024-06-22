package org.example.models.settings

import org.example.models.HammerObject

class VersionInfo: HammerObject("versioninfo") {
    init {
        put("editorversion", "400")
        put("editorbuild", "9784")
        put("mapversion", "1")
        put("formatversion", "100")
        put("prefab", "0")
    }
}