# SI_2023_lab2_213124

**Prasanje BR.2: За дадениот код во функцијата function нацртајте Control Flow Graph со некоја
алатка за цртање дијаграми. Внесете го нацртанот CFG во документацијата.**
--
![Control Graph (CFG)](https://github.com/imdat1/SI_2023_lab2_213124/assets/88778609/4826fe3b-7669-44c7-9fc4-a9a80895d2ee)
_____________________________________________________________________________________________
**Prasanje BR.3: Пресметајте ја цикломатската комплексност на дадениот код. Објаснете како
стигнавте до резултатот**

-- Ciklomatskata kompleksnost na dadeniot kod e 11. Stignav do taa presmetka so broenje na regionite na Control Graphot (CFG) +1 za nadvoresniot region. 
_____________________________________________________________________________________________
**Prasanje BR.4: Напишете ги сите тест случаи според Every Branch критериумот. Напишете и
објаснете ги тест случаите во документацијата.**
--![All Branches](https://github.com/imdat1/SI_2023_lab2_213124/assets/88778609/dee74c1f-29b3-43f4-bd2c-34cc8c701955)

1. First Test Case:
->User.username = NULL

>>So ovoj test case go opfakjam prviot izlez od programata koj frla Exception.

2. Second Test Case: 
->User.username=NULL, User.password="dean", User.email="dean@gmail.com"
->ListUser[0] = username("Borche"), password("nesto"), email("borche@gmail.com")
->ListUser[1] = username("dean@gmail.com"), password("nesto"), email("dean@gmail.com")

>> So ovoj test case go opfakjam izlezot "return false" na pozicija 13 dodeka po patot opfakjam i drugi granki preku listata. Ja fakjam grankata 3-4 so toa sto username na samiot user go postavuvam na NULL. Posle so listata imam eden user razlicen i eden user so isto ime i password na dadeniot user vo funkcijata poradi prviot "for" ciklus (granka 6), vo koj ke vlezi dokolku samiot user ima @ i (granka 5). vo email adresata. Dokolku se razlicni userot i passwordot izmegju userot i listata, ke se opfatat grankite kade "if" uslovot e greshen i go skoka jazelot vo samiot "if" uslov (granki 7-9 i 9-11). A pak koga ke se isti usernameot i passwordot izmegju userot i listata (so vtoriot user vo listata) se fakjaat grankite i jazlite vnatre vo "if" uslovite (granki 7-8=>8-9 i 9-10=>10-11). Return false go fakjam so toa sto passwordot nema golema bukva i nema min.8 karakteri na samiot user.

3. Third Test Case:
->User.username=dean, User.password="deki1234&5", User.email="deangmailcom"
->ListUser[0] = username("Borche"), password("nesto"), email("borche@gmail.com")
->ListUser[1] = username("dean@gmail.com"), password("nesto"), email("dean@gmail.com")

>> So ovoj test case go opfakjam izlezot "return same == 0;" na jazol 18. Tuka ja fakjam grankata 5-12 so toa sto nemam @ ili . vo email adresata, preskoknuvajki gi vnatre grankite koj gi fativ so prethodniot test case. Tuka ja fakjam "else" granka br.14 koj potteknuva od "if" granka br.12. so toa sto passwordot na saamiot user e nad 8 karateri. Vo passwordot nema space, vleguva vo "if" uslov granka br.15 i ima specijalen znak "&", pri sto pred da stigni do nego ke se pominat grankite br.17-19 i br.19-16. Koga ke stigni do specijalniot znak & ke se pominat grankite 17-18 kade zavrsuva kodot so "return same == 0" 

4. Fourth Test Case:
->User.username=dean, User.password="deki1234&5", User.email="deangmailcom"
->ListUser[0] = username("Borche"), password("nesto"), email("borche@gmail.com")
->ListUser[1] = username("dean@gmail.com"), password("nesto"), email("dean@gmail.com")

>> So ovoj test case go opfakjam izlezot "return false;" jazol 20. Za razlika od predhodniot test case, tuka vo passwordot imame space na samiot user za da ja opfatime granka br.15-20.

5. Fifth Test Case:
->User.username=dean, User.password="deki1234&5", User.email="deangmailcom"
->ListUser[0] = username("Borche"), password("nesto"), email("borche@gmail.com")
->ListUser[1] = username("dean@gmail.com"), password("nesto"), email("dean@gmail.com")

>> So ovoj test case go opfakjam izlezot "return false;" jazol 20. Za razlika od predhodniot test case, vo passwordot na samiot user nemam space niti specijalen karakter, za da ja fatam grankata br.16-20 do izlezot.
_____________________________________________________________________________________________
**Prasanje BR.5: Напишете ги сите тест случаи според Multiple Condition критериумот за условот
if (user==null || user.getPassword()==null || user.getEmail()==null). Напишете и
објаснете ги тест случаите во документацијата.
**
![Multiple If Test Case](https://github.com/imdat1/SI_2023_lab2_213124/assets/88778609/244e4157-10de-4dc0-9644-6302b95f58be)

--      
      
        1.assertThrows(RuntimeException.class, () -> SILab2.function(null,null));
        2.assertThrows(RuntimeException.class, () -> SILab2.function(new User("Dean",null,"dean.nastevski@students.finki.ukim.mk"),null));
        3.assertThrows(RuntimeException.class, () -> SILab2.function(new User("Dean","deki123UwU",null),null));

        User user1 = new User("borche","nesto","borche@gmail.com");
        User user2 = new User("dean@gmail.com","nesto","dean@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        4.assertFalse(() -> SILab2.function(new User("Dean","deki123UwU","dean.nastevski@students.finki.ukim.mk"),users));

Ova se testovite za Multiple Case, kade T=true, F=false;NULL, i X=doesn't matter. Na slikata se gleda koi test slucaevi gi opfakjav so test casovite od kodot gore, kade 1.assertThrows fakja (T X X), 2.assertThrows fakja (F T X), i 3.assertThrows fakja (F F T). Posledniot 4.assertFalse (F F F) fakja koga nikogash ne se vleguva vo samiot uslov.
