import kotlin.math.round

data class SymbolGraphic(
    val symbolRemaining: String = "█",
    val symbolLost: String = "_",
    val barrier: Char = '|',
    val colors: Map<String, String> = mapOf(
        "red" to "\u001b[91m",
        "purple" to "\u001b[95m",
        "blue" to "\u001b[34m",
        "blue2" to "\u001b[36m",
        "blue3" to "\u001b[96m",
        "green" to "\u001b[92m",
        "green2" to "\u001b[32m",
        "brown" to "\u001b[33m",
        "yellow" to "\u001b[93m",
        "grey" to "\u001b[37m",
        "default" to "\u001b[0m"
    )
)

class HealthBar(
    private val entity: Character,
    private val length: Double = 20.0,
    val isColored: Boolean = false,
    _color: String = ""
) {
    private val maxHP: Double = entity.healthMax
    private var currentHP: Double = entity.health

    private val colors = SymbolGraphic()
    private var color: String

    init {
        this.color = colors.colors.getOrDefault(_color, "default")
    }

    fun update(){
        this.currentHP = this.entity.health
    }

    fun draw(){
        val remainingBars: Int = round(currentHP / maxHP * length).toInt()
        val lostBars: Int = (length - remainingBars).toInt()
        println("${entity.name}'s HEALTH: ${(entity.health).toInt()}/${(entity.healthMax).toInt()}")
        println("${colors.barrier}" +
                (if (isColored) color else " ") +
                colors.symbolRemaining.repeat(remainingBars) +
                colors.symbolLost.repeat(lostBars) +
                (if (isColored) colors.colors["default"] else " ") +
                "${colors.barrier}"
        )
    }
}