package us.jsand.inventory

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import us.jsand.inventory.repo.InMemoryEquipmentSetRepository
import us.jsand.inventory.repo.InMemoryEquipmentPieceRepository

@Configuration
class InventoryApplicationConfiguration {
    @Bean
    fun inventoryRepository() = InMemoryEquipmentSetRepository()

    @Bean
    fun itemRepository() = InMemoryEquipmentPieceRepository()
}