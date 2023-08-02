abstract class Character(val name: String, var health: Double, var weapon: Weapon) {
    val healthMax = this.health
    open lateinit var healthBar: HealthBar

    open fun attack(target: Character) {
        target.health -= this.weapon.damage
        target.health = maxOf(target.health, 0.0)
        target.healthBar.update()
        println("${this.name} dealt ${this.weapon.damage}" +
                "${this.weapon.type} damage to ${target.name} with the ${this.weapon.name}")
    }
}

class Hero(name: String, health: Double, weapon: Weapon) : Character(name, health, weapon) {
    private val defaultWeapon = fists
    override var healthBar = HealthBar(this, isColored = true, _color = "red")

    fun equip(weapon: Weapon) {
        this.weapon = weapon
        println("${this.name} equipped the ${this.weapon.name}")
    }

    fun drop() {
        println("${this.name} dropped the ${this.weapon.name}")
        this.weapon = defaultWeapon
    }
}

class Enemy(name: String, health: Double, weapon: Weapon) : Character(name, health, weapon){
    override var healthBar = HealthBar(this, isColored = true, _color = "green")
}