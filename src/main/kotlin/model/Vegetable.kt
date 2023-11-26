package model

/**
 * Abstract class representing a vegetable.
 *
 * @param quantity The quantity of the vegetable.
 *
 * @throws IllegalArgumentException if quantity is not positive.
 */
abstract class Vegetable(val quantity: Double) {

    /**
     * Initializes the vegetable with the specified quantity.
     * Throws an exception if the quantity is not positive.
     */
    init {
        if (quantity <= 0.0) throw IllegalArgumentException("quantity should be positive")
    }

    /**
     * Abstract property representing the calories per piece of the vegetable.
     */
    abstract val caloriesPerPiece: Double

    /**
     * Abstract property representing the color of the vegetable.
     */
    abstract val color: String

    /**
     * Calculates the total calories for the given quantity of the vegetable.
     *
     * @return The total calories.
     */
    fun getCalories(): Double {
        return quantity * caloriesPerPiece
    }

    /**
     * Generates a string representation of the vegetable.
     *
     * @return A string in the format "quantity of color VegetableType".
     */
    override fun toString(): String {
        return "$quantity of $color ${javaClass.simpleName}"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Vegetable) return false
        return hashCode() == other.hashCode()
    }

    override fun hashCode(): Int {
        var result = quantity.hashCode()
        result = 31 * result + caloriesPerPiece.hashCode()
        result = 31 * result + color.hashCode()
        return result
    }

}