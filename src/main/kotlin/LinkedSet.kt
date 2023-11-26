import model.Vegetable

/**
 * Represents a linked set of unique Vegetable objects.
 *
 * <p>This LinkedSet implementation maintains order of insertion and provides constant time complexity for adding elements to the end of the set.</p>
 *
 * @param <Vegetable> the type of elements in this set.
 * @author Kirill Biliashov
 */
class LinkedSet(): Set<Vegetable> {

    /** The first node in the linked set. */
    private var head: Node? = null

    /** The last node in the linked set. */
    private var tail: Node? = null

    /** The number of elements in the set. */
    private var _size = 0

    override val size: Int
        get() = _size

    /**
     * Constructs a LinkedSet with a single Vegetable element.
     *
     * @param vegetable the Vegetable to be added to the set.
     */
    constructor(vegetable: Vegetable) : this() {
        add(vegetable)
    }

    /**
     * Constructs a LinkedSet with elements from the given collection.
     *
     * @param vegetables the collection of Vegetables to be added to the set.
     */
    constructor(vegetables: Collection<Vegetable>): this() {
        addAll(vegetables)
    }

    /**
     * Adds all elements from the given collection to the set.
     *
     * @param vegetables the collection of Vegetables to be added to the set.
     */
    private fun addAll(vegetables: Collection<Vegetable>) {
        vegetables.forEach { vegetable ->
            add(vegetable)
        }
    }

    /**
     * Adds a Vegetable to the set, if it is not already present.
     *
     * @param vegetable the Vegetable to be added to the set.
     */
    private fun add(vegetable: Vegetable) {
        if (contains(vegetable)) return
        val newNode = Node(data = vegetable)
        _size++
        if (head == null) {
            head = newNode
            tail = newNode
            return
        }
        tail!!.next = newNode
        tail = newNode
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set is empty, false otherwise.
     */
    override fun isEmpty(): Boolean {
        return _size == 0
    }

    /**
     * Returns an iterator over the elements in the set.
     *
     * @return an iterator over the elements in the set.
     */
    override fun iterator(): Iterator<Vegetable> {
        return LinkedSetIterator(head)
    }

    /**
     * Checks if all elements in the specified collection are present in the set.
     *
     * @param elements the collection of elements to be checked.
     * @return true if all elements are present, false otherwise.
     */
    override fun containsAll(elements: Collection<Vegetable>): Boolean {
        var matches = 0
        val iterator = iterator()
        while (iterator.hasNext()) {
            val currEl = iterator.next()
            if (elements.contains(currEl)) matches++
        }
        return matches == elements.size
    }

    /**
     * Checks if the set contains the specified element.
     *
     * @param element the element to be checked.
     * @return true if the element is present, false otherwise.
     */
    override fun contains(element: Vegetable): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val currEl = iterator.next()
            if (currEl == element) return true
        }
        return false
    }

    /**
     * Represents a node in the linked set.
     * @param data The Vegetable object stored in this node
     * @param next Reference to the next node in the linked set
     */
    private data class Node(val data: Vegetable, var next: Node? = null)

    /**
     * Iterator for the LinkedSet.
     * @param currNode current node in the iteration
     */
    private class LinkedSetIterator(private var currNode: Node?): Iterator<Vegetable> {

        /**
         * Checks if there are more elements in the iteration.
         *
         * @return true if there are more elements, false otherwise.
         */
        override fun hasNext(): Boolean {
            return currNode != null
        }

        /**
         * Retrieves the next element in the iteration.
         *
         * @return the next Vegetable in the iteration.
         */
        override fun next(): Vegetable {
            val currNodeData = currNode!!.data
            currNode = currNode?.next
            return currNodeData
        }

    }

}