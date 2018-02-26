package us.jsand.inventory.core

data class SkillModifier(
        val skillName: String,
        val positive: Boolean = true,
        val amount: Int
)