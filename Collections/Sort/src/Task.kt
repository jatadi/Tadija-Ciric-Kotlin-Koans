fun Shop.getCustomersSortedByOrders(): List<Customer> {
        return customers.sortedByDescending { it.orders.size }
}
