package model

/**
 * Represents a Tomato, which is a type of vegetable.
 *
 * @param quantity The quantity of the tomatoes.
 */
class Tomato(quantity: Double) : Vegetable(quantity) {

    /**
     * The calories per piece of the tomato.
     */
    override val caloriesPerPiece = 22.0

    /**
     * The color of the tomato.
     */
    override val color = "Red"

}