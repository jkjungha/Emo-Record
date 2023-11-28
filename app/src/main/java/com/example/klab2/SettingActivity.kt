import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.myapplication.LoadingHelper

class SettingActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 设置对应的 XML 布局文件

        loadingHelper = LoadingHelper(this)
    }

    // 重写 onCreateOptionsMenu 方法以创建菜单项
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    // 处理菜单项点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_profile -> {
                // 在点击更改个人信息菜单项时显示加载动画
                showLoading()

                // 处理更改个人信息
                val intent = Intent(this, ChangeProfileActivity::class.java)
                startActivity(intent)

                // 隐藏加载动画
                hideLoading()
                return true
            }
            R.id.change_password -> {
                // 在点击更改密码菜单项时显示加载动画
                showLoading()

                // 处理更改密码
                val intent = Intent(this, ChangePasswordActivity::class.java)
                startActivity(intent)

                // 隐藏加载动画
                hideLoading()
                return true
            }
            R.id.change_theme -> {
                // 在点击设置主题菜单项时显示加载动画
                showLoading()

                // 处理设置主题
                val intent = Intent(this, SettingThemeActivity::class.java)
                startActivity(intent)

                // 隐藏加载动画
                hideLoading()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
