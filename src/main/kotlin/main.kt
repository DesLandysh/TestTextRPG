fun clear_screen() {
    val cls = arrayListOf("cmd.exe", "/c", "cls")
    ProcessBuilder(cls).inheritIO().start().waitFor()
}

fun main(args: Array<String>) {
    print("Enter your name: ")
    val userName = readln()
    val hero = Hero(userName, 100.0, iron_sword)
    val enemy = Enemy(name = "Enemy", health = 100.0, short_bow)

    println("Hello, ${hero.name}!")

    while (readln() != "0") {
        clear_screen()
        //hero.equip(iron_sword)

        hero.attack(enemy)
        enemy.attack(hero)

        if (hero.weapon != fists) hero.drop()

        hero.healthBar.draw()
        enemy.healthBar.draw()
    }
}