package at.thealoofpotato.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    var adapter: FragmentAdapter? = null
    var tabLayout: TabLayout? = null
    var viewPager2: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager2)

        val fm: FragmentManager = supportFragmentManager
        adapter = FragmentAdapter(fm, lifecycle)
        viewPager2!!.adapter = adapter

        tabLayout!!.addTab(tabLayout!!.newTab().setText("1st"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("2nd"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("3rd"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("4th"))

        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        viewPager2!!.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout!!.selectTab(tabLayout!!.getTabAt(position))
            }
        })

    }
}