package com.drmangotea.i_architecture.base;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import com.tterrag.registrate.util.entry.BlockEntry;


import net.minecraft.world.level.block.Block;

import static com.drmangotea.i_architecture.base.IAUtils.*;

public class RustedBlockVariants<T extends Block> implements Iterable<BlockEntry<T>> {

	private static final int VARIANT_AMOUNT = RustedVariants.values().length;

	private final BlockEntry<?>[] values = new BlockEntry<?>[VARIANT_AMOUNT];

	public RustedBlockVariants(Function<RustedVariants, BlockEntry<? extends T>> filler) {
		for (RustedVariants variant : RustedVariants.values()) {
			values[variant.ordinal()] = filler.apply(variant);
		}
	}

	public BlockEntry<?>[] getValues(){
		return values;
	}

	public BlockEntry<T> getNormal(){
		return get(RustedVariants.NORMAL);
	}
	public BlockEntry<T> getSlightlyRusted(){
		return get(RustedVariants.SLIGHTLY_RUSTED);
	}
	public BlockEntry<T> getRusted(){
		return get(RustedVariants.RUSTED);
	}


	@SuppressWarnings("unchecked")
	public BlockEntry<T> get(RustedVariants variant) {
		return (BlockEntry<T>) values[variant.ordinal()];
	}

	public boolean contains(Block block) {
		for (BlockEntry<?> entry : values) {
			if (entry.is(block)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public BlockEntry<T>[] toArray() {
		return (BlockEntry<T>[]) Arrays.copyOf(values, values.length);
	}

	@Override
	public Iterator<BlockEntry<T>> iterator() {
		return new Iterator<>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < values.length;
			}

			@SuppressWarnings("unchecked")
			@Override
			public BlockEntry<T> next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return (BlockEntry<T>) values[index++];
			}
		};
	}

	public static String convertToFolder(String variant){
		if(variant == RustedVariants.RUSTED.getName())
			return RUSTED_METAL;
		if(variant == RustedVariants.SLIGHTLY_RUSTED.getName())
			return SLIGHTLY_RUSTED_METAL;
		if(variant == RustedVariants.NORMAL.getName())
			return METAL;



		return "";
	}

	public enum RustedVariants{
		NORMAL(""),
		SLIGHTLY_RUSTED("slightly_rusted_"),
		RUSTED("rusted_");


		private final String name;

		RustedVariants(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

	}




}