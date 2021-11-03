package me.evieiles.addytrackerv4

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import me.evieiles.addytrackerv4.databinding.ActivityMainBinding
import me.evieiles.addytrackerv4.databinding.HelpDialogBinding
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import me.evieiles.addytrackerv4.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btnHelp: ImageView;
    private lateinit var dialog: Dialog;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val steroids = resources.getStringArray(R.array.steroids)
//        // create an array adapter and pass the required parameter
//        // in our case pass the context, drop down layout , and array.
//        val arrayAdapter = ArrayAdapter(DashboardFragment, R.layout.steroid_dropdown, steroids)
//        val steroidChoice = findViewById<AutoCompleteTextView>(R.id.cSteroid)
//        steroidChoice.setAdapter(arrayAdapter)



        val navView: BottomNavigationView = binding.navView
        //Sets questionmark icon as button to trigger help popup.
        btnHelp = findViewById<ImageView>(R.id.btnHelp)

        //Help Popup
        btnHelp.setOnClickListener{
            dialog =  Dialog(this);
            dialog.setContentView(R.layout.help_dialog)
            dialog.show()
        }







        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }


    }


