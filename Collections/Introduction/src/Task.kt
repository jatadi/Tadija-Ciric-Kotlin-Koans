fun Shop.getSetOfCustomers(): Set<Customer> {
        return customers.toSet()  // Convert the list of customers to a set to ensure uniqueness
}
