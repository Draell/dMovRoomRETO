package com.example.dmovroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dmovroom.database.User
import com.example.dmovroom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name : String
        var lastId : Int = 0

        binding.btnSave.setOnClickListener {
            name = binding.etUsuario.text.toString()
            binding.etUsuario.setText("")


        /* mainViewModel.saveUser(User(
            "Userid0001",
            "name001b",
            1.72,
            72.2,
            "user001@email.com",
            "passworduser001"

        ))*/

        mainViewModel.getUsers()

        mainViewModel.savedUsers.observe(this) { usersList ->
            if (usersList.isNotEmpty()) {
                for (user in usersList) {
                    if(user.user_id > lastId){
                        lastId = user.user_id
                    }
                }
            }
        }

        //Si es Fragment es con viewLifecycleOwner en vez de this
      /*  mainViewModel.savedUsers.observe(this) { usersList ->
            if (usersList.isNotEmpty()) {
                for (user in usersList) {
                    if(user.user_id > ultimoId){

                    }
                    Log.d("EstosSonLosUsuarios", user.user_name)
                    binding.rvNombresRec.adapter = MainAdapter(usersList)
                }
            } else {
                Log.d("EstosSonLosUsuarios", "null or empty")
            }
        } */

    lastId ++
    mainViewModel.saveUser(
        User(
            lastId,
            name
        )
    )

            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (usersList.isNotEmpty()) {
                    binding.rvUsers.adapter = MainAdapter(usersList)
                }
            }

    }
    }
}