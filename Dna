import kotlin.math.floor

class Dna(size:Int, target: String) {


    var target=target
     var size= size
   var genes =geneErstellen()
     //var chars = charArrayOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','.',',','!','?')
    var chars="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ,.!?"
  var   fitness= calcFitness(target)
     fun geneErstellen(): MutableList<Char> {
       var chars="abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ,.!?"
        // var list=MutableList<Char>(size,chars.random())
         var list=mutableListOf<Char>()
         for (i in target.indices) {

            val rnd = chars.random()
           list.add(rnd)
       }
         return list
    }

   fun  calcFitness(target:String): Double {
         var score = 0.0
         for ( i in  genes.indices) {
             if (this.genes[i] == target.toCharArray()[i]) {
                 score++
             }
         }
          return (score / size)

     }

     // Crossover
    fun crossover(partner:Dna): Dna {
         // A new child
         var child = Dna(this.genes.size,this.target);

         var midpoint:Int = (0..this.size-1).random() // Pick a midpoint

         // Half from one, half from the other
         for (i in child.genes.indices) {
             if (i > midpoint) child.genes[i] = this.genes[i]
             else child.genes[i] = partner.genes[i]
         }
         return child;
     }

     // Based on a mutation probability, picks a new random character
     fun mutate(mutationRate:Double) {
         for (i in this.genes.indices) {
             if ((1..100).random()/100 < mutationRate) {
                 this.genes[i] = chars.random()
             }
         }
     }
 }
