import kotlin.math.floor

class Population(target: String, mutationRate: Double, size: Int) {
    var size = size
    var target=target
        var finished = false
        var generations = 0
        var perfectScore = 1.0
  var  mutationRate = mutationRate
        var population= populationErstellen(this.size, this.target)
        var matingPool=mutableListOf<Dna>()
        var best = ""
    fun evolution(): String {
        while (!finished) {

            this.calcFitness()
            this.naturalSelection()

            this.generate()

            this.evaluate()
            println(getAverageFitness())
            println(matingPool.count())
            // If we found the target phrase, stop
        this.population.forEach(){
            print(it.genes)}
            println("")
        }
        return(best)}
    fun populationErstellen(size: Int, target: String):MutableList<Dna>{
        var population= mutableListOf<Dna>()
        repeat(size){
            var a = Dna(target.length, target)
            population.add(a)
        }

        return population
    }
    fun calcFitness() {
        for (i in  population.indices) {
            this.population[i].calcFitness(target = this.target)
        }
    }
   fun naturalSelection() {
       // Clear the ArrayList
       var maxFitness = 0.0
       for (i in population.indices) {
           if (this.population[i].fitness > maxFitness) {
               maxFitness = this.population[i].fitness
           }
       }
       // Based on fitness, each member will get added to the mating pool a certain number of times
       // a higher fitness = more entries to mating pool = more likely to be picked as a parent
       // a lower fitness = fewer entries to mating pool = less likely to be picked as a parent
       var totalFitness =0.0
       matingPool=mutableListOf<Dna>()
       for (i in population.indices){totalFitness+=population[i].fitness}
       for (i in population.indices) {

           var n:Int =((population[i].fitness/totalFitness)*1000).toInt() // Arbitrary multiplier, we can also use monte carlo method
           repeat(n) {
           this.matingPool.add(this.population[i])
       }
       }
   }
    fun generate() {
        // Refill the population with children from the mating pool

        for (i in population.indices) {
            val partnerA= matingPool.random()
            val partnerB = matingPool.random()
            val child = partnerA.crossover(partnerB)
            child.mutate(this.mutationRate)
            population[i] = child
        }
        generations++
    }

    @JvmName("getBest1")
    fun getBest(): String {
        return best
    }

    // Compute the current "most fit" member of the population
  fun  evaluate() {
        var worldrecord = 0.0
        var index = 0
        for (i in population.indices) {
            if (this.population[i].fitness > worldrecord) {
                index = i
                worldrecord = this.population[i].fitness
            }
        }

        this.best = ""
        this.population[index].genes.forEach(){
            best+=it
        }

        if (worldrecord == this.perfectScore) {
            this.finished = true
        }
    }



   @JvmName("getGenerations1")
   fun getGenerations(): Int {
        return this.generations
    }

    // Compute average fitness for the population
    fun getAverageFitness(): Double {
        var total = 0.0
        for (i in population.indices) {
            total += population[i].fitness
        }
        return total / (this.population.size)
    }


}


