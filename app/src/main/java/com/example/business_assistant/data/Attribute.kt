package com.example.business_assistant.data

import java.math.BigDecimal
import java.text.DateFormat

data class DBUser(val account: Account, val products:Collection<Product>, val counterparties:Collection<Counterparty>,val orders:Collection<Order>,
                  val plannings:Collection<Planning>,val futureExpenses:Collection<FutureExpense>,val futureIncomes:Collection<FutureIncome>,
                  val todayExpenses:Collection<TodayExpense>, val todayIncomes:Collection<TodayIncome>)

data class Account(
    val id: Int,
    val fullName: String,
    val titleCompany: String,
    val email: String,
    val password: String,
    val phone: String,
    val inn: String,
    val kpp: String,
    val legalAddress: String,
    val physicalAddress: String,
    val currentBalance: BigDecimal
)


data class Product(
    val id: Int,
    val title: String,
    val unit: String,
    val price: BigDecimal,
    val rawMaterials: Float,
    val salary: Float,
    val socialNeeds: Float,
    val depreciation: Float,
    val taxes: Float,
    val storage: Float,
    val other: Float,
    val dateRegistration: DateFormat,
    val images:Collection<ProductImages>
)

data class ProductImages(
    val id: Int,
    val product: Product?,
    val image: String
)

data class Counterparty(
    val id: Int,
    val fullName: String,
    val phone: String,
    val inn: String,
    val kpp: String,
    val email: String,
    val legalAddress: String,
    val physicalAddress: String,
    val dateRegistration: DateFormat
)

data class Order(
    val id: Int,
    val deliveryAddress: String,
    val priceDelivery: BigDecimal,
    val totalPrice: BigDecimal,
    val counterparty: Counterparty?,
    val dateRegistration: DateFormat,
    val dateIssue:DateFormat,
    val status: Status?,
    val basket: Collection<Basket>
)

data class Basket(
    val id: Int,
    val count: Int,
    val product: Product?,
    val order: Order?
)


data class Planning(
    val id: Int,
    val topic:String,
    val description:String,
    val date:DateFormat?,
    val dateRegistration: DateFormat,
    val order:Order?,
    val category:CategoryPlanning
)

data class Status(
    val id: Int,
    val title: String
)

data class CategoryPlanning(
    val id: Int,
    val title: String
)


data class FutureIncome(
    val id: Int,
    val sum: BigDecimal,
    val date: DateFormat,
    val type: TypeIncome
)

data class FutureExpense(
    val id: Int,
    val sum: BigDecimal,
    val date: DateFormat,
    val type: TypeExpense
)

data class TodayIncome(
    val id: Int,
    val sum: BigDecimal,
    val date: DateFormat,
    val type: TypeIncome
)

data class TodayExpense(
    val id: Int,
    val sum: BigDecimal,
    val date: DateFormat,
    val type: TypeExpense
)

data class TypeIncome(
    val id: Int,
    val title: String
)

data class TypeExpense(
    val id: Int,
    val title: String
)