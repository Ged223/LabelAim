### Názov týmu: SlabiProgramatori
### Členovia tymu: Juraj Seman, Barbora Horvátová, Patrik Ištván
# Názov hry: LabelAim
## Hlavný cieľ:
Urobiť hru, kde hrac zostrielava nepriatelov tym, ze na klavesnici napise ich meno.
Tu je screen z podobnej hry: ![image](https://user-images.githubusercontent.com/42540086/110616730-2e30ea80-8195-11eb-9cdb-c523b327122c.png)
## Nápady na features/ulohy na rozdelenie (navrchu najvyssia priorita):
- pripravit na konecnu prezentaciu
- urobit .zip subor na distribuciu hry inym ludom bez instalovania inych veci ako java atd.
## Rozdelenie uloh do 22.4.2021:
### Juraj:

- postupne zrychlovanie hry - DONE
- bude sa poctom znicenych nepriatelov menit rychlost objavovania nepriatelov a rychlost ich pohybu - DONE

### Barbora:
- pocet znicenych nepriatelov = score (1 bod = 1 nepriatel) - DONE
- zobrazenie terajsieho score niekde vpravo hore v rohu - DONE

### Patrik: 
- upravit FXGL menu aby obsahovalo len pouzitelne tlacitka alebo ho uplne vypnut lebo nema ziadne vyuzitie momentalne
- pridat nekonecnu hudbu do pozadia

## Rozdelenie uloh do 8.4.2021: (DONE)
### Juraj:
- slova pod nepriatelmi sa ziskaju z .txt suboru - DONE
    - text v subore je v formate normalnych viet, bez enterov(linebreakov \n) cize v jednom riadku. - DONE
    - nepriatelia dostavaju svoje mena postupne ako su napisane v subore od zaciatku, ak sa dojde na koniec tak ide od zaciatku - DONE
- ak sa nepriatel dostane k hracovi, hrac prehral a je game over - DONE
- pohyb pozadia - DONE
- stlacenim backspace sa vymaze posledne pismeno - DONE

### Barbora:
- poskytnut font textu - DONE
- zmenit font na lepsi - DONE
- viac vrstiev backgroundu(bez pozadia s hviezdami, iba uplne spodny je cely zafarbeny) ktore sa budu hybat roznymi rychlostami - DONE

### Patrik: 
- animacie spritov sfunkcnit - DONE
- pridat zvukovy efekt znicenia nepriatela (vystrelenia s spravne napisanym slovom) - DONE
- pridat iny zvukovy efekt vystrelenia bez znicenia nejakeho nepriatela - DONE
- pridat zvukovy efekt pri napisani hocijakeho pismenka - DONE


## Rozdelenie uloh do 25.3.2021: (DONE)
### Juraj:
- pod hracom sa zobrazuje text ktory hrac napisal, po stlaceni medzernika sa napisany text zmaze - DONE
- pod kazdym nepriatelom sa zobrazuje jeho nahodne vygenerovane meno (zatial to budu iba nahodne pismena A-Z) - DONE
- nepriatel ktoreho meno bolo napisane pri stlaceni medzernika zomrie/zmizne - DONE
### Barbora:
- grafika hraca, nepriatelov, pozadie, - DONE
### Patrik: 
- hrac je na pravej strane obrazovky, v strede vertikalne, nedokaze sa hybat - DONE
- nepriatelia sa objavuju na lavej strane obrazovky, postupne sa posuvaju smerom k pravej strane - DONE


#### Používame FXGL 
beginner-friendly JavaFX game framework - https://github.com/AlmasB/FXGL
