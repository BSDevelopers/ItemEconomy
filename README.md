# ItemEconomy
This is an addon for the SimplePets v5 plugin.
It allows players to purchase pets by using In-Game Items configured in its config
The items used as currency can be Custom Models you just need to know what material the item is and what the CustomModelData number is

### Optional Requirements:
- [Custom Items](https://www.spigotmc.org/resources/63848/) Plugin
- [ItemsAdder](https://www.spigotmc.org/resources/73355/) Plugin
- Or any other plugin that adds custom item models (The CustomModelData number and the base material is needed from these plugins)


### Default configuration (Located in `plugins/SimplePets/Addons/config/ItemEconomy.yml`)
```yaml
# Disabling this will make the items show the price, but if the player has bypass permissions he wont have to pay
# 
# Default: 'true'
Hide-Price-If-Bypassed: true

# Should players have to pay each time they spawn a pet?
# 
# Default: 'false'
Pay-Per-Use-Enabled: false

Price:
  # If a pet is free this will be in the place of the price in the lore
  # 
  # Default: 'FREE'
  Free: FREE
  # If the player has the bypass permission, will be in the place of the price in the lore
  # 
  # Default: 'BYPASSED'
  Bypassed: BYPASSED

# Here is where you can set the translations for the 2 boolean values (true/false)
Boolean:
  # Default: '&#92fc98true'
  'true': '&#92fc98true'
  # Default: '&#fa7d7dfalse'
  'false': '&#fa7d7dfalse'

Messages:
  PurchaseSuccessful:
    # This message will be sent if the purchase it successful
    # Placeholders:
    # - {type} (will get what type of pet it is)
    # - {cost-display} (A custom display of what the pet will cost)
    # 
    # Default: '&eSimplePets &6>> &7You have successfully purchased the {type} pet.'
    One-Time-Purchase: '&eSimplePets &6>> &7You have successfully purchased the {type}
      pet.'
    # This message will be sent if the purchase it successful
    # Placeholders:
    # - {type} (will get what type of pet it is)
    # - {cost-display} (A custom display of what the pet will cost)
    # 
    # Default: '&eSimplePets &6>> &7You have successfully paid for the {type} pet.'
    Pay-Per-Use: '&eSimplePets &6>> &7You have successfully paid for the {type} pet.'

  # This message will be sent if the purchase it successful
  # Placeholders:
  # - {type} (will get what type of pet it is)
  # - {cost-display} (A custom display of what the pet will cost)
  # 
  # Default: '&eSimplePets &6>> &cYou do not have the item(s) to buy this pet, you need to have {cost-display}'
  InsufficientFunds: '&eSimplePets &6>> &cYou do not have the item(s) to buy this
    pet, you need to have {cost-display}'

  Lore-Lines:
    # These Lore Lines will only be used if 'Pay-Per-Use' is set to false
    # Placeholders:
    # - {type} (will get what type of pet it is)
    # - {cost-display} (A custom display of what the pet will cost)
    # - {purchased} (true/false if the player purchased the pet)
    # 
    # Default: '[&#ffbf5ePrice: &#99ffac{cost-display}, &#ffbf5ePurchased: {purchased}]'
    One-Time-Purchase:
      - '&#ffbf5ePrice: &#99ffac{cost-display}'
      - '&#ffbf5ePurchased: {purchased}'

    # These Lore Lines will only be used if 'Pay-Per-Use' is set to true
    # Placeholders:
    # - {type} (will get what type of pet it is)
    # - {cost-display} (A custom display of what the pet will cost)
    # - {purchased} (true/false if the player purchased the pet)
    # 
    # Default: '[&#ffbf5ePrice: &#99ffac{cost-display}]'
    Pay-Per-Use:
      - '&#ffbf5ePrice: &#99ffac{cost-display}'


# Here I will explain what each value controls for all the pet type customization.
# - 'enabled'
#    This will allow you to toggle if the pet is FREE or if they have to pay
# - 'display'
#    This is what will be displayed as the 'price' of the item
#    This is customizable so you should be able to use Custom Items (Custom Model Data Items)
# 
#    Note: Colors can be used here ;)
# - 'material'
#    This is what controls what material the players have to pay with
#    If you are using CustomModels this will have to be the base item for the item
# 
#    See: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/Material.java#123
# - 'count'
#    This one is self explanatory how many of said item will the player pay with
# - 'custom-model-data'
#    If you have a resource pack that adds custom models chances are you use CustomModels
#    This allows you to specify what model of item you are using
#    (This is how other plugins such as ItemsAdder have support)
# 
#    Note: If you are not using Custom Models then set the value to -1
#    See:  https://mcmodels.net/how-to-tutorials/resource-pack-tutorials/what-is-custommodeldata-2/
type:
  allay:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  armor_stand:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  axolotl:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  bat:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  bee:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  blaze:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  camel:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  cat:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  cave_spider:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  chicken:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  cod:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  cow:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  creeper:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  dolphin:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  donkey:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  drowned:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  elder_guardian:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  enderman:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  endermite:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  evoker:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  fox:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  frog:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  ghast:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  giant:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  glow_squid:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  goat:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  guardian:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  hoglin:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  horse:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  husk:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  illusioner:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  iron_golem:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  llama:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  magma_cube:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  mooshroom:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  mule:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  ocelot:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  panda:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  parrot:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  phantom:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  pig:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  piglin:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  piglin_brute:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  pillager:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  polarbear:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  pufferfish:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  rabbit:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  ravager:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  salmon:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  sheep:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  shulker:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  silverfish:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  skeleton:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  skeleton_horse:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  slime:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  sniffer:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  snowman:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  spider:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  squid:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  stray:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  strider:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  tadpole:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  trader_llama:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  tropical_fish:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  turtle:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  vex:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  villager:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  vindicator:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  wandering_trader:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  warden:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  witch:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  wither:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  wither_skeleton:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  wolf:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  zoglin:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  zombie:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  zombie_horse:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  zombie_villager:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1
  zombified_piglin:
    enabled: true
    display: 10 Diamonds
    cost:
      material: DIAMOND
      count: 10
      custom-model-data: -1


bypass_permissions:
  # This is the master permission, Will ignore all individual bypass permissions listed below
  parent: pet.itemeconomy.bypass
  type:
    # This is a bypass permission for the allay pet, who ever has this permission will now have to pay for this pet
    allay: pet.itemeconomy.bypass.allay
    # This is a bypass permission for the armor_stand pet, who ever has this permission will now have to pay for this pet
    armor_stand: pet.itemeconomy.bypass.armor_stand
    # This is a bypass permission for the axolotl pet, who ever has this permission will now have to pay for this pet
    axolotl: pet.itemeconomy.bypass.axolotl
    # This is a bypass permission for the bat pet, who ever has this permission will now have to pay for this pet
    bat: pet.itemeconomy.bypass.bat
    # This is a bypass permission for the bee pet, who ever has this permission will now have to pay for this pet
    bee: pet.itemeconomy.bypass.bee
    # This is a bypass permission for the blaze pet, who ever has this permission will now have to pay for this pet
    blaze: pet.itemeconomy.bypass.blaze
    # This is a bypass permission for the camel pet, who ever has this permission will now have to pay for this pet
    camel: pet.itemeconomy.bypass.camel
    # This is a bypass permission for the cat pet, who ever has this permission will now have to pay for this pet
    cat: pet.itemeconomy.bypass.cat
    # This is a bypass permission for the cave_spider pet, who ever has this permission will now have to pay for this pet
    cave_spider: pet.itemeconomy.bypass.cave_spider
    # This is a bypass permission for the chicken pet, who ever has this permission will now have to pay for this pet
    chicken: pet.itemeconomy.bypass.chicken
    # This is a bypass permission for the cod pet, who ever has this permission will now have to pay for this pet
    cod: pet.itemeconomy.bypass.cod
    # This is a bypass permission for the cow pet, who ever has this permission will now have to pay for this pet
    cow: pet.itemeconomy.bypass.cow
    # This is a bypass permission for the creeper pet, who ever has this permission will now have to pay for this pet
    creeper: pet.itemeconomy.bypass.creeper
    # This is a bypass permission for the dolphin pet, who ever has this permission will now have to pay for this pet
    dolphin: pet.itemeconomy.bypass.dolphin
    # This is a bypass permission for the donkey pet, who ever has this permission will now have to pay for this pet
    donkey: pet.itemeconomy.bypass.donkey
    # This is a bypass permission for the drowned pet, who ever has this permission will now have to pay for this pet
    drowned: pet.itemeconomy.bypass.drowned
    # This is a bypass permission for the elder_guardian pet, who ever has this permission will now have to pay for this pet
    elder_guardian: pet.itemeconomy.bypass.elder_guardian
    # This is a bypass permission for the enderman pet, who ever has this permission will now have to pay for this pet
    enderman: pet.itemeconomy.bypass.enderman
    # This is a bypass permission for the endermite pet, who ever has this permission will now have to pay for this pet
    endermite: pet.itemeconomy.bypass.endermite
    # This is a bypass permission for the evoker pet, who ever has this permission will now have to pay for this pet
    evoker: pet.itemeconomy.bypass.evoker
    # This is a bypass permission for the fox pet, who ever has this permission will now have to pay for this pet
    fox: pet.itemeconomy.bypass.fox
    # This is a bypass permission for the frog pet, who ever has this permission will now have to pay for this pet
    frog: pet.itemeconomy.bypass.frog
    # This is a bypass permission for the ghast pet, who ever has this permission will now have to pay for this pet
    ghast: pet.itemeconomy.bypass.ghast
    # This is a bypass permission for the giant pet, who ever has this permission will now have to pay for this pet
    giant: pet.itemeconomy.bypass.giant
    # This is a bypass permission for the glow_squid pet, who ever has this permission will now have to pay for this pet
    glow_squid: pet.itemeconomy.bypass.glow_squid
    # This is a bypass permission for the goat pet, who ever has this permission will now have to pay for this pet
    goat: pet.itemeconomy.bypass.goat
    # This is a bypass permission for the guardian pet, who ever has this permission will now have to pay for this pet
    guardian: pet.itemeconomy.bypass.guardian
    # This is a bypass permission for the hoglin pet, who ever has this permission will now have to pay for this pet
    hoglin: pet.itemeconomy.bypass.hoglin
    # This is a bypass permission for the horse pet, who ever has this permission will now have to pay for this pet
    horse: pet.itemeconomy.bypass.horse
    # This is a bypass permission for the husk pet, who ever has this permission will now have to pay for this pet
    husk: pet.itemeconomy.bypass.husk
    # This is a bypass permission for the illusioner pet, who ever has this permission will now have to pay for this pet
    illusioner: pet.itemeconomy.bypass.illusioner
    # This is a bypass permission for the iron_golem pet, who ever has this permission will now have to pay for this pet
    iron_golem: pet.itemeconomy.bypass.iron_golem
    # This is a bypass permission for the llama pet, who ever has this permission will now have to pay for this pet
    llama: pet.itemeconomy.bypass.llama
    # This is a bypass permission for the magma_cube pet, who ever has this permission will now have to pay for this pet
    magma_cube: pet.itemeconomy.bypass.magma_cube
    # This is a bypass permission for the mooshroom pet, who ever has this permission will now have to pay for this pet
    mooshroom: pet.itemeconomy.bypass.mooshroom
    # This is a bypass permission for the mule pet, who ever has this permission will now have to pay for this pet
    mule: pet.itemeconomy.bypass.mule
    # This is a bypass permission for the ocelot pet, who ever has this permission will now have to pay for this pet
    ocelot: pet.itemeconomy.bypass.ocelot
    # This is a bypass permission for the panda pet, who ever has this permission will now have to pay for this pet
    panda: pet.itemeconomy.bypass.panda
    # This is a bypass permission for the parrot pet, who ever has this permission will now have to pay for this pet
    parrot: pet.itemeconomy.bypass.parrot
    # This is a bypass permission for the phantom pet, who ever has this permission will now have to pay for this pet
    phantom: pet.itemeconomy.bypass.phantom
    # This is a bypass permission for the pig pet, who ever has this permission will now have to pay for this pet
    pig: pet.itemeconomy.bypass.pig
    # This is a bypass permission for the piglin pet, who ever has this permission will now have to pay for this pet
    piglin: pet.itemeconomy.bypass.piglin
    # This is a bypass permission for the piglin_brute pet, who ever has this permission will now have to pay for this pet
    piglin_brute: pet.itemeconomy.bypass.piglin_brute
    # This is a bypass permission for the pillager pet, who ever has this permission will now have to pay for this pet
    pillager: pet.itemeconomy.bypass.pillager
    # This is a bypass permission for the polarbear pet, who ever has this permission will now have to pay for this pet
    polarbear: pet.itemeconomy.bypass.polarbear
    # This is a bypass permission for the pufferfish pet, who ever has this permission will now have to pay for this pet
    pufferfish: pet.itemeconomy.bypass.pufferfish
    # This is a bypass permission for the rabbit pet, who ever has this permission will now have to pay for this pet
    rabbit: pet.itemeconomy.bypass.rabbit
    # This is a bypass permission for the ravager pet, who ever has this permission will now have to pay for this pet
    ravager: pet.itemeconomy.bypass.ravager
    # This is a bypass permission for the salmon pet, who ever has this permission will now have to pay for this pet
    salmon: pet.itemeconomy.bypass.salmon
    # This is a bypass permission for the sheep pet, who ever has this permission will now have to pay for this pet
    sheep: pet.itemeconomy.bypass.sheep
    # This is a bypass permission for the shulker pet, who ever has this permission will now have to pay for this pet
    shulker: pet.itemeconomy.bypass.shulker
    # This is a bypass permission for the silverfish pet, who ever has this permission will now have to pay for this pet
    silverfish: pet.itemeconomy.bypass.silverfish
    # This is a bypass permission for the skeleton pet, who ever has this permission will now have to pay for this pet
    skeleton: pet.itemeconomy.bypass.skeleton
    # This is a bypass permission for the skeleton_horse pet, who ever has this permission will now have to pay for this pet
    skeleton_horse: pet.itemeconomy.bypass.skeleton_horse
    # This is a bypass permission for the slime pet, who ever has this permission will now have to pay for this pet
    slime: pet.itemeconomy.bypass.slime
    # This is a bypass permission for the sniffer pet, who ever has this permission will now have to pay for this pet
    sniffer: pet.itemeconomy.bypass.sniffer
    # This is a bypass permission for the snowman pet, who ever has this permission will now have to pay for this pet
    snowman: pet.itemeconomy.bypass.snowman
    # This is a bypass permission for the spider pet, who ever has this permission will now have to pay for this pet
    spider: pet.itemeconomy.bypass.spider
    # This is a bypass permission for the squid pet, who ever has this permission will now have to pay for this pet
    squid: pet.itemeconomy.bypass.squid
    # This is a bypass permission for the stray pet, who ever has this permission will now have to pay for this pet
    stray: pet.itemeconomy.bypass.stray
    # This is a bypass permission for the strider pet, who ever has this permission will now have to pay for this pet
    strider: pet.itemeconomy.bypass.strider
    # This is a bypass permission for the tadpole pet, who ever has this permission will now have to pay for this pet
    tadpole: pet.itemeconomy.bypass.tadpole
    # This is a bypass permission for the trader_llama pet, who ever has this permission will now have to pay for this pet
    trader_llama: pet.itemeconomy.bypass.trader_llama
    # This is a bypass permission for the tropical_fish pet, who ever has this permission will now have to pay for this pet
    tropical_fish: pet.itemeconomy.bypass.tropical_fish
    # This is a bypass permission for the turtle pet, who ever has this permission will now have to pay for this pet
    turtle: pet.itemeconomy.bypass.turtle
    # This is a bypass permission for the vex pet, who ever has this permission will now have to pay for this pet
    vex: pet.itemeconomy.bypass.vex
    # This is a bypass permission for the villager pet, who ever has this permission will now have to pay for this pet
    villager: pet.itemeconomy.bypass.villager
    # This is a bypass permission for the vindicator pet, who ever has this permission will now have to pay for this pet
    vindicator: pet.itemeconomy.bypass.vindicator
    # This is a bypass permission for the wandering_trader pet, who ever has this permission will now have to pay for this pet
    wandering_trader: pet.itemeconomy.bypass.wandering_trader
    # This is a bypass permission for the warden pet, who ever has this permission will now have to pay for this pet
    warden: pet.itemeconomy.bypass.warden
    # This is a bypass permission for the witch pet, who ever has this permission will now have to pay for this pet
    witch: pet.itemeconomy.bypass.witch
    # This is a bypass permission for the wither pet, who ever has this permission will now have to pay for this pet
    wither: pet.itemeconomy.bypass.wither
    # This is a bypass permission for the wither_skeleton pet, who ever has this permission will now have to pay for this pet
    wither_skeleton: pet.itemeconomy.bypass.wither_skeleton
    # This is a bypass permission for the wolf pet, who ever has this permission will now have to pay for this pet
    wolf: pet.itemeconomy.bypass.wolf
    # This is a bypass permission for the zoglin pet, who ever has this permission will now have to pay for this pet
    zoglin: pet.itemeconomy.bypass.zoglin
    # This is a bypass permission for the zombie pet, who ever has this permission will now have to pay for this pet
    zombie: pet.itemeconomy.bypass.zombie
    # This is a bypass permission for the zombie_horse pet, who ever has this permission will now have to pay for this pet
    zombie_horse: pet.itemeconomy.bypass.zombie_horse
    # This is a bypass permission for the zombie_villager pet, who ever has this permission will now have to pay for this pet
    zombie_villager: pet.itemeconomy.bypass.zombie_villager
    # This is a bypass permission for the zombified_piglin pet, who ever has this permission will now have to pay for this pet
    zombified_piglin: pet.itemeconomy.bypass.zombified_piglin
```