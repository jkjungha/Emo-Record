import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.myapplication.LoadingHelper

class SettingThemeActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper
    private lateinit var themeRadioGroup: RadioGroup
    private lateinit var lightThemeRadioButton: RadioButton
    private lateinit var darkThemeRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 初始化 LoadingHelper
        loadingHelper = LoadingHelper(this)

        // 初始界面为白色主题
        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.change_theme)

        themeRadioGroup = findViewById(R.id.themeRadioGroup)
        lightThemeRadioButton = findViewById(R.id.lightThemeRadioButton)
        darkThemeRadioButton = findViewById(R.id.darkThemeRadioButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        themeRadioGroup.check(R.id.lightThemeRadioButton)

        themeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            // 在选择主题时显示加载动画
            showLoading()

            if (checkedId == R.id.lightThemeRadioButton) {
                setTheme(R.style.AppTheme_Light)
            } else if (checkedId == R.id.darkThemeRadioButton) {
                setTheme(R.style.AppTheme_Dark)
            }

            // 隐藏加载动画并重新创建 Activity 以应用主题更改
            hideLoading()
            recreate()
        }

        backToLoginButton.setOnClickListener {
            // 在返回按钮点击时显示加载动画
            showLoading()

            // 创建一个 Intent 以返回到设置界面
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)

            // 延迟一段时间后隐藏加载动画
            backToLoginButton.postDelayed({
                // 隐藏加载动画
                hideLoading()
            }, 500) // 根据需要调整延迟时间
        }
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
