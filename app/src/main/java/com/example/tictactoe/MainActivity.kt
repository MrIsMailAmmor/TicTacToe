package com.example.tictactoe

import android.app.Application
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buClick(view: View){

        val buChoice = view as Button
        var cellId = 0
    when(buChoice.id){
        R.id.button -> cellId = 1
        R.id.button2 -> cellId = 2
        R.id.button3 -> cellId = 3
        R.id.button4 -> cellId = 4
        R.id.button5 -> cellId = 5
        R.id.button6 -> cellId = 6
        R.id.button7 -> cellId = 7
        R.id.button8 -> cellId = 8
        R.id.button9 -> cellId = 9
    }
        PlayGame(cellId,buChoice)
        checkWinner()
    }
    private var player1= ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun PlayGame(number:Int, buchoice : Button){

        if(activePlayer==1){
            buchoice.text="X"
            buchoice.setBackgroundColor(Color.BLUE)
            player1.add(number)
            activePlayer =2


        }else{
            buchoice.text="O"
            buchoice.setBackgroundColor(Color.RED)
            player2.add(number)
            activePlayer=1


        }
        buchoice.isEnabled=false
        
    }

    var P1Score = 0
    var P2Score = 0

    fun checkWinner(){
        var winner =- 1

        if((player1.contains(1)&&player1.contains(2)&&player1.contains(3)) || (player1.contains(4)&&player1.contains(5)&&player1.contains(6)) || (player1.contains(7)&&player1.contains(8)&&player1.contains(9)) || (player1.contains(1)&&player1.contains(5)&&player1.contains(9)) || (player1.contains(3)&&player1.contains(5)&&player1.contains(7))){
            winner = 1

        }
        if((player2.contains(1)&&player2.contains(2)&&player2.contains(3)) || (player2.contains(4)&&player2.contains(5)&&player2.contains(6)) || (player2.contains(7)&&player2.contains(8)&&player2.contains(9)) || (player2.contains(1)&&player2.contains(5)&&player2.contains(9)) || (player2.contains(3)&&player2.contains(5)&&player2.contains(7))){
            winner = 2

        }

        if((player1.contains(1)&&player1.contains(4)&&player1.contains(7)) ||(player1.contains(2)&&player1.contains(5)&&player1.contains(8)) ||(player1.contains(3)&&player1.contains(6)&&player1.contains(9))){
            winner = 1
        }
        if((player2.contains(1)&&player2.contains(4)&&player2.contains(7)) ||(player2.contains(2)&&player2.contains(5)&&player2.contains(8)) ||(player2.contains(3)&&player2.contains(6)&&player2.contains(9))){
            winner = 2
        }

        //check if Draw
        var buttonTaken= ArrayList<Int>()
        for (cellId in 0..9){
            if(player1.contains(cellId) || player2.contains(cellId)){
                buttonTaken.add(cellId)
            }
        }
        if (buttonTaken.size === 9  && winner===-1){

            redo(findViewById(R.id.redo))
            buttonTaken.clear()
            winner =3
        }

        if(winner!=-1){
            if(winner ===1){
                Toast.makeText(this, "Player 1 Won the game", Toast.LENGTH_SHORT).show()
                redo(findViewById(R.id.redo))
                P1Score++
                ScoreText.text="Player 1 : $P1Score Player 2 : $P2Score"

            }
            if(winner ===2){
                Toast.makeText(this, "Player 2 Won the game", Toast.LENGTH_SHORT).show()
                redo(findViewById(R.id.redo))
                P2Score++
                ScoreText.text="Player 1 : $P1Score Player 2 : $P2Score"
            }
            if(winner===3){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
            }
        }
    }


        fun redo(view: View) {
            try {
                var listBtn = arrayOf(button, button2, button3, button4, button5, button6, button7, button8, button9)
                val it: Iterator<Button> = listBtn.iterator()

                while (it.hasNext()) {

                    val e = it.next()
                    e.isEnabled=true
                    e.text=""
                }
                player1.clear()
                player2.clear()

            }catch (e:Exception){
                println(e)
            }
        }

    fun redoBtn(view: View) {
        try {
            var listBtn = arrayOf(button, button2, button3, button4, button5, button6, button7, button8, button9)
            val it: Iterator<Button> = listBtn.iterator()

            while (it.hasNext()) {

                val e = it.next()
                e.isEnabled=true
                e.text=""
            }
            player1.clear()
            player2.clear()

            P1Score= 0
            P2Score=0
            ScoreText.text="Player 1 : $P1Score Player 2 : $P2Score"

        }catch (e:Exception){
            println(e)
        }
    }



        fun autoPlay(){

        val emptyList = ArrayList<Int>()

        for (cellId in 1..9){
            if(!player1.contains(cellId) || !player2.contains(cellId)){
                emptyList.add(cellId)
            }
        }
        val random = (emptyList.size..0).random()

    }

}


