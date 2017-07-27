# Battle Odds for Warbarons

A battle odds calculator for [Warbarons](http://www.warbarons.com/ "Warbarons"), a free browser remake of [Warlords](https://en.wikipedia.org/wiki/Warlords_(game_series) "Warlords"), a classic turn-based strategy series.

> Warbarons can be played for free within a web-browser. Being web-based makes it easier to find 
> human opponents to play with. Development was started in 2009 by Mattias Carlstrom and Jonte 
> Rydberg, initially not intended to be a Warlords clone. However, with help from members of the 
> Warlords' player community, the game developed many striking similarities: map with square tiles, 
> stacks of up to 8 units, the entire combat system, ruins, cities, temples, heroes, allies, etc. 
> Notable differences to Warlords are: the level system for heroes (similar to Warlords III, but 
> differing skills and classes); the absence of hero quests (sages just improve hero abilities) and 
> that ships for water movement are not built, but instantly bought instead. As of August 2015, 
> Warbarons[25] is fully playable online and still actively maintained and improved by its original 
> developers.

It was a fun project I wrote in 2012. **Warbarons** is very competitive, a tight community of turn-based strategies veterans, ladders and all. So playing it I thought it needed badly a battle odds calculator, that you could stop wasting time wondering about the odds and focus on strategy. It could also flatten the ground for new players as, obviously, experienced ones stood a much better chance of divining the odds intuitively. As anybody can imagine, raising the issue on the forums didn't go well. I got bashed by veterans for trying to dismantle their precious advantage. After some deliberation, the authors sided with the veteran players and ruled the feature undesirable. AFAIK they changed their minds since, but back then I had to do it myself. And thus **Battle Odds** was born.

Writing it was buckets of fun because it required building from scratch the very bowels of the game. The odds are calculated by running a substantial number (e.g. 1000) of actual, simulated battles. One could theoretically take it from there, add AI, add graphics and make an actual game. One could still do, I guess. I think the abstracted model I ended up with is pretty elegant in OO terms. One could just play with the `effects` and `units` packages and use the `text`-spewing one for debugging. Just an idea.

Because I really needed something working fast, I never got around to placing the unit and effects data in separate text files, let alone a data base. So everything's hardcoded. And there's no GUI, so you have to manually change units and terrain of a battle you'd like to know the odds of in `Simulation` class's `concoctAmies()` method. But as I said - the layout is clear and easy to alter and play with.

Also, mind it was done in 2012. For one it's all Java 6. The other thing being: AFAIK **Warbarons** haven't changed much since (I quit playing it shortly after writing **Battle Odds**, decided it was too good and ate away too much of my time), but the effects and units data (abilities, hit points etc.) are more or less out-of-date.

#### HOW TO RUN

After cloning the repo add `bin` directory to it and (on Linux) in a terminal run commands:
`javac -d bin -sourcepath src src/battleodds/*/*.java`
`java -cp bin battleodds.main.Launcher` (output is rather long so piping it through `less` won't be a bad idea).

If you change units in `concoctArmies()` method, remember to update imports accordingly. If you'd like to add heroes and units with special abilities like *Swarm*, you have to make heads or tails of `Army` class methods and apply the effects manually. It was easy enough to know which units needed which methods to be activated when I played the game - now not so much.