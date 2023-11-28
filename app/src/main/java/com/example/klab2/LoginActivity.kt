import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.klab2.R
import com.example.myapplication.LoadingHelper

class LoginActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val loginButton: Button = findViewById(R.id.loginButton)
        val registerButton: Button = findViewById(R.id.registerButton)
        val forgotPasswordButton: Button = findViewById(R.id.forgotPasswordButton)

        // 初始化 LoadingHelper
        loadingHelper = LoadingHelper(this)

        registerButton.setOnClickListener {
            // 在注册按钮点击时显示加载动画
            showLoading()

            // 创建一个 Intent 以跳转到注册界面
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@LoginActivity)
            startActivity(intent, options.toBundle())
        }

        forgotPasswordButton.setOnClickListener {
            // 在忘记密码按钮点击时显示加载动画
            showLoading()

            // 创建一个 Intent 以跳转到忘记密码界面
            val intent = Intent(this@LoginActivity, ForgetPasswordActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@LoginActivity)
            startActivity(intent, options.toBundle())
        }

        loginButton.setOnClickListener {
            // 获取用户输入的用户名和密码
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // 从 Shared Preferences 中获取已保存的用户名和密码
            val sharedPreferences: SharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
            val savedUsername: String? = sharedPreferences.getString("username", "")
            val savedPassword: String? = sharedPreferences.getString("password", "")

            // 检查用户名和密码是否匹配
            if (enteredUsername == savedUsername && enteredPassword == savedPassword) {
                // 登录成功
                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                // 在这里可以进行登录后的操作，如跳转到主界面
            } else {
                // 登录失败
                Toast.makeText(this@LoginActivity, "아이디나 비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
