package ru.startandroid.players.data.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.players.data.network.model.PlayerApi
import ru.startandroid.players.domain.model.Player
import javax.inject.Inject

class PlayerApiToUiMapper @Inject constructor(): Mapper<PlayerApi, Player> {
    override fun map(from: PlayerApi): Player {
        return Player(
            id = from.player.id,
            name = from.player.name.orEmpty(),
            age = from.player.age?.toString().orEmpty(),
            nationality = from.player.nationality.orEmpty(),
            height = from.player.height.orEmpty(),
            weight = from.player.weight.orEmpty(),
            photo = from.player.photo
        )
    }
}