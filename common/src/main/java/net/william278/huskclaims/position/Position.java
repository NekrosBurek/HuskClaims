/*
 * This file is part of HuskClaims, licensed under the Apache License 2.0.
 *
 *  Copyright (c) William278 <will27528@gmail.com>
 *  Copyright (c) contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package net.william278.huskclaims.position;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.william278.cloplib.operation.OperationChunk;
import net.william278.cloplib.operation.OperationPosition;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Position implements CoordinatePoint, OperationPosition {

    @Expose
    private double x;
    @Expose
    private double y;
    @Expose
    private double z;
    @Expose
    private float yaw;
    @Expose
    private float pitch;
    @Expose
    private World world;

    @NotNull
    public static Position at(double x, double y, double z, @NotNull World world) {
        return new Position(x, y, z, 0f, 0f, world);
    }

    @NotNull
    public static Position at(double x, double y, double z, float yaw, float pitch, @NotNull World world) {
        return new Position(x, y, z, yaw, pitch, world);
    }

    @NotNull
    @Override
    public OperationChunk getChunk() {
        return new OperationChunk() {
            @Override
            public int getX() {
                return ((int) x) << 16;
            }

            @Override
            public int getZ() {
                return ((int) z) << 16;
            }
        };
    }

    @Override
    public int getBlockX() {
        return (int) getX();
    }

    @Override
    public int getBlockZ() {
        return (int) getZ();
    }
}
