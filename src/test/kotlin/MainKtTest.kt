import org.junit.Assert.assertEquals
import org.junit.Test

internal class MainKtTest {

    @Test
    fun calcCommissionShouldAccountTypeVKPay() {
        val amount = 4_500_000
        val monthLimit = 7_500_000
        val accountType = "VK pay"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(0, result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMaestro() {
        val amount = 4_500_000
        val monthLimit = 500_000
        val accountType = "Maestro"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(0, result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMaestroMaxLimit() {
        val amount = 4_500_000
        val monthLimit = 7_500_000
        val accountType = "Maestro"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(29000, result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMastercard() {
        val amount = 4_500_000
        val monthLimit = 500_000
        val accountType = "Mastercard"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(0, result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMastercardMaxLimit() {
        val amount = 4_500_000
        val monthLimit = 7_500_000
        val accountType = "Mastercard"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(29000 , result)
    }

    @Test
    fun calcCommissionShouldAccountTypeVisa() {
        val amount = 4_500_000
        val monthLimit = 7_500_000
        val accountType = "Visa"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(33750 , result)
    }

    @Test
    fun calcCommissionShouldAccountTypeVisaMinCommission() {
        val amount = 10_000
        val monthLimit = 7_500_000
        val accountType = "Visa"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(3500 , result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMir() {
        val amount = 4_500_000
        val monthLimit = 7_500_000
        val accountType = "Мир"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(33750 , result)
    }

    @Test
    fun calcCommissionShouldAccountTypeMirMinCommission() {
        val amount = 10_000
        val monthLimit = 7_500_000
        val accountType = "Мир"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(3500 , result)
    }

    @Test
    fun calcCommissionShouldIncorrectAccountType() {
        val amount = 10_000
        val monthLimit = 7_500_000
        val accountType = "Mir"
        val result = calcCommission(accountType, monthLimit, amount)
        assertEquals(-1 , result)
    }

    @Test
    fun calcCommissionShouldDefaultValues() {
        val amount = 10_000
        val result = calcCommission(transferAmount = amount)
        assertEquals(0 , result)
    }
}