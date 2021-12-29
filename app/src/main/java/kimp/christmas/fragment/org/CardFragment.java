package kimp.christmas.fragment.org;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CardFragment extends Fragment {
    public CardFragment() {
        super(R.layout.card_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView iv = (ImageView)view.findViewById(R.id.card_image);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AudioPlayer.getInstance().isPlaying()) AudioPlayer.getInstance().pause();
                else AudioPlayer.getInstance().play(view.getContext());
            }
        });
    }
}
