fun main(){
    var target = "Hallo"
    var size = 200
    var mutationRate= 0.01
    var chars = "abcdefghijklmnopqrstuvwxyz"
    var list=mutableListOf<Char>()

  val population = Population(target, mutationRate, size)
  var a= population.evolution()
    println(a)
    println (population.best)
    //println("generations:${population.generations}")
    }

