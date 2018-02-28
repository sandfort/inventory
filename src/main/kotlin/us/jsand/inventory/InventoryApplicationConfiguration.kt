package us.jsand.inventory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import us.jsand.inventory.core.EquipmentPieceRepository
import us.jsand.inventory.repo.InMemoryEquipmentPieceRepository
import us.jsand.inventory.repo.InMemoryEquipmentSetRepository

@Configuration
class InventoryApplicationConfiguration {
    @Bean
    fun inventoryRepository() = InMemoryEquipmentSetRepository()

    @Bean
    fun itemRepository(): EquipmentPieceRepository {
        val repo = InMemoryEquipmentPieceRepository()
        repo.seed()

        return repo
    }
}