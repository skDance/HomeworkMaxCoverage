fun main() {
    val amount = 10_000
    val monthLimit = 7_500_000
    val accountType = "Visa"

    val commission = calcCommission(accountType, monthLimit, amount)
    val amountAfterCommission = amount - commission
    commissionMessage(amount, commission, amountAfterCommission)
}

fun calcCommission(accountType: String = "VK pay", monthLimit: Int = 0, transferAmount: Int): Int {
    when {
        accountType == "VK pay" -> return 0
        accountType == "Mastercard" || accountType == "Maestro" -> {
            val maxLimit = 7_500_000
            val commission = 0.006
            if (monthLimit >= maxLimit) return ((transferAmount * commission) + 2000).toInt() else return 0
        }

        accountType == "Visa" || accountType == "Мир" -> {
            val commission = 0.0075
            val minCommission = 3500
            if (transferAmount * commission < minCommission) return minCommission else return (transferAmount * commission).toInt()
        }

        else -> return -1
    }
}

fun commissionMessage(transferAmount: Int, commission: Int, amountAfterCommission: Int) {
    if (commission == -1) {
        println("Введен некорректный тип счета")
    } else {
        val rublesAmount = transferAmount / 100
        val rublesCommission = commission / 100
        val rublesTransfer = amountAfterCommission / 100

        val message = """
        Перевод на сумму $rublesAmount рублей
        Комиссия $rublesCommission рублей
        Сумма перевода за вычетом комиссии составит $rublesTransfer рублей
    """.trimIndent()
        println(message)
    }
}