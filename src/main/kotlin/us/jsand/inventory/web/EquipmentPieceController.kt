package us.jsand.inventory.web

import org.springframework.web.bind.annotation.*
import us.jsand.inventory.core.EquipmentPiece
import us.jsand.inventory.core.EquipmentPieceRepository

@RestController
class EquipmentPieceController constructor(val repo: EquipmentPieceRepository) {
    @GetMapping("/equips/{id}")
    fun getItem(@PathVariable("id") id: Int): EquipmentPieceResponse {
        return EquipmentPieceResponse(repo.read(id))
    }

    @GetMapping("/equips")
    fun getAllItems(): EquipmentPiecesResponse {
        return EquipmentPiecesResponse(repo.readAll())
    }

    @PostMapping("/equips")
    fun makeItem(@RequestBody request: EquipmentPieceRequest) {
        repo.create(request.name, request.description, request.skillMods)
    }

    @PutMapping("/equips/{id}")
    fun updateItem(@PathVariable("id") id: Int, @RequestBody request: EquipmentPieceRequest) {
        repo.update(EquipmentPiece(id, request.name, request.description, request.skillMods))
    }
}