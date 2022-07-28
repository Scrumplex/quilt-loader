package org.quiltmc.loader.impl.plugin.base;

import java.io.IOException;
import java.nio.file.Path;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.loader.api.plugin.QuiltPluginContext;
import org.quiltmc.loader.api.plugin.solver.ModLoadOption;
import org.quiltmc.loader.impl.metadata.qmj.InternalModMetadata;
import org.quiltmc.loader.impl.util.HashUtil;

public abstract class InternalModOptionBase extends ModLoadOption {

	protected final QuiltPluginContext pluginContext;
	protected final InternalModMetadata metadata;
	protected final Path from, resourceRoot;
	protected final boolean mandatory;

	byte[] hash;

	public InternalModOptionBase(QuiltPluginContext pluginContext, InternalModMetadata meta, Path from,
		Path resourceRoot, boolean mandatory) {

		this.pluginContext = pluginContext;
		this.metadata = meta;
		this.from = from;
		this.resourceRoot = resourceRoot;
		this.mandatory = mandatory;
	}

	@Override
	public InternalModMetadata metadata() {
		return metadata;
	}

	@Override
	public Path from() {
		return from;
	}

	@Override
	public Path resourceRoot() {
		return resourceRoot;
	}

	@Override
	public boolean isMandatory() {
		return mandatory;
	}

	@Override
	public String toString() {
		return "{" + getClass().getName() + " '" + metadata.id() + "' from " //
			+ pluginContext.manager().describePath(from) + "}";
	}

	@Override
	public QuiltPluginContext loader() {
		return pluginContext;
	}

	@Override
	public String shortString() {
		// TODO Auto-generated method stub
		throw new AbstractMethodError("// TODO: Implement this!");
	}

	@Override
	public String getSpecificInfo() {
		// TODO Auto-generated method stub
		throw new AbstractMethodError("// TODO: Implement this!");
	}

	@Override
	public @Nullable String namespaceMappingFrom() {
		return metadata.intermediateMappings();
	}

	@Override
	public boolean needsChasmTransforming() {
		return true;
	}

	@Override
	public byte[] computeOriginHash() throws IOException {
		if (hash == null) {
			hash = HashUtil.computeHash(from);
		}
		return hash;
	}
}