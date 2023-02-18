class RockPaperScissors(){
    var winComputer = 0
    var winPlayer = 0
    var inputGame: Array<String> = arrayOf("Paper", "Rock", "Scissors")

    fun play(){
        println( "Welcome to Game Paper Rock And Scissors" )
        println( "1. Paper" )
        println( "2. Rock" )
        println( "3. Scissors" )
        println( "Point Computer : $winComputer" )
        println( "Point Player : $winPlayer" )

        if ( winPlayer == 3 || winComputer == 3 ){
            checkWinner()
        } else {
            checkUserInput()
            play()
        }

    }

    fun checkUserInput() {
        print("Player Input by number (1/2/3) = ")
        var inputUser = 0
        try {
            inputUser = readLine()?.toInt() ?: null
        } catch (e: NumberFormatException) {
            println("input jangan kosong")
        }
        inputUser -= 1
        if (inputUser in 0..2 ) {
            var inputComputer = ( 0..2 ).random()
            return  checkRound(inputComputer,inputUser)
        } else {
            println("Input tidak valid. Harap masukkan angka 1, 2, atau 3.")
            return checkUserInput()
        }
    }

    fun checkRound( inputComputer: Int ,inputPlayer: Int ){
        if ( inputComputer == inputPlayer ) {
            println( "Player input ${ inputGame[ inputPlayer  ] } vs Computer Input ${ inputGame[ inputComputer ] } ")
            println( "Game Tie" )
        } else if ( inputPlayer.equals(0) && inputComputer.equals(1) ||
            inputPlayer.equals(1) && inputComputer.equals(2) ||
            inputPlayer.equals(2) && inputComputer.equals(0) ) {
            println( "Player input ${ inputGame[inputPlayer] } vs Computer Input ${ inputGame[inputComputer] } ")
            println( "Point Player +1" )
            winPlayer++
            println( "Point Player Sekarang $winPlayer" )
        } else {
            println( "Player input ${ inputGame[inputPlayer] } vs Computer Input ${ inputGame[inputComputer] } " )
            println( "Point Computer +1" )
            winComputer++
            println( "Point Computer Sekarang $winComputer" )
        }
    }

    fun checkWinner(){
        if ( winPlayer > winComputer ) {
            println( "Player Win" )
        } else {
            println( "Computer Win" )
        }
    }

}