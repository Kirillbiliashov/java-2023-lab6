package model

/**
 * Represents a lettuce, a type of vegetable.
 *
 * @param quantity The quantity of the lettuces.
 */
class Lettuce(quantity: Double) : Vegetable(quantity) {

    /**
     * The calories per piece of the lettuce.
     */
    override val caloriesPerPiece = 4.2

    /**
     * The color of the onion.
     */
    override val color = "Green"
}