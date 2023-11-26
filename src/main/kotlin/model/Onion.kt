package model

/**
 * Represents an Onion, a type of vegetable.
 *
 * @param quantity The quantity of the onions.
 */
class Onion(quantity: Double) : Vegetable(quantity) {

    /**
     * The calories per piece of the onion.
     */
    override val caloriesPerPiece: Double = 124.08

    /**
     * The color of the onion.
     */
    override val color = "Yellow"

}