package io.engi.mechanicaltech.block;

import io.engi.mechanicaltech.entity.SawmillBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SawmillBlock extends HorizontalOrientableBlock implements BlockEntityProvider {
	public SawmillBlock(Settings settings) {
		super(settings);
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockView world) {
		return new SawmillBlockEntity();
	}

	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SawmillBlockEntity) {
				player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
			}
			return ActionResult.CONSUME;
		}
	}

	public boolean hasSidedTransparency(BlockState state) {
		return true;
	}
}
