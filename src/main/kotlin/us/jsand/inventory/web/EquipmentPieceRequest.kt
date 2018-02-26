package us.jsand.inventory.web

import us.jsand.inventory.core.SkillModifier

data class EquipmentPieceRequest(
        val name: String,
        val description: String,
        val skillMods: List<SkillModifier>
)