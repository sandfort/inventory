package us.jsand.inventory.core

data class EquipmentPiece(
        val id: Int,
        val name: String,
        val description: String,
        val skillMods: List<SkillModifier>
)
