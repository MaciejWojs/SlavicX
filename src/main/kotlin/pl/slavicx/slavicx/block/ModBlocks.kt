package pl.slavicx.slavicx.block

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import pl.slavicx.slavicx.Slavicx
import java.util.function.ToIntFunction


object ModBlocks {
    val REGISTRY = DeferredRegister.createBlocks(Slavicx.ID)
    val BlockItemRegistry = DeferredRegister.createItems(Slavicx.ID)

    // If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
//    val EXAMPLE_BLOCK by REGISTRY.register("example_block") { ->
//        Block(
//            BlockBehaviour.Properties.of()
//                .lightLevel { _ -> 15 } // FIXED here
//                .strength(3.0f)
//                .setId(EXAMPLE_BLOCK./)
//        )
//    }

    //BLOCKS is a DeferredRegister.Blocks
    val MY_BETTER_BLOCK: DeferredBlock<Block> = REGISTRY.register(
        "my_better_block",
        { registryName ->
            Block(
                BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GRAVEL)
                    .lightLevel(ToIntFunction { state: BlockState? -> 15 })
            )
        })

    val MY_BETTER_BLOCK_ITEM: DeferredItem<BlockItem> = BlockItemRegistry.registerSimpleBlockItem(
        "my_better_block",
        MY_BETTER_BLOCK,
    )
}
