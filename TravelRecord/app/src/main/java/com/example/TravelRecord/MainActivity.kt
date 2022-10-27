package com.example.TravelRecord
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.TravelRecord.MainButton.PackingActivity
import com.example.TravelRecord.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    lateinit var adapter: UserAdapter

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    private lateinit var userList: ArrayList<User>

//    val positiveButtonClick = {
//            dialogInterface: DialogInterface, i: Int ->
//        Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
//    }
//    val negativeButtonClick = {
//            dialogInterface: DialogInterface, i: Int ->
//        Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
//    }
//    val neutralButtonClick = {
//            dialogInterface: DialogInterface, i: Int ->
//        Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.logoutBtn.setOnClickListener {
//            AlertDialog.Builder() builder=new AlertDialog.Builder(MainActivity.this)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("로그아웃 하시겠습니까?")
            builder.setMessage("로그인 화면으로 돌아갑니다.")
            builder.setPositiveButton("확인") {
                    dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
                FirebaseAuth.getInstance().signOut()
                val intent: Intent = Intent(this@MainActivity, LogInActivity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("취소") {
                    dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
            }
//            builder.setNeutralButton("Neutral") {
//                    dialogInterface: DialogInterface, i: Int ->
//                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
//            }
            builder.show()

        }
        binding.packingBtn.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, PackingActivity::class.java)
            startActivity(intent)
        }
    }

}

//    binding.logoutbtn.setOnClickListener {
//        val intent: Intent = Intent(this@LogInActivity, SignUpActivity::class.java)
//        startActivity(intent)
//    }

//    fun btn_logout(v: View?) {
//        Builder(this)
//            .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
//            .setPositiveButton("로그아웃", DialogInterface.OnClickListener { dialog, whichButton ->
//                val i = Intent(this@Main1_main, Login::class.java)
//                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
//                startActivity(i)
//            })
//            .setNegativeButton("취소",
//                DialogInterface.OnClickListener { dialog, whichButton -> })
//            .show()
//    }


//    else {
//        val btnLogout = findViewById<Button>(R.id.btnLogout) as Button
//        btnLogin.visibility = View.GONE // 반대로 로그인이 되어 있는 상태에서 로그인을 볼 필요가 없기에 GONE 한다.
//        btnLogout.setOnClickListener{
//            val intent = Intent(this, LogoutActivity::class.java)
//            startActivity(intent)
//        }
