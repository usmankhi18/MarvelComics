package villa.usman.marvelcomics.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Marvel Comics is the common name and primary imprint of Marvel Worldwide Inc., formerly Marvel Publishing, Inc. and Marvel Comics Group, a publisher of American comic books and related media. In 2009, The Walt Disney Company acquired Marvel Entertainment, Marvel Worldwide's parent company."
                +"\n" +
                "\n" +
                "Marvel started in 1939 as Timely Publications, and by the early 1950s, had generally become known as Atlas Comics. The Marvel branding began 1961, the year that the company launched The Fantastic Four and other superhero titles created by Stan Lee, Jack Kirby, Steve Ditko, and many others."
                +"\n" +
                "\n" +
                "Marvel counts among its characters such well-known superheroes as Spider-Man, Wolverine, the Hulk, Thor, Iron Man, Captain America, Daredevil, Ghost Rider, Dr. Strange, Punisher, Deadpool and the Black Panther, and such teams as the Avengers, the X-Men, the Guardians of the Galaxy, and the Fantastic Four, and antagonists including Doctor Doom, the Red Skull, the Green Goblin, Thanos, Ultron, Doctor Octopus, Magneto, and Loki. Most of Marvel's fictional characters operate in a single reality known as the Marvel Universe, with most locations mirroring real-life places; many major characters are based in New York City."
                +"\n" +
                "\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}