package me.evieiles.addytrackerv4

import android.app.Dialog
import android.content.Intent
import android.media.Image
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
import android.widget.Spinner
import me.evieiles.addytrackerv4.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btnHelp: ImageView;
    private lateinit var dialog: Dialog;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //sets up Navbar View
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


