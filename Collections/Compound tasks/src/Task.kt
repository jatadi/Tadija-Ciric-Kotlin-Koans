// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders
        .filter { it.isDelivered }
        .flatMap { it.products }
        .maxByOrNull { it.price }

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    customers.flatMap { it.orders }
        .flatMap { it.products }
        .count { it == product }

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }
