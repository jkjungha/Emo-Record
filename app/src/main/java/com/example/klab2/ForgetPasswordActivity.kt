import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.myapplication.LoadingHelper

class ForgetPasswordActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper
    private lateinit var resetEmailOrPhoneEditText: EditText

    private fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern)
    }

    private fun isPhoneNumberValid(phoneNumber: String): Boolean {
        val phonePattern = "^[0-9]{11}$"
        return phoneNumber.matches(phonePattern)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_password)

        loadingHelper = LoadingHelper(this)

        resetEmailOrPhoneEditText = findViewById(R.id.resetEmailOrPhoneEditText)

        val resetPasswordButton: Button = findViewById(R.id.resetButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        resetPasswordButton.setOnClickListener {
            // 在点击重置按钮时显示加载动画
            showLoading()

            val emailOrPhone = resetEmailOrPhoneEditText.text.toString()

            // 检查是否匹配
            val sharedPreferences: SharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
            val validatedEmailOrPhone: String = sharedPreferences.getString("validatedEmailOrPhone", "") ?: ""

            // 模拟延时，然后隐藏加载动画
            Handler().postDelayed({
                hideLoading()

                if (emailOrPhone == validatedEmailOrPhone) {
                    // 用户提供的手机号或邮箱与验证成功的匹配
                    // 执行密码重置逻辑
                    val intent = Intent(this, ResetPasswordActivity::class.java)
                    startActivity(intent)
                } else {
                    // 用户提供的手机号或邮箱与验证成功的不匹配
                    Toast.makeText(this, "전화번호 또는 이메일 불일치", Toast.LENGTH_SHORT).show()
                }
            }, 2000) // 调整延时时间
        }

        backToLoginButton.setOnClickListener {
            // 在返回之前显示加载动画
            showLoading()

            // 模拟延时，然后返回到登录界面
            Handler().postDelayed({
                hideLoading()

                // 创建一个 Intent 以返回到登录界面
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // 结束当前的忘记密码界面
            }, 2000) // 调整延时时间
        }
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
