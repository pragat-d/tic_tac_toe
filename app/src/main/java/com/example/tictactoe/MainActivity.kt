package com.example.tictactoe

import android.annotation.SuppressLint
import android.os.Build

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var totalButtonPress : Int = 0;
    var matrix: Array<IntArray> = Array(3) { IntArray(3) }
    var result : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeToolbar.setTitle("Tic Tac Toe")
        homeToolbar.setOnMenuItemClickListener(@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        object : Toolbar.OnMenuItemClickListener, androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean { if(item?.itemId == R.id.gameRefresh){
                clearData()
            }
               return true;
            }
        })
        button1.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button1?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[0][0] = 2;
                    }else {
                        matrix[0][0] = 1;
                    }
                    setButtonImage(button1)
                }
            }
        })

        button2.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button2?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[0][1] = 2;
                    }else {
                        matrix[0][1] = 1;
                    }
                    setButtonImage(button2)
                }
            }
        })

        button3.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button3?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[0][2] = 2;
                    }else {
                        matrix[0][2] = 1;
                    }
                    setButtonImage(button3)
                }
            }
        })

        button4.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button4?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[1][0] = 2;
                    }else {
                        matrix[1][0] = 1;
                    }
                    setButtonImage(button4)
                }
            }
        })

        button5.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button5?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[1][1] = 2;
                    }else {
                        matrix[1][1] = 1;
                    }
                    setButtonImage(button5)
                }
            }
        })

        button6.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button6?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[1][2] = 2;
                    }else {
                        matrix[1][2] = 1;
                    }
                    setButtonImage(button6)
                }
            }
        })

        button7.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button7?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[2][0] = 2;
                    }else {
                        matrix[2][0] = 1;
                    }
                    setButtonImage(button7)
                }
            }
        })

        button8.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button8?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[2][1] = 2;
                    }else {
                        matrix[2][1] = 1;
                    }
                    setButtonImage(button8)
                }
            }
        })


        button9.setOnClickListener(object : View.OnClickListener{
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(v: View?) {
                if(button9?.getTag() != "yes" && result.equals("")){
                    totalButtonPress++;
                    if(totalButtonPress%2 == 0){
                        matrix[2][2] = 2;
                    }else {
                        matrix[2][2] = 1;
                    }
                    setButtonImage(button9)
                }
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setButtonImage(button : Button?) {
        if(totalButtonPress <= 9){
            if(button?.getTag() != "yes"){
                if(totalButtonPress % 2 == 0){
                    button?.background = resources.getDrawable(R.drawable.ic_check)
                    button?.setTag("yes")
                }else {
                    button?.background = resources.getDrawable(R.drawable.ic_cross)
                    button?.setTag("yes")
                }
                if(totalButtonPress >=5){
                     result = result()
                    if(result.equals("win")){

                        if(totalButtonPress %2 != 0){
                            Toast.makeText(this,"Player 1 wins",Toast.LENGTH_LONG).show()
                            winner.setText("Player 1 wins")
                        }else {
                            Toast.makeText(this,"Player 2 wins",Toast.LENGTH_LONG).show()
                            winner.setText("Player 2 wins")
                        }
                    }else if(result.equals("draw")) {
                        Toast.makeText(this,"Its A Draw",Toast.LENGTH_LONG).show()
                        winner.setText("Draw")
                    }
                }
            }
        }
    }

    private fun result() :String {
        var winner : Boolean =false
        for(i in 0..2){
            if( !matrix[i][0].equals(0) && matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])){
                winner = true
            }

            if( !matrix[0][i].equals(0)  && matrix[0][i].equals(matrix[1][i]) && matrix[0][i].equals(matrix[2][i])){
                winner = true
            }
        }

        if(!winner){

            if(!matrix[0][0].equals(0) && matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2])){
                winner =true;
            }

            if(!matrix[0][2].equals(0) && matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0])){
                winner =true;
            }
        }
        if(totalButtonPress == 9 && winner == false){
            return "draw"
        }else if (totalButtonPress < 9 && winner == true) {
            return "win"
        } else if(totalButtonPress == 9 && winner == true){
            return "win"
        }else {
            return ""
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceType")
    private fun clearData() {
        totalButtonPress = 0
        matrix = Array(3) { IntArray(3) }
        result = ""
        winner.text = ""
        button1?.background = resources.getDrawable( R.color.black)
        button1.setTag("no")
        button2?.background= resources.getDrawable( R.color.black)
        button2.setTag("no")
        button3?.background= resources.getDrawable( R.color.black)
        button3.setTag("no")
        button4?.background= resources.getDrawable( R.color.black)
        button4.setTag("no")
        button5?.background= resources.getDrawable( R.color.black)
        button5.setTag("no")
        button6?.background= resources.getDrawable( R.color.black)
        button6.setTag("no")
        button7?.background= resources.getDrawable( R.color.black)
        button7.setTag("no")
        button8?.background= resources.getDrawable( R.color.black)
        button8.setTag("no")
        button9?.background= resources.getDrawable( R.color.black)
        button9.setTag("no")
    }

}