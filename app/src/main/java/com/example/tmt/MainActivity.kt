package com.example.tmt

import android.content.Intent
import android.content.SharedPreferences.Editor
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.main_nav_drawer.*
import kotlinx.android.synthetic.main.main_toolbar.*


class MainActivity : AppCompatActivity() {
    // Intialize variable for navigation
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        if(FirebaseAuth.getInstance().currentUser == null)
        {
            val intent = Intent(this, LoginRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }


         val buttonA = findViewById<Button>(R.id.button_A)
         val buttonB = findViewById<Button>(R.id.button_B)

        val timeA = findViewById<TextView>(R.id.timeA)
        val timeB = findViewById<TextView>(R.id.timeB)

        val metrics = findViewById<LinearLayout>(R.id.Metrics)

        val fullName = findViewById<TextView>(R.id.fullName)



      //  val userInfo = getSharedPreferences("UserInfo",0)
        if(FirebaseAuth.getInstance().currentUser == null) {
            fullName.setText("Hello Mr.  Unknown")
        } else {
            fullName.setText("Hello Mr. " + FirebaseAuth.getInstance().currentUser.displayName.toString())
        }
      //  Log.d("Email" , "THIS IS THE USERSEMAIL " + FirebaseAuth.getInstance().currentUser.email.toString())

        val sharedPreferences = getSharedPreferences("sharedPrefs",0)
        val lastTimeA = sharedPreferences.getString("STRING_KEYA", null)
        val lastTimeB = sharedPreferences.getString("STRING_KEYB",null)

        if (lastTimeA == null) {
            val editor: Editor = sharedPreferences.edit()
            editor.putInt("Last time on part A", 0)
            editor.apply()
        } else {
            timeA.setText("Last time on part A: " + lastTimeA)
        }

        if (lastTimeB == null) {
            val editor: Editor = sharedPreferences.edit()
            editor.putInt("Last time on Part B", 0)
            editor.apply()
        } else {
            timeB.setText("Last time on part B: " + lastTimeB)
        }



        val animDrawable = drawer_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        buttonA.setOnClickListener{
            val intent = Intent(this, TMTA::class.java)
            startActivity(intent)

        }

        buttonB.setOnClickListener{
            val intent = Intent(this, TMTB::class.java)
            startActivity(intent)

        }




        //Assign variable for navigation bar
        drawerLayout = findViewById(R.id.drawer_layout)

        fun openDrawer(drawerLayout: DrawerLayout?)
        {

            drawerLayout?.openDrawer(GravityCompat.START)
        }

        fun closeDrawer(drawerLayout: DrawerLayout?)
        {
            Log.d("TAGCLOSE", "YOU CLOSED MEEEE!!")
            //Close drawer layout
            //Check condition
            if (drawerLayout != null) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    //When drawer is open
                    //Close drawer
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
        }

        ClickLogo.setOnClickListener{
          //  Log.d("TAGMENU", "CONGRATS YOU PRESSED ON THE LOGO!!")
            closeDrawer(drawerLayout)

        }

        ClickMenu.setOnClickListener{
          //  Log.d("TAGMENU", "CONGRATS YOU PRESSED ON THE MENU!!")
            openDrawer(drawerLayout)
        }

        ClickHome.setOnClickListener{
          //  Log.d("TAGMENU", "CONGRATS YOU PRESSED ON THE MENU!!")
            closeDrawer(drawerLayout)
        }



        ClickAboutUs.setOnClickListener(){

            val intentAbout = Intent(this, About::class.java)
            intentAbout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentAbout)

        }


        ClickLogout.setOnClickListener{
            // Make the user logout
            AuthUI.getInstance().signOut(this)
            val intent = Intent(this,LoginRegisterActivity::class.java)
            startActivity(intent)
        }


        metrics.setOnClickListener {

        }





    }
}





