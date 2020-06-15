package villa.usman.marvelcomics.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vestibulum justo lorem, et scelerisque ante tempus at. Cras at rhoncus ante. Suspendisse potenti. Curabitur purus ipsum, mollis sit amet dapibus in, hendrerit in ligula. Quisque et pellentesque quam, sed mattis purus. Morbi facilisis eu leo sed ultrices. Fusce venenatis pretium rutrum.\n" +
                "\n" +
                "Quisque laoreet magna vitae tortor vulputate cursus. Nam a ante eget erat tempor tristique. Phasellus pellentesque porttitor leo nec bibendum. Fusce pulvinar, urna ac vestibulum interdum, nibh eros placerat lacus, a auctor lacus lectus sed dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse vestibulum placerat turpis, nec bibendum magna sollicitudin malesuada. Vivamus nulla elit, rutrum vitae tristique sed, iaculis quis mauris. Etiam lobortis neque odio, sed vehicula purus sollicitudin sed. Morbi vitae leo lacus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer et turpis sed ante ultricies porta ullamcorper eget erat. Suspendisse sodales tempus nisi, id auctor erat pellentesque et. In hac habitasse platea dictumst. Donec sit amet efficitur arcu. Mauris eros tellus, dictum sit amet feugiat in, iaculis eu odio.\n" +
                "\n" +
                "Pellentesque volutpat, tortor id dictum efficitur, quam risus fermentum orci, quis accumsan nisl massa ut dolor. Etiam consectetur vulputate finibus. Quisque justo nulla, ornare sed neque id, fermentum vulputate sapien. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum mattis mauris risus, iaculis eleifend urna feugiat sit amet. Maecenas tincidunt vestibulum massa. Duis placerat bibendum imperdiet. Aliquam malesuada gravida tellus. Suspendisse efficitur quam ut lectus cursus scelerisque. Nullam id malesuada ex. Aenean at fringilla elit. Etiam non nibh at eros finibus mollis a in nulla. Vestibulum dignissim ac diam quis pulvinar.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}