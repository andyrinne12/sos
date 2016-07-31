#SOS: COD MORSE 
created by <b>Crimson Night Studio</b>

Version <b>1.1</b>

#Cerinte de sistem

<b>Hardware:</b> <br>Telefon mobil cu difuzor, lanternă si senzorul de lumina frontal.
<br>Minim 64MB memorie RAM

<b>Software:</b>
<br>Android 4.0.3 sau mai recent

#Update logs

<b>-version 1.1</b>
<br>//updates


#Prezentare

<p>
	Sigur v-ați aflat de multe ori în situația de a avea nevoie să comunicați cu alte persoane din împrejurimi, dar la distanțe mai mari decât ați putea folosi vocea ori gesticulația. Chiar și în aceste situații, nu aveți mereu acces la o rețea mobilă – spre exemplu vă rătăciți într-o excursie în munți și vreți ca prietenii ori grupul cu care ați plecat acolo să vă găsească-. Se poate întâmpla să aveți nevoie să cereți ajutor cuiva din apropiere, dar nu aveți cum să-l contactați, deoarece nu cunoașteți numărul de telefon sau o adresă de e-mail, iar pompierilor și poliției le-ar lua prea mult să ajungă la dumneavoastră, ca în cazul în care sunteți blocați în mijlocul mării sau într-o prăpastie și nu puteți ieși, dar ați putea atrage atenția cuiva care se află în apropiere. 
</p>
<p>
Această aplicație vine în ajutorul dumneavoastră, oferindu-vă posibilitatea de a transmite, cu ajutorul Codului Morse orice mesaj doriți, atât prin intermediul luminii, cât și al sunetului. Aplicația folosește doar lanterna și difuzorul dispozitivului dumneavostră, este aplicabilă în aproape orice situație și vă rezolva problema ușor și simplu.
</p>
<p>
V-ați putea întreba de ce Codul Morse, ținând cont că poate fi considerat depășit în momentul de față, când Wi-Fi-ul și rețelele mobile domină lumea?
</p>
<p>
Răspunsul este simplu: trebuie să ne adaptăm și să folosim ce avem și în situații mai complicate, diferite de cele din viața de zi cu zi.
</p>
<p>
Codul Morse este un alfabet universal, format numai din 2 elemente: linia și punctul, cele două reprezentând un semnal de durată scurtă, respectiv unul de durată lungă, cu ajutorul cărora, în diferite combinații, se pot forma literele alfabetului latin și multe alte caractere.
</p>
<p>
Datorită acestor proprietăți Codul Morse este o alegerea ideală când doriți să transmiteți un mesaj pe o distanță moderată, ce se limitează la aproximativ 500 de metrii, deoarece este foarte ușor atât de emis cât și de recepționat, spre deobsebire de frecvențele radio ori rețelele wireless; acest cod poate fi transmis ori decodat și de o persoană, nu doar de un dispozitiv, acest lucru oferind un bonus în spațiile fără semnal mobil, și având o acuratețe ridicată prin simplitatea elementelor lui pe care un om le poate diferenția cu ușurință. 
</p>
<p>
Singurul dezavantaj al său este o viteză de transmitere nu atât de mare ca în cazul unui apel telefonic, dar totuși suficientă pentru a transmite mesajul la timp.
</p>

#Despre proiect
<p>
Acest proiect a avut la bază încercarea de a explora și exploata diversele capacități ale dispozitivelor Android. Am vrut să dăm posibilitatea utilizatorilor să se folosească de aceste utilități în scopuri noi, dar la fel de folositoare. Deobicei lanterna telefonului este utilizată pentru a căuta diverse obiecte în locuri întunecoase în viața de zi cu zi, ori ca flash-light la 
realizarea fotografiilor, dar ideea de a transforma această funcție aparent banală într-un mod inedit de comunicare ne-a fascinat.
</p>
<p>
Proiectul a fost realizat în limbajul de programare Java cu ajutorul framework-ului Libgdx cu suportul Gradle pentru construirea software-ului. LibGDX este un framework pentru dezvoltarea de aplicații și jocuri cross-platform ce folosește la rândul sau biblioteci ca OpenGL sau LWJGL și ne oferă posibilitatea de a scrie o aplicație în limbajul Java și a o porta pe PC, android, ios, html5, acestea fiind utile și ușor de folosit pentru ciclul de viața al aplicației, grafică, sunet, manipularea fișierelor ori receptarea input-ului.
</p>

#Utilizarea aplicatiei
<p>
După câte putem observa, sunt disponibile 5 butoane. Primul dintre acestea, Code transmission, ne introduce în meniul de transmitere al mesajelor. Acestea pot fi introduse prin 2 modalități: introducerea unui text literă cu literă, utilizând tastatura de pe ecran, sau, în cazul în care mesajul are dimensiuni mai mari, o simplă atingere pe butonul edit message ne oferă posibilitatea de a introduce integral un text. Apăsăm pe OK, iar mesajul va fii copiat pe ecran. Înainte de a a începe emisia, putem selecta viteza și modul de transmitere. De asemenea, putem adăuga altitudinea la care ne aflăm utilizând butonul Add Altitude. Pentru a începe, apăsăm Start Transmission. Vom putea urmări progresiv transmiterea mesajului, fiecare caracter finalizat colorându-se în portocaliu.
</p>
<p>
Al doilea buton este dedicat interpretării automate a unul mesaj. Înainte de a utiliza acest meniu, este nevoie să calibrăm senzorul. Ținem apăsat pe cercul gri până ce bara de progres se completeaza. Înca o atingere a ecranului și intrăm în meniu. Putem să recalibrăm senzorul dacă este nevoie cu ajutorul butonului Reset Set-up. În cazul în care viteza cu care este transmis mesajul diferă de viteza de receptare, modificați-o utilizând butonul Speed. După ce terminați decodarea, goliți ecranul apăsând pe Clear Screen.
</p>
<p>
Al treilea buton ne introduce in meniul pentru decodarea manuală. Se poate întâmpla ca semnalele luminoase să nu atingă senzorul dispozitivului. În această situație, vom introduce mesajul utilizând butoanele pentru punct și linie. Un semnal mai scurt este echivalentul punctului, iar un semnal mai lung al liniei. Sfârșitul unuei litere sau cifre va fii semnalată printr-o pauză scurtă, iar finalul unui cuvânt o pauză mai lungă între flashurile luminoase. Dacă introduceți incorect o linie sau un punct, ori chiar o întreagă litera, utilizați butoanele Delete last character și Delete last letter. Butonul clear screen va goli ecranul.
</p>
<p>
În meniul Documentation din ecranul principal va poate oferi mai multe informatii cu privire la istoria Codului Morse, utilizari ale acestuia sau modalitati de invatare.
</p>

#Fisiere continute

<p>
Fisiere ce aparțin suportului Gradle: 'settings.gradle', 'gradlew', 'gradlew.bat', 'gradle.properties', 'build.gradle', 'gradle/wrapper/gradle-wrapper.jar', 'gradle/wrapper/gradle-wrapper.properties', 'android/build.gradle, project.properties', 'core/build.gradle'
<br><br>
Fisiere nefolosite: folder: 'desktop/...' 
<br><br>
Surse Java scrise de noi: 'core/src/com/ideaproj/thecode.java' 'core/src/com/ideaproj/screens/AboutScreen.java, CreditsScreen.java, IntroReceiveScreen.java, KeyScreen.java, MainScreen.java, ReceiverScreen.java, SplashScreen.java' 'core/src/com/ideaproj/tools/DeviceControl.java, GameRenderer.java, InputHandler.java, ResourceLoader.java' 'android/src/com/android/ideaproj/sos/AndroidDeviceController.java, AndroidLauncher.java'
<br<br>
Manifest: 'android/AndroidManifest.xml'
<br><br>
Resurse: 'android/assets/...', ' 'android/res/...'
<br><br>
Librariile LibGDX folosite se află pe un repository online din Maven și sunt accesate de fisierele Gradle( se pot vizualiza link-urile in fisierele gradle.build)

