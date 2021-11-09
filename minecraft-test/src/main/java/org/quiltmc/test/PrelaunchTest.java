/*
 * Copyright 2021 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.quiltmc.test;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.quiltmc.loader.impl.launch.common.QuiltLauncherBase;

/**
 * Test preLaunch entrypoint.
 */
public final class PrelaunchTest implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch(ModContainer mod) {
		if (TestMod.class.getClassLoader() != QuiltLauncherBase.getLauncher().getTargetClassLoader()) {
			throw new IllegalStateException("Invalid class loader: " + TestMod.class.getClassLoader());
		}

		System.out.println("Hello from preLaunch in Quilt");
		System.out.printf("PreLaunch CL: %s%n", TestMod.class.getClassLoader());
	}
}
