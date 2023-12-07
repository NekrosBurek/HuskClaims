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

package net.william278.huskclaims.claim;

import lombok.*;
import net.kyori.adventure.key.Key;
import net.william278.cloplib.operation.OperationType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TrustLevel implements Comparable<TrustLevel> {

    private Key key;
    private String displayName;
    @Builder.Default
    private List<String> commandAliases = List.of();
    @Builder.Default
    private List<OperationType> flags = List.of();
    @Builder.Default
    private List<Privilege> privileges = List.of();
    @Builder.Default
    private int weight = 100;

    @NotNull
    public String getId() {
        return key.asString();
    }

    @Override
    public int compareTo(@NotNull TrustLevel o) {
        return Integer.compare(weight, o.weight);
    }

    public enum Privilege {
        MANAGE_TRUSTEES,
        MANAGE_CHILD_CLAIMS,
        MANAGE_OPERATION_GROUPS,
    }

}