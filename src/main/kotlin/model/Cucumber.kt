package model

/**
 * Represents a cucumber, a type of vegetable.
 *
 * @param quantity The quantity of the cucumber.
 */
class Cucumber(quantity: Double) : Vegetable(quantity) {

    /**
     * The calories per piece of the cucumber.
     */
    override val caloriesPerPiece = 45.0

    /**
     * The color of the cucumber.
     */
    override val color = "Green"
}