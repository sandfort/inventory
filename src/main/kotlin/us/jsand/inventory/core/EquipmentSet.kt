package us.jsand.inventory.core

data class EquipmentSet(
        val id: Int,
        val name: String,
        val head: EquipmentPiece? = null,
        val chest: EquipmentPiece? = null,
        val arms: EquipmentPiece? = null,
        val waist: EquipmentPiece? = null,
        val legs: EquipmentPiece? = null,
        val talisman: EquipmentPiece? = null
)