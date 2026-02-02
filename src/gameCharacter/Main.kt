package gameCharacter

fun main() {
    val character = GameCharacter("Lenya")
    fun handleCharacterState(name: String, state: CharacterState) {
        when (state) {
            CharacterState.Idle -> println("$name is idle")
            CharacterState.Running -> println("$name is running")
            is CharacterState.Attacking -> println("$name is attacking with damage ${state.damage}")
            is CharacterState.Dead -> println("$name died: ${state.reason}")
        }
    }

    character.changeState(CharacterState.Running)
    handleCharacterState(character.name, character.state)

    character.changeState(CharacterState.Attacking(52))
    handleCharacterState(character.name, character.state)

    character.changeState(CharacterState.Dead("Energy drink overdose"                                                                   ))
    handleCharacterState(character.name, character.state)
}