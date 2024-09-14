// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.asSequence()
        .filter { it.isDelivered }
        .flatMap { it.products.asSequence() }
        .maxByOrNull { it.price }

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    customers.asSequence()
        .flatMap { it.orders.asSequence() }
        .flatMap { it.products.asSequence() }
        .count { it == product }

// Return all products the given customer has ordered as a sequence
fun Customer.getOrderedProducts(): Sequence<Product> =
    orders.asSequence().flatMap { it.products.asSequence() }
