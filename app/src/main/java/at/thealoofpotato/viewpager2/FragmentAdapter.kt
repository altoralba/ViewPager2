package at.thealoofpotato.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import at.thealoofpotato.viewpager2.Fragments.Page1
import at.thealoofpotato.viewpager2.Fragments.Page2
import at.thealoofpotato.viewpager2.Fragments.Page3
import at.thealoofpotato.viewpager2.Fragments.Page4


class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            1 -> return Page2()
            2 -> return Page3()
            3 -> return Page4()
        }
        return Page1()
    }

    override fun getItemCount(): Int {
        return 4
    }
}