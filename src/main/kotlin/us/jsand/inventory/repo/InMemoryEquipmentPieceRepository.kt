package us.jsand.inventory.repo

import us.jsand.inventory.core.EquipmentPiece
import us.jsand.inventory.core.EquipmentPieceRepository
import us.jsand.inventory.core.SkillModifier

class InMemoryEquipmentPieceRepository : EquipmentPieceRepository {
    private val items = mutableListOf<EquipmentPiece>()
    private var count = 0

    override fun create(name: String, description: String, skillMods: List<SkillModifier>): Int {
        count += 1
        val item = EquipmentPiece(count, name, description, skillMods)
        items.add(item)

        return count
    }

    override fun read(id: Int): EquipmentPiece? {
        return items.find { it.id == id }
    }

    override fun readAll(): List<EquipmentPiece> {
        return items
    }

    override fun update(equipmentPiece: EquipmentPiece): EquipmentPiece {
        val id = items.indexOfFirst { it.id == equipmentPiece.id }
        items[id] = equipmentPiece

        return equipmentPiece
    }

    override fun delete(id: Int) {
        items.removeIf { it.id == id }
    }

    fun seed() {
        create("Leather Headgear", "", listOf())
        create("Leather Vest", "", listOf())
        create("Leather Gloves", "", listOf())
        create("Leather Belt", "", listOf())
        create("Leather Trousers", "", listOf())

        create("Jaggi Cap", "", listOf())
        create("Jaggi Vest", "", listOf())
        create("Jaggi Guards", "", listOf())
        create("Jaggi Coat", "", listOf())
        create("Jaggi Leggings", "", listOf())
    }
}