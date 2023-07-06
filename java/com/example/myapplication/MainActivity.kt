package com.example.myapplication
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mridulFood: EditText = findViewById(R.id.mridulFood)
        val mridulUtility: EditText = findViewById(R.id.mridulUtility)
        val azmalFood: EditText = findViewById(R.id.azmalFood)
        val azmalUtility: EditText = findViewById(R.id.azmalUtility)
        val nasifFood: EditText = findViewById(R.id.nasifFood)
        val nasifUtility: EditText = findViewById(R.id.nasifUtility)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        val mridulTotal: TextView = findViewById(R.id.mridulTotal)
        val azmalTotal: TextView = findViewById(R.id.azmalTotal)
        val nasifTotal: TextView = findViewById(R.id.nasifTotal)

        val oneLiner: TextView = findViewById(R.id.oneLiner)


        btnCalculate.setOnClickListener{
// Inside btnCalculate.setOnClickListener
            val mridulFoodValue = mridulFood.text.toString()
            val mridulUtilityValue = mridulUtility.text.toString()
            val azmalFoodValue = azmalFood.text.toString()
            val azmalUtilityValue = azmalUtility.text.toString()
            val nasifFoodValue = nasifFood.text.toString()
            val nasifUtilityValue = nasifUtility.text.toString()

// Check if any EditText fields are empty or contain non-numeric input
            if (mridulFoodValue.isEmpty() || !mridulFoodValue.matches(Regex("-?\\d+(\\.\\d+)?")) ||
                mridulUtilityValue.isEmpty() || !mridulUtilityValue.matches(Regex("-?\\d+(\\.\\d+)?")) ||
                azmalFoodValue.isEmpty() || !azmalFoodValue.matches(Regex("-?\\d+(\\.\\d+)?")) ||
                azmalUtilityValue.isEmpty() || !azmalUtilityValue.matches(Regex("-?\\d+(\\.\\d+)?")) ||
                nasifFoodValue.isEmpty() || !nasifFoodValue.matches(Regex("-?\\d+(\\.\\d+)?")) ||
                nasifUtilityValue.isEmpty() || !nasifUtilityValue.matches(Regex("-?\\d+(\\.\\d+)?"))
            ) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

// Convert the input to double values
            val mridul_food_cost = mridulFoodValue.toDouble()
            val mridul_utility_cost = mridulUtilityValue.toDouble()
            val azmal_food_cost = azmalFoodValue.toDouble()
            val azmal_utility_cost = azmalUtilityValue.toDouble()
            val nasif_food_cost = nasifFoodValue.toDouble()
            val nasif_utility_cost = nasifUtilityValue.toDouble()

// Rest of the code remains the same


            val total_food_cost = mridul_food_cost + azmal_food_cost + nasif_food_cost
            val perhead_food_cost = total_food_cost / 4

            val total_utility_cost = mridul_utility_cost + azmal_utility_cost + nasif_utility_cost
            val perhead_utility_cost = total_utility_cost / 3

            val mridul_food_account = mridul_food_cost - (perhead_food_cost * 2)
            val azmal_food_account = azmal_food_cost - perhead_food_cost
            val nasif_food_account = nasif_food_cost - perhead_food_cost

            val mridul_utility_account = mridul_utility_cost - perhead_utility_cost
            val azmal_utility_account = azmal_utility_cost - perhead_utility_cost
            val nasif_utility_account = nasif_utility_cost - perhead_utility_cost

            val mridul_total_account = mridul_food_account + mridul_utility_account
            val azmal_total_account = azmal_food_account + azmal_utility_account
            val nasif_total_account = nasif_food_account + nasif_utility_account


            mridulTotal.text = "Mridul: %.2f".format(mridul_total_account)
            azmalTotal.text = "Azmal: %.2f".format(azmal_total_account)
            nasifTotal.text = "Nasif: %.2f".format(nasif_total_account)


            // Hide the keyboard
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            currentFocus?.let { currentFocus ->
                inputMethodManager?.hideSoftInputFromWindow(currentFocus.windowToken, 0)
            }
        }
    }
}
