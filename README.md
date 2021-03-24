### Názov týmu: SlabiProgramatori
### Členovia tymu: Juraj Seman, Barbora Horvátová, Patrik Ištván
# Názov hry: LabelAim
## Hlavný cieľ:
Urobiť hru, kde hrac zostrielava nepriatelov tym, ze na klavesnici napise ich meno.
Tu je screen z podobnej hry: ![image](https://user-images.githubusercontent.com/42540086/110616730-2e30ea80-8195-11eb-9cdb-c523b327122c.png)
## Nápady na features/ulohy na rozdelenie:
- hrac je na pravej strane obrazovky, v strede vertikalne, nedokaze sa hybat
- nepriatelia sa objavuju na lavej strane obrazovky, postupne sa posuvaju smerom k hracovi
- kazdy nepriatel ma zobrazeny nahodne vygenerovany nazov, ktory moze byt hocijake slovo
- pod hracom sa zobrazuje text ktory hrac napisal
- ak sa aktualne napisany text zhoduje s nejakym nepriatelom, ukaze sa na nom crosshair/target lock. 
- po stlaceni medzernika sa napisany text zmaze, a ak sa zhodoval s nejakym nepriatelom tak sa k tomu nepriatelovi vystreli navadzacia raketa
- ak sa nepriatel dostane k hracovi, hrac prehral a je game over
- pocitanie skore (prezity cas, zniceny nepriatelia, vystrelene rakety,)
- pridat zvukove efekty
- zmenit font na krajsi
- ...
## Rozdelenie uloh:
### Juraj:
- pod hracom sa zobrazuje text ktory hrac napisal, po stlaceni medzernika sa napisany text zmaze - DONE
- pod kazdym nepriatelom sa zobrazuje jeho nahodne vygenerovane meno (zatial to budu iba nahodne pismena A-Z) - DONE
- nepriatel ktoreho meno bolo napisane pri stlaceni medzernika zomrie/zmizne
### Barbora:
- grafika hraca, nepriatelov, rakety, pozadie,
- ak sa nepriatel dostane k hracovi, hrac prehral a je game over
### Patrik: 
- hrac je na pravej strane obrazovky, v strede vertikalne, nedokaze sa hybat - DONE
- nepriatelia sa objavuju na lavej strane obrazovky, postupne sa posuvaju smerom k pravej strane - DONE

#### Používame FXGL 
beginner-friendly JavaFX game framework - https://github.com/AlmasB/FXGL
