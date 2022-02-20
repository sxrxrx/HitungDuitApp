package com.ngedev.hitungduit.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.utils.NightMode

class SettingFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val listPreference = findPreference<ListPreference>(getString(R.string.pref_key_dark))
        listPreference?.setOnPreferenceChangeListener { _, newValue ->
            val value = listPreference.findIndexOfValue(newValue.toString())
            updateTheme(value)
        }
    }

    private fun updateTheme(nightMode: Int): Boolean {
        when(nightMode) {
            0 -> AppCompatDelegate.setDefaultNightMode(NightMode.AUTO.value)
            1 -> AppCompatDelegate.setDefaultNightMode(NightMode.ON.value)
            2 -> AppCompatDelegate.setDefaultNightMode(NightMode.OFF.value)
        }
        requireActivity().recreate()
        return true
    }
}