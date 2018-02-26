package us.jsand.inventory.web

import org.springframework.web.bind.annotation.*
import us.jsand.inventory.core.EquipmentSet
import us.jsand.inventory.core.EquipmentSetRepository

@RestController
class EquipmentSetController constructor(val repo: EquipmentSetRepository) {
    @GetMapping("/sets/{id}")
    fun getInventory(@PathVariable("id") id: Int): EquipmentSetResponse {
        return EquipmentSetResponse(repo.read(id))
    }

    @GetMapping("/sets")
    fun getAllInventories(): EquipmentSetsResponse {
        return EquipmentSetsResponse(repo.readAll())
    }

    @PostMapping("/sets")
    fun makeInventory(@RequestBody request: EquipmentSetRequest) {
        repo.create(request.name)
    }

    @PutMapping("/sets/{id}")
    fun updateInventory(@PathVariable("id") id: Int, @RequestBody request: EquipmentSetRequest) {
        repo.update(EquipmentSet(id, request.name))
    }

    @DeleteMapping("/sets/{id}")
    fun deleteInventory(@PathVariable("id") id: Int) {
        repo.delete(id)
    }
}