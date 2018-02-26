package us.jsand.inventory.core

interface EquipmentPieceRepository {
    fun create(name: String, description: String, skillMods: List<SkillModifier>): Int
    fun read(id: Int): EquipmentPiece?
    fun readAll(): List<EquipmentPiece>
    fun update(equipmentPiece: EquipmentPiece): EquipmentPiece
    fun delete(id: Int)
}