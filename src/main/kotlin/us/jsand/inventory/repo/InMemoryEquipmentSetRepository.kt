package us.jsand.inventory.repo

import us.jsand.inventory.core.EquipmentSet
import us.jsand.inventory.core.EquipmentSetRepository

class InMemoryEquipmentSetRepository : EquipmentSetRepository {
    private val inventories = mutableListOf<EquipmentSet>()
    private var count = 0

    override fun create(name: String): Int {
        count += 1
        val inventory = EquipmentSet(count, name)
        inventories.add(inventory)

        return count
    }

    override fun read(id: Int): EquipmentSet? {
        return inventories.find { it.id == id }
    }

    override fun readAll(): List<EquipmentSet> {
        return inventories
    }

    override fun update(equipmentSet: EquipmentSet): EquipmentSet {
        val id = inventories.indexOfFirst { it.id == equipmentSet.id }
        inventories[id] = equipmentSet

        return equipmentSet
    }

    override fun delete(id: Int) {
        inventories.removeIf { it.id == id }
    }
}