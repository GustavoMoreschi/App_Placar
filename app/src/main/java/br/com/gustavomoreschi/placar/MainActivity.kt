package br.com.gustavomoreschi.placar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.gustavomoreschi.placar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var playerOneScore = 0
    private var playerTwoScore = 0

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setUpExtras(savedInstanceState)

        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btPlayerOneScore.setOnClickListener {
            playerOneScore++
            setUpScorePlayerOne()
        }

        binding.btPlayerTwoScore.setOnClickListener {
            playerTwoScore++
            setUpScorePlayerTwo()
        }
        binding.btFinishMatch.setOnClickListener {
            finish()
        }
        binding.btRestart.setOnClickListener {
            restart()
        }
    }

    private fun setUpScorePlayerOne() {
        binding.tvPlayerOneScore.text = playerOneScore.toString()
    }

    private fun setUpScorePlayerTwo() {
        binding.tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun restart() {
        playerOneScore = 0
        playerTwoScore = 0
        setUpScorePlayerOne()
        setUpScorePlayerTwo()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER_ONE_SCORE", playerOneScore)
        outState.putInt("PLAYER_TWO_SCORE", playerTwoScore)
    }

    private fun setUpExtras(savedInstanceState: Bundle?) {
        if(savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt("PLAYER_ONE_SCORE")
            playerTwoScore = savedInstanceState.getInt("PLAYER_TWO_SCORE")
            setUpScorePlayerOne()
            setUpScorePlayerTwo()
        }
    }
}