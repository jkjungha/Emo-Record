import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.myapplication.LoadingHelper

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        loadingHelper = LoadingHelper(this)

        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        val resetButton: Button = findViewById(R.id.resetButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        resetButton.setOnClickListener {
            // 在点击重置按钮时显示加载动画
            showLoading()

            // 获取用户输入的新密码和确认密码
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // 模拟延时，然后隐藏加载动画并执行密码重置操作
            Handler().postDelayed({
                hideLoading()

                if (newPassword == confirmPassword) {
                    // 密码重置成功
                    Toast.makeText(this@ResetPasswordActivity, "비밀번호 재설정 완료", Toast.LENGTH_SHORT).show()
                    // 在这里可以执行其他操作，如返回登录界面
                } else {
                    // 密码重置失败
                    Toast.makeText(this@ResetPasswordActivity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                }
            }, 2000) // 调整延时时间
        }

        backToLoginButton.setOnClickListener {
            // 在返回按钮点击时显示加载动画
            showLoading()

            // 模拟延时，然后返回到忘记密码界面
            Handler().postDelayed({
                hideLoading()

                // 创建一个 Intent 以返回到忘记密码界面
                val intent = Intent(this@ResetPasswordActivity, ForgetPasswordActivity::class.java)
                startActivity(intent)
                finish() // 结束当前的忘记密码界面
            }, 500) // 调整延时时间
        }
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
