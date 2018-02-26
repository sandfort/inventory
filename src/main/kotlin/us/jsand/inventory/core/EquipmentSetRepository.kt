package us.jsand.inventory.core

interface EquipmentSetRepository {
    fun create(name: String): Int
    fun read(id: Int): EquipmentSet?
    fun readAll(): List<EquipmentSet>
    fun update(equipmentSet: EquipmentSet): EquipmentSet
    fun delete(id: Int)
}