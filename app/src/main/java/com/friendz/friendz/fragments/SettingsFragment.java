package com.friendz.friendz.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.friendz.friendz.R;

import android.support.v7.preference.PreferenceFragmentCompat;
public class SettingsFragment extends PreferenceFragmentCompat {

    private OnSettingsFragmentInteraction settingsFragmentInteraction;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnSettingsFragmentInteraction) {
            settingsFragmentInteraction = (OnSettingsFragmentInteraction)context;
        }
    }

    public interface OnSettingsFragmentInteraction {

        public void openProfile();
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String rootKey) {
        // Load the Preferences from the XML file
        setPreferencesFromResource(R.xml.preferences, rootKey);

        Preference button = findPreference("OpenProfile");
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //code for what you want it to do

                settingsFragmentInteraction.openProfile();
                return true;
            }
        });
    }


}
